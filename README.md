To reproduce, run:
```
./gradlew run
```

You should get the following runtime error:
```
Exception in thread "main" org.koin.core.error.NoBeanDefFoundException: No definition found for type 'dev.panuszewski.AnotherComponent'. Check your Modules configuration and add missing type and/or qualifier!
	at org.koin.core.scope.Scope.throwDefinitionNotFound(Scope.kt:302)
	at org.koin.core.scope.Scope.resolveValue(Scope.kt:272)
	at org.koin.core.scope.Scope.resolveInstance(Scope.kt:234)
	at org.koin.core.scope.Scope.get(Scope.kt:213)
	at dev.panuszewski.SomeComponent$special$$inlined$inject$default$1.invoke(KoinComponent.kt:67)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at dev.panuszewski.SomeComponent.getAnotherComponent(SomeComponent.kt:14)
	at dev.panuszewski.SomeComponent.foo(SomeComponent.kt:17)
	at dev.panuszewski.MainKt.main$lambda$0(Main.kt:12)
	at org.koin.core.context.GlobalContext.startKoin(GlobalContext.kt:64)
	at org.koin.core.context.DefaultContextExtKt.startKoin(DefaultContextExt.kt:40)
	at dev.panuszewski.MainKt.main(Main.kt:9)
	at dev.panuszewski.MainKt.main(Main.kt)

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':run'.
> Process 'command '/Users/radoslaw.panuszewski/Library/Java/JavaVirtualMachines/temurin-21.0.6/Contents/Home/bin/java'' finished with non-zero exit value 1
```

Expected outcome is compiler error:
```
e: [ksp] --> Missing Definition for property 'anotherComponent : dev.panuszewski.AnotherComponent' in 'dev.panuszewski.SomeComponent'. Fix your configuration: add definition annotation on the class.
e: Error occurred in KSP, check log for detail

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':kspKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.compilerRunner.GradleCompilerRunnerWithWorkers$GradleKotlinCompilerWorkAction
   > Compilation error. See log for more details
```

After uncommenting line 10 and commenting out line 14 in `SomeComponent.kt`, the above compiler error is correctly reported.