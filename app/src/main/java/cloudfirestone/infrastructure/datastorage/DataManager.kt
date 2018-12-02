package cloudfirestone.infrastructure.datastorage

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import cloudfirestone.infrastructure.datastorage.user.UserInterface

class DataManager(_context: ContextWrapper): DataManagerInterface {

    private val preferencesFileName = "cloudfirestone.infrastructure.datastorage.prefs"
    private val context: ContextWrapper = _context
    private val prefs: SharedPreferences

    init {
        prefs = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE)
    }

    val USER_KEY = "USER_KEY"

    override val user: UserInterface?
        //TODO use gson
        get() = null
}