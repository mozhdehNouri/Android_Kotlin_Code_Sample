package com.example.android_code_sample.compose_examples

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember


@Composable
@NonRestartableComposable
fun SideEffectWithKey(
    key1: Any,
    block: () -> Unit
) {
    remember(key1) {
        SideEffectWithKey(block)
    }
}

class SideEffectWithKey(private val block: () -> Unit) : RememberObserver {
    
    private var onCallBlock: Unit? = null
    override fun onAbandoned() {
        onCallBlock = null
    }

    override fun onForgotten() {
        onCallBlock = null
    }

    override fun onRemembered() {
        onCallBlock = block()
    }
}
