package cloudfirestone.infrastructure.injector

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
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

class Injector : InjectorInterface {

    companion object {
        val apiManagerType: KClass<out APIManagerInterface> = FireBaseAPIManager::class

        //Navigation
        val navigationManagerType: KClass<out NavigationInterface> = NavigationManager::class
        val navigationManagerBuilderType: KClass<out NavigationBuilderInterface> = NavigationManagerBuilder::class

        //Credential
        val credentialType: KClass<out CredentialInterface> = Credential::class
        val credentialBuilderType: KClass<out CredentialBuilderInterface> = CredentialBuilder::class

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
}