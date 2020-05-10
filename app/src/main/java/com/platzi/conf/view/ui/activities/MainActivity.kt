package com.platzi.conf.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
import com.platzi.conf.R
import com.platzi.conf.model.Team
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                val jsonArr = JSONArray("[\n" +
                "            {\n" +
                "                'image' : 'https://www.kindpng.com/picc/m/28-284461_transparent-dentures-clipart-arsenal-de-sarandi-escudo-hd.png',\n" +
                "                'name' : 'Arsenal Fútbol Club',\n" +
                "                'puntos' : '18',\n" +
                "                'promedio' : '1.413',\n" +
                "                'website' : 'http://clubgodoycruz.com.ar/'\n" +
                "            }\n" +
                "        ]")



        val firebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonArr.length()) {
            val aux = jsonArr.get(i) as JSONObject
            var team = Team()
            team.name = aux.getString("name")
            team.estadio = aux.getString("estadio")
            team.entrenador = aux.getString("entrenador")
            team.fundación = aux.getString("fundación")
            team.apodos = aux.getString("apodos")
            team.image = aux.getString("image")
            team.capacidad = aux.getString("capacidad")

            firebaseFirestore.collection("teams").document().set(team)
        }


        setActionBar(findViewById(R.id.toolbarMain))
        configNav()

    }

    private fun configNav() {
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }

}
