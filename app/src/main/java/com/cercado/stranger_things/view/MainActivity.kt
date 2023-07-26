package com.cercado.stranger_things.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.cercado.stranger_things.R
import com.cercado.stranger_things.R.id.fragment_container_view_tag
import com.cercado.stranger_things.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    private val mOnNavToolBar = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.elements -> {
                supportFragmentManager.commit {

                    replace<ElementsFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.favorite -> {
                supportFragmentManager.commit {

                    replace<FavoriteFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.information -> {
                supportFragmentManager.commit {

                    replace<InformationFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMenu.setOnNavigationItemSelectedListener (mOnNavToolBar)

        supportFragmentManager.commit {

            replace<ElementsFragment> (fragment_container_view_tag)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}