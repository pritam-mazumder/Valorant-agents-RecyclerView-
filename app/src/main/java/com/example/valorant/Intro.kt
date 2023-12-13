package com.example.valorant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.valorant.databinding.ActivityIntroBinding

class Intro : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.intro.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))

            val welcome = AlertDialog.Builder(this)
            welcome.setTitle(R.string.adTitle)
            welcome.setMessage(R.string.adMsg)
            welcome.setIcon(R.drawable.ic_launcher_foreground)

            welcome.setPositiveButton("Yes go") { dialogInterface, which ->
                startActivity(Intent(this, MainActivity::class.java))
            }
            welcome.setNegativeButton("No") { dialogInterface, which ->
                Toast.makeText(this, "clicked No", Toast.LENGTH_SHORT).show()
            }
            welcome.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(this, "clicked No", Toast.LENGTH_SHORT).show()
            }

            val alertDialog: AlertDialog = welcome.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}