package com.greenmarket.app.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.greenmarket.app.data.model.Product
import com.greenmarket.app.data.repositories.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepositoryImpl) :
    BaseViewModel<Product>() {

    override fun fetchAllItems() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val itemList = productRepository.getAllProducts()
                    _items.postValue(itemList)
                }
            } catch (e: Exception){
                // Handle error
            }
        }
    }

}