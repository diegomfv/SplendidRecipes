package com.diegomfv.splendidrecipesmvvm.data.database.model.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RESTRICTION
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RESTRICTION_ID
import com.diegomfv.splendidrecipesmvvm.data.database.constants.RESTRICTION_TABLE_NAME

@Entity (tableName = RESTRICTION_TABLE_NAME)
data class RestrictionDbDTO(

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = RESTRICTION_ID)
    val restrictionId: Long? = null,

    @ColumnInfo(name = RESTRICTION)
    val restriction: String

)
