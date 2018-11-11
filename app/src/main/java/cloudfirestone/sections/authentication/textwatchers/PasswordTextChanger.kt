package cloudfirestone.sections.authentication.textwatchers

import cloudfirestone.extensions.isPasswordValid
import cloudfirestone.sections.base.textwatchers.BaseTextWatcher

class PasswordTextChanger : BaseTextWatcher() {

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        s.takeIf { it.isPasswordValid() }?.let {
            validation?.invoke(it)
        }
    }
}