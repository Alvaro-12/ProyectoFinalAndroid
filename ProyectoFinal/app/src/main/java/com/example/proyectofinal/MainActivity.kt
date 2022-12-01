package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.analytics.FirebaseAnalytics
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var usuario:EditText
    private lateinit var pass:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuario = findViewById(R.id.txt_ID)
        pass = findViewById(R.id.txt_Pass)

        ejecutarAnalitica()
    }


    fun logIn (vista:View)
    {
        var us = usuario.text.toString()
        var ps = pass.text.toString()

        val procesoCola:RequestQueue = Volley.newRequestQueue(this)
        val url = "http://192.168.101.14/pfinalphp/Find.php?Nick=$us&Pass=$ps"
        var resultado = JsonObjectRequest(
            Request.Method.GET,url,null,{Respuesta->


                if (usuario.text.toString()==Respuesta.getString("Nick")&&
                    pass.text.toString()==Respuesta.getString("Pass"))
               {

                   val ventana: Intent = Intent(this,PrincipalActivity::class.java)

                    startActivity(ventana)
                }else
              {
                   Toast.makeText(this, "Puto el k lo lea", Toast.LENGTH_SHORT).show()
                }

            },{
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            })


    procesoCola.add(resultado)
    }
    fun ejecutarAnalitica()
    {
        val analicis: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("mensaje","Integracion de firebase completado")
        analicis.logEvent("InitScreen",bundle)
    }

    fun registro(vista: View){
        val ventana:Intent = Intent(this,Registro::class.java)
        startActivity(ventana)
    }


}