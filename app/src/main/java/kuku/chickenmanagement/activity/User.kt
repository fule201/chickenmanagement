package kuku.chickenmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.app_bar_user.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_user.*
import kuku.chickenmanagement.MainActivity
import kuku.chickenmanagement.R
import kuku.chickenmanagement.data.kukuAdapter
import kuku.chickenmanagement.model.KukuModel

class User : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var dialogBuilder: AlertDialog.Builder? = null
    private var dialog: AlertDialog? = null
    private var adapter: kukuAdapter? = null
    private var kukuList: ArrayList<KukuModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)

        //instansiating
        kukuList = ArrayList<KukuModel>()
        layoutManager = LinearLayoutManager(this)
        adapter = kukuAdapter(kukuList!!, this)

        //setup the list  recycler view
        urecyclerViewID.layoutManager = layoutManager
        urecyclerViewID.adapter = adapter

        //load data
        for (i in 0..9){
            val kukuModel = KukuModel()
            kukuModel.Title = "fule" + i
            kukuModel.Content = "Content" + i

            kukuList!!.add(kukuModel)
        }
        adapter!!.notifyDataSetChanged()

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            //going back to main activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.user, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_share -> {

                val i = Intent(Intent.ACTION_SEND)
                i.type = "text/plain"
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing Kuku App")
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=kuku.chickenmanagement")
                startActivity(Intent.createChooser(i, "Sharing Kuku App"))
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
