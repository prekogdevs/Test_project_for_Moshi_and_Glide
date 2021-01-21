package com.example.usingmoshi.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.usingmoshi.model.SampleData
import com.example.usingmoshi.utils.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SampleDataRepository(private val application: Application) {
    val sampleData = MutableLiveData<List<SampleData>>()

    private val listType = Types.newParameterizedType(
        List::class.java, SampleData::class.java
    )

    init {
        getSampleData()
    }

    private fun getSampleData() {
        val text = FileHelper.getTextFromAssets(application, "moshi_input.json")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<List<SampleData>> =
            moshi.adapter(listType)
        sampleData.value = adapter.fromJson(text) ?: emptyList()
    }
}