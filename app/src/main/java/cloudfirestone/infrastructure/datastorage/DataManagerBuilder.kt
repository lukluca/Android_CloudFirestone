package cloudfirestone.infrastructure.datastorage

import android.content.ContextWrapper
import cloudfirestone.sections.injector

class DataManagerBuilder : DataManagerBuilderInterface {

    private lateinit var context: ContextWrapper

    override fun context(context: ContextWrapper)= apply { this.context = context }

    override fun build(): DataManagerInterface {
        return injector.dataManagerConstructor.call(context)
    }
}