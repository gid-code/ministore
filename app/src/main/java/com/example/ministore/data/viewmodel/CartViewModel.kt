package com.example.ministore.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ministore.data.model.CartItem
import com.example.ministore.data.model.ProductItem
import com.example.ministore.data.model.products
import dagger.hilt.android.lifecycle.HiltViewModel
import io.paperdb.Paper
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(): ViewModel() {
//    var cartItems : MutableList<CartItem> = mutableListOf(CartItem(products[2],2,300.0),
//        CartItem(products[9],1,100.0)
//    )

    var cartItems : MutableList<CartItem> = Paper.book().read("cartItems", mutableListOf())

    fun inCart(productId : Int): Boolean{
        return cartItems.find { it.item.id == productId } != null
    }

    fun addCart(product: ProductItem){
        cartItems.add(CartItem(product,1,product.price))
        Paper.book().write("cartItems",cartItems)
    }

    fun removeFromCart(item: CartItem): MutableList<CartItem>{
        cartItems.remove(item)
        Paper.book().write("cartItems",cartItems)
        return cartItems
    }

    fun increase(item: CartItem){
        cartItems.find { it.item.id == item.item.id }?.quantity = item.quantity++
        Paper.book().write("cartItems",cartItems)
//        item.quantity++
//        cartItems.
    }
}