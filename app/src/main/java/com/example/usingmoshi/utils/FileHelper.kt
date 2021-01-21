package com.example.usingmoshi.utils

import android.content.Context

object FileHelper {
    fun getTextFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            inputStream.bufferedReader().use { bufferedReader ->
                bufferedReader.readText()
            }
        }
    }
}