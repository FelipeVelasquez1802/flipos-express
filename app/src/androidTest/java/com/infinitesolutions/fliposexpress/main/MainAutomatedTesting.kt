package com.infinitesolutions.fliposexpress.main

import androidx.test.rule.ActivityTestRule
import com.infinitesolutions.fliposexpress.presentation.views.activities.MainActivity
import org.junit.Rule
import org.junit.Test

class MainAutomatedTesting {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private val mainPage = MainPage()

    @Test
    fun createOrderSuccess() {
        mainPage.writeCost()
        mainPage.writeOrderCost()
        mainPage.writeDescription()
        mainPage.clickInButtonSave()
    }
}