package com.infinitesolutions.presentation.viewmodel

import android.os.AsyncTask
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.service.UserService

class UserViewModel @ViewModelInject constructor(
    private val userService: UserService,
    @Assisted
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private var userLiveData: MutableLiveData<User?> = MutableLiveData()
    }

    fun executeLogin(user: User?): LiveData<User?> {
        login(user)
        return userLiveData
    }

    private fun login(user: User?) {
        val userAsyncTask = UserAsyncTask(userService)
        userAsyncTask.execute(user)
    }

    class UserAsyncTask(private val userService: UserService) : AsyncTask<User, String, Token>() {
        override fun doInBackground(vararg p0: User?): Token {
            return try {
                val user = p0[0]!!
                val username = user.username
                val password = user.auth.password
                userService.login(username, password)
            } catch (e: Throwable) {
                throw IllegalStateException(e)
            }
        }

        override fun onPostExecute(result: Token?) {
            userLiveData.value = result?.user
        }
    }

}