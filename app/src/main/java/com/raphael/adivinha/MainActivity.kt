package com.raphael.atividadeadivinha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast

import com.raphael.adivinha.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random.Default.nextInt


class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    val random = (0..100).random().toString().toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun conferir(view: View) {
        val entrada: Int = entradaValor.text.toString().toInt()
        this.entradaValor.text = " "
        if  (entrada == this.random) {
            this.resultado.text = "Você acertou, o número é:"
            this.resultado2.text = random.toString()
        }
        else if
                     (entrada > this.random) {
            this.resultado.text = "Digite um número menor"
                     }
        else {
            this.resultado.text = "Digite um número maior"
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}