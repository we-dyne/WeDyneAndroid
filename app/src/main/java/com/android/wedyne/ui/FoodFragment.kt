package com.android.wedyne.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.wedyne.R
import com.android.wedyne.adapters.FoodAdapter
import com.android.wedyne.databinding.FragmentFoodBinding
import com.android.wedyne.models.Food

/**
 * A simple [Fragment] subclass.
 */
class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding
    private lateinit var foodToolbar: Toolbar
    private lateinit var foodToolbarCustomView : View
    private lateinit var foodList : RecyclerView
    private lateinit var foodDataSource : ArrayList<Food>
    private lateinit var foodAdapter : FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food, container, false)
        setUpFields()

        foodDataSource = ArrayList()
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))
        foodDataSource.add(Food(R.drawable.food_image,"Paneer Biryani","Basmati Rice Lunchbox","$ 220"))

        foodList.apply {
            layoutManager = LinearLayoutManager(context)
            foodAdapter = FoodAdapter()
            foodAdapter.submitList(foodDataSource)
            adapter = foodAdapter
        }

        binding.foodCloseAction.setOnClickListener {
            this.findNavController().navigateUp()
        }

        return binding.root
    }

    @SuppressLint("InflateParams")
    private fun setUpFields() {
        foodToolbar = binding.FoodToolbar
        (activity as AppCompatActivity).apply {
            setSupportActionBar(foodToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
       // foodToolbarCustomView = layoutInflater.inflate(R.layout.food_toolbar_customm_layout,null)
     //   foodToolbar.addView(foodToolbarCustomView)
        foodList = binding.foodList
    }


}
