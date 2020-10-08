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

    val ordersActiveLiveData: MutableLiveData<Resource<List<Order>>> = MutableLiveData()
    val orderLiveData: MutableLiveData<Resource<Order>> = MutableLiveData()
    val ordersInactiveLiveData: MutableLiveData<Resource<List<Order>>> = MutableLiveData()

    fun executeSelectActiveByUser() {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.selectOrderActive(userId)
                ordersActiveLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersActiveLiveData.postValue(Resource(e))
            }
        }
    }

    fun executeSelectInactiveByUser() {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.selectOrderInactive(userId)
                ordersActiveLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersActiveLiveData.postValue(Resource(e))
            }
        }
    }

    fun executeInsert(cost: String, orderCost: String, description: String) {
        CoroutineScope(IO).launch {
            try {
                val userId = userService.selectId()
                val result = orderService.insert(cost, orderCost, description, userId)
                ordersActiveLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersActiveLiveData.postValue(Resource(e))
            }
        }
    }
}