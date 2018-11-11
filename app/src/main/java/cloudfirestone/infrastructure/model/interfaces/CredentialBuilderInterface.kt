package cloudfirestone.infrastructure.model.interfaces

interface CredentialBuilderInterface {
    fun build(): CredentialInterface
    fun email(email: String): CredentialBuilderInterface
    fun password(password: String): CredentialBuilderInterface
}