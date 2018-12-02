package cloudfirestone.infrastructure.injector

import cloudfirestone.infrastructure.datastorage.DataManagerBuilder
import cloudfirestone.infrastructure.datastorage.DataManagerBuilderInterface
import cloudfirestone.infrastructure.datastorage.DataManagerInterface
import cloudfirestone.infrastructure.model.interfaces.CredentialBuilderInterface
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationInterface
import cloudfirestone.infrastructure.network.APIManagerInterface
import cloudfirestone.infrastructure.session.SessionManagerInterface
import kotlin.reflect.KFunction

interface InjectorInterface {
    //Network
    val apiManager: APIManagerInterface

    //Navigation
    val navigationManagerBuilder: NavigationBuilderInterface
    val navigationManagerConstructor: KFunction<NavigationInterface>

    //Credential
    val credentialBuilder: CredentialBuilderInterface
    val credentialConstructor: KFunction<CredentialInterface>

    //Session
    val sessionManager: SessionManagerInterface

    //DataManager
    val dataManagerBuilder: DataManagerBuilderInterface
    val dataManagerConstructor: KFunction<DataManagerInterface>

}