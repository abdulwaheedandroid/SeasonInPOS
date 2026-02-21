package com.abdulwaheed.seasoninnpos.ui.bottom_navigation.home_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulwaheed.seasoninnpos.ui.theme.SeasonInnPOSTheme

@Composable
fun HomeUI() {
    Scaffold(topBar = { TopBar() }) { padding ->
        Row(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            CartPanel(
                modifier = Modifier
                    .weight(0.35f)
                    .fillMaxHeight()
            )
            ProductSection(
                modifier = Modifier
                    .weight(0.65f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.weight(1f),
            placeholder = { Text("Search Items") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true
        )

        Spacer(modifier = Modifier.width(12.dp))

        IconButton(onClick = {}) {
            Icon(Icons.Default.AddCircle, null)
        }

        Spacer(modifier = Modifier.weight(1f))

        Text("Cashier\nJames Lee", textAlign = TextAlign.End)
    }
}

@Composable
fun CartPanel(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(12.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Text("Items", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(5) {
                CartItemRow()
            }
        }
        Divider()
        PriceRow("Sub Total", "$1.50")
        PriceRow("Tax", "$1.50")
        PriceRow("Discount", "-$0.00", Color.Red)

        Spacer(modifier = Modifier.height(8.dp))

        PriceRow("Total", "$1.50")

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                enabled = false
            ) {
                Text("Hold Cart")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Checkout")
            }
        }

    }
}

@Composable
fun PriceRow(
    lable: String,
    lableValue: String,
    valueColor: Color = Color.Black
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = lable)
        Text(text = lableValue, color = valueColor)

    }

}

@Composable
fun CartItemRow() {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Item Name", modifier = Modifier.weight(1f))
            Text("10")
            Spacer(modifier = Modifier.width(8.dp))
            Text("$0.00")
        }
        Text("Discount -$555.55", color = Color.Red, fontSize = 12.sp)
    }
}

@Composable
fun ProductSection(modifier: Modifier) {
    Column(modifier = modifier.padding(12.dp)) {
        Text(
            "Category Title",
            modifier = Modifier
                .background(Color(0xFFF3E5F5), RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )

        Spacer(Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(12) {
                ProductCard()
            }
        }
    }
}

@Composable
fun ProductCard() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFEDE7F6))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.White, CircleShape)
        )

        Spacer(Modifier.height(8.dp))
        Text(
            "Product Name",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}


@Preview(
    showBackground = true,
    device = Devices.TABLET,
)
@Composable
fun GreetingPreview() {
    SeasonInnPOSTheme {
        HomeUI()
    }
}