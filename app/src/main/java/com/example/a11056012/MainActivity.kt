//11056001吳想想
//11056012吳佳耘
//11056039吳怡萱

package com.example.a11056012

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a11056012.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            if (result.resultCode == RESULT_OK){
                val data = result.data
                if (data != null) {
                    val tot = data.getIntExtra("tot", 0)
                    val food = data.getStringExtra("food")
                    val foodMoney = data.getIntExtra("foodMoney", 0)
                    val drink = data.getStringExtra("drink")
                    val drinkMoney = data.getIntExtra("drinkMoney", 0)
                    val desserts1 = data.getStringExtra("desserts1")
                    val desserts1Money = data.getIntExtra("desserts1Money", 0)
                    val desserts2 = data.getStringExtra("desserts2")
                    val desserts2Money = data.getIntExtra("desserts2Money", 0)
                    binding.foodName.text=food
                    binding.foodMoney.text=foodMoney.toString()
                    binding.drinkName.text=drink
                    binding.drinkMoney.text=drinkMoney.toString()
                    binding.dessertsName1.text=desserts1
                    binding.dessertsMoney1.text=desserts1Money.toString()
                    if (desserts2 == ""){
                        binding.dollorFordesserts2.text=""
                        binding.dessertsMoney2.text=""
                        binding.dessertsName2.text=""
                    }else {
                        binding.dessertsName2.text=desserts2
                        binding.dessertsMoney2.text=desserts2Money.toString()
                        binding.dollorFordesserts2.text="元"
                    }
                    binding.totMoney.text=tot.toString()
                }
            }
        }

        binding.order.setOnClickListener {
            val intent = Intent(this, OrderPage::class.java)
            launcher.launch(intent)
        }


    }
}