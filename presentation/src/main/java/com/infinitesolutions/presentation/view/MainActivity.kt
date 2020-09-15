package com.infinitesolutions.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infinitesolutions.presentation.R
import com.infinitesolutions.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
