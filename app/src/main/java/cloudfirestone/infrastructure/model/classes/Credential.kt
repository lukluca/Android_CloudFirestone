package cloudfirestone.infrastructure.model.classes

import cloudfirestone.infrastructure.model.interfaces.CredentialInterface

data class Credential(override val email: String, override val password: String): CredentialInterface


