package com.infinitesolutions.fliposexpress.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.infinitesolutions.fliposexpress.R

class MainPage {

    fun writeCost() {
        Espresso.onView(ViewMatchers.withId(R.id.etCost))
            .perform(ViewActions.typeText("20000"))
            .perform(ViewActions.closeSoftKeyboard())
    }

    fun writeOrderCost() {
        Espresso.onView(ViewMatchers.withId(R.id.etOrderCost))
            .perform(ViewActions.typeText("7000"))
            .perform(ViewActions.closeSoftKeyboard())
    }

    fun writeDescription() {
        Espresso.onView(ViewMatchers.withId(R.id.etDescription))
            .perform(ViewActions.typeText("4 hamburguesas y una gaseosa"))
            .perform(ViewActions.closeSoftKeyboard())
    }

    fun clickInButtonSave() {
        Espresso.onView(ViewMatchers.withId(R.id.btSave))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
    }

}