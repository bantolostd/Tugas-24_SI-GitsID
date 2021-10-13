package id.gits.si.tugas15.rest

import id.gits.si.tugas15.model.DetailMovieResponse
import id.gits.si.tugas15.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("movie/popular?api_key=770b0adea2f0731e693d88241cd8daba&language=en-US")
    fun getMovie(): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=770b0adea2f0731e693d88241cd8daba&language=en&page=1")
    fun getMovieDetail(
        @Path("movie_id") movie_id: Int
    ): Call<DetailMovieResponse>

}