package com.example.architecturepattern.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepattern.mvvm.model.User

class LoginViewModel : ViewModel() {
    private val user: User = User()
    private val _isLoginSuccessfulFlag: MutableLiveData<Boolean> = MutableLiveData()
    val isLoginSuccessfulFlag: LiveData<Boolean>
        get() = _isLoginSuccessfulFlag
    val userName: String
        get() = user.userName.toString()


    private fun setIsLoginSuccessfulFlag(isLoginSuccessful: Boolean) {
        _isLoginSuccessfulFlag.postValue(isLoginSuccessful)
    }

    fun login(userName: String, password: String) {
        val isLoginSuccessful: Boolean = user.login(userName, password)
        if (isLoginSuccessful) {
            setIsLoginSuccessfulFlag(true)
        } else {
            setIsLoginSuccessfulFlag(false)
        }
    }
}
