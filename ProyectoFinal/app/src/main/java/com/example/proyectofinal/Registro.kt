package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.net.PasswordAuthentication

class Registro : AppCompatActivity() {
    private lateinit var Nick:EditText
    private lateinit var Email:EditText
    private lateinit var Ps:EditText
    private lateinit var ps2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Nick = findViewById(R.id.txt_Nick)
        Email=findViewById(R.id.txt_Email)
        Ps=findViewById(R.id.txt_Ps)
        ps2=findViewById(R.id.txt_ps2)
    }
    fun InsertU(vista:View){
        val procesoCola: RequestQueue = Volley.newRequestQueue(this)
        val url = "http://192.168.101.14/pfinalphp/InsertUser.php"
        val resultado = object :StringRequest(Request.Method.POST,url,
            {Respuesta->
                Toast.makeText(this, "Resgistro con Exito", Toast.LENGTH_SHORT).show()
                Nick.setText("")
                Email.setText("")
                Ps.setText("")
                ps2.setText("")
            },
            {error->
                Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show()
            }){
            override fun getParams(): MutableMap<String, String>? {
                var parametros = HashMap<String,String>()
                parametros.put("Nick",Nick.text.toString())
                parametros.put("Email",Email.text.toString())
                parametros.put("Pass",Ps.text.toString())
                parametros.put("Calificacion","2")
                parametros.put("Errores","0")
                parametros.put("Aciertos","0")
                return parametros
            }


        }
        procesoCola.add(resultado)
    }
}

