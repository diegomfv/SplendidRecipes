package com.diegomfv.splendidrecipesmvvm.data.database.model.assoc

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.diegomfv.splendidrecipesmvvm.data.database.constants.CUISINE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.DISH_TYPE_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RECIPE_ID
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin.RecipeCuisineAssoc
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entititiesjoin.RecipeDishTypeAssoc
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.CuisineDb
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.DishTypeDb
//import com.diegomfv.splendidrecipesmvvm.data.database.model.entities.RecipeDb

//data class RecipeJoin(
//
//    @Embedded
//    val recipe: RecipeDb,
//
//    @Relation(
//        parentColumn = RECIPE_ID,
//        entityColumn = CUISINE_ID,
//        associateBy = Junction(
//            value = RecipeCuisineAssoc::class))
//    val cuisines: List<CuisineDb>,
//
//    @Relation(
//        parentColumn = RECIPE_ID,
//        entityColumn = DISH_TYPE_ID,
//        associateBy = Junction(
//            value = RecipeDishTypeAssoc::class))
//    val dishTypes: List<DishTypeDb>
//)