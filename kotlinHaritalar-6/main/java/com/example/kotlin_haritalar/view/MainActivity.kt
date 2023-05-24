package com.example.kotlin_haritalar.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.kotlin_haritalar.R
import com.example.kotlin_haritalar.adapter.placeAdapter
import com.example.kotlin_haritalar.databinding.ActivityMainBinding
import com.example.kotlin_haritalar.databinding.ActivityMapsBinding
import com.example.kotlin_haritalar.rooms.yerDatabase
import com.example.kotlin_haritalar.yer
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val db = Room.databaseBuilder(applicationContext,yerDatabase::class.java,"yerler").build()
        val placeDao = db.YerDao()
        compositeDisposable.add(
            placeDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )

    }

    private fun handleResponse(placeList : List<yer>){
            binding.recyclerView.layoutManager=LinearLayoutManager(this)
            val adapter =  placeAdapter(placeList)
            binding.recyclerView.adapter=adapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.place_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if( item.itemId == R.id.add_place){
           val intent = Intent(this, MapsActivity::class.java)
           startActivity(intent)
       }
          return super.onOptionsItemSelected(item)
    }


}