package com.eniecole.mod4tpstateflowvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.eniecole.mod4tpstateflowvm.ui.theme.TPTheme

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterPage()
                }
            }
        }
    }
}

@Composable
fun CounterPage(viewModel: CounterViewModel = viewModel()) {
    val counterState = viewModel.counterState.collectAsState().value
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$counterState",
            style = MaterialTheme.typography.headlineLarge
        )
        Row{
            IconButton(onClick = { viewModel.increment() }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowUp,contentDescription = null)
            }
            IconButton(onClick = { viewModel.decrement() }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowDown,contentDescription = null)
            }
        }
        OutlinedButton(onClick = { viewModel.triggerReset() }) {
            Text("Remise à zéro")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPagePreview() {
    TPTheme {
        CounterPage()
    }
}