package com.example.pagination.ui

import androidx.lifecycle.ViewModel

class CharacterViewModel:ViewModel() {
    private val respository=CharacterRepository()
    fun searchCharacter()=respository.getPageList()
}