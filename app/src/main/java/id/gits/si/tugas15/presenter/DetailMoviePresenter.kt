package id.gits.si.tugas15.presenter

import android.content.Context
import id.gits.si.tugas15.model.DetailMovieResponse
import id.gits.si.tugas15.rest.RetrofitClient
import id.gits.si.tugas15.view.MovieView
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class DetailMoviePresenter(context: Context) {
    private var detailMovieView = context as MovieView.DetailMovieView
    fun getDetailMovie(movie_id: String?) {
        RetrofitClient().getServiceDetailMovie().getMovieDetail(
            movie_id!!.toInt()
        ).enqueue(object: Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>)
            {
                if (response!!.isSuccessful){
                    detailMovieView.onDetailCompleteFromApi(response?.body()!!)
                }
            }
            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable?) {
                detailMovieView.onDetailErrorFromApi(t)
            }
        })
    }
}