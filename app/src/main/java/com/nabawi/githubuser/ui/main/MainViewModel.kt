package com.nabawi.githubuser.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabawi.githubuser.api.retrofitClient
import com.nabawi.githubuser.data.model.User
import com.nabawi.githubuser.data.model.userResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val listUser = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String){
        retrofitClient.apiInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<userResponse>{
                override fun onResponse(
                    call: Call<userResponse>,
                    response: Response<userResponse>
                ) {
                    if (response.isSuccessful){
                        listUser.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<userResponse>, t: Throwable) {
                    Log.d("Failure", t.message?.toString() ?: "Unknown error")
                }

            })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUser
    }
}