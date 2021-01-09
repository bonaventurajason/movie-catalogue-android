package com.bonaventurajason.moviecatalogue.ui.favourite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.source.local.entity.FilmEntity
import com.bonaventurajason.moviecatalogue.utils.Constant
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_film.view.*

class FavouriteFilmAdapter : PagedListAdapter<FilmEntity, FavouriteFilmAdapter.ViewHolder>(DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>(){
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem == newItem
            }

        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(film: FilmEntity){
            with(itemView){
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
                        it(film)
                    }
                }
            }
        }
    }

//    private val differCallback = object : DiffUtil.ItemCallback<FilmEntity>(){
//        override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
//            return oldItem == newItem
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film = getItem(position)
        if(film != null){
            holder.bind(film)
        }
    }


    private var onItemClickListener: ((FilmEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (FilmEntity) -> Unit){
        onItemClickListener = listener
    }
}