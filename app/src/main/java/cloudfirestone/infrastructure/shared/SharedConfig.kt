package cloudfirestone.infrastructure.shared

import android.content.ContextWrapper
import cloudfirestone.infrastructure.network.APIManagerInterface
import cloudfirestone.infrastructure.session.SessionManagerInterface
import cloudfirestone.sections.injector

class SharedConfig private constructor() : SharedConfigInterface  {

    override fun getSessionManager(context: ContextWrapper): SessionManagerInterface {
        this.sessionManager.context = context
        return this.sessionManager
    }

    override val apiManager: APIManagerInterface = injector.apiManager

    private val sessionManager: SessionManagerInterface = injector.sessionManager

    init {
    }

    private object Holder {
        val INSTANCE = SharedConfig()
    }

    companion object {
        val instance: SharedConfig by lazy { Holder.INSTANCE }
    }

}