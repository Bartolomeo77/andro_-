package com.miempresa.proyectousomenusv4

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementos>()
        for(i in 1 until 20){
            llenarLista.add(Elementos("Elemento"+i,BitmapFactory.decodeResource(resources,R.drawable.imgconfiguracion)))
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter

        registerForContextMenu(lista)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual,menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.getItemId()
        if(id == R.id.configuracion){
            //Toast.makeText(this, "Elegistes menu configuracion", Toast.LENGTH_SHORT).show();
            val llamaractividad = Intent(applicationContext,Configuracion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if(id == R.id.informacion){
            //Toast.makeText(this, "Elegistes menu informacion", Toast.LENGTH_SHORT).show();
            val llamaractividad = Intent(applicationContext,Informacion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nombre ->{
                Toast.makeText(this,"Elejistes nombre",Toast.LENGTH_LONG).show()
            }
            R.id.semestre ->{
                Toast.makeText(this,"Elejistes semestre",Toast.LENGTH_LONG).show()
            }
            R.id.email->{
                Toast.makeText(this,"Elejistes email",Toast.LENGTH_LONG).show()
            }
            R.id.carrera ->{
                Toast.makeText(this,"Elejistes carrera",Toast.LENGTH_LONG).show()
            }

        }

        return super.onContextItemSelected(item)
    }
}