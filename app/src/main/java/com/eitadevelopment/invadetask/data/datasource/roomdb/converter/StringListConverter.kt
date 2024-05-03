package com.eitadevelopment.invadetask.data.datasource.roomdb.converter

import androidx.room.TypeConverter

class StringListConverter {
    @TypeConverter
    fun fromListToRecord(value:List<String>):String
    {
        return value.joinToString(",")
    }
    @TypeConverter
    fun fromRecordToList(value:String) :List<String>{
        return value.split(",")
    }
}
