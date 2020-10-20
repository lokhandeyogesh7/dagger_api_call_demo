package com.yogeshlokhande.daggerdemo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var retrofit: Retrofit? = null
    @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as BaseApplication).getNetworksComponent().inject(this@MainActivity)

        val webService = retrofit?.create(RetrofitInterface::class.java)
        val quoteList = webService?.allQuotes()

        quoteList!!.enqueue(object :retrofit2.Callback<MutableList<QuoteResponse>>{
            override fun onResponse(
                call: Call<MutableList<QuoteResponse>>,
                response: Response<MutableList<QuoteResponse>>
            ) {
                Log.d(TAG,response.body().toString())
            }

            override fun onFailure(call: Call<MutableList<QuoteResponse>>, t: Throwable) {
                Log.d(TAG,t.toString())
            }
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}