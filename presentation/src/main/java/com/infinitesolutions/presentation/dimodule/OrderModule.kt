package com.infinitesolutions.presentation.dimodule

import com.infinitesolutions.dataaccess.repository.order.OrderRepositoryImpl
import com.infinitesolutions.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class OrderModule {
    @Binds
    abstract fun bindOrderRepository(orderRepository: OrderRepositoryImpl): OrderRepository
}