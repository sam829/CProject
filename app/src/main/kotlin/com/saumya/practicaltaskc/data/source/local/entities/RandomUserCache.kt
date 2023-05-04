package com.saumya.practicaltaskc.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saumya.practicaltaskc.data.source.remote.response.random_user.InfoResponse
import com.saumya.practicaltaskc.data.source.remote.response.random_user.ResultResponse

@Entity(tableName = "random_user")
data class RandomUserCache(
    @PrimaryKey
    val id: Int = 0,
    val infoCache: InfoResponse,
    val resultResponse: List<ResultResponse>
)