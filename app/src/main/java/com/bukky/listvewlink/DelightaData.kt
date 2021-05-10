package com.bukky.listvewlink

object DelightaData {
    val facts = listOf<DelightaFact>(
        DelightaFact("Home", R.drawable.home, "Mama"),
        DelightaFact("About", R.drawable.about, "I don't know this person"),
        DelightaFact("Contact Us", R.drawable.contact_us, "Computer Engineering Dept."),
        DelightaFact("Review", R.drawable.review, "Architecture Department")
    )

    val verifiedUsers = listOf<LoginDetails>(
        LoginDetails("bukky@gmail.com", "password")
    )

}