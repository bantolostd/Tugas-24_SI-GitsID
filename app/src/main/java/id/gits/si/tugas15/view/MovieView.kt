package id.gits.si.tugas15.view

import id.gits.si.tugas15.model.DetailMovieResponse
import id.gits.si.tugas15.model.ResultsItem

class MovieView {
    interface MovieView {
        fun onDataCompleteFromApi(movie: List<ResultsItem>)
        fun onDataErrorFromApi(throwable: Throwable?)
    }

    interface DetailMovieView {
        fun onDetailCompleteFromApi(detailMovie: DetailMovieResponse)
        fun onDetailErrorFromApi(throwable: Throwable?)
    }
}