package com.ababu.mobiledevproject.data

import java.util.Date

data class BookingData(
    val bookingId: String? = null,
    val userId: String? = null,
    val username: String? = null,
    val email : String? = null,
    val serviceId: String? = null,
    val serviceDescription: String? = null,
    val date: Date? = null,
){
    fun toMap() = mapOf(
        "bookingId"  to bookingId,
        "userId" to userId,
        "username" to username,
        "email" to email,
        "serviceId" to serviceId,
        "serviceDescription" to serviceDescription,
        "date" to date,

    )
}
