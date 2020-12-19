package com.bonaventurajason.moviecatalogue.ui.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.source.model.FilmResult
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(film: FilmResult) {
            with(itemView) {
                Glide.with(context)
                    .load(Constant.IMAGE_URL+film.backdropPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                            .centerCrop()
                    ).into(poster)
                title.text = film.title
                setOnClickListener {
                    onItemClickListener?.let {
                        it(film.id)
                    }
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<FilmResult>(){
        override fun areItemsTheSame(oldItem: FilmResult, newItem: FilmResult): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FilmResult, newItem: FilmResult): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: List<FilmResult?>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit){
        onItemClickListener = listener
    }
}