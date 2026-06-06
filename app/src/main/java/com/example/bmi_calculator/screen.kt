package com.example.bmi_calculator


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Black = Color(0xFF000000)
val White = Color(0xFFffffff)

@Composable
fun BMI_Calculator()
{
    var heightInput by remember { mutableStateOf("") }
    var weightInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("BMI Calculator", fontSize = 28.sp, color = White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = weightInput,
            onValueChange = {weightInput = it },
            label = {Text("Weight (in kg)")}
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = heightInput,
            onValueChange = {heightInput = it },
            label = {Text("Height (in m)")}
        )
        Spacer(modifier = Modifier.height(26.dp))

        Button(onClick = {

            val height = heightInput.toFloatOrNull()
            val weight = weightInput.toFloatOrNull()
            if (height != null && weight!=null && height>0) {
                val bmi = weight/((height)*(height))
                val status = when{
                    bmi<18.5 -> "Underweight"
                    bmi<25 -> "Normal"
                    bmi<30 -> "Overweight"
                    else -> "Obese"
                }
                result="BMI: $bmi\nStatus:$status"
            } else{
                result = "Please enter valid numbers"
            }
        }, modifier = Modifier
            .background(White)
            .width(200.dp)
            .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = White)
            ) {
            Text("Calculate BMI", color = Black, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(result, fontSize = 22.sp, color = White)
    }


}