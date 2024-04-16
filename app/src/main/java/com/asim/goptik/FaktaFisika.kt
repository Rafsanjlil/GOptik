package com.asim.goptik

data class FaktaFisika(val factText: String, val imageResource: Int) {

    companion object {
        fun getDummyData(): List<FaktaFisika> {
            val dummyFacts = mutableListOf<FaktaFisika>()
            // Populate your facts list with dummy data
            dummyFacts.add(FaktaFisika("Kamera pertama di dunia membutuhkan waktu sekitar 8 jam untuk menghasilkan satu gambar menggunakan proses heliogravur", R.drawable.img_fakta1))
            dummyFacts.add(FaktaFisika("Mikroskop pertama kali dibuat oleh Hans Janssen dan anaknya, Zacharias Janssen, pada akhir abad ke-16", R.drawable.gambar_fakta_2))
            // Add other facts...
            return dummyFacts
        }
    }
}