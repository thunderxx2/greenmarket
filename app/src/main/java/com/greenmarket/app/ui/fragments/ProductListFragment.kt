package com.greenmarket.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.greenmarket.app.data.database.AppDatabase
import com.greenmarket.app.data.model.Product
import com.greenmarket.app.databinding.FragmentProductListBinding
import com.greenmarket.app.ui.adapters.ProductListAdapter
import com.greenmarket.app.ui.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductListFragment : BaseFragment<FragmentProductListBinding>() {

    @Inject
    lateinit var appDatabase: AppDatabase

    private lateinit var binding: FragmentProductListBinding

    private val productViewModel: ProductViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProductListBinding {
        binding = FragmentProductListBinding.inflate(inflater)
        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        insertDummyData()
        productViewModel.fetchAllItems()
        productViewModel._items.observe(viewLifecycleOwner) { products ->
            val adapter = ProductListAdapter()
            adapter.createList(products)
            binding.rvProducts.adapter = adapter
            binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initializeViews() {
    }

    override fun setupListeners() {
    }

    private fun insertDummyData() {
        val productDao = appDatabase.productDao()
        val dummyProducts = listOf<Product>(
            Product(
                "1",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "2",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "3",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "4",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "5",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "6",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "7",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "8",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            ),
            Product(
                "9",
                "Wireless Gaming Headset",
                "Gaming headphones that offer 15 hours of battery life on a single charge",
                500.0,
                "https://media.istockphoto.com/id/1289318271/photo/3d-pink-headphones.webp?s=1024x1024&w=is&k=20&c=6L92VJrvKzk4aaCEPqX2Yv5XIxY_QTP2KvbMSFMLaWE="
            )
        )
        CoroutineScope(Dispatchers.IO).launch {
            dummyProducts.forEach { product ->
                productDao.inserProduct(product)
            }
        }
    }
}