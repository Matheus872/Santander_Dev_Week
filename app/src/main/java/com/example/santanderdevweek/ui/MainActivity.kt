package com.example.santanderdevweek.ui

import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        getClientAccount()
        //throw RuntimeException("Teste Crash")
    }

    private fun getClientAccount(){
        mainViewModel.getAccount().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(result: com.example.santanderdevweek.data.Account){
        findViewById<TextView>(R.id.tv_agencia).text = "Ag "+ result.branch
        findViewById<TextView>(R.id.tv_conta_corrente).text = "Cc" + result.number
        findViewById<TextView>(R.id.card_tv_balance).text = result.balance
        findViewById<TextView>(R.id.card_tv_balance_with_limit_value).text = result.limit
        findViewById<TextView>(R.id.tv_usuario).text = "Olá, "+ result.client.name
        findViewById<TextView>(R.id.tv_cartao_final_value).text = result.card.number
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when(item.itemId){
            R.id.item_1 -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}