package com.nantaaq.myapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nantaaq.myapp.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val data = intent.getParcelableExtra<UserData>("USER_DATA")

        data?.let {
            findViewById<TextView>(R.id.tvHasilNama).text = "Nama: ${it.nama}"
            findViewById<TextView>(R.id.tvHasilNim).text = "NIM: ${it.nim}"
            findViewById<TextView>(R.id.tvHasilProdi).text = "Prodi: ${it.prodi}"
            findViewById<TextView>(R.id.tvHasilGender).text = "Gender: ${it.gender}"
            findViewById<TextView>(R.id.tvHasilHobi).text = "Hobi: ${it.hobi}"
        }
    }
}