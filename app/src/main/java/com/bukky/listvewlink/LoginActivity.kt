package com.bukky.listvewlink

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailInput = findViewById(R.id.login_email)
        passwordInput = findViewById(R.id.login_password)

    }

    fun loginAction(view: View) {

        if (!validateLogin()) {
            return
        }

        val newLoginCred =
            LoginDetails(emailInput.text?.toString()!!, passwordInput.text?.toString()!!)

        if (!DelightaData.verifiedUsers.contains(newLoginCred)){
            Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_LONG).show()
            return
        }

        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    private fun validateLogin(): Boolean {
        if (emailInput.text.isNullOrEmpty()) {
            emailInput.error = "Email required"
            return false
        }

        if (passwordInput.text.isNullOrEmpty()) {
            passwordInput.error = "Password required"
            return false
        }

        if (!isEmailValid(emailInput.text?.toString()!!)) {
            emailInput.error = "Input a valid email"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

}
