package com.android.wedyne.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.wedyne.databinding.RestaurantListItemBinding
import com.android.wedyne.models.Restaurant

class RestaurantAdapter(val clickListener : RestaurantClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

     val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Restaurant>() {

        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
              return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
               return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater =  LayoutInflater.from(parent.context)

        return RestaurantViewHolder(
            RestaurantListItemBinding.inflate(inflater, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RestaurantViewHolder -> {
                holder.bind(differ.currentList[position],clickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Restaurant>) {
        differ.submitList(list)
    }

    class RestaurantViewHolder(val binding: RestaurantListItemBinding)
                             : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Restaurant,
            clickListener: RestaurantClickListener
        )  {

            binding.restaurant = item
            binding.restaurantClickListener = clickListener
            binding.executePendingBindings()
        }
    }

    class RestaurantClickListener(val clickListener : () -> Unit){
        fun onClick( ) = clickListener()
    }
}