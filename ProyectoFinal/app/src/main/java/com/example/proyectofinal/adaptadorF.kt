package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class adaptadorF(F:FragmentActivity,var email:String):FragmentStateAdapter(F) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        if(position == 0){
            val fragment = JuegoFragment(email)

            Log.d("Adaptador",email)
            return fragment
        }
        else{
            val fragment = puntajeGobal(email)

            return fragment
        }

    }

    companion object{
        private const val ARG_OBJECT2 = "object"
        private const val ARG_OBJECT3= "object"
    }
}