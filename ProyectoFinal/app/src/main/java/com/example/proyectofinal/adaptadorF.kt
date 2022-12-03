package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class adaptadorF(F:FragmentActivity):FragmentStateAdapter(F) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        if(position == 0){
            val fragment = historialFragment()

            fragment.arguments = Bundle().apply {
                putInt(ARG_OBJECT1,position)
            }

            return fragment
        }
        else if (position==1){
            val fragment = JuegoFragment()
            return fragment
        }
        else{
            val fragment = puntajeGobal()

            fragment.arguments = Bundle().apply {
                putInt(ARG_OBJECT3,position)
            }
            return fragment
        }

    }

    companion object{
        private const val ARG_OBJECT1 = "object"
        private const val ARG_OBJECT2 = "object"
        private const val ARG_OBJECT3= "object"
    }
}