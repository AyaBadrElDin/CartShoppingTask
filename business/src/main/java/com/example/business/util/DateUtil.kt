package com.example.business.util

import java.text.SimpleDateFormat
import java.util.*

fun currentDate() :Int{
    val cartFullDate = Calendar.getInstance()
    return formatAndConvertDateToInt(cartFullDate)
}

fun dateAfter3Days(): Int {
    val dateAfter3Days = Calendar.getInstance()
    dateAfter3Days.add(Calendar.DATE, 3)
    dateAfter3Days.add(Calendar.HOUR_OF_DAY, 3)

    return formatAndConvertDateToInt(dateAfter3Days)

}

private fun formatAndConvertDateToInt(dateAfter3Days: Calendar): Int {
    val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val dateFormat = df.format(dateAfter3Days.time)
    return dateFormat.replace("/", "").toInt()
}

fun compareBetweenTwoDates(): Boolean {
    return (currentDate() == dateAfter3Days())
}

