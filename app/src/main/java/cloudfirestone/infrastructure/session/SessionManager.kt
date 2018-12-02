package cloudfirestone.infrastructure.session

import android.content.ContextWrapper
import cloudfirestone.infrastructure.datastorage.DataManagerInterface
import cloudfirestone.sections.injector

class SessionManager: SessionManagerInterface {

    override var dataManager: DataManagerInterface? = null
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        private set

    override var context: ContextWrapper? = null
        set(value) {
            value?.takeIf {
                it != context
            }?.let {
                context = it

                this.dataManager = injector.dataManagerBuilder.context(it).build()
            }
        }
}