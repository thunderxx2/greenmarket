package com.greenmarket.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskdemoapp.R
import com.greenmarket.app.data.model.Product

class ProductListAdapter() :
    BaseAdapter<Product, ProductListAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onBindData(holder: ProductViewHolder, item: Product) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product_row, parent, false)
        return ProductViewHolder(itemView)
    }

    inner class ProductViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivProductImage = itemView.findViewById<AppCompatImageView>(R.id.iv_product_img)
        val tvProductName =  itemView.findViewById<AppCompatTextView>(R.id.tv_product_name)
        val tvProductDesc =  itemView.findViewById<AppCompatTextView>(R.id.tv_product_desc)
        val tvProductPrice =  itemView.findViewById<AppCompatTextView>(R.id.tv_product_price)
        val btnAddtoCart = itemView.findViewById<AppCompatButton>(R.id.btn_add_to_cart)

        fun bind(product: Product){
            Glide.with(itemView)
                .load(product.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_launcher_foreground)
                .into(ivProductImage)
            tvProductName.text = product.name
            tvProductDesc.text = product.description
            tvProductPrice.text = "$"+product.price.toString().trim()
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}