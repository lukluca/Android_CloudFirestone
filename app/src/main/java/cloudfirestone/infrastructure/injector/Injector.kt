package cloudfirestone.infrastructure.injector

import cloudfirestone.infrastructure.firebase.network.FireBaseAPIManager
import cloudfirestone.infrastructure.navigation.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.NavigationInterface
import cloudfirestone.infrastructure.navigation.NavigationManager
import cloudfirestone.infrastructure.navigation.NavigationManagerBuilder
import cloudfirestone.infrastructure.network.APIManagerInterface
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

class Injector : InjectorInterface {

    companion object {
        val navigationManagerBuilderType: KClass<out NavigationBuilderInterface> = NavigationManagerBuilder::class
        val navigationManagerType : KClass<out NavigationInterface> = NavigationManager::class
        val apiManagerType: KClass<out APIManagerInterface> = FireBaseAPIManager::class

    }

    override val navigationManagerBuilder: NavigationBuilderInterface
        get() {
            return (navigationManagerBuilderType.constructors as List).first().call()
        }

    override val navigationManagerConstructor: KFunction<NavigationInterface>
        get() {
            return (navigationManagerType.constructors as List).first()
        }

    override val apiManager: APIManagerInterface
        get() {
            return (apiManagerType.constructors as List).first().call()
        }
}