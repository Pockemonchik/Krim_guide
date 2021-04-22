package com.example.krim_guide


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.krim_guide.db.DataBase
import com.example.krim_guide.db.ObjectDesc
import com.example.krim_guide.db.ObjectDescViewModel
import com.example.krim_guide.ui.gallery.CategoryAdapter
import com.example.krim_guide.ui.gallery.ListItem
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mObjectDescViewModel: ObjectDescViewModel
//    private var db: DataBase? = null
//    private var objectDesc: ObjectDesc? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)




        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        mObjectDescViewModel =  ViewModelProvider(this).get(ObjectDescViewModel::class.java)
        val dbData = mObjectDescViewModel.getAllObjectDesc.value
        Log.e("data", dbData.toString())
        if (dbData == null){
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(1,"Сейф",R.drawable.key2))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(2,"Замок",R.drawable.key))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(3,"Сейф",R.drawable.key2))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(4,"Замок",R.drawable.key))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val menuItem = menu!!.findItem(R.id.search)
        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(text: String?): Boolean {
                    if (text!!.isNotEmpty()) {
                        //clear data list and search from db
                    }
                    else{
                        // clear data list notify
                    }
                    return true
                }

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }
            })
        }
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}