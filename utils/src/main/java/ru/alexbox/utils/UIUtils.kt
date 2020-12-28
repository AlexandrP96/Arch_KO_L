package ru.alexbox.utils

import android.app.AlertDialog
import android.content.Context

fun getStubAlertDialog(context: Context): AlertDialog {
    return getAlertDialog(context, null, null)
}

fun getAlertDialog(context: Context, title: String?, message: String?): AlertDialog {
    val builder = AlertDialog.Builder(context)
    var finalTitle: String? = context.getString(R.string.dialog_error)

    if (!title.isNullOrBlank()) {
        finalTitle = title
    }
    builder.setTitle(finalTitle)

    if (!message.isNullOrBlank()) {
        builder.setMessage(message)
    }

    builder.setCancelable(true)
    builder.setPositiveButton(R.string.button_exit) {
        dialog, _ -> dialog.dismiss()
    }

    return builder.create()
}