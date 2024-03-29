package com.eniecole.tpmod3listtache

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eniecole.tpmod3listtache.ui.theme.TPTheme

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
                    PageTaches()
                }
            }
        }
    }
}
@Composable
fun PageTaches(){
    val mutableStateTaches = remember { mutableStateListOf<Tache>() }
    var mutableStateIsAlrDone by rememberSaveable { mutableStateOf(false) }
    var mutableStateTache by rememberSaveable { mutableStateOf("") }
    Scaffold(contentWindowInsets = WindowInsets(16.dp,16.dp,16.dp,16.dp)) { innerPadding->
        Column(Modifier.fillMaxWidth()
            .padding(innerPadding)) {
            Row(Modifier.fillMaxWidth()) {
                TextField(modifier = Modifier.fillMaxWidth(),
                    value = mutableStateTache,
                    onValueChange = {
                        mutableStateTache = it
                    }
                )
                Checkbox(modifier = Modifier.defaultMinSize(72.dp),
                    checked = mutableStateIsAlrDone,
                    onCheckedChange = {
                        mutableStateIsAlrDone = mutableStateIsAlrDone.not()
                    }
                )
            }
            OutlinedButton(onClick = {
                mutableStateTaches.add(Tache(mutableStateTache, mutableStateIsAlrDone))
            }) {
                Text("AJOUTER")
            }
            LazyColumn(Modifier.fillMaxHeight()) {
                items(mutableStateTaches) { tache ->
                    Row(Modifier.padding(8.dp)) {
                        Text(tache.name)
                        Spacer(Modifier.weight(1f))
                        Text(if (tache.isAlreadyDone) "Done" else "A faire")
                    }
                }
            }
        }
    }
}