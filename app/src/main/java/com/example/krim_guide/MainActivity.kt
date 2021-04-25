@file:Suppress("DEPRECATION")

package com.example.krim_guide


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.krim_guide.db.DataBase
import com.example.krim_guide.db.ObjectDesc
import com.example.krim_guide.db.ObjectDescViewModel
import com.example.krim_guide.search.SearchListAdapter
import com.example.krim_guide.ui.gallery.CategoryAdapter
import com.example.krim_guide.ui.gallery.GalleryAdapter
import com.example.krim_guide.ui.gallery.ListItem
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mObjectDescViewModel: ObjectDescViewModel
    private  val searchAdapter: SearchListAdapter by lazy { SearchListAdapter(this) }



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
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(1,"Сейф","Категория сейфы",R.drawable.key2))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(2,"Замок","Категория замки и пломбы",R.drawable.key))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(3,"Сейф","Категория сейфы",R.drawable.key2))
            mObjectDescViewModel.insertObjectDesc(ObjectDesc(4,"Замок","Категория замки и пломбы",R.drawable.key))
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val search = menu!!.findItem(R.id.search)
        val searchView = search?.actionView as? SearchView
        searchView?.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        val searchListView : RecyclerView = findViewById(R.id.searchListView)
        if (text!!.isNotEmpty()) {
            val searchListView : RecyclerView = findViewById(R.id.searchListView)
            val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
            dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_drawable))
            searchListView.addItemDecoration(dividerItemDecoration)
            searchListView.visibility = VISIBLE
            searchListView.layoutManager = LinearLayoutManager(this)
            searchListView.adapter = searchAdapter
            searchDatabase(text)

        }
        else{
            searchListView.visibility = GONE
        }
        return true
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {

        return true
    }
    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        Log.e("query", searchQuery)
        mObjectDescViewModel.searchDatabase(searchQuery).observe(this) { list ->
            list.let {
                Log.e("list", it.toString())
                searchAdapter.setData(it)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}