package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraIMC(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculadoraIMC(modifier: Modifier = Modifier) {

    var altura by remember {
        mutableStateOf("")
    }
    var peso by remember{
        mutableStateOf("")
    }

    var imc by remember {
        mutableStateOf(0.0)
    }
    var resultado by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(color = colorResource(R.color.cor_app)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Calculadora IMC",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            //form
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .offset(0.dp, -30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(222, 222, 222, 255)
                ),
                elevation = CardDefaults.cardElevation(4.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Seus dados",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.cor_app)
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 30.dp)
                            .border(2.dp, color = colorResource(R.color.cor_app), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp)),
                        placeholder = {
                            Text(
                                text = "Altura",
                                modifier = Modifier
                                    .fillMaxWidth(),
                            )
                        },
                        onValueChange = {it -> altura = it},
                        value = altura,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.cor_app),
                            focusedBorderColor = colorResource(R.color.cor_app)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 30.dp)
                            .border(2.dp, color = colorResource(R.color.cor_app), RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp)),
                        placeholder = {
                            Text(
                                text = "Peso",
                                modifier = Modifier
                                    .fillMaxWidth(),
                            )
                        },
                        onValueChange = {it -> peso = it},
                        value = peso,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.cor_app),
                            focusedBorderColor = colorResource(R.color.cor_app)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        )
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 30.dp),
                        onClick = {
                            imc = peso.toDouble() / (Math.pow((altura.toDouble() / 100), 2.0))
                            resultado = "%.2f".format(imc)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.cor_app),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "CALCULAR",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }

            //result
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when{
                        imc > 18.5 && imc < 25 -> Color(139, 224, 55, 255)
                        imc >= 25 && imc < 30 -> Color(248, 104, 27, 255)
                        else -> Color(239, 57, 57, 255)
                    }
                ),
                elevation = CardDefaults.cardElevation(4.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when{
                            imc < 18.5 && imc > 0 -> "$resultado Abaixo do Peso"
                            imc > 18.5 && imc < 25 -> "$resultado Peso ideal"
                            imc >= 25 && imc < 30 -> "$resultado Levemente Acima do Peso"
                            imc >= 30 && imc < 35 -> "$resultado Obesidade Grau I"
                            imc >= 35 && imc < 40 -> "$resultado Obesidade Grau II"
                            imc >= 40 -> "$resultado Obesidade Grau III"
                            else -> "Imc Invalido"
                        },
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(vertical = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(112, 66, 20, 255),
                    contentColor = Color.White
                ),
                onClick = {
                    altura = ""
                    peso = ""

                }
            ) {
                Text(
                    text = "Limpar Dados",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }



        }
    }


}