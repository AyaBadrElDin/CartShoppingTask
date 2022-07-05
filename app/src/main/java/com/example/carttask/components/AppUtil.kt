package com.example.carttask.components

import android.content.Context
import android.widget.Toast
import com.example.carttask.R


 fun toastMessage(context: Context, message:String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}