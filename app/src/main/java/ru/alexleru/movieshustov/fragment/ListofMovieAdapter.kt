package ru.alexleru.movieshustov.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.alexleru.movieshustov.R
import ru.alexleru.movieshustov.pojo.Movie

class ListofMovieAdapter : RecyclerView.Adapter<ListofMovieAdapter.ListofMovieViewHolder>() {

    var listOfMovie: List<Movie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ListofMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_text_view)
        var yearText: TextView = itemView.findViewById(R.id.year_text_view)
        var poster: ImageView = itemView.findViewById(R.id.poster_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListofMovieViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListofMovieViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ListofMovieViewHolder, position: Int) {
        val item = listOfMovie[position]
        with(holder) {
            name.text = item.originalTitle
            yearText.text = item.year()
            Picasso.get().load(item.getFullImageUrl()).into(poster)
        }
    }

    override fun getItemCount() = listOfMovie.size
}
