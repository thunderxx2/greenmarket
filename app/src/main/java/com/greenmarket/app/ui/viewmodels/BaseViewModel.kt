package com.greenmarket.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : Any> :
    ViewModel() {
    val _items = MutableLiveData<List<T>>()
    val items: LiveData<List<T>> get() = _items

    abstract fun fetchAllItems()
}