package com.example.helloworld.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Shapes
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helloworld.components.NavDrawer
import com.example.helloworld.ui.theme.garamond
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun Favorites(navController: NavController) {
    NavDrawer(navController = navController) {
        FavoritesContent(contentPadding = null)
    }
}

@Composable
fun FavoritesContent(contentPadding : PaddingValues?) {

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
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            TabScreen()
        }
    }
}

@Composable
fun TabScreen() {
    var tabIndex by remember() {
        mutableStateOf(0)
    }

    val tabs = listOf("Ammo", "Armors", "Ashes of War", "Bosses", "Classes", "Creatures", "Incantations", "Items", "Locations", "NPCs", "Shields", "Sorceries", "Spirit Ashes", "Talismans", "Weapons")

    Column(modifier = Modifier.fillMaxWidth()) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            containerColor = Color(0xff1c1d17),
            contentColor = Color(0xffb2ad9a),
            divider = {
                HorizontalDivider(
                    color = Color(0xff3f3f39)
                )
            },
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = Color(0xffaca07d)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            fontFamily = garamond
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> Icon(imageVector = Icons.Default.Info, contentDescription = null)
                            2 -> Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                            3 -> Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                            4 -> Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                            5 -> Icon(imageVector = Icons.Default.Star, contentDescription = null)
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> Text("Ammo", color = Color.White)
            1 -> Text("Armors", color = Color.White)
            2 -> Text("Ashes of War", color = Color.White)
//            3 -> MoreScreen()
//            4 -> SomethingScreen()
//            5 -> EverythingScreen()
        }
    }
}
