package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Account
import com.example.santanderdevweek.data.Card
import com.example.santanderdevweek.data.Client

class FakeData {
    fun getLocalData(): Account{

        val client = Client("Leandro")
        val card = Card("0033")

        return Account(
            "01097954-54",
            "2030",
            "1.324,64",
            "2.324,64",
            client,
            card
        )
    }
}