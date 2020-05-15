package com.lchowaniec.app_template.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lchowaniec.app_template.R
import com.lchowaniec.app_template.ui.Second.SecondInsideFragment
import com.lchowaniec.app_template.util.BottomNavController
import com.lchowaniec.app_template.util.setUpNavigation
import com.lchowaniec.app_template.util.startAuthActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BottomNavController.NavGraphProvider,
    BottomNavController.OnNavigationGraphChanged,
    BottomNavController.OnNavigationReselectedListener
{

    lateinit var viewModel: MainViewModel
    private lateinit var bottomNavigationView: BottomNavigationView

    private val bottomNavController by lazy(LazyThreadSafetyMode.NONE) {
        BottomNavController(
            this,
            R.id.main_nav_host_fragment,
            R.id.nav_first,
            this,
            this)
    }

    override fun getNavGraphId(itemId: Int) = when(itemId){
        R.id.nav_first -> {
            R.navigation.nav_first
        }

        R.id.nav_second -> {
            R.navigation.nav_second
        }
        R.id.nav_third -> {
            R.navigation.nav_third
        }

        else -> {
            R.navigation.nav_first
        }
    }

    override fun onGraphChange() {
//        TODO("What needs to happen when the graph changes?")
    }

    override fun onReselectNavItem(
        navController: NavController,
        fragment: Fragment
    ) = when(fragment){

        is SecondInsideFragment -> {
            navController.navigate(R.id.action_secondInsideFragment_to_secondFragment)
        }


        else -> {
            // do nothing
        }
    }

    override fun onBackPressed() = bottomNavController.onBackPressed()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar()
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setUpNavigation(bottomNavController, this)
        if (savedInstanceState == null) {
            bottomNavController.onNavigationItemSelected()
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



    }


    private fun setupActionBar(){
        setSupportActionBar(tool_bar)
    }

    override fun onStart() {
        super.onStart()
        if(viewModel.user == null){
            startAuthActivity()
        }
    }

}



