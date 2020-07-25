package com.infinitesolutions.fliposexpress.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.infinitesolutions.fliposexpress.presentation.views.activities.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginAutomatedTesting {
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    private val loginPage = LoginPage()

    @Test
    fun loginSuccess() {
        loginPage.writeUsername()
        loginPage.writePassword()
        loginPage.clickInButtonLogin()
    }

}