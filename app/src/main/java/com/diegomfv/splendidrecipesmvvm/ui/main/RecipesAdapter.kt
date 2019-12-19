package com.diegomfv.splendidrecipesmvvm.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegomfv.splendidrecipesmvvm.R
import com.diegomfv.splendidrecipesmvvm.ui.common.basicDiffUtil
import com.diegomfv.splendidrecipesmvvm.ui.common.inflate
import kotlinx.android.synthetic.main.item_recipe.view.*
import com.diegomfv.domain.Recipe

class RecipesAdapter(private val listener: (Recipe) -> Unit) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    var recipes: List<Recipe> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.title == new.title }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_recipe, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
        holder.itemView.setOnClickListener { listener(recipe) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(recipe: Recipe) {
            itemView.title.text = recipe.title
//            itemView.recipeTitle.text = recipe.title
//            itemView.recipeCover.loadUrl("https://image.tmdb.org/t/p/w185/${recipe.posterPath}")
        }
    }
}