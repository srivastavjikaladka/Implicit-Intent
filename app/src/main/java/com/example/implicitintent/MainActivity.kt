package com.example.implicitintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.implicitintent.ui.theme.ImplicitIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImplicitIntentTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                     val intent = Intent(Intent.ACTION_SEND).apply{
                         type = "text/plain"
                         putExtra(Intent.EXTRA_EMAIL, arrayOf("anupmasrivastava593@gmail.com"))
                         putExtra(Intent.EXTRA_SUBJECT, "Email Subject")
                         putExtra(Intent.EXTRA_TEXT, "Email Text")


                     }
                        if (intent.resolveActivity(packageManager) != null) {
                            val chooser = Intent.createChooser(intent, "Send Email via")
                            startActivity(chooser)
                        }
                    }) {
                        Text(text = "Click Me")

                    }
                }
            }
        }
    }
}


