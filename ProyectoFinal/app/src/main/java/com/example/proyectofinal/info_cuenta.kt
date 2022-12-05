package com.example.proyectofinal

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.roundToInt


class info_cuenta(var em:String) : Fragment() {
    lateinit var nombre:TextView
    lateinit var email:TextView
    lateinit var mayor:TextView
    lateinit var menor:TextView
    lateinit var bot:Button
    lateinit var btns:Button
    var db = FirebaseFirestore.getInstance()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bot=view.findViewById(R.id.btncerrar)
        btns=view.findViewById(R.id.btnsesion)

        cargar(view)
        bot.setOnClickListener{
            cerrar(view)
            cargar(view)
        }

        btns.setOnClickListener{
            salir(view)
        }
        Log.d("info cuenta",em)

    }

    fun salir(view: View){
        val ventana:Intent = Intent(view.context,MainActivity::class.java)

        startActivity(ventana)

    }

    fun cerrar(view: View){

        db.collection("usuarios").document(em).get().addOnSuccessListener{ document ->
            if(document != null){


                db.collection("usuarios").document(em).set(

                    hashMapOf(
                        "Email" to em,
                        "Nick" to document.getString("Nick").toString(),
                        "Puntaje" to "0",
                        "MayorP" to "0",
                        "MenorP" to "0"
                    )


                )
            }
        }



        cargar(view)

    }

    fun cargar(view: View){
        nombre = view.findViewById(R.id.txt_nick)
        menor = view.findViewById(R.id.txtmenor)
        mayor = view.findViewById(R.id.txtmayor)
        email = view.findViewById(R.id.txt_email)

        db.collection("usuarios").document(em).get().addOnSuccessListener { document ->

            nombre.text = document.getString("Nick")
            email.text=em
            menor.text = document.getString("MenorP")
            mayor.text = document.getString("MayorP")

        }
    }

    companion object {

    }
}