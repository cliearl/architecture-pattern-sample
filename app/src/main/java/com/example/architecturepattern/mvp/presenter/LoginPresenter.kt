package com.example.architecturepattern.mvp.presenter

import com.example.architecturepattern.mvp.model.User

interface LoginPresenter {
    val user: User

    fun login()
}