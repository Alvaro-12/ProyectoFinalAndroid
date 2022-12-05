package com.example.proyectofinal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class adaptador2(F:FragmentActivity,var email:String):FragmentStateAdapter(F) {
    override fun getItemCount(): Int = 1
    override fun createFragment(position: Int): Fragment {
        val fragment = info_cuenta(email)
        return fragment
    }
}