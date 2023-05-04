package com.saumya.practicaltaskc.data.source.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.saumya.practicaltaskc.data.source.remote.response.random_user.ResultResponse

class ListResultTypeConverter {
    @TypeConverter
    fun stringToListResult(resultString: String?): List<ResultResponse>? {
        if (resultString == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<ResultResponse>>() {}.type
        return Gson().fromJson<List<ResultResponse>>(resultString, listType)
    }

    @TypeConverter
    fun listResultToString(resultList: List<ResultResponse>?): String? {
        return Gson().toJson(resultList)
    }
}