package com.nantaaq.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.nantaaq.myapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNim)
        val spProdi = findViewById<Spinner>(R.id.spProdi)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            
            if (nama.isEmpty() || nim.isEmpty()) {
                Toast.makeText(this, "Nama dan NIM wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            val hobiList = mutableListOf<String>()
            if (findViewById<CheckBox>(R.id.cbCoding).isChecked) hobiList.add("Coding")
            if (findViewById<CheckBox>(R.id.cbGaming).isChecked) hobiList.add("Gaming")
            if (findViewById<CheckBox>(R.id.cbGym).isChecked) hobiList.add("Gym")

            val hobiString = if (hobiList.isEmpty()) "Tidak ada hobi" else hobiList.joinToString(", ")

            val data = UserData(nama, nim, spProdi.selectedItem.toString(), gender, hobiString)

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_DATA", data)
            startActivity(intent)
        }
    }
}