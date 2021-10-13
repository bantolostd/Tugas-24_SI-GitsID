package id.gits.si.tugas15.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.gits.si.tugas15.R
import id.gits.si.tugas15.adapter.MovieAPIAdapter
import id.gits.si.tugas15.model.ResultsItem
import id.gits.si.tugas15.presenter.MoviePresenter
import id.gits.si.tugas15.view.MovieView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieView.MovieView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MoviePresenter(this).getDataMovie()
    }

    override fun onDataCompleteFromApi(movieData: List<ResultsItem>) {
        val movieAdapter = MovieAPIAdapter(movieData as ArrayList<ResultsItem>)
        rvMovie.layoutManager = LinearLayoutManager(this)
        rvMovie.adapter = movieAdapter
    }

    override fun onDataErrorFromApi(throwable: Throwable?) {
        Toast.makeText(this, "Tidak ada respon $throwable", Toast.LENGTH_LONG).show()
        error("Tidak ada respon: ${throwable?.localizedMessage}")
    }
}