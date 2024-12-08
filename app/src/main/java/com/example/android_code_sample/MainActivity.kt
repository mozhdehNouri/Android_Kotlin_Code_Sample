package com.example.android_code_sample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.android_code_sample.compose_examples.SideEffectWithKey
import com.example.android_code_sample.ui.theme.Android_Code_SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_Code_SampleTheme {
                var counter by remember { mutableIntStateOf(0) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    if (counter < 16) {
                        Greeting(counter = counter,  onCounterChanged = { value ->
                            counter = value +1
                        })
                    } else {
                        REDSC()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(counter: Int, onCounterChanged: (Int) -> Unit) {

    SideEffectWithKey(counter) {
        Log.d("checkCounterRecomposeScope", counter.toString() )
    }

    Button(onClick = {
        onCounterChanged(counter)
    }) {
    }

}

@Composable
fun REDSC(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
}