package cloudfirestone.infrastructure.datastorage

import cloudfirestone.infrastructure.datastorage.user.UserInterface

interface DataManagerInterface {

    val user: UserInterface?
}