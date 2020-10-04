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

class UserViewModel @ViewModelInject constructor(private val userService: UserService) :
    ViewModel() {

    private var loginLiveData: MutableLiveData<Resource<User>> = MutableLiveData()
    var isLoginLiveData: MutableLiveData<Resource<User>> = MutableLiveData()

    fun executeLogin(user: User?) {
        CoroutineScope(IO).launch {
            try {
                val result = login(user)
                loginLiveData.postValue(Resource(result?.user))
            } catch (e: Throwable) {
                loginLiveData.postValue(Resource(e))
            }
        }
    }

    fun getLoginLiveData(): LiveData<Resource<User>> = loginLiveData

    private fun login(user: User?): Token? =
        user?.let {
            val username = user.username
            val password = user.auth.password
            userService.login(username, password)
        }

    fun executeIsLogin() {
        CoroutineScope(IO).launch {
            try {
                val result = userService.isLogin()
                isLoginLiveData.postValue(Resource(result?.user))
            } catch (e: Throwable) {
                isLoginLiveData.postValue(Resource(e))
            }
        }
    }

}