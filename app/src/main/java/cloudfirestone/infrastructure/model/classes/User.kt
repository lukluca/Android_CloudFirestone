package cloudfirestone.infrastructure.model.classes

import cloudfirestone.infrastructure.model.interfaces.UserInterface

data class User(override val email: String): UserInterface