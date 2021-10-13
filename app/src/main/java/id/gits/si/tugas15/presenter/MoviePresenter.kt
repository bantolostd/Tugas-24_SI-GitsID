package id.gits.si.tugas15.presenter

import android.content.Context
import id.gits.si.tugas15.model.DetailMovieResponse
import id.gits.si.tugas15.model.MovieResponse
import id.gits.si.tugas15.model.ResultsItem
import id.gits.si.tugas15.rest.RetrofitClient
import id.gits.si.tugas15.view.MovieView
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class MoviePresenter(context: Context) {
    private var movieView = context as MovieView.MovieView
    fun getDataMovie() {
        RetrofitClient().getServiceMovie().getMovie()
            .enqueue(object: Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>)
            {
                if (response!!.isSuccessful){
                    movieView.onDataCompleteFromApi(response.body()?.results as List<ResultsItem>)
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable?) {
                movieView.onDataErrorFromApi(t)
            }
        })
    }

}