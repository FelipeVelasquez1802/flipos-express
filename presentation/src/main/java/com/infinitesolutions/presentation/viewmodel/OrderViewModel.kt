package com.infinitesolutions.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infinitesolutions.domain.entity.Order
import com.infinitesolutions.domain.entity.Resource
import com.infinitesolutions.domain.service.OrderService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class OrderViewModel @ViewModelInject constructor(
    private val orderService: OrderService
) : ViewModel() {

    private val ordersLiveData: MutableLiveData<Resource<List<Order>>> = MutableLiveData()

    fun executeSelectByUser() {
        CoroutineScope(IO).launch {
            try {
                // TODO aquí agregar la lógica para que traiga el id del usuario
                val result = orderService.selectOrder(1)
                ordersLiveData.postValue(Resource(result))
            } catch (e: Throwable) {
                ordersLiveData.postValue(Resource(e))
            }
        }
    }

    fun getSelectByUserLiveData(): LiveData<Resource<List<Order>>> = ordersLiveData
}