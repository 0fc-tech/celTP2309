package com.eniecole.tpmod5testunit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eniecole.tpmod5testunit.ui.theme.TPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

fun checkPassword(pwd : String) : Boolean{
    val is8charLong = pwd.length >= 8
    val containsSpecialsChars =
        pwd.contains(".") ||
        pwd.contains(":") ||
        pwd.contains("?") ||
        pwd.contains("!") ||
        pwd.contains("=") ||
        pwd.contains("*")
    var containsCap = false
    for (char in pwd){
        if(char.isUpperCase()) {
            containsCap = true
        }
    }
    return is8charLong && containsSpecialsChars && containsCap
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TPTheme {
        Greeting("Android")
    }
}