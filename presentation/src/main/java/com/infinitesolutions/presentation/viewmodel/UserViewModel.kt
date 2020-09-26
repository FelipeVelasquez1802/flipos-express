package com.infinitesolutions.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.entity.Token
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(
    private val userService: UserService
) : ViewModel() {

    companion object {
        private var userLiveData: MutableLiveData<Resource<User>> = MutableLiveData()
    }

    fun executeLogin(user: User?) {
        CoroutineScope(IO).launch {
            try {
                val result = login(user)
                userLiveData.postValue(Resource(result?.user))
            } catch (e: Throwable) {
                userLiveData.postValue(Resource(e))
            }
        }
    }

    fun getLoginLiveData(): LiveData<Resource<User>> = userLiveData


    private fun login(user: User?): Token? =
        user?.let {
            val username = user.username
            val password = user.auth.password
            userService.login(username, password)
        }

}