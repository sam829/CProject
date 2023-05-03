package com.saumya.practicaltaskc.data.source.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.saumya.practicaltaskc.data.source.remote.response.random_user.InfoResponse

class InfoTypeConverter {
    @TypeConverter
    fun stringToInfo(infoString: String?): InfoResponse? {
        return Gson().fromJson(infoString, InfoResponse::class.java)
    }

    @TypeConverter
    fun infoToString(infoResponse: InfoResponse?): String? {
        return Gson().toJson(infoResponse)
    }
}