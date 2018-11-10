package cloudfirestone.infrastructure.injecter

import cloudfirestone.infrastructure.navigation.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.NavigationInterface
import cloudfirestone.infrastructure.navigation.NavigationManager
import cloudfirestone.infrastructure.navigation.NavigationManagerBuilder
import kotlin.reflect.KClass

class Inj {

    companion object {
        val navigationManagerBuilderType: KClass<out NavigationBuilderInterface> = NavigationManagerBuilder::class
        val navigationManagerType : KClass<out NavigationInterface> = NavigationManager::class
    }

    val navigationManagerBuilder: NavigationBuilderInterface
        get() {
            return (navigationManagerBuilderType.constructors as List).first().call()
        }

    val navigationManager: NavigationInterface
        get() {
            return navigationManagerType.objectInstance!!
        }
}