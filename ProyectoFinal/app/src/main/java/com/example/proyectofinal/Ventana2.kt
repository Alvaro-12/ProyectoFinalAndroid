package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.log

class Ventana2 : AppCompatActivity() {
    private val bd = FirebaseFirestore.getInstance()
    lateinit var rp1: RadioButton
    lateinit var rp2: RadioButton
    lateinit var rp3: RadioButton
    lateinit var rp4: RadioButton
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    lateinit var rb3:RadioButton
    lateinit var rb4:RadioButton
    lateinit var txtpregun:TextView
    var pregunta = 1 .. 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana2)

        rb1=findViewById(R.id.rb1)
        rb2=findViewById(R.id.rb2)
        rb3=findViewById(R.id.rb3)
        rb4=findViewById(R.id.rb4)
        txtpregun=findViewById(R.id.textView)
        var bd = FirebaseFirestore.getInstance()

    cargardatos()
    }


    fun cargardatos(){
        var rb = arrayListOf<RadioButton>(rb1,rb2,rb3,rb4)
        rp1=rb.random()
        rb.remove(rp1)
        rp2=rb.random()
        rb.remove(rp2)
        rp3=rb.random()
        rb.remove(rp3)
        rp4=rb.random()
        rb.remove(rp4)
        val doc = bd.collection("Pregunta").document(pregunta.random().toString())
        doc.get().addOnSuccessListener { document ->
            if (document != null){
                txtpregun.text=document.getString("Pregunta")
                rp1.text= document.getString("Respuesta")
                rp2.text= document.getString("Incorrecta1")
                rp3.text= document.getString("Incorrecta2")
                rp4.text= document.getString("Incorrecta3")
                Log.d("tag",document.data.toString())
            }else{
                Log.d("tag","errror")
            }

        }
    }
}