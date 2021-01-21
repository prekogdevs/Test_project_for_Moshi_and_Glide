package com.example.usingmoshi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.usingmoshi.repository.SampleDataRepository

class SampleDataViewModel(application: Application) : AndroidViewModel(application) {
    private val sampleDataRepository = SampleDataRepository(application)
    val sampleData = sampleDataRepository.sampleData
}