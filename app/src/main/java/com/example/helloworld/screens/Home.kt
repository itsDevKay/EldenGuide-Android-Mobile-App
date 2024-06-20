package com.example.helloworld.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.helloworld.components.NavDrawer
import com.example.helloworld.data.categoryEntries
import com.example.helloworld.structs.CategoryStruct
import com.example.helloworld.ui.theme.garamond

@Composable
fun Home(navController: NavController) {
    NavDrawer(navController = navController) {
        HomeContent(contentPadding = null)
    }
}

@Composable
fun HomeContent(contentPadding : PaddingValues?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff16150e),
                        Color(0xff1e1b18),
                        Color(0xff36372b),
                        Color(0xff514d41)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        SectionList(entries = categoryEntries)
    }
}

@Composable
fun SectionList(entries: List<CategoryStruct>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp)
    ) {
        items(entries) { entry ->
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .height(200.dp)
                    .background(
                        color = Color(0xff1f201c),
                        shape = RoundedCornerShape(0.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xff989898)
                    )
                    .clickable {
                        Log.d("UserAction", "Clicked ${entry.title}")
                    },
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(entry.coverImage)
                        .setHeader("User-Agent", "Mozilla/5.0")
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .alpha(0.7f)
                )
                Text(
                    entry.title,
                    modifier = Modifier
                        .padding(15.dp)
                        .shadow(
                            elevation = 12.dp
                        ),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    fontFamily = garamond,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}