package com.example.retrofitkotlinmvp

import android.content.Context
import android.util.Log
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterImpl : MainContract.presenter {

    var context: Context
    var view: MainActivity
     var helpList = ArrayList<ResponModel>()


    constructor(context: Context, view: MainActivity) {
        this.context = context
        this.view = view
    }


    override fun requestDataFromServer() {

        var client =
            RestClient.create().getHelpLineNumber().enqueue(object : Callback<HelpLineMain> {
                override fun onFailure(call: Call<HelpLineMain>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<HelpLineMain>,
                    response: Response<HelpLineMain>
                ) {

                    response.body()?.arrayList
                    Log.d("Respose", response.body()?.arrayList?.get(0)?.helpline_phone)

                    var iCount = response.body()?.arrayList?.size

                    for (i in 0 until iCount!!) {
                        var name: String? = response.body()?.arrayList?.get(i)?.helpline_name
                        var number: String? = response.body()?.arrayList?.get(i)?.helpline_phone

                        var responeData = ResponModel(name, number)
                         helpList .add(responeData)

                    }

                    view.recycle.adapter = MainAdapter(context,helpList)

                }

            })
    }

}