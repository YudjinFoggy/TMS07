package com.example.tms07

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout


class HW5Activity : AppCompatActivity() {

    lateinit var viewModel: ViewModelHW5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5)

        viewModel = ViewModelProvider(this).get(ViewModelHW5::class.java)

        val login =
            findViewById<TextInputLayout>(R.id.login)
        val password =
            findViewById<TextInputLayout>(R.id.password)
        val buttonSignUp = findViewById<Button>(R.id.button_sign_up)

        buttonSignUp.setOnClickListener {

            if (checkLogin(login) && checkPassword(password)) {
                HW5DialogFragment().show(supportFragmentManager, HW5DialogFragment.TAG)
                val str = login.editText?.text.toString()
                viewModel.setLogin(str)

                login.editText?.text = null
                password.editText?.text = null
            }
        }
    }

    private fun checkLogin(login: TextInputLayout): Boolean {
        login.isErrorEnabled = false

        if (login.editText?.text.isNullOrEmpty()) {
            login.isErrorEnabled = true
            login.error = resources.getString(R.string.enter_username_please)
            return false
        }
        return true
    }

    private fun checkPassword(password: TextInputLayout): Boolean {
        password.isErrorEnabled = false

        if (password.editText?.text.isNullOrEmpty()) {
            password.isErrorEnabled = true
            password.error = resources.getString(R.string.enter_password_please)
            return false
        } else if (password.editText?.text?.length!! > 8) {
            password.isErrorEnabled = true
            password.error = resources.getString(R.string.too_long_password)
            return false
        }
        return true
    }
}