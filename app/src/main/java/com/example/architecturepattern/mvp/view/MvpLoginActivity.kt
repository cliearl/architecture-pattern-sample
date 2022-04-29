package com.example.architecturepattern.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.architecturepattern.databinding.ActivityMvpLoginBinding
import com.example.architecturepattern.mvp.presenter.LoginPresenterImpl

class MvpLoginActivity : AppCompatActivity(), MvpLoginView {
    private val binding: ActivityMvpLoginBinding by lazy {
        ActivityMvpLoginBinding.inflate(layoutInflater)
    }
    private lateinit var loginPresenterImpl: LoginPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loginPresenterImpl = LoginPresenterImpl(this)
        binding.included.loginBtn.setOnClickListener { loginPresenterImpl.login() }
    }

    override val userName: String
        get() = binding.included.etUserName.text.toString()
    override val password: String
        get() = binding.included.etPassword.text.toString()

    override fun onLoginResult(isLoginSuccess: Boolean?) {
        if (isLoginSuccess == true) {
            Toast.makeText(this@MvpLoginActivity, "$userName Login Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MvpLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}