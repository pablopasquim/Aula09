package com.example.pou5

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pou5.ui.theme.Pou5Theme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutActivity3()
        }
    }
}

@Composable
fun LayoutActivity3(){

    var name by remember {
        mutableStateOf("")
    }

    var adress by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // call the custom text field
        CustomTextField(valor = name,
            onvalueChange = {name = it},
            label = "Plese, enter your name")

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(valor = adress,
            onvalueChange = {adress = it},
            label = "Plese, enter your adress")

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(valor = email,
            onvalueChange = {email = it},
            label = "Plese, enter your email")

        Text(text = "\nNome: $name " +
                "\nEndereço: $adress"+
                "\nEmail: $email",
                fontSize = 20.sp
            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(

    valor: String, // text value
    onvalueChange: (String) -> Unit, // callback when text changes
    label: String // text for label
){

    TextField(value = valor,
        onValueChange = onvalueChange,
        label = { Text(text = label)}
    )

}

@Preview (showBackground = true)
@Composable
fun PreviewLayout3(){
    LayoutActivity3()
}