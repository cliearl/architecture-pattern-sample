package com.example.architecturepattern.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.architecturepattern.databinding.ActivityMvcLoginBinding
import com.example.architecturepattern.mvc.model.User

class MvcLoginActivity : AppCompatActivity() {
    private val binding: ActivityMvcLoginBinding by lazy {
        ActivityMvcLoginBinding.inflate(layoutInflater)
    }
    private lateinit var user : User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 처리
        setContentView(binding.root)

        user = User()

        // 프레젠테이션 로직
        binding.included.loginBtn.setOnClickListener {
            val isLoginSuccessful = user.login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString(),
            )

            if (isLoginSuccessful) {
                Toast.makeText(this@MvcLoginActivity, "${user.userName} Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MvcLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
