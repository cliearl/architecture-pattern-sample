package com.example.architecturepattern.bare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.architecturepattern.databinding.ActivityBareLoginBinding

class BareLoginActivity : AppCompatActivity() {

    private val binding: ActivityBareLoginBinding by lazy {
        ActivityBareLoginBinding.inflate(layoutInflater)
    }

    var userName: String? = null
    var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 처리
        setContentView(binding.root)

        binding.included.loginBtn.setOnClickListener {

            // 데이터 취득
            val isLoginSuccessful = login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString(),
            )

            // 이벤트 처리
            if (isLoginSuccessful) {
                Toast.makeText(this@BareLoginActivity, "$userName Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@BareLoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 로직 판정
    fun login(userName: String?, password: String?): Boolean {
        if (userName == secretName && password == secretWord) {
            this.userName = userName
            this.password = password
            return true
        }
        return false
    }

    companion object {
        const val secretName = "user"
        const val secretWord = "1234"
    }
}