package com.example.examenretrofitjordi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class Login : AppCompatActivity() {
    private lateinit var etUsuari: EditText

    private lateinit var tvSubtitle: TextView

    private lateinit var etPassword: EditText

    private lateinit var btnLogin: Button

    private lateinit var ViewModelLogin: ViewModelLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ViewModelLogin = ViewModelProvider(this)[ViewModelLogin::class.java]
        initComponents();
        initUI()
    }
    fun initUI(){
        btnLogin.setOnClickListener {
            ViewModelLogin.login(etUsuari.text.toString(), etPassword.text.toString())
        }

        ViewModelLogin.errorMessage.observe(this){
                error -> tvSubtitle.text = error ?: ""
        }

        ViewModelLogin.loginResult.observe(this){
                succesful ->
            if(succesful){
                var intent = Intent(this, reserves::class.java)
                startActivity(intent)
            }
        }
    }

    fun initComponents(){
        btnLogin = findViewById<Button>(R.id.btnLogin)
        etUsuari = findViewById<EditText>(R.id.etUsuari)
        etPassword = findViewById<EditText>(R.id.etPassword)
        tvSubtitle = findViewById<TextView>(R.id.tvSubtitle)
    }
}