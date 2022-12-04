package com.example.proyectofinal

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class info_cuenta() : Fragment() {
    public var nick = "ffpepe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_cuenta, container, false)
    }
    var pruv = prueva()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        Log.d("casas","")

    }

    companion object {

    }
}