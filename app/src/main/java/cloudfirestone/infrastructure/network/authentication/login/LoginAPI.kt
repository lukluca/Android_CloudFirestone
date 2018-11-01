package cloudfirestone.infrastructure.network.authentication.login

import cloudfirestone.infrastructure.dataclass.UserInterface
import cloudfirestone.infrastructure.network.listener.NetworkListener

interface LoginAPI {
    fun login(email: String, password: String, listener: LoginListener)
}

typealias LoginListener = NetworkListener<UserInterface, LoginError>

