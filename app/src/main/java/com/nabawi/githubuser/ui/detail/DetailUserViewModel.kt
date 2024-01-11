package com.nabawi.githubuser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabawi.githubuser.api.retrofitClient
import com.nabawi.githubuser.data.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel() {

    val user = MutableLiveData<DetailUserResponse>()

    fun setUserDetail(username: String){
        retrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserResponse>{
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    Log.e("DetailUserViewModel", "Network request failure: ${t.message}", t)
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUserResponse>{
        return user
    }
}