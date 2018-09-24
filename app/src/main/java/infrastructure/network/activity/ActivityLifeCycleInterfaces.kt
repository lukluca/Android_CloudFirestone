package infrastructure.network.activity

import infrastructure.dataclass.UserInterface
import infrastructure.network.login.LoginError


interface ActivityLifeCycleInterface {
    fun onActivityCreate()
    fun onActivityStart()
}