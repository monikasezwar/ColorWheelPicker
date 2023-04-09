package com.example.colorpickerwheel

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colorpickerwheel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    companion object{
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.toggleButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnLeft -> {
                        var hexColor = "#00c2a3"
                        val tripleValue = getRgbFromHex(hexColor)
                        mainBinding.colorWheel.setRgb(tripleValue.first, tripleValue.second, tripleValue.third)
                        Log.i(TAG, "Teal Button clicked")
                    }
                    R.id.btnCenter -> {
                        var hexColor = "#4ba54f"
                        val tripleValue = getRgbFromHex(hexColor)
                        mainBinding.colorWheel.setRgb(tripleValue.first, tripleValue.second, tripleValue.third)
                        Log.i(TAG, "Green Button clicked")
                    }
                    R.id.btnRight -> {
                        var hexColor = "#ff6100"
                        val tripleValue = getRgbFromHex(hexColor)
                        mainBinding.colorWheel.setRgb(tripleValue.first, tripleValue.second, tripleValue.third)
                        Log.i(TAG, "Orange Button clicked")
                    }
                }
            } else {
                if (toggleButtonGroup.checkedButtonId == View.NO_ID) {
                    Log.i(TAG, "No color selected")
                }
            }
        }
    }

    private fun getRgbFromHex(hexColor: String): Triple<Int, Int, Int> {
        val hexColorWithoutHash = hexColor.replace("#", "")
        val colorInt = hexColorWithoutHash.toInt(16)
        val red = colorInt shr 16 and 0xFF
        val green = colorInt shr 8 and 0xFF
        val blue = colorInt and 0xFF
        return Triple(red, green ,blue)
    }
}