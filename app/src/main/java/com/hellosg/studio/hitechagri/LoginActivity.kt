package com.hellosg.studio.hitechagri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.intentFor

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignUp.setOnClickListener {
            startActivity(intentFor<SignUpActivity>())
        }

        btnLogin.setOnClickListener {
            startActivity(intentFor<DashboardActivity>())
        }
    }
}
