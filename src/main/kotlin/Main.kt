package dev.panuszewski

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun main() {
    startKoin {
        modules(MainModule().module)
        val someComponent = koin.get<SomeComponent>()
        someComponent.foo()
    }
}

@Module
@ComponentScan
class MainModule