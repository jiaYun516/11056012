package com.example.a11056012

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.a11056012.databinding.ActivityMainBinding
import com.example.a11056012.databinding.ActivityOrderPageBinding

class OrderPage : AppCompatActivity() {

    private lateinit var binding: ActivityOrderPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_page)
        binding = ActivityOrderPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("點餐完成了嗎")
                .setPositiveButton("是的"){ dialog, i->
                    var tot = 0
                    var food = ""
                    var foodMoney = 0
                    var drink = ""
                    var drinkMoney = 0
                    var desserts1 = ""
                    var desserts2 = ""
                    var desserts1Money = 0
                    var desserts2Money = 0
                    when(binding.foodGroup.checkedRadioButtonId) {
                        R.id.food1 -> {
                            tot += 180
                            foodMoney = 180
                            food = "豬排飯"
                        }

                        R.id.food2 -> {
                            tot += 150
                            foodMoney = 150
                            food = "雞排飯"
                        }

                        R.id.food3 -> {
                            tot += 200
                            foodMoney = 200
                            food = "牛排飯"
                        }
                    }
                    when(binding.drinkGroup.checkedRadioButtonId){
                        R.id.drink1 -> {
                            drinkMoney = 0
                            drink = "紅茶"
                        }
                        R.id.drink2 -> {
                            drinkMoney = 0
                            drink = "綠茶"
                        }
                        R.id.drink3 -> {
                            tot += 10
                            drinkMoney = 10
                            drink = "冬瓜茶"
                        }
                    }
                    if (binding.desserts1.isChecked){
                        tot+=30
                        desserts1Money = 30
                        desserts1 = "地瓜球"
                    }
                    if (binding.desserts2.isChecked){
                        tot+=10
                        if (desserts1 == ""){
                            desserts1Money = 10
                            desserts1 = "沙瓦"
                        }else{
                            desserts2Money = 10
                            desserts2 = "沙瓦"
                        }
                    }

                    val intent = Intent(this, MainActivity::class.java)
                    intent.apply {
                        putExtra("tot", tot)
                        putExtra("food", food)
                        putExtra("foodMoney", foodMoney)
                        putExtra("drink", drink)
                        putExtra("drinkMoney", drinkMoney)
                        putExtra("desserts1", desserts1)
                        putExtra("desserts1Money", desserts1Money)
                        putExtra("desserts2", desserts2)
                        putExtra("desserts2Money", desserts2Money)
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                }
                .setNegativeButton("還沒"){ dialog, i->
                    // 不做操作
                }
                .show()
        }



    }

}