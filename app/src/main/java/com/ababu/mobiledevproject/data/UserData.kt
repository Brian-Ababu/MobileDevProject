package com.ababu.mobiledevproject.data

/**
 * Represents user data.
 *
 * @property userId The unique identifier of the user.
 * @property username The username of the user.
 * @property firstname The User's first name
 * @property lastname The User's last name
 * @property email The User's email
 * @property phoneNumber The User's mobile number
 * @property role Assigned user Role
 * @property imageUrl The URL of the user's profile image.
 * @property bio The bio of the user.
 * @property Services The list of services that the user has.
 */
// firebase requires empty constructor thus initalize to null

data class UserData(
    var userId: String? = null,
    var username: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var imageUrl: String? = null,
    var bio: String? = null,
    var role:List<Roles>? = null,
    var pass: String? = null,
    //Add the services
    var services: List<String>? = null
) {
    /**
     * Converts the UserData object to a map for Firebase.
     *
     * @return The map representation of the UserData object.
     */
    fun toMap() = mapOf(
        "userId" to userId,
        "firstname" to firstname,
        "lastname" to lastname,
        "phoneNumber" to phoneNumber,
        "username" to username,
        "imageUrl" to imageUrl,
        "bio" to bio,
        "role" to role,
        "services" to services
    )
}