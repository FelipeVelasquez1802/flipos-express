package com.infinitesolutions.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.entity.User
import com.infinitesolutions.domain.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(private val userService: UserService) :
    ViewModel() {

    private var loginLiveData: MutableLiveData<Resource<User>> = MutableLiveData()
    var isLoginLiveData: MutableLiveData<Resource<User>> = MutableLiveData()

    fun executeLogin(username: String, password: String) {
        CoroutineScope(IO).launch {
            try {
                val result = userService.login(username, password)
                loginLiveData.postValue(Resource(result?.user))
            } catch (e: Throwable) {
                loginLiveData.postValue(Resource(e))
            }
        }
    }

    fun getLoginLiveData(): LiveData<Resource<User>> = loginLiveData

    fun executeIsLogin() {
        CoroutineScope(IO).launch {
            try {
                val result = userService.isLogin()
                isLoginLiveData.postValue(Resource(result.user))
            } catch (e: Throwable) {
                isLoginLiveData.postValue(Resource(e))
            }
        }
    }

}