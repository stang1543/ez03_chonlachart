package com.example.work01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var t1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        t1 = findViewById(R.id.t1)


        // Set click listeners for operator buttons
        findViewById<Button>(R.id.plus).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.minus).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.multiply).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.divider).setOnClickListener { calculate('/') }
        findViewById<Button>(R.id.modulo).setOnClickListener { calculate('%') }
        findViewById<Button>(R.id.clear).setOnClickListener { clearInputs() }
    }

    private fun calculate(operator: Char) {
        val num1 = ed1.text.toString()
        val num2 = ed2.text.toString()

        if (num1.isBlank() || num2.isBlank()) {
            showToast("กรุณากรอกเลข")
            return
        }

        val operand1 = num1.toDouble()
        val operand2 = num2.toDouble()

        val result = when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหาร 0")
                    return
                }
                operand1 / operand2
            }
            '%' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหาร 0")
                    return
                }
                operand1 % operand2
            }
            else -> {
                showToast("เครื่องหมายไม่ถูกต้อง")
                return
            }
        }

        t1.text = "$result"

    }

    private fun clearInputs() {
        ed1.text.clear()
        ed2.text.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
