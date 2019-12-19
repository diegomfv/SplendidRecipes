package com.diegomfv.splendidrecipesmvvm.data.server

import com.diegomfv.splendidrecipesmvvm.ui.common.logSentToServer
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RecipeRetrofit(baseUrl: String) {

    val interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            logSentToServer(chain.request().url.toString())

            val request = original.newBuilder()
                .method(original.method, original.body)
                .build()

            return chain.proceed(request)
        }
    }

    val client = OkHttpClient.Builder()
        .apply {
            this.connectTimeout(30, TimeUnit.SECONDS)
            this.readTimeout(30, TimeUnit.SECONDS)
        }
        .addInterceptor(interceptor).build()

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    val spoonacularServerEndpoints: SpoonacularServerEndpoints = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run { create(SpoonacularServerEndpoints::class.java) }


}