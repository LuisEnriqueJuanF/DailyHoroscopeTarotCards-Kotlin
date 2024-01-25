package com.luisenrique.horoscopeapp.ui.providers

import com.luisenrique.horoscopeapp.R
import com.luisenrique.horoscopeapp.ui.model.LuckModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor() {
    fun getLuck(): LuckModel? {
        return when (Random.nextInt(0, 32)) {
            0 -> LuckModel(R.drawable.card_hope, R.string.luck_0)
            1 -> LuckModel(R.drawable.card_justice, R.string.luck_1)
            2 -> LuckModel(R.drawable.card_temperance, R.string.luck_2)
            3 -> LuckModel(R.drawable.card_thedevil, R.string.luck_3)
            4 -> LuckModel(R.drawable.card_thefool, R.string.luck_4)
            5 -> LuckModel(R.drawable.card_thehermit, R.string.luck_5)
            6 -> LuckModel(R.drawable.card_themagician, R.string.luck_6)
            7 -> LuckModel(R.drawable.card_themoon, R.string.luck_7)
            8 -> LuckModel(R.drawable.card_thestar, R.string.luck_8)
            9 -> LuckModel(R.drawable.card_thesun, R.string.luck_9)
            10 -> LuckModel(R.drawable.card_theworld, R.string.luck_10)
            11 -> LuckModel(R.drawable.card_wheeloffortune, R.string.luck_11)
            12 -> LuckModel(R.drawable.card_hope, R.string.luck_12)
            13 -> LuckModel(R.drawable.card_justice, R.string.luck_13)
            14 -> LuckModel(R.drawable.card_temperance, R.string.luck_14)
            15 -> LuckModel(R.drawable.card_thedevil, R.string.luck_15)
            16 -> LuckModel(R.drawable.card_thefool, R.string.luck_16)
            17 -> LuckModel(R.drawable.card_thehermit, R.string.luck_17)
            18 -> LuckModel(R.drawable.card_themagician, R.string.luck_18)
            19 -> LuckModel(R.drawable.card_themoon, R.string.luck_19)
            20 -> LuckModel(R.drawable.card_thestar, R.string.luck_20)
            21 -> LuckModel(R.drawable.card_thesun, R.string.luck_21)
            22 -> LuckModel(R.drawable.card_theworld, R.string.luck_22)
            23 -> LuckModel(R.drawable.card_wheeloffortune, R.string.luck_23)
            24 -> LuckModel(R.drawable.card_hope, R.string.luck_24)
            25 -> LuckModel(R.drawable.card_justice, R.string.luck_25)
            26 -> LuckModel(R.drawable.card_temperance, R.string.luck_26)
            27 -> LuckModel(R.drawable.card_thedevil, R.string.luck_27)
            28 -> LuckModel(R.drawable.card_thefool, R.string.luck_28)
            29 -> LuckModel(R.drawable.card_thehermit, R.string.luck_29)
            30 -> LuckModel(R.drawable.card_themagician, R.string.luck_30)
            31 -> LuckModel(R.drawable.card_themoon, R.string.luck_31)
            else -> null
        }
    }
}