package com.androidtechguru.kotlinpractice.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androidtechguru.kotlinpractice.rxjava.data.model.ProductItem


@Composable
fun ProductListView(products: List<ProductItem>) {
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(products) { product ->
            ProductItemRow(product)
        }
    }
}

@Composable
fun ProductItemRow(product: ProductItem) {
    Text(text = "${product.id} : price-> ${product.price} => ${product.title}",
        modifier = Modifier.padding(10.dp))
}
