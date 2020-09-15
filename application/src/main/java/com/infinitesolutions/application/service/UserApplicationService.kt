package com.infinitesolutions.application.service

import com.infinitesolutions.domain.service.UserService
import javax.inject.Inject

class UserApplicationService @Inject constructor() {

    @Inject
    lateinit var userService: UserService


}