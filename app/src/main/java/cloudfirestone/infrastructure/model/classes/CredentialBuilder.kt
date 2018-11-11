package cloudfirestone.infrastructure.model.classes

import cloudfirestone.infrastructure.model.interfaces.CredentialBuilderInterface
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.sections.injector

class CredentialBuilder : CredentialBuilderInterface {

    private lateinit var email: String
    private lateinit var password: String

    override fun email(email: String) = apply { this.email = email }

    override fun password(password: String) = apply { this.password = password }

    override fun build(): CredentialInterface {
        return injector.credentialConstructor.call(email, password)
    }
}