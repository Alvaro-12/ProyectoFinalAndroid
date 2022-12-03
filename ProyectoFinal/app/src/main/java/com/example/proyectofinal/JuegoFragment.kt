package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import org.checkerframework.common.subtyping.qual.Bottom


class JuegoFragment : Fragment() {
  private val bd = FirebaseFirestore.getInstance()

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
        return inflater.inflate(R.layout.fragment_juego, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var rb1: RadioButton=view.findViewById(R.id.rb1)
        var rb2: RadioButton=view.findViewById(R.id.rb2)
        var rb3: RadioButton=view.findViewById(R.id.rb3)
        var rb4: RadioButton=view.findViewById(R.id.rb4)
        var btn: Button = view.findViewById(R.id.iniv)
        val bd = FirebaseFirestore.getInstance()
        var rb = arrayListOf<RadioButton>(rb1,rb2,rb3,rb4)

       cargarPregunta(rb,view)

        btn.setOnClickListener{
            cargarPregunta(rb,view)
        }



    }
    fun cargarPregunta(rb:ArrayList<RadioButton>, view: View){
        var rp1: RadioButton
        var rp2: RadioButton
        var rp3: RadioButton
        var rp4: RadioButton
        val txt: TextView   =view.findViewById(R.id.re)
        rp1=rb.random()
        rb.remove(rp1)
        rp2=rb.random()
        rb.remove(rp2)
        rp3=rb.random()
        rb.remove(rp3)
        rp4=rb.random()
        rb.remove(rp4)

        var pregunta = 1 .. 50
        val doc = bd.collection("Pregunta").document(pregunta.random().toString())
        doc.get().addOnSuccessListener { document ->
            if (document != null){
                rp1.text= document.getString("Respuesta")
                rp2.text= document.getString("Incorrecta1")
                rp3.text= document.getString("Incorrecta2")
                rp4.text= document.getString("Incorrecta3")
                txt.text = document.getString("Pregunta")

                Log.d("tag", ARG_OBJECT2)
            }else{
                Log.d("tag","errror")
            }

        }
    }

    companion object {
      private const val ARG_OBJECT2 = "objeto"
    }
}