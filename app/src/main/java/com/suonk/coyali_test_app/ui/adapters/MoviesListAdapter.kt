package com.suonk.coyali_test_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suonk.coyali_test_app.R
import com.suonk.coyali_test_app.databinding.ItemMovieBinding
import com.suonk.coyali_test_app.models.data.Movie
import com.suonk.coyali_test_app.ui.activity.MainActivity

class MoviesListAdapter(
    private val activity: MainActivity,
    private val onClickedCallback: (Int) -> Unit
) :
    ListAdapter<Movie, MoviesListAdapter.ViewHolder>(MovieComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.onBind(movie, onClickedCallback)
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: Movie, onClicked: (Int) -> Unit) {
            binding.movieTitle.text = movie.title

            when (movie.note) {
                1 -> {
                    binding.apply {
                        star1.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star2.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star3.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star4.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star5.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                    }
                }
                2 -> {
                    binding.apply {
                        star1.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star2.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star3.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star4.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star5.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                    }
                }
                3 -> {
                    binding.apply {
                        star1.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star2.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star3.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star4.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                        star5.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                    }
                }
                4 -> {
                    binding.apply {
                        star1.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star2.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star3.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star4.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star5.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star,
                                null
                            )
                        )
                    }
                }
                5 -> {
                    binding.apply {
                        star1.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star2.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star3.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star4.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                        star5.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                activity.resources,
                                R.drawable.ic_star_1,
                                null
                            )
                        )
                    }
                }
            }

            binding.root.setOnClickListener {
                onClicked(movie.id)
            }
        }
    }

    class MovieComparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title &&
                    oldItem.comment == newItem.comment &&
                    oldItem.note == newItem.note
        }
    }
}