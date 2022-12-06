package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.net.PasswordAuthentication
import android.widget.Toast as toast

class Registro : AppCompatActivity() {
    private lateinit var Nick:EditText
    private lateinit var Email:EditText
    private lateinit var Ps:EditText
    private lateinit var ps2:EditText

    private var DB = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Nick = findViewById(R.id.txt_Nick)
        Email=findViewById(R.id.txt_Email)
        Ps=findViewById(R.id.txt_Ps)
        ps2=findViewById(R.id.txt_ps2)

    }
    fun InsertU(vista:View){
        if(Nick.text.isNotEmpty()){
            if(Ps.text.toString() == ps2.text.toString()){
                if(Email.text.isNotEmpty()&&Ps.text.isNotEmpty()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email.text.toString(),Ps.text.toString()).addOnCompleteListener{
                        Log.d("Contraseña",Ps.text.toString())
                        if(it.isSuccessful){
                            DB.collection("usuarios").document(Email.text.toString()).set(
                                hashMapOf(
                                    "Email" to Email.text.toString(),
                                    "Nick" to Nick.text.toString(),
                                    "Puntaje" to "0",
                                    "Partidas" to "0",
                                    "MayorP" to "0",
                                    "MenorP" to "0"
                                )

                            )
                            toast.makeText(this, "exito", toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            toast.makeText(this, "Ocurrio un error", toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }else{
                toast.makeText(this,"contraseña no coincide",toast.LENGTH_LONG).show()
            }
        }else{
            toast.makeText(this,"no deje espacios en blanco",toast.LENGTH_LONG).show()
        }


    }
}

