package cloudfirestone.sections.authentication.buttons

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.model.interfaces.UserInterface
import cloudfirestone.infrastructure.network.authentication.login.LoginError
import cloudfirestone.infrastructure.network.authentication.login.LoginListener
import cloudfirestone.sections.authentication.onclicklisteners.LoginOnClickListener
import com.tagliabue.cloudfirestone.R

class LoginButton : AppCompatButton {

    private val loginListener = LoginListener(this::loginSuccess, this::loginError)

    private val loginOnClickListener = LoginOnClickListener()

    private fun loginError(error: LoginError) {

    }

    private fun loginSuccess(value: UserInterface) {

    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        this.isEnabled = false
        this.text = context.resources.getString(R.string.login_button)

        this.loginOnClickListener.loginListener = loginListener

        this.setOnClickListener(loginOnClickListener)
    }

    var credential: CredentialInterface? = null
        set(value) {
            value?.let {
                this.isEnabled = true
            }

            this.loginOnClickListener.credential = value

            field = value
        }
}