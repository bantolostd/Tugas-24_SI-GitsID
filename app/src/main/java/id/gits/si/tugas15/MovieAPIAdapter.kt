package id.gits.si.tugas15

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.gits.si.tugas15.model.ResultsItem
import android.R.string




class MovieAPIAdapter (val results : ArrayList<ResultsItem>) : RecyclerView.Adapter<MovieAPIAdapter.ViewHolder>() {

    fun setData(data : List<ResultsItem>){
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAPIAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_movie, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieAPIAdapter.ViewHolder, position: Int) {
        val data = results[position]
        val URL_GAMBAR = "https://www.themoviedb.org/t/p/w220_and_h330_face"
        Glide.with(holder.itemView).load(URL_GAMBAR+data.posterPath).apply(RequestOptions().override(320,320)).into(holder.poster)
        holder.judul.text = "${data.title} (${data?.releaseDate?.take(4)})"
        holder.rating.text = "Rating : ${data.voteAverage.toString()}"
        holder.sinopsis.text = "Sinopsis : ${data?.overview?.take(100)}..."
        holder.klik.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("judul", data.title)
            intent.putExtra("popularitas", data.popularity.toString())
            intent.putExtra("rating", data.voteAverage.toString())
            intent.putExtra("ratingbar", ((data.voteAverage)!! /2.toFloat()).toFloat())
            intent.putExtra("backdrop", data.backdropPath)
            intent.putExtra("poster", data.posterPath)
            intent.putExtra("tanggal", konversiTanggal(data.releaseDate.toString()))
            intent.putExtra("tahun", data?.releaseDate?.take(4))
            intent.putExtra("sinopsis", data.overview)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }
    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val judul : TextView = itemView.findViewById(R.id.tv_judul_film)
        val rating : TextView = itemView.findViewById(R.id.tv_rating_film)
        val poster : ImageView = itemView.findViewById(R.id.iv_poster_film)
        val sinopsis : TextView = itemView.findViewById(R.id.tv_sinopsis_film)
        val klik : CardView = itemView.findViewById(R.id.cv_movie)
    }

    fun konversiTanggal (tanggal: String): String{
        val tanggal = tanggal.split("-")
        val bulan = when(tanggal[1]){
            "01" -> "Januari"
            "02" -> "Februari"
            "03" -> "Maret"
            "04" -> "April"
            "05" -> "Mei"
            "06" -> "Juni"
            "07" -> "Juli"
            "08" -> "Agustus"
            "09" -> "September"
            "10" -> "Oktober"
            "11" -> "November"
            "12" -> "Desember"
            else -> "Terjadi kesalahan"
        }
        var final = "${tanggal[2]} $bulan ${tanggal[0]}"
        return final
    }
}