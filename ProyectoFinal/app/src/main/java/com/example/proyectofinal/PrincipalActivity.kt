package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PrincipalActivity : AppCompatActivity() {
    lateinit var tb_Layaut:TabLayout
    lateinit var vp_Layaut:ViewPager2
    var cantidad = 3



    private val adaptador by lazy {
        adaptadorF(this)
    }
    private val adaptador2e by lazy {
        adaptador2(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
       var bundle:Bundle? = intent.extras
        tb_Layaut=findViewById(R.id.tb_layaot)
        vp_Layaut=findViewById(R.id.vp_layaout)
        var prueva = prueva()
        Log.d("principal",prueva.nombre)
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

    override fun onBackPressed() {
        if(cantidad != 3){
            vp_Layaut.adapter=adaptador
            cantidad == 3
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
        }else{
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.cuenta -> {
                val fragment = info_cuenta()

                vp_Layaut.adapter = adaptador2e
                cantidad = 1
                var mitabla = TabLayoutMediator(tb_Layaut,vp_Layaut,TabLayoutMediator.TabConfigurationStrategy{
                        tab,position ->
                    when (position) {
                        0->{
                            tab.text=""
                        }

                    }
                })
                mitabla.attach()

                //var ventana:Intent = Intent(this,Ventana2::class.java)
                //startActivity(ventana)
            }

            R.id.cerrar -> {
                finish()
            }

        }
        return true
    }
}