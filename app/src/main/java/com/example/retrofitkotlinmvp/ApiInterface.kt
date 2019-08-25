package com.example.retrofitkotlinmvp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/GargotiApp/Helpline.php")
    fun getHelpLineNumber(): Call<HelpLineMain>


}