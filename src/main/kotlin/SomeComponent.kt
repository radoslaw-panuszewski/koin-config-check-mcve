package dev.panuszewski

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single
class SomeComponent : KoinComponent {

    private val anotherComponent: AnotherComponent by inject()

    fun foo() {
        anotherComponent.bar()
    }
}