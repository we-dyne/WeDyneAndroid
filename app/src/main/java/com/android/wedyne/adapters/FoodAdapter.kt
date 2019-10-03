package com.android.wedyne.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.wedyne.databinding.FoodListItemBinding
import com.android.wedyne.models.Food

class FoodAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {

        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            TODO("not implemented")
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            TODO("not implemented")
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater =   LayoutInflater.from(parent.context)

        return FoodViewHolder(
           FoodListItemBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FoodViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Food>) {
        differ.submitList(list)
    }

    class FoodViewHolder(
      val binding: FoodListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Food){
            binding.food = item
            binding.executePendingBindings()

        }
    }
    class NoteListener(val clickListener : () -> Unit){
        fun onClick( ) = clickListener()
    }

}