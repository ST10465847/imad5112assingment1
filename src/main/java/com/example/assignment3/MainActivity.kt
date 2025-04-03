package com.example.assignment3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements
        val timeText = findViewById<EditText>(R.id.timeText)
        val mealText = findViewById<TextView>(R.id.mealText)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Reset button click listener
        resetButton.setOnClickListener {
            timeText.text.clear()  // Fixed the clear() function
            mealText.text = ""
        }

        // Meal suggestions map
        val suggestions = mapOf(
            "morning" to "Grilled flatiron steak and eggs,chorizo and black bean egg burrito,tofu scramble,pancakes,biscuits and coffee",
            "mid-morning" to "Oatmeal,china seeds,china pudding,cottage chesse,nuts,greentea,fruits",
            "afternoon" to "cheese sandiwich,hamburger,chickern fingers,beef steak,caesar salad,potato wedges",
            "night" to "cheese ravioli,grilled filet mignon with red wine reduction,wild mushroom risotto burruto,grilled rib chop",
            "dessert" to "oatmeal rasin , black forest pudding, brownies, vegan tiramisu with choclate cake, cheesecake"
        )

        // Submit button click listener
        submitButton.setOnClickListener {
            val input = timeText.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (input in suggestions) {
                mealText.text = "Suggestions: ${suggestions[input]}"
            } else {
                mealText.text = "No meal suggestions available for \"$input\"."
            }
        }
    }
}
