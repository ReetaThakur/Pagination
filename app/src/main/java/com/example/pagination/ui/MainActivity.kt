package com.example.pagination.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagination.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.Result

class MainActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        setAdapter()
        characterViewModel.searchCharacter().observe(this,{
            it?.let {
               CoroutineScope(Dispatchers.Main).launch {
                   characterAdapter.submitData(it)
               }
            }
        })

    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
           this.adapter = characterAdapter
        }
    }
}
