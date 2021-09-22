package id.gits.si.tugas15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val URL_GAMBAR = "https://www.themoviedb.org/t/p/w220_and_h330_face"
        Glide.with(this).load(URL_GAMBAR+intent.getStringExtra("backdrop")).into(iv_backdrop_film)
        Glide.with(this).load(URL_GAMBAR+intent.getStringExtra("poster")).into(iv_poster_film)
        tv_judul_film.text = intent.getStringExtra("judul")
        tv_rating_film.text = intent.getStringExtra("rating")
        tv_sinopsis_film.text = intent.getStringExtra("sinopsis")
        tv_tanggal_rilis_film.text = "Rilis: " + intent.getStringExtra("tanggal")
        rb_rating_film.rating = intent.getFloatExtra("ratingbar", 0.0F)

        btnBack.setOnClickListener() {
            super.onBackPressed()
        }
    }


}
