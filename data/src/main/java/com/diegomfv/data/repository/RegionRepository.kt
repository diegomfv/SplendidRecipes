package com.diegomfv.data.repository

import com.diegomfv.data.other.PermissionHandler
import com.diegomfv.data.source.LocationDataSource

class RegionRepository (
    private val locationDataSource: LocationDataSource,
    private val permissionHandler : PermissionHandler
) {

    companion object {
        const val DEFAULT_REGION = "US"
    }

    suspend fun findLastRegion(): String {
        return if (permissionHandler.check(PermissionHandler.Permission.COARSE_LOCATION)) {
            locationDataSource.findLastRegion() ?: DEFAULT_REGION
        } else {
            DEFAULT_REGION
        }
    }

}