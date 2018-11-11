package cloudfirestone.sections.base.textwatchers

import android.text.Editable
import android.text.TextWatcher

typealias Validation = (CharSequence) -> Unit

abstract class BaseTextWatcher : TextWatcher {

    var validation: Validation? = null

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
}