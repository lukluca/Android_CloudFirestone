package cloudfirestone.infrastructure.injector

import cloudfirestone.infrastructure.model.interfaces.CredentialBuilderInterface
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationInterface
import cloudfirestone.infrastructure.network.APIManagerInterface
import kotlin.reflect.KFunction

interface InjectorInterface {
    val apiManager: APIManagerInterface

    //Navigation
    val navigationManagerBuilder: NavigationBuilderInterface
    val navigationManagerConstructor: KFunction<NavigationInterface>

    //Credential
    val credentialBuilder: CredentialBuilderInterface
    val credentialConstructor: KFunction<CredentialInterface>

    //User

}