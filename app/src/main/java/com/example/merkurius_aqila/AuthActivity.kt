package com.example.merkurius_aqila

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.merkurius_aqila.databinding.ActivityAuthBinding
import com.example.merkurius_aqila.databinding.ActivityFourthBinding
import com.example.merkurius_aqila.pertemuan_5.FifthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            //Panggil Intent untuk ke MainActivity
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.isiUsername.text.toString()
            val password = binding.isiPassword.text.toString()

            if(username == password) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()


                // berpindah ke MainActivity
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Oopss...")
                    .setMessage("Username atau Password Salah!")
                    .show()
            }


        }

    }
}