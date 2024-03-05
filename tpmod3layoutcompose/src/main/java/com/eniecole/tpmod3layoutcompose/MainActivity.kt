package com.eniecole.tpmod3layoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eniecole.tpmod3layoutcompose.ui.theme.TPTheme

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
                    DescriptionPage()
                }
            }
        }
    }
}

@Composable
fun DescriptionPage(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        HeaderPrice()
        ImagePresentation()
        Description()
        Caracteristiques()
    }
}

@Composable
private fun HeaderPrice() {
    Text(
        "Apple iPhone Pro Max Edition",
        style = MaterialTheme.typography.headlineSmall
    )
    Text("2800€", style = MaterialTheme.typography.titleSmall)
    Text("ou 400€/mois")
}

@Composable
private fun ImagePresentation() {
    Spacer(modifier = Modifier.padding(6.dp))
    AsyncImage(
        model = "https://images.frandroid.com/wp-content/uploads/2023/09/iphone-15-pro-max.png",
        contentDescription = null,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(Color(0xFFEAF6FF))
    )
    Spacer(modifier = Modifier.padding(6.dp))
}

@Composable
private fun Description() {
    Text("Description", style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.padding(6.dp))
    Text("Ce téléhpone lorem ipsum lorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsum")
    Spacer(modifier = Modifier.padding(6.dp))
}

@Composable
private fun Caracteristiques() {
    Text("Caractéristiques", style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.padding(6.dp))
    Text("Processeur")
    Text(" 19 coeurs")
    Text(" 125 AI Threads")
    Text("GPU")
    Text(" 256 coeurs")
    Text(" 12 AI")
    Text("Ecran")
    Text(" OLED")
}

@Preview(showBackground = true)
@Composable
fun DescriptionPagePreview() {
    TPTheme {
        DescriptionPage()
    }
}