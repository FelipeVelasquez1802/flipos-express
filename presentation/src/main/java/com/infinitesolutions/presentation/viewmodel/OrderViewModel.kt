package com.infinitesolutions.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.service.OrderService
import com.infinitesolutions.domain.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class OrderViewModel @ViewModelInject constructor(
    private val orderService: OrderService,
    private val userService: UserService
) : ViewModel() {

    val ordersLiveData: MutableLiveData<Resource<List<Order>>> = MutableLiveData()

    fun executeSelectActiveByUser() {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.selectOrderActive(userId)
                ordersLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersLiveData.postValue(Resource(e))
            }
        }
    }

    fun executeSelectInactiveByUser() {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.selectOrderInactive(userId)
                ordersLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersLiveData.postValue(Resource(e))
            }
        }
    }

    fun executeInsert(cost: String, orderCost: String, description: String) {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.insert(cost, orderCost, description, userId)
                ordersLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersLiveData.postValue(Resource(e))
            }
        }
    }

    fun executeUpdateFinish(orderId: Int) {
        CoroutineScope(IO).launch {
            try {
                val result = orderService.updateFinish(orderId)
                ordersLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersLiveData.postValue(Resource(e))
            }
        }
    }
}