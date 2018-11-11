package cloudfirestone.sections.base.onclicklisteners

import android.view.View
import cloudfirestone.infrastructure.navigation.interfaces.DestinationInterface
import cloudfirestone.infrastructure.navigation.listener.OnNavigateButtonClickListener

class NavigationClickListener(private val destination: DestinationInterface) : View.OnClickListener {

    var navigationListener: OnNavigateButtonClickListener? = null

    override fun onClick(v: View?) {
        this.navigationListener?.onNavigateClick(destination)
    }
}