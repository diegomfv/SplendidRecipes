package com.diegomfv.splendidrecipesmvvm.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegomfv.splendidrecipesmvvm.R
import com.diegomfv.splendidrecipesmvvm.ui.common.basicDiffUtil
import com.diegomfv.splendidrecipesmvvm.ui.common.inflate
import kotlinx.android.synthetic.main.item_recipe.view.*
import com.diegomfv.domain.Recipe
import com.diegomfv.splendidrecipesmvvm.ui.common.loadUrl

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
            itemView.title.text = "Title: ${recipe.title}"
            itemView.cuisines.text = "Cuisines: ${recipe.cuisines.joinToString(separator = ", ")}"
            itemView.dishTypes.text= "Dish types: ${recipe.dishTypes.joinToString(separator = ", ")}"
            itemView.image.loadUrl(recipe.imageUrl)

//            itemView.recipeTitle.text = recipe.title
//            itemView.recipeCover.loadUrl("https://image.tmdb.org/t/p/w185/${recipe.posterPath}")
        }
    }
}

//fun DTORecipe.fromDTOToDomain () : Recipe {
//    return Recipe(
//        id = id ?: 0,
//        title = title ?: "null title",
//        cuisines = cuisines ?: listOf(),
//        imageUrl = image ?: "",
//        dishTypes = dishTypes ?: listOf(),
//        readyInMinutes = readyInMinutes ?: 0
//    )
//
//}