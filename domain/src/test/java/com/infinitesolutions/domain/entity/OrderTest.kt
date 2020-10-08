package com.infinitesolutions.domain.entity

import com.infinitesolutions.domain.exception.BadUserIdException
import com.infinitesolutions.domain.exception.empty.EmptyCostException
import com.infinitesolutions.domain.exception.empty.EmptyDescriptionException
import com.infinitesolutions.domain.exception.empty.EmptyOrderCostException
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class OrderTest {

    @Test
    fun createOrderWithBadCostZero() {
        // Given
        val cost = 0.0
        val orderCost = 5000.0
        val description = "Esto es una prueba"
        val messageException = "El campo de costo no puede ser vació."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description)
            fail()
        } catch (e: EmptyCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createOrderWithBadOrderCostZero() {
        // Given
        val cost = 5000.0
        val orderCost = 0.0
        val description = "Esto es una prueba"
        val messageException = "El campo de costo del pedido no puede ser vació."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description)
            fail()
        } catch (e: EmptyOrderCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createOrderWithBadDescriptionEmpty() {
        // Given
        val cost = 5000.0
        val orderCost = 5000.0
        val description = ""
        val messageException = "El campo descripción no puede ser vació."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description)
            fail()
        } catch (e: EmptyDescriptionException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createOrderWithBadUserId() {
        // Given
        val cost = 5000.0
        val orderCost = 5000.0
        val description = "Esto es una prueba"
        val userId = -1
        val messageException = "Tenemos un problema con tus credenciales, lo sentimos."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description, userId = userId)
            fail()
        } catch (e: BadUserIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createOrderWithBadCostEmpty() {
        // Given
        val cost = ""
        val orderCost = "5000.0"
        val description = "Esto es una prueba"
        val userId = 1
        val messageException = "El campo de costo no puede ser vació."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description, userId = userId)
            fail()
        } catch (e: EmptyCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun createOrderWithBadOrderCostEmpty() {
        // Given
        val cost = "6000.0"
        val orderCost = ""
        val description = "Esto es una prueba"
        val userId = 1
        val messageException = "El campo de costo del pedido no puede ser vació."
        // When
        try {
            Order(cost = cost, orderCost = orderCost, description = description, userId = userId)
            fail()
        } catch (e: EmptyOrderCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }
}