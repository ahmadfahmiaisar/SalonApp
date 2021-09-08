package com.example.base.extension

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

inline fun Context.showToast(message: () -> String) {
    Toast.makeText(this, message(), Toast.LENGTH_SHORT).show()
}