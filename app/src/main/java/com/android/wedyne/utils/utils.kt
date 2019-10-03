package com.android.wedyne.utils

import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.android.wedyne.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView

fun BottomNavigationItemView.show() {
    this.visibility = View.VISIBLE
}

fun BottomNavigationItemView.hide() {
    this.visibility = View.GONE
}

 fun Button.setupBackground() {
    if(this.isEnabled){
        this.setBackgroundColor(ContextCompat.getColor(context!!, R.color.green_button))
    } else{
        this.setTextColor(ContextCompat.getColor(context!!,android.R.color.white))
    }
}