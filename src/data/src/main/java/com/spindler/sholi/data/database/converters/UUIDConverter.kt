package com.spindler.sholi.data.database.converters

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun fromUUID(value: UUID): String = value.toString()

    @TypeConverter
    fun fromString(value: String): UUID = UUID.fromString(value)
}