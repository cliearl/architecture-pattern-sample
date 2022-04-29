package com.example.architecturepattern.mvp.view

interface MvpLoginView {
    val userName: String?
    val password: String?

    fun onLoginResult(isLoginSuccess: Boolean?)
}
