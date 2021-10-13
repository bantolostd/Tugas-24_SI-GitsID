package id.gits.si.tugas15

class Constant {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
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
}