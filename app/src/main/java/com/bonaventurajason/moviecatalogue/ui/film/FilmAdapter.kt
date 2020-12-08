package com.bonaventurajason.moviecatalogue.ui.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.FilmEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(film: FilmEntity) {
            with(itemView) {
                Glide.with(context)
                    .load(film.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                            .centerCrop()
                    ).into(poster)
                title.text = film.title
                setOnClickListener {
                    onItemClickListener?.let {
                        it(film.filmId)
                    }
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<FilmEntity>(){
        override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
            return oldItem.filmId == newItem.filmId
        }

        override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: List<FilmEntity>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit){
        onItemClickListener = listener
    }
}