package com.bangkitacademy.suitmediatest.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bangkitacademy.suitmediatest.data.response.User
import com.bangkitacademy.suitmediatest.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class UserListAdapter(private val onItemClick: (String) -> Unit) : PagingDataAdapter<User, UserListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    class MyViewHolder(private val binding: ItemUserBinding,
                       private val onItemClick: (String) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: User) {
            binding.tvItemEmail.text = data.email
            binding.tvItemUsername.text = data.firstName +" "+ data.lastName
            Glide.with(binding.root)
                .load(data.avatar)
                .centerCrop()
                .circleCrop()
                .into(binding.ivItem)

            itemView.setOnClickListener {
                onItemClick.invoke(data.firstName +" "+ data.lastName)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}