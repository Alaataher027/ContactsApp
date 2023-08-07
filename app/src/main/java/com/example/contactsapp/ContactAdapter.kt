package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contacts: MutableList<Contact>, private val listener: OnContactClickListener) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.avatarImageView.setImageResource(R.drawable.user)
        holder.nameTextView.text = currentContact.name
        holder.phoneNumberTextView.text = currentContact.phoneNumber
        holder.itemView.setOnClickListener {
            listener.onContactClick(currentContact)
        }
    }

    override fun getItemCount() = contacts.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatar_image_view)
        val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.phone_number_text_view)
    }

    interface OnContactClickListener {
        fun onContactClick(contact: Contact)
    }
}