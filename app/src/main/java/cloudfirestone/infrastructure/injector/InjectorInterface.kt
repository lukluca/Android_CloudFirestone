package cloudfirestone.infrastructure.injector

import cloudfirestone.infrastructure.navigation.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.NavigationInterface
import cloudfirestone.infrastructure.network.APIManagerInterface
import kotlin.reflect.KFunction

interface InjectorInterface {
    val apiManager: APIManagerInterface
    val navigationManagerConstructor: KFunction<NavigationInterface>
    val navigationManagerBuilder: NavigationBuilderInterface
}