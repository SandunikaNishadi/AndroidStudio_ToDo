package com.example.managmentapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.managmentapp.databinding.ActivityViewBinding

class Adapter(private val data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(private val binding: ActivityViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val layout = binding.mylayout
        val title = binding.title
        val priority = binding.priority
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        // Set background color based on priority
        holder.layout.setBackgroundColor(
            when (currentItem.priority.toLowerCase()) {
                "high" -> Color.parseColor("#F05454")
                "medium" -> Color.parseColor("#EDC988")
                else -> Color.parseColor("#EDC988")
            }
        )

        holder.title.text = currentItem.title
        holder.priority.text = currentItem.priority

        // Set click listener to navigate to UpdateCard activity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateCard::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
