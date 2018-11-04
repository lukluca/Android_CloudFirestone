package cloudfirestone.sections.authentication.buttons

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.View
import cloudfirestone.infrastructure.navigation.Destination
import cloudfirestone.infrastructure.navigation.listener.OnNavigateButtonClickListener
import com.tagliabue.cloudfirestone.R

class NavigateToNewAccountButton: AppCompatButton, View.OnClickListener {

    var navigationListener: OnNavigateButtonClickListener? = null

    override fun onClick(v: View?) {

        this.navigationListener?.onNavigateClick(Destination.NEW_ACCOUNT)

    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        this.text = context.resources.getString(R.string.new_account_need)
        this.setOnClickListener(this)
    }
}
