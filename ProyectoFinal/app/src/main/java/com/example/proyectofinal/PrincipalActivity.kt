package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PrincipalActivity : AppCompatActivity() {
    lateinit var tb_Layaut:TabLayout
    lateinit var vp_Layaut:ViewPager2

    private val adaptador by lazy {
        adaptadorF(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        tb_Layaut=findViewById(R.id.tb_layaot)
        vp_Layaut=findViewById(R.id.vp_layaout)

        vp_Layaut.adapter=adaptador
        var mitabla = TabLayoutMediator(tb_Layaut,vp_Layaut,TabLayoutMediator.TabConfigurationStrategy{
                tab,position ->
            when (position) {
                0->{
                    tab.text=""
                }
                1->{
                    tab.text=""
                }
                2->{
                    tab.text=""
                }
            }
        })
        mitabla.attach()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cuenta,menu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.cuenta -> {
                Toast.makeText(this,"has seleccionado contactos", Toast.LENGTH_SHORT).show()
            }

            R.id.cerrar -> {
                finish()
            }

        }
        return true
    }
}