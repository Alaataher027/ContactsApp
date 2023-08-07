package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ContactAdapter.OnContactClickListener {

    private lateinit var nameEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var contactsRecyclerView: RecyclerView

    private val contacts = mutableListOf<Contact>()
    private val contactAdapter = ContactAdapter(contacts, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_edit_text)
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text)
        descriptionEditText = findViewById(R.id.description_edit_text)
        saveButton = findViewById(R.id.save_button)
        contactsRecyclerView = findViewById(R.id.contacts_recycler_view)
        contactsRecyclerView.adapter = contactAdapter

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (name.length < 3) {
                nameEditText.error = "Name should be at least 3 characters long"
            } else if (phoneNumber.length != 11) {
                phoneNumberEditText.error = "Phone number should be 11 digits long"
            } else {
                val contact = Contact(name, phoneNumber, description)
                contacts.add(contact)
                contactAdapter.notifyItemInserted(contacts.size - 1)
                clearFields()
            }
        }
    }

    private fun clearFields() {
        nameEditText.text.clear()
        phoneNumberEditText.text.clear()
        descriptionEditText.text.clear()
    }

    override fun onContactClick(contact: Contact) {
        val intent = Intent(this, ContactDetailsActivity::class.java)
        intent.putExtra("name", contact.name)
        intent.putExtra("phoneNumber", contact.phoneNumber)
        intent.putExtra("description", contact.description)
        startActivity(intent)
    }
}