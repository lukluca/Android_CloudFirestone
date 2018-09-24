package infrastructure.network.login

import infrastructure.dataclass.UserInterface

interface LoginAPI {
    fun login(email: String, password: String, success: (user: UserInterface) -> Unit, error: (r: LoginError) -> Unit)
}

