package cloudfirestone.infrastructure.shared

import cloudfirestone.sections.injector

class SharedConfig private constructor() {

    val apiManager = injector.apiManager

    init {
    }

    private object Holder {
        val INSTANCE = SharedConfig()
    }

    companion object {
        val instance: SharedConfig by lazy { Holder.INSTANCE }
    }

}