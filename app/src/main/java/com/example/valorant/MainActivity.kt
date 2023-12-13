package com.example.valorant

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), agentsAdapter.AgentItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var agentsKiList: ArrayList<agentsData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        agentsKiList = AgentsDataGenerator.generateAgentsData()

        binding.rvc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvc.adapter = agentsAdapter(this, agentsKiList, this)
    }

    override fun onAgentItemClick(position: Int) {
        val selectedAgent = agentsKiList[position]
        Toast.makeText(this, "Clicked on ${selectedAgent.agName}", Toast.LENGTH_SHORT).show()
    }
}
