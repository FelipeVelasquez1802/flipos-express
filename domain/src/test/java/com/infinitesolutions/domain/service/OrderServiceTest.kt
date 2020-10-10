package com.infinitesolutions.domain.service

import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.exception.BadUserIdException
import com.infinitesolutions.domain.exception.badid.BadOrderIdException
import com.infinitesolutions.domain.exception.empty.EmptyCostException
import com.infinitesolutions.domain.exception.empty.EmptyDescriptionException
import com.infinitesolutions.domain.exception.empty.EmptyOrderCostException
import com.infinitesolutions.domain.repository.OrderRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class OrderServiceTest {

    @Mock
    lateinit var orderRepository: OrderRepository

    private lateinit var orderService: OrderService

    @Before
    fun init() {
        orderService = OrderService(orderRepository)
    }

    @Test
    fun consultOrdersActiveWithBadUserId() {
        // Given
        val userId = -1
        val messageException =
            "Tenemos un problema con tus credenciales, lo sentimos."
        // When
        try {
            orderService.selectOrderActive(userId)
            fail()
        } catch (e: BadUserIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun consultOrdersActiveSuccess() {
        // Given
        val userId = 1
        Mockito.`when`(orderRepository.selectActiveByUser(userId)).thenReturn(listOf())
        // When
        val orders = orderService.selectOrderActive(userId)
        // Then
        assertNotNull(orders)
    }

    @Test
    fun consultOrdersInactiveWithBadUserId() {
        // Given
        val userId = -1
        val messageException =
            "Tenemos un problema con tus credenciales, lo sentimos."
        // When
        try {
            orderService.selectOrderInactive(userId)
            fail()
        } catch (e: BadUserIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun consultOrdersInactiveSuccess() {
        // Given
        val userId = 1
        Mockito.`when`(orderRepository.selectInactiveByUser(userId)).thenReturn(listOf())
        // When
        val orders = orderService.selectOrderInactive(userId)
        // Then
        assertNotNull(orders)
    }

    @Test
    fun insertOrderSuccess() {
        // Given
        val cost = "6000.0"
        val orderCost = "6000.0"
        val description = "Esto es una prueba"
        val userId = 1
        val order = Order(cost, orderCost, description, userId)
        Mockito.`when`(orderRepository.insert(order)).thenReturn(listOf())
        // When
        val orders = orderService.insert(cost, orderCost, description, userId)
        // Then
        assertNotNull(orders)
    }

    @Test
    fun insertOrderWithCostEmpty() {
        // Given
        val cost = ""
        val orderCost = "6000.0"
        val description = "Esto es una prueba"
        val userId = 1
        val messageException = "El campo de costo no puede ser vació."
        // When
        try {
            orderService.insert(cost, orderCost, description, userId)
            fail()
        } catch (e: EmptyCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun insertOrderWithOrderCostEmpty() {
        // Given
        val cost = "5000.0"
        val orderCost = ""
        val description = "Esto es una prueba"
        val userId = 1
        val messageException = "El campo de costo del pedido no puede ser vació."
        // When
        try {
            orderService.insert(cost, orderCost, description, userId)
            fail()
        } catch (e: EmptyOrderCostException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun insertOrderWithDescriptionEmpty() {
        // Given
        val cost = "5000.0"
        val orderCost = "6000.0"
        val description = ""
        val userId = 1
        val messageException = "El campo descripción no puede ser vació."
        // When
        try {
            orderService.insert(cost, orderCost, description, userId)
            fail()
        } catch (e: EmptyDescriptionException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun insertOrderWithBadUserId() {
        // Given
        val cost = "5000.0"
        val orderCost = "6000.0"
        val description = "Esto es una prueba"
        val userId = -1
        val messageException = "Tenemos un problema con tus credenciales, lo sentimos."
        // When
        try {
            orderService.insert(cost, orderCost, description, userId)
            fail()
        } catch (e: BadUserIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun finishOrderWithBadOrderId() {
        // Given
        val orderId = -1
        val messageException = "Tenemos problemas con esta orden, comunicate con soporte."
        // When
        try {
            orderService.updateFinish(orderId)
            fail()
        } catch (e: BadOrderIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun finishOrderSuccess() {
        // Given
        val orderId = 1
        // When
        val orders = orderService.updateFinish(orderId)
        // then
        assertNotNull(orders)
    }

    @Test
    fun cancelOrderWithBadOrderId() {
        // Given
        val orderId = -1
        val messageException = "Tenemos problemas con esta orden, comunicate con soporte."
        // When
        try {
            orderService.updateCancel(orderId)
            fail()
        } catch (e: BadOrderIdException) {
            // Then
            assertEquals(messageException, e.message)
        }
    }

    @Test
    fun cancelOrderSuccess() {
        // Given
        val orderId = 1
        // When
        val orders = orderService.updateCancel(orderId)
        assertNotNull(orders)
    }

}