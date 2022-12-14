 package com.example.idbmapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.idbmapi.Adapter.MovieAdapter
import com.example.idbmapi.Retrofit.*
import com.example.idbmapi.Retrofit.ApiClient.Companion.getRetrofit
import com.example.idbmapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

 class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding
     lateinit var movieAdapter: MovieAdapter
     var list = arrayListOf<DItem>()
     var list2 = arrayListOf<I>()
     var l3 = arrayListOf<DItem>()
     var movie = String()



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         initClick()


    }

     private fun initClick() {

         binding.search.setOnClickListener {
             movie =binding.edtname.text.toString()
             apicall(movie,"df0b31967bmsh5820936348dbeefp15ad6fjsn023cb89b2d94","imdb8.p.rapidapi.com")
         }
         apicall("srk","df0b31967bmsh5820936348dbeefp15ad6fjsn023cb89b2d94","imdb8.p.rapidapi.com")
     }

     fun apicall(q:String,key:String,host:String) {
         var apiInterface =getRetrofit().create(ApiInterface::class.java)
        apiInterface.getData(q,key,host).enqueue(object : Callback<Modeldata> {
            override fun onResponse(call: Call<Modeldata>, response: Response<Modeldata>) {
                var movieMD = response.body()
                list = movieMD?.d as ArrayList<DItem>
                list2 = movieMD?.d as ArrayList<I>
                rvAdapter()
            }

            override fun onFailure(call: Call<Modeldata>, t: Throwable) {
                Toast.makeText(this@MainActivity, "=======================================", Toast.LENGTH_SHORT).show()
            }
        })

    }

      fun rvAdapter() {
          movieAdapter = MovieAdapter(this,list)
          var lm =GridLayoutManager(this,2)
          binding.rcy.layoutManager =lm
          binding.rcy.adapter =movieAdapter
      }
 }