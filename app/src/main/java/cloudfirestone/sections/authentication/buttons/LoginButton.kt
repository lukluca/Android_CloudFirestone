package cloudfirestone.sections.authentication.buttons

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.View
import cloudfirestone.infrastructure.dataclass.UserInterface
import cloudfirestone.infrastructure.network.authentication.login.LoginAPI
import cloudfirestone.infrastructure.network.authentication.login.LoginError
import com.tagliabue.cloudfirestone.R


class LoginButton: AppCompatButton, View.OnClickListener {

    var loginAPI: LoginAPI? = null

    override fun onClick(v: View?) {

        loginAPI?.login("cippalippa@test.com","Qwerty123", {this.loginSuccess(it)}, {this.loginFailure(it)})

    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        this.text = context.resources.getString(R.string.login_button)
        this.setOnClickListener(this)
    }


    private fun loginSuccess(user: UserInterface) {
        print("success")
    }

    private fun loginFailure(error: LoginError) {
        print("error")
    }
}