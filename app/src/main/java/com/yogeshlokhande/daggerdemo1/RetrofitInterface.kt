package com.yogeshlokhande.daggerdemo1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {
    @GET("?cat=famous&count=10")
    @Headers(
        "x-rapidapi-host:andruxnet-random-famous-quotes.p.rapidapi.com",
        "x-rapidapi-key:KLjbCv90EemshINAiXrPuxi5Ul7qp1oJMdljsnuxeChClA0rtp"
    )
    fun allQuotes(): Call<MutableList<QuoteResponse>>
}