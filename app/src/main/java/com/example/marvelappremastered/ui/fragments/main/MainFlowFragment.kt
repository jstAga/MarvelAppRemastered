package com.example.marvelappremastered.ui.fragments.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentMainFlowBinding
import com.example.marvelappremastered.ui.core.base.BaseFlowFragment

class MainFlowFragment : BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)


    private lateinit var navController: NavController


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController =
            (requireActivity() as AppCompatActivity).findNavController(R.id.nav_host_fragment_main)
    }

    override fun setupNavigation(navController: NavController) {
        constructBottomNavigation(navController)
    }

    private fun constructBottomNavigation(navController: NavController) {
        setupWithNavController(binding.bottomNavigation, navController)
        binding.bottomNavigation.itemActiveIndicatorColor =
            ContextCompat.getColorStateList(requireContext(), R.color.black)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.shopFragment -> {
                    navController.navigate(R.id.shopFragment)
                    true
                }
                R.id.comicsFragment -> {
                    navController.navigate(R.id.comicsFragment)
                    true
                }
                else -> false
            }
        }
    }
}