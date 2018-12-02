package cloudfirestone.infrastructure.shared

import android.content.ContextWrapper
import cloudfirestone.infrastructure.network.APIManagerInterface
import cloudfirestone.infrastructure.session.SessionManagerInterface

interface SharedConfigInterface {

    val apiManager: APIManagerInterface

    fun getSessionManager(context: ContextWrapper): SessionManagerInterface

}