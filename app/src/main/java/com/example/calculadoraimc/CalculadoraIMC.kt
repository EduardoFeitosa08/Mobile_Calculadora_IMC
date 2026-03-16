package com.example.calculadoraimc

fun CalcularImc(peso: Double, altura: Double): Double{
    var imc = peso / (Math.pow((altura / 100), 2.0))
    return imc
}

fun ValidarImc(imc: Double): String{
    return when{
        imc < 18.5 && imc > 0 -> " Abaixo do Peso"
        imc > 18.5 && imc < 25 -> " Peso ideal"
        imc >= 25 && imc < 30 -> " Levemente Acima do Peso"
        imc >= 30 && imc < 35 -> " Obesidade Grau I"
        imc >= 35 && imc < 40 -> " Obesidade Grau II"
        imc >= 40 -> " Obesidade Grau III"
        else -> "Imc Invalido"
    }
}
