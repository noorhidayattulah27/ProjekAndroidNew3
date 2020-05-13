package com.projekandroidnew

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_game.texthasil
import kotlinx.android.synthetic.main.activity_hitung.*
import java.util.*
import kotlinx.android.synthetic.main.activity_game.textPlayer1 as textPlayer1

private const val Batu = 1
private const val Kertas = 2
private const val  Gunting = 3

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var pilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener{
            pilihanPlayer = Batu
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text=""
            Handler().postDelayed({
            texthasil.text = suwit(pilihanPlayer, pilihanKomputer)
            textPlayer1.text = "BATU"
            showpilihanKomputer(pilihanKomputer)
            },2000)

        }

        buttonGunting.setOnClickListener{

            pilihanPlayer = Gunting
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text=""
            Handler().postDelayed({
                texthasil.text = suwit(pilihanPlayer, pilihanKomputer)
                textPlayer1.text = "Gunting"
                showpilihanKomputer(pilihanKomputer)
            },2000)



        }
        buttonKertas.setOnClickListener{
            pilihanPlayer = Kertas
            pilihanKomputer = getPilihanKomputer()
            textKomputer.text=""
            Handler().postDelayed({
                texthasil.text = suwit(pilihanPlayer, pilihanKomputer)
                textPlayer1.text = "Kertas"
                showpilihanKomputer(pilihanKomputer)
            },2000)

        }

    }

    fun getPilihanKomputer():Int{
        return Random().nextInt(3 )+1;
    }

    fun suwit(PilihanPlayer : Int , pilihanKomputer:Int):String {

        var hasil: String = ""
        if (PilihanPlayer == pilihanKomputer) {
            hasil = "SERI"
            texthasil.setTextColor(Color.BLUE)
        }
        else if((PilihanPlayer == Batu && pilihanKomputer == Kertas) ||
            (PilihanPlayer == Gunting && pilihanKomputer == Batu) ||
            (PilihanPlayer == Kertas && pilihanKomputer == Gunting)){

            hasil = "YOU LOSE"
            texthasil.setTextColor(Color.RED)
        }
        else{
            hasil = "YOU WIN"
            texthasil.setTextColor(Color.GREEN)
        }

        return hasil
    }

    fun showpilihanKomputer(pilihanKomputer: Int){
        when(pilihanKomputer){
            1 -> textKomputer.text  = "Komputer Memilih Batu"
            2 -> textKomputer.text  = "Komputer Memilih Gunting"
            3 -> textKomputer.text  = "Komputer Memilih Kertas"
        }
    }

}