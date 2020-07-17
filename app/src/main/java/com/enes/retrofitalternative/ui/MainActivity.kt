package com.enes.retrofitalternative.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.enes.retrofit.adapter.DogRecyclerViewAdapter
import com.enes.retrofit.model.Dog
import com.enes.retrofit.service.RetrofitApi
import com.enes.retrofit.utils.Constants.BASE_URL
import com.enes.retrofitalternative.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var dogAdapter: DogRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeRetrofitCall()
    }

    private fun makeRetrofitCall() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val instance = retrofit.create(RetrofitApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            instance.getDogData().enqueue(object : Callback<Dog> {
                override fun onFailure(call: Call<Dog>, t: Throwable) {
                    makeLog(t.message)
                }

                override fun onResponse(call: Call<Dog>, response: Response<Dog>) {
                    setupRecyclerView(response.body())
                }
            })
        }
    }

    private fun setupRecyclerView(dogList: Dog?) {
        dogList?.let {
            dogAdapter = DogRecyclerViewAdapter(dogList.message)
        }

        val dogLayoutManager = GridLayoutManager(
            this,
            2,
            GridLayoutManager.VERTICAL,
            false
        )

        dogRecyclerViewContainer.apply {
            adapter = dogAdapter
            layoutManager = dogLayoutManager
        }
    }

    private fun makeLog(message: String?) {
        message?.let {
            Log.e("Dog View Model", message)
        }
    }
}