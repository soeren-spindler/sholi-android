package com.spindler.sholi.app.ui.composable

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.spindler.sholi.domain.util.ShoLiLog

@Composable
fun TestSettings(
    onNavigateBack: () -> Unit = {}
) {
    ShoLiLog.i("TestSettings", "TestSettings")
    Text(text = "SETTINGS")
    Button(
        onClick = { onNavigateBack() }
    ) {
        Text(text = "Back")
    }
}
