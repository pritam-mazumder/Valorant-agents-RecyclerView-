package com.example.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class agentsAdapter(
    val requiredContext: Context, private val roleDetails: ArrayList<agentsData>,
    private val clickListener: AgentItemClickListener
) :
    RecyclerView.Adapter<agentsAdapter.roleViewDetails>() {

    interface AgentItemClickListener {
        fun onAgentItemClick(position: Int)
    }


    class roleViewDetails(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val aImg: ImageView = itemView.findViewById(R.id.i)
        val aName: TextView = itemView.findViewById(R.id.name)
        val aRole: TextView = itemView.findViewById(R.id.role)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): roleViewDetails {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv, parent, false)
        return roleViewDetails(view)
    }

    override fun getItemCount(): Int {
        return roleDetails.size
    }

    override fun onBindViewHolder(holder: roleViewDetails, position: Int) {

        holder.aImg.setImageResource(roleDetails[position].agImg)
        holder.aName.text = roleDetails[position].agName
        holder.aRole.text = roleDetails[position].agRole

        holder.itemView.setOnClickListener {
            clickListener.onAgentItemClick(position)
        }
    }
}