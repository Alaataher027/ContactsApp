package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ContactDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val description = intent.getStringExtra("description")

        val avatarImageView = findViewById<ImageView>(R.id.avatar_image_view)
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        val phoneNumberTextView = findViewById<TextView>(R.id.phone_number_text_view)
        val descriptionTextView = findViewById<TextView>(R.id.description_text_view)
        val backButton = findViewById<ImageView>(R.id.back_button)

        avatarImageView.setImageResource(R.drawable.user)
        nameTextView.text = name
        phoneNumberTextView.text = phoneNumber
        descriptionTextView.text = description

        backButton.setOnClickListener {
            finish()
        }
    }
}