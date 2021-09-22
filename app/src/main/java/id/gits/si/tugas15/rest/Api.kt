package id.gits.si.tugas15.rest

import id.gits.si.tugas15.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie/popular?api_key=770b0adea2f0731e693d88241cd8daba&language=en-US")
    fun getMovie(): Call<MovieResponse>

}