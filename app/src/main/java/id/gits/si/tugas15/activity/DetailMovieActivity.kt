package id.gits.si.tugas15.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import id.gits.si.tugas15.Constant.Companion.konversiTanggal
import id.gits.si.tugas15.R
import id.gits.si.tugas15.model.DetailMovieResponse
import id.gits.si.tugas15.presenter.DetailMoviePresenter
import id.gits.si.tugas15.view.MovieView
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.toolbar_detail.*

class DetailMovieActivity : AppCompatActivity(), MovieView.DetailMovieView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        //GET INTENT
        var id = intent.getStringExtra("movie_id")

        DetailMoviePresenter(this).getDetailMovie(id)

        btnBack.setOnClickListener() {
            super.onBackPressed()
        }

        btnBeli.setOnClickListener() {
            Toast.makeText(this, "Coming soon!", Toast.LENGTH_LONG).show()
        }

    }

    override fun onDetailCompleteFromApi(detailMovie: DetailMovieResponse) {
        showDetailMovie(detailMovie)
    }

    override fun onDetailErrorFromApi(throwable: Throwable?) {
        Toast.makeText(this, "Tidak ada respon $throwable", Toast.LENGTH_LONG).show()
        error("Tidak ada respon: ${throwable?.localizedMessage}")
    }

    private fun showDetailMovie(body: DetailMovieResponse) {
        val URL_GAMBAR = "https://image.tmdb.org/t/p/w500"
        Glide.with(this).load(URL_GAMBAR+body.backdropPath).into(iv_backdrop_film)
        Glide.with(this).load(URL_GAMBAR+body.posterPath).into(iv_poster_film)
        tv_judul_film.text = body.title.toString()
        tv_rating_film.text = body.voteAverage.toString()
        tv_sinopsis_film.text = body.overview.toString()
        tv_tanggal_rilis_film.text = body.releaseDate
        rb_rating_film.rating = ((body.voteAverage)!!/2.toFloat()).toFloat()
    }


}
