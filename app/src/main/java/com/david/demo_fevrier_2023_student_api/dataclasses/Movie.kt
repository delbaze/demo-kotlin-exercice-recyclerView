package com.david.demo_fevrier_2023_student_api.dataclasses


import com.david.demo_fevrier_2023_student_api.enums.MovieType

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val type: MovieType,
    val duration: Int,
    val image: Int,
    var selected: Boolean = false,
) {

}
