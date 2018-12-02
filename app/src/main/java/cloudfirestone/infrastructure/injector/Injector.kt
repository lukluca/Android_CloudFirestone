package cloudfirestone.infrastructure.injector

import cloudfirestone.infrastructure.datastorage.DataManager
import cloudfirestone.infrastructure.datastorage.DataManagerBuilder
import cloudfirestone.infrastructure.datastorage.DataManagerBuilderInterface
import cloudfirestone.infrastructure.datastorage.DataManagerInterface
import cloudfirestone.infrastructure.firebase.network.FireBaseAPIManager
import cloudfirestone.infrastructure.model.classes.Credential
import cloudfirestone.infrastructure.model.classes.CredentialBuilder
import cloudfirestone.infrastructure.model.interfaces.CredentialBuilderInterface
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.navigation.classes.NavigationManager
import cloudfirestone.infrastructure.navigation.classes.NavigationManagerBuilder
import cloudfirestone.infrastructure.navigation.interfaces.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationInterface
import cloudfirestone.infrastructure.network.APIManagerInterface
import cloudfirestone.infrastructure.session.SessionManager
import cloudfirestone.infrastructure.session.SessionManagerInterface
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

class Injector : InjectorInterface {

    companion object {
        //Network
        val apiManagerType: KClass<out APIManagerInterface> = FireBaseAPIManager::class

        //Navigation
        val navigationManagerType: KClass<out NavigationInterface> = NavigationManager::class
        val navigationManagerBuilderType: KClass<out NavigationBuilderInterface> = NavigationManagerBuilder::class

        //Credential
        val credentialType: KClass<out CredentialInterface> = Credential::class
        val credentialBuilderType: KClass<out CredentialBuilderInterface> = CredentialBuilder::class

        //Session
        val sessionManagerType: KClass<out SessionManagerInterface> = SessionManager::class

        //DataManager
        val dataManagerType: KClass<out DataManagerInterface> = DataManager::class
        val dataManagerBuilderType: KClass<out DataManagerBuilderInterface> = DataManagerBuilder::class

    }

    override val navigationManagerBuilder: NavigationBuilderInterface
        get() = (navigationManagerBuilderType.constructors as List).first().call()

    override val navigationManagerConstructor: KFunction<NavigationInterface>
        get() = (navigationManagerType.constructors as List).first()

    override val apiManager: APIManagerInterface
        get() = (apiManagerType.constructors as List).first().call()

    override val credentialBuilder: CredentialBuilderInterface
        get() = (credentialBuilderType.constructors as List).first().call()

    override val credentialConstructor: KFunction<CredentialInterface>
        get() = (credentialType.constructors as List).first()

    override val sessionManager: SessionManagerInterface
        get() = (sessionManagerType.constructors as List).first().call()

    override val dataManagerBuilder: DataManagerBuilderInterface
        get() = (dataManagerBuilderType.constructors as List).first().call()

    override val dataManagerConstructor: KFunction<DataManagerInterface>
        get() = (dataManagerType.constructors as List).first()
}