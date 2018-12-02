package cloudfirestone.infrastructure.datastorage

import android.content.ContextWrapper


interface DataManagerBuilderInterface {
    fun build(): DataManagerInterface
    fun context(context: ContextWrapper): DataManagerBuilderInterface
}