package com.eniecole.tpmod4stateorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eniecole.tpmod4stateorder.ui.theme.TPTheme
import com.eniecole.tpmod4stateorder.OrderState.*

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
                    OrderPage()
                }
            }
        }
    }
}

@Composable
fun OrderPage(viewModel: OrderViewModel = viewModel()) {
    val stateOrder = viewModel.orderStateFlow.collectAsState()
    when(stateOrder.value){
        is CartState -> CartPage(viewModel)
        is CartValidatedState -> DeliveryAddressPage(viewModel)
        is AddressFilledState -> CreditCardPage(viewModel)
        is CreditCardFilledState -> OrderInProgressPage()
        is OrderFinishedSate -> OrderFinishedPage()
    }
}
@Composable
fun CartPage(viewModel: OrderViewModel ) {
    Column(Modifier.fillMaxWidth()) {
        Text("Vélo à assitance électrique")
        Spacer(Modifier.weight(1f))
        ElevatedButton(onClick={
            viewModel.order()
        }, modifier = Modifier.fillMaxWidth()){
            Text("Passer commande")
        }
    }
}

@Composable
fun DeliveryAddressPage(viewModel: OrderViewModel ) {
    Column(Modifier.fillMaxWidth()) {
        Text("9 rue des lilas PARIS")
        Spacer(Modifier.weight(1f))
        ElevatedButton(onClick={
            viewModel.validateAddress("9 rue des lilas PARIS")
        }, modifier = Modifier.fillMaxWidth()){
            Text("Valider adresse de livraison")
        }
    }
}

@Composable
fun CreditCardPage(viewModel: OrderViewModel ) {
    Column(Modifier.fillMaxWidth()) {
        Text("1923 34923 9324 9324")
        Spacer(Modifier.weight(1f))
        ElevatedButton(onClick={viewModel.pay("1923 34923 9324 9324")}, modifier = Modifier.fillMaxWidth()){
            Text("Payer")
        }
    }

}

@Composable
fun OrderInProgressPage() {
    Box(Modifier.fillMaxSize()){
        Text("Commande en cours", modifier= Modifier.align(Alignment.Center))

    }
}

@Composable
fun OrderFinishedPage() {
    Box(Modifier.fillMaxSize()) {
        Text("Commande validée", modifier = Modifier.align(Alignment.Center))
    }
}