package com.example.ministore.ui.home

import androidx.lifecycle.ViewModel
//import com.example.ministore.data.model.CategoryRepo
import com.example.ministore.data.model.ProductCategory
import com.example.ministore.data.model.ProductItem
import com.example.ministore.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CategoryRepository
): ViewModel() {
    private val _categories: List<ProductCategory> = repository.getProducts()
    var categories : List<ProductCategory> =  _categories

    fun getProduct(id: Int): ProductItem{
        return repository.getProduct(id)
    }

    fun getCategory(id: Int): ProductCategory{
        return repository.getCategory(id)
    }
}