package com.example.proyectofinal

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.sync.Semaphore
import org.checkerframework.common.subtyping.qual.Bottom
import kotlin.math.roundToInt


class JuegoFragment(var email:String) : Fragment() {
    private val bd = FirebaseFirestore.getInstance()
    var respuesta:String=""
    var preguntah = 1
    var aciertos = 0
    var errores = 0
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


        var btn: Button = view.findViewById(R.id.iniv)
        var rb1: RadioButton=view.findViewById(R.id.rb1)
        var rb2: RadioButton=view.findViewById(R.id.rb2)
        var rb3: RadioButton=view.findViewById(R.id.rb3)
        var rb4: RadioButton=view.findViewById(R.id.rb4)
        var txterr: TextView = view.findViewById(R.id.txtErrores)
        var txtaci: TextView = view.findViewById(R.id.txtAciertos)



        txterr.text = errores.toString()
        txtaci.text = aciertos.toString()
        val bd = FirebaseFirestore.getInstance()
        var rb = arrayListOf<RadioButton>(rb1,rb2,rb3,rb4)
        var rp1: RadioButton
        var rp2: RadioButton
        var rp3: RadioButton
        var rp4: RadioButton

        rp1=rb.random()
        rb.remove(rp1)
        rp2=rb.random()
        rb.remove(rp2)
        rp3=rb.random()
        rb.remove(rp3)
        rp4=rb.random()
        rb.remove(rp4)
        var prue = "fdvd"

           val txt: TextView   =view.findViewById(R.id.re)



        var pregunta = 1 .. 50
        val doc = bd.collection("Pregunta").document(pregunta.random().toString())
        doc.get().addOnSuccessListener { document ->
            if (document != null){
                respuesta = document.getString("Respuesta").toString()
                rp1.text= document.getString("Respuesta")
                rp2.text= document.getString("Incorrecta1")
                rp3.text= document.getString("Incorrecta2")
                rp4.text= document.getString("Incorrecta3")
                txt.text = document.getString("Pregunta")



            }else{
                Log.d("tag","errror")
            }

        }

