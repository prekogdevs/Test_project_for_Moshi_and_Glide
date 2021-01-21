package com.example.usingmoshi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.usingmoshi.databinding.ListItemBinding
import com.example.usingmoshi.model.SampleData

class SampleDataAdapter :
    ListAdapter<SampleData, SampleDataAdapter.SampleViewHolder>(SampleDataCallback()) {

    class SampleViewHolder private constructor(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindSample(sampleData: SampleData) {
            binding.sampleData = sampleData
        }

        companion object {
            fun from(parent: ViewGroup): SampleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return SampleViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SampleViewHolder.from(parent)

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val sampleData = getItem(position)
        holder.bindSample(sampleData)
    }
}

class SampleDataCallback : DiffUtil.ItemCallback<SampleData>() {
    override fun areItemsTheSame(oldItem: SampleData, newItem: SampleData) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SampleData, newItem: SampleData) =
        oldItem == newItem
}