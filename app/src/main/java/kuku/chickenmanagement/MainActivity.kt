package kuku.chickenmanagement

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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.login_popup.view.*
import kotlinx.android.synthetic.main.register_popup.*
import kotlinx.android.synthetic.main.register_popup.view.*
import kuku.chickenmanagement.R
import kuku.chickenmanagement.R.id.LoginNoAccID
import kuku.chickenmanagement.activity.About
import kuku.chickenmanagement.activity.Admin
import kuku.chickenmanagement.activity.ContactUs
import kuku.chickenmanagement.activity.User
import kuku.chickenmanagement.data.kukuAdapter
import kuku.chickenmanagement.model.KukuModel

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var dialogBuilder: AlertDialog.Builder? = null
    private var dialog: AlertDialog? = null
    private var adapter: kukuAdapter? = null
    private var kukuList: ArrayList<KukuModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //instansiating
        kukuList = ArrayList<KukuModel>()
        layoutManager = LinearLayoutManager(this)
        adapter = kukuAdapter(kukuList!!, this)

        //setup the list  recycler view
        kukuRecyclerView.layoutManager = layoutManager
        kukuRecyclerView.adapter = adapter

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
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
////        when (item.itemId) {
////            R.id.action_settings -> return true
////            else -> return super.onOptionsItemSelected(item)
////        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.LoginpopID -> {
                // Handle the camera action
                createLogin()
            }
            R.id.RegPopID -> {

                createReg()
            }

            R.id.nav_share -> {

                val i = Intent(Intent.ACTION_SEND)
                i.type = "text/plain"
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing Kuku App")
                i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=kuku.chickenmanagement")
                startActivity(Intent.createChooser(i, "Sharing Kuku App"))
            }

            R.id.AboutID -> {
                startActivity(Intent(this, About::class.java))
                finish()
            }

            R.id.ContactID -> {
                startActivity(Intent(this, ContactUs::class.java))
                finish()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun createLogin(){

        var view = layoutInflater.inflate(R.layout.login_popup, null)
        var LoginLoginID = view.LoginLoginID
        var LoginEmailID = view.LoginEmailID
        var LoginPassID = view.LoginPassID
        var LoginBtnID = view.LoginBtnID
        var LoginNoAccID = view.LoginNoAccID


        dialogBuilder = AlertDialog.Builder(this).setView(view)
        dialog = dialogBuilder!!.create()

        dialog?.show()

//        var tList: ArrayList<Double>? = null
//
//        tList = dbHandler!!.getTodayExp()
//        var t = tList[0]


//        dialog?.dismiss()

        LoginNoAccID.setOnClickListener{
            dialog?.dismiss()
            createReg()
        }

        LoginBtnID.setOnClickListener {
            dialog?.dismiss()
            startActivity(Intent(this, Admin::class.java))
            finish()
        }

    }

    fun createReg(){

        var view = layoutInflater.inflate(R.layout.register_popup, null)
        var RegUserNameID = view.RegUserNameID
        var RegPhoneID = view.RegPhoneID
        var RegEmailID = view.RegEmailID
        var RegpassID = view.RegpassID
        var RedRegID = view.RedRegID
        var RegbtnID = view.RegbtnID
        var reghaveloginID = view.reghaveloginID

        dialogBuilder = AlertDialog.Builder(this).setView(view)
        dialog = dialogBuilder!!.create()

        dialog?.show()

//        var tList: ArrayList<Double>? = null
//
//        tList = dbHandler!!.getTodayExp()
//        var t = tList[0]


//        dialog?.dismiss()

        RegbtnID.setOnClickListener {

            dialog?.dismiss()
            startActivity(Intent(this, User::class.java))
            finish()
        }

        reghaveloginID.setOnClickListener {
            dialog?.dismiss()
            createLogin()
        }

    }

}
