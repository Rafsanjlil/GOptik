package com.asim.goptik

import FaktaFisikaAdapter
import FaktaFisikaRepo
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.asim.goptik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository = FaktaFisikaRepo(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.topBar.moreButton.setOnClickListener{view->
            showPopupMenu(view)}

        // Get the current fact from the repository
        val currentFact = repository.getCurrentFact()

        // Set up RecyclerView
        val adapter = FaktaFisikaAdapter(listOf(currentFact))
        binding.rcvFakta.layoutManager = LinearLayoutManager(this)
        binding.rcvFakta.adapter = adapter
    }

    //fungsi menu more
    private fun showPopupMenu(view:View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.home_more)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_exit -> {
                    // Keluar dari aplikasi
                    finish()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }


}