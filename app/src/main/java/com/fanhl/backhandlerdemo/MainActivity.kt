package com.fanhl.backhandlerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fanhl.backhandlerdemo.ui.theme.BackHandlerDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BackHandlerDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    var expand by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.padding(innerPadding),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = { expand = true }) {
            Text(text = "Expand")
        }

        DropdownMenu(expanded = expand, onDismissRequest = { expand = false }) {
            Text(text = "Content")
        }

        BackHandler(expand) { expand = false }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BackHandlerDemoTheme {
        MainScreen(PaddingValues())
    }
}