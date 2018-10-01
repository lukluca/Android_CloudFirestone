package cloudfirestone.infrastructure.network.authentication.login

import cloudfirestone.infrastructure.dataclass.UserInterface

interface LoginAPI {
    fun login(email: String, password: String, success: (user: UserInterface) -> Unit, error: (r: LoginError) -> Unit)
}

