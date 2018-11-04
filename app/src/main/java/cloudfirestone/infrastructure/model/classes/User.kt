package cloudfirestone.infrastructure.model.classes

interface UserInterface {

    val email: String
}

data class User(override val email: String): UserInterface