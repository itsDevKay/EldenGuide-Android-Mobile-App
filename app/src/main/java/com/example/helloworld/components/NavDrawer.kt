package com.example.helloworld.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.helloworld.screens.HomeContent
import com.example.helloworld.ui.theme.garamond
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(navController: NavController, content: @Composable() () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.6f),
                drawerContainerColor = Color(0xff1f201c)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            end = 15.dp,
                            top = 15.dp,
                            bottom = 20.dp,
                            start = 15.dp
                        ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Elden Guide",
                            color = Color(0xffb9a88d),
                            textAlign = TextAlign.Center,
                            fontSize = 28.sp,
                            fontFamily = garamond,
                            fontWeight = FontWeight.Medium
                        )

                        Box(modifier = Modifier.height(30.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .clickable {
                                    Log.d("UserAction", "Home Clicked")
                                    navController.navigate(Destinations.Home)
                                }
                        ) {
                            Icon(
                                Icons.Filled.Home, contentDescription = "",
                                tint = Color(0xffb9a88d),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                "Home",
                                color = Color(0xffb9a88d),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = garamond,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .clickable {
                                    Log.d("UserAction", "Favorites Clicked")
                                    navController.navigate(Destinations.Favorites)
                                }
                        ) {
                            Icon(
                                Icons.Filled.Favorite, contentDescription = "",
                                tint = Color(0xffb9a88d),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                "Favorites",
                                color = Color(0xffb9a88d),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = garamond,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .clickable {
                                    Log.d("UserAction", "Map Clicked")
                                }
                        ) {
                            Icon(
                                Icons.Filled.LocationOn, contentDescription = "",
                                tint = Color(0xffb9a88d),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                "Map",
                                color = Color(0xffb9a88d),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = garamond,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                                .clickable {
                                    Log.d("UserAction", "Collection Clicked")
                                }
                        ) {
                            Icon(
                                Icons.Filled.CheckCircle, contentDescription = "",
                                tint = Color(0xffb9a88d),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                "Collection",
                                color = Color(0xffb9a88d),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = garamond,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://cdn3.emoji.gg/emojis/3796-eldenring.png")
                                .setHeader("User-Agent", "Mozilla/5.0")
                                .build(),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(bottom = 25.dp)
                        )
                        Text(
                            "Made with ❤️ by itsDevKay",
                            color = Color(0xffb9a88d),
                            fontFamily = garamond,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    containerColor = Color(0xffb9a88d),
                    contentColor = Color.White,
                    text = { Text(
                        "Menu",
                        color = Color(0xff1f201c),
                        fontSize = 18.sp,
                        fontFamily = garamond
                    ) },
                    icon = {
                        Icon(
                            Icons.Filled.Menu, contentDescription = "",
                            tint = Color(0xff1f201c)
                        )
                    },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {
                content()
            }
        }
    }
}