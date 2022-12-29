package kr.co.bullets.chapater3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kr.co.bullets.chapater3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditTextView = binding.inputEditText
        val inputUnitTextView = binding.inputUnitTextView
        val swapImageButton = binding.swapImageButton

        var inputNumber: Int = 0
        var cmToM: Boolean = true

        inputEditTextView.addTextChangedListener { text ->
//            inputNumber = try {
//                text.toString().toInt()
//            } catch (e: NumberFormatException) {
//                0
//            }

            inputNumber = if (text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }

            Log.d("inputNumber", inputNumber.toString())

//            var outputNumber = inputNumber.times(0.01)
//            outputTextView.text = outputNumber.toString()

            if (cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
        }

        swapImageButton.setOnClickListener {
//            cmToM = cmToM.not()
            cmToM = !cmToM

            if (cmToM) {
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }
}