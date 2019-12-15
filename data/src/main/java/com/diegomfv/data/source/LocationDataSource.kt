package com.diegomfv.data.source

interface LocationDataSource {

    suspend fun findLastRegion () : String? {
        TODO("findLastRegion")
    }
}