        btn.setOnClickListener{
            Log.d("Pregunta",preguntah.toString())
            if (rb1.isChecked){
                rb1.isChecked = false
                if(preguntah==13){

                    mostraralerta(view,aciertos,errores)
                    aciertos = 0
                    errores = 0
                    txterr.text="0"
                    txtaci.text ="0"
                    preguntah = 0

                }else{
                    if(rb1.text.toString() == respuesta){

                        Toast.makeText(view.context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                        aciertos += 1
                        preguntah += 1
                        txtaci.text = aciertos.toString()
                        agregarpuntaje(aciertos)
                        cargarPregunta(view)


                    }else{

                        Toast.makeText(view.context, "Respuesta Incorracta, la respuesta es $respuesta", Toast.LENGTH_SHORT).show()
                        errores += 1
                        preguntah += 1
                        txterr.text = errores.toString()

                        cargarPregunta(view)
                    }

                }

            }else if(rb2.isChecked){
                rb2.isChecked = false
                if(preguntah==13){
                    mostraralerta(view,aciertos,errores)
                    aciertos = 0
                    errores = 0
                    txterr.text="0"
                    txtaci.text ="0"
                    preguntah = 0
                }else{
                    if(rb2.text.toString() == respuesta){

                        Toast.makeText(view.context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                        aciertos += 1
                        preguntah += 1
                        txtaci.text = aciertos.toString()
                        agregarpuntaje(aciertos)
                        cargarPregunta(view)

                    }else{

                        Toast.makeText(view.context, "Respuesta Incorracta, la respuesta es $respuesta", Toast.LENGTH_SHORT).show()
                        errores += 1
                        preguntah += 1
                        txterr.text = errores.toString()

                        cargarPregunta(view)
                    }

                }

            }else if(rb3.isChecked){
                rb3.isChecked = false
                if(preguntah==13){
                    mostraralerta(view,aciertos,errores)
                    aciertos = 0
                    errores = 0
                    txterr.text="0"
                    txtaci.text ="0"
                    preguntah = 0
                }else{
                    if(rb3.text.toString() == respuesta){
                        Toast.makeText(view.context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                        aciertos += 1
                        preguntah += 1
                        txtaci.text = aciertos.toString()
                        agregarpuntaje(aciertos)
                        cargarPregunta(view)

                    }else{

                        Toast.makeText(view.context, "Respuesta Incorracta, la respuesta es $respuesta", Toast.LENGTH_SHORT).show()
                        errores += 1
                        preguntah += 1
                        txterr.text = errores.toString()

                        cargarPregunta(view)
                    }

                }

            }else if(rb4.isChecked){
                rb4.isChecked = false
                if(preguntah==13){
                    mostraralerta(view,aciertos,errores)
                    aciertos = 0
                    errores = 0
                    txterr.text="0"
                    txtaci.text ="0"
                    preguntah = 0
                }else{
                    if(rb4.text.toString() == respuesta){
                        Toast.makeText(view.context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                        aciertos += 1
                        preguntah += 1
                        txtaci.text = aciertos.toString()
                        agregarpuntaje(aciertos)
                        cargarPregunta(view)

                    }else{
                        Toast.makeText(view.context, "Respuesta Incorracta, la respuesta es $respuesta", Toast.LENGTH_SHORT).show()
                        errores += 1
                        preguntah += 1
                        txterr.text = errores.toString()

                        cargarPregunta(view)
                    }

                }

            }else{
                Toast.makeText(view.context, "Seleccione una respuesta", Toast.LENGTH_SHORT).show()
            }


        }



    }

    fun cargarPregunta(view: View){
        var rb1: RadioButton=view.findViewById(R.id.rb1)
        var rb2: RadioButton=view.findViewById(R.id.rb2)
        var rb3: RadioButton=view.findViewById(R.id.rb3)
        var rb4: RadioButton=view.findViewById(R.id.rb4)

        val bd = FirebaseFirestore.getInstance()
        var rb = arrayListOf<RadioButton>(rb1,rb2,rb3,rb4)
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

                respuesta = document.getString("Respuesta").toString()
                rp1.text= document.getString("Respuesta")
                rp2.text= document.getString("Incorrecta1")
                rp3.text= document.getString("Incorrecta2")
                rp4.text= document.getString("Incorrecta3")
                txt.text = document.getString("Pregunta")

            }else{
                Log.d("tag","errror")
            }

        }
    }
    var puntajemay="0"
    var puntajemen="0"
    var nick="0"
    fun agregarpuntaje(aciertos:Int){
        var puntaje:Float = aciertos.toFloat()/12*1000
        Log.d("Puntaje",puntaje.toString())

        bd.collection("usuarios").document(email).get().addOnSuccessListener{ document ->
            if(document != null){

                puntajemay= document.getString("MayorP").toString()
                puntajemen =document.getString("MenorP").toString()
                nick = document.getString("Nick").toString()
                bd.collection("usuarios").document(email).set(

                    if(puntajemay.toInt()>puntaje.roundToInt() ){
                        if(puntajemen.toInt() > puntaje.roundToInt() || puntajemen.toInt() == 0){

                            hashMapOf(
                                "Email" to email,
                                "Nick" to nick,
                                "Puntaje" to puntaje.roundToInt().toString(),
                                "MayorP" to puntajemay,
                                "MenorP" to puntaje.roundToInt().toString()
                            )
                        }else{
                            hashMapOf(
                                "Email" to email,
                                "Nick" to nick,
                                "Puntaje" to puntaje.roundToInt().toString(),
                                "MayorP" to puntajemay,
                                "MenorP" to puntajemen
                            )
                        }

                    } else {
                        if(puntajemen.toInt() > puntaje.roundToInt() || puntajemen.toInt() == 0){

                            hashMapOf(
                                "Email" to email,
                                "Nick" to nick,
                                "Puntaje" to puntaje.roundToInt().toString(),
                                "MayorP" to puntaje.roundToInt().toString(),
                                "MenorP" to puntaje.roundToInt().toString()
                            )
                        }else{
                            hashMapOf(
                                "Email" to email,
                                "Nick" to nick,
                                "Puntaje" to puntaje.roundToInt().toString(),
                                "MayorP" to puntaje.roundToInt().toString(),
                                "MenorP" to puntajemen
                            )
                        }
                    }

                )
            }else{

            }


        }

    }
    fun mostraralerta(view: View,aciertos: Int,errores:Int){
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Ronda Finalizada")
        builder.setMessage("Respuesta correctas $aciertos, respuestas incorrectas $errores")
        builder.setPositiveButton("aceptar",null)
        val dialog=builder.create()
        dialog.show()
    }
    companion object {
      private const val ARG_OBJECT2 = "objeto"
    }
}