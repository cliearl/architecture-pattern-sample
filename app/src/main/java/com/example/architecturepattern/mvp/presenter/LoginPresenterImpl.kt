package com.example.architecturepattern.mvp.presenter

import com.example.architecturepattern.mvp.model.User
import com.example.architecturepattern.mvp.view.MvpLoginView

class LoginPresenterImpl(
    private val mvpLoginView: MvpLoginView
) : LoginPresenter {

    override val user: User
        get() = User()

    override fun login() {
        val userName = mvpLoginView.userName.toString()
        val password = mvpLoginView.password.toString()
        val isLoginSuccessful: Boolean = user.login(userName, password)

        mvpLoginView.onLoginResult(isLoginSuccessful)
    }
}
