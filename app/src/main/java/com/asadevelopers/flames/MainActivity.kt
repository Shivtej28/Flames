package com.asadevelopers.flames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.asadevelopers.flames.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    private val flamesArray = arrayOf("Friendship", "Love", "Affection", "Marriage", "Enemies")
    private lateinit var yourName: String
    private lateinit var crushName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun findFlames(view: View) {
        yourName = binding.etYourName.text.toString().toLowerCase(Locale.getDefault()).trim()
        crushName = binding.etCrushName.text.toString().toLowerCase(Locale.getDefault()).trim()
        calculate(yourName, crushName)

    }

    private fun calculate(yourName: String, crushName: String) {
        Log.i(TAG, "$yourName $crushName")
        var firstName = yourName
        var secondName = crushName
        Log.i(TAG, "$firstName $secondName")

        for (i in firstName) {
            Log.i("i", i.toString())
            for (element in secondName) {
                Log.i("j", element.toString())
                if (i == element) {
                    firstName = firstName.replace(i.toString(), "")
                    secondName = secondName.replace(element.toString(), "")
                }
            }
        }
        val name = firstName + secondName

        binding.tvResult.text = getResult(name)

    }

    private fun getResult(name: String): CharSequence {
        var n = name.length
        Log.i(TAG, "Name :$name , N: $n")
        while (n > 5) {
            n -= 5
        }
        Log.i(TAG, "$n")
        return flamesArray[n - 1]

    }
}