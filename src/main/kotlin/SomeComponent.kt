package dev.panuszewski

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single
class SomeComponent(
    // this is checked during compile time (uncomment to verify)
    // private val anotherComponent: AnotherComponent
) : KoinComponent {

    // this is not checked during compile time
    private val anotherComponent: AnotherComponent by inject()

    fun foo() {
        anotherComponent.bar()
    }
}