package com.pupusadev.keepingup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    lateinit var listaDeTareasFragment: lista_de_tareas_Fragment
    lateinit var calendarFragment: calendar_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)

        listaDeTareasFragment = lista_de_tareas_Fragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,listaDeTareasFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitNow()


        bottomNavigation.setOnNavigationItemSelectedListener{ item->

            when(item.itemId){
                R.id.lista_tareas->{
                    listaDeTareasFragment = lista_de_tareas_Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,listaDeTareasFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitNow()
                }

                R.id.calendario->{
                    calendarFragment = calendar_Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,calendarFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitNow()
                }

            }
            true
        }
    }

}
