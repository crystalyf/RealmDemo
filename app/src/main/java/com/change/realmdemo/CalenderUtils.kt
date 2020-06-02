package com.change.realmdemo

import java.text.SimpleDateFormat
import java.util.*

object CalenderUtils {

    private const val DATE_TIME_FORMAT_MAIN_YMD = "yyyy年MM月dd日"
    private const val DATE_TIME_FORMAT_YYYY_SPIRIT = "yyyy/MM/dd"

    // Date -> yyyy/MM/dd
    fun getCurrentDateToSpiritString(): String {
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_FORMAT_YYYY_SPIRIT)
        val calendar = Calendar.getInstance()
        return simpleDateFormat.format(calendar.time)
    }
}