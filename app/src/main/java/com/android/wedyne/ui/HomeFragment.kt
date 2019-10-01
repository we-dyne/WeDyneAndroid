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
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.wedyne.R
import com.android.wedyne.adapters.RestaurantAdapter
import com.android.wedyne.databinding.FragmentHomeBinding
import com.android.wedyne.models.Restaurant

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeToolbar : Toolbar
    private lateinit var homeToolbarCustomLayout : View
    private lateinit var restaurantList: RecyclerView
    private lateinit var restaurantAdapter : RestaurantAdapter
    private lateinit var restaurantDataList : ArrayList<Restaurant>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        setUpFields()

        restaurantDataList =  ArrayList()
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",1))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",2))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",3))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",4))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",5))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",6))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",7))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",8))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",9))
        restaurantDataList.add(Restaurant("AGASHIYE, AHMEDABAD",R.drawable.restaurant_image,"3.0",10))


        restaurantList.apply {
            layoutManager = GridLayoutManager(context,2)
            restaurantAdapter = RestaurantAdapter(RestaurantAdapter.RestaurantClickListener {
                    this.findNavController().navigate(R.id.foodFragment)
            })
            restaurantAdapter.submitList(restaurantDataList)
            adapter = restaurantAdapter
        }


        return binding.root
    }

    @SuppressLint("InflateParams")
    private fun setUpFields(){
        homeToolbar = binding.homeToolbar
        (activity as AppCompatActivity).apply {
            setSupportActionBar(homeToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
        homeToolbarCustomLayout = layoutInflater.inflate(R.layout.home_toolbar_custom_layout,null)
        homeToolbar.addView(homeToolbarCustomLayout)
        restaurantList = binding.restaurantList
    }
}
