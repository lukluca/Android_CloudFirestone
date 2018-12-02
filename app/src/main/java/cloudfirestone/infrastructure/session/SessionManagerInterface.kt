package cloudfirestone.infrastructure.session

import android.content.ContextWrapper
import cloudfirestone.infrastructure.datastorage.DataManagerInterface

interface SessionManagerInterface {

    var context: ContextWrapper?
    val dataManager: DataManagerInterface?
}