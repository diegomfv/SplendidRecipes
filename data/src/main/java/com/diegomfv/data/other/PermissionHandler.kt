package com.diegomfv.data.other

interface PermissionHandler {

    enum class Permission {
        COARSE_LOCATION
    }

    suspend fun check (permission: Permission) : Boolean

}