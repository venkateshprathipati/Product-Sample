package com.example.sample.presentation.view.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.sample.domain.model.products.ProductsModel
import com.example.sample.presentation.ui.theme.SampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(viewModel: ProductsViewModel = hiltViewModel()) {
    val products by viewModel.products.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Item List") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(products) { products ->
                ProductsItem(products = products)
            }
        }
    }
}


@Composable
fun ProductsItem(products: ProductsModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = rememberAsyncImagePainter(products.image),
                contentDescription = products.title,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = products.title, style = MaterialTheme.typography.titleLarge)
                Text(text = products.price.toString(), style = MaterialTheme.typography.bodyMedium)
                Text(text = products.description, style = MaterialTheme.typography.bodySmall)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductsPreview() {
    SampleTheme {
        ProductsScreen()
    }
}