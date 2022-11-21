package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var usuario:EditText
    private lateinit var pass:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuario = findViewById(R.id.txt_ID)
        pass = findViewById(R.id.txt_Pass)

    }


    fun logIn (vista:View)
    {
        val url = "http://127.0.0.1:8080/pfinalphp/Conexion.php"

        if (usuario.text.toString()== "Alvaro" && pass.text.toString()== "123")
        {
            val ventana: Intent = Intent(this,Ventana2::class.java)

            startActivity(ventana)
        }else
        {
            Toast.makeText(this, "Puto el k lo lea", Toast.LENGTH_SHORT).show()
        }

    }
}