package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TableLayout
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot


class puntajeGobal : Fragment() {

    lateinit var lv_lista:ListView
    lateinit var txt_mayor:TextView
    lateinit var txt_menor:TextView
    lateinit var txt_anterior:TextView


    var db= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_puntaje_gobal, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lv_lista = view.findViewById(R.id.lv_puntajes)
        txt_mayor = view.findViewById(R.id.txt_mayor)
        txt_menor = view.findViewById(R.id.txt_menor)
        txt_anterior = view.findViewById(R.id.txt_ultimo)
        var lista:ArrayList<String> = arrayListOf<String>()
        db.collection("usuarios").limit(5).orderBy("MayorP",Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Collecciones", "${document.id} => ${document.data.get("Puntaje")}")

                    lista.add("${document.data.get("Nick").toString()} (＠＾◡＾) ${document.data.get("MayorP").toString()}")
                    var adaptador:ArrayAdapter<String> = ArrayAdapter<String>(view.context,R.layout.paralist,lista)
                    lv_lista?.adapter = adaptador
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error", "Error getting documents: ", exception)
            }
        db.collection("usuarios").document("pepe@gmail.com").get().addOnSuccessListener { document->

            txt_mayor.text=document.getString("MayorP")
            txt_menor.text=document.getString("MenorP")
            txt_anterior.text=document.getString("Puntaje")
        }
    }



    companion object {

    }
}