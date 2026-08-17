package com.example.cse226

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cse226.ui.theme.CSE226Theme

class PractiseApi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface {
                    DetailScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
fun DetailScreen() {
    var expanded by remember{mutableStateOf(false)}
    val buttonColor by animateColorAsState(
        if(!expanded) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.secondary,
        label="Button Color"
    )
    Column(modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier.padding(18.dp)) {
            Column(modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Pranav Gaira",
                    style = MaterialTheme.typography.headlineSmall)
                Text("BTech 4th Year")
                AnimatedVisibility(expanded,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Column(Modifier.padding(top=18.dp)) {
                        Text("Email: user@gmail.com")
                        Text("Phone: 7078911356")
                        Text("Attendance: 85%")
                    }
                }
                Button(onClick = {expanded=!expanded},
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
                    Text(if(expanded) "Hide Details"
                    else "Show Details"
                    )
                }
            }
        }
    }
}
