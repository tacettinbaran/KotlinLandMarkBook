package com.baran.kotlinlandmarkbook.model

import java.io.Serializable


class LandMark(
    val name: String,
    val country: String,
    val image: Int
) : Serializable