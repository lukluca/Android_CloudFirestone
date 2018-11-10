package cloudfirestone.sections

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.tagliabue.cloudfirestone.R
import cloudfirestone.infrastructure.firebase.network.FireBaseAPIManager
import cloudfirestone.infrastructure.injecter.Inj
import cloudfirestone.infrastructure.navigation.DestinationInterface
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.network.APIManagerInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, NavigationListener {

    //TODO add id layout fragment container
    private val navigationManager = Inj().navigationManagerBuilder
            .fragmentManager(supportFragmentManager)
            .apiManager(getAPI())
            .navigationListener(this)
            .build()

    private val apiManager: APIManagerInterface = FireBaseAPIManager()

    //TODO substitute getAPI
    private fun getAPI(): APIManagerInterface {
        return apiManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        apiManager.onActivityCreate()
    }

    override fun onStart() {
        super.onStart()

        apiManager.onActivityStart()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    var actionBarTitle: String? = null
        set(value) {
            supportActionBar?.title = value
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks.
        navigationManager.handleTouch(item)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun navigateTo(destination: DestinationInterface) {
       navigationManager.navigateTo(destination)
    }
}
