package cloudfirestone.sections.authentication.textwatchers

import cloudfirestone.extensions.isEmailValid
import cloudfirestone.sections.base.textwatchers.BaseTextWatcher

class EmailTextWatcher : BaseTextWatcher() {

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        s.takeIf { it.isEmailValid() }?.let {
            validation?.invoke(it)
        }

    }
}