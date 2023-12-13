package com.example.valorant.agents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.valorant.R
import com.example.valorant.databinding.ActivityBrimBinding

class BrimActivity : AppCompatActivity() {

    private val binding by lazy { ActivityBrimBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFrag(BrimQFragment(), 0)

        binding.brimQ.setOnClickListener {
            loadFrag(BrimQFragment(), 1)
        }

        binding.brimE.setOnClickListener {
            loadFrag(BrimEFragment(), 1)
        }

        binding.brimC.setOnClickListener {
            loadFrag(BrimCFragment(), 1)
        }

        binding.brimX.setOnClickListener {
            loadFrag(BrimXFragment(), 1)
        }

    }

    private fun loadFrag(fragments: Fragment, flag: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if (flag == 1) ft.add(R.id.brimF, fragments)
        else ft.replace(R.id.brimF, fragments)

        ft.commit()
    }
}