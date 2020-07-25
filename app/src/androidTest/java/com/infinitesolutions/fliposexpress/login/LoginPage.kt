package com.infinitesolutions.fliposexpress.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.infinitesolutions.fliposexpress.R

class LoginPage {

    fun writeUsername() {
        onView(withId(R.id.etUsername))
            .perform(typeText("pipeandres1010@hotmail.com"))
            .perform(closeSoftKeyboard())
    }

    fun writePassword() {
        onView(withId(R.id.etPassword))
//            .perform(typeText("admin2020"))
            .perform(typeText("admin2020"))
            .perform(closeSoftKeyboard())
    }

    fun clickInButtonLogin() {
        onView(withId(R.id.btLogin))
            .check(matches(isDisplayed()))
            .perform(click())
    }

}