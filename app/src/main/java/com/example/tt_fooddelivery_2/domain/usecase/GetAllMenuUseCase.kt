package com.example.tt_fooddelivery_2.domain.usecase

import com.example.tt_fooddelivery_2.data.repository.Repository
import com.example.tt_fooddelivery_2.domain.model.MainModel
import javax.inject.Inject

class GetAllMenuUseCase @Inject constructor(private val repository: Repository) {

    suspend fun execute(): ArrayList<MainModel> {
        return repository.requestData()
    }
}