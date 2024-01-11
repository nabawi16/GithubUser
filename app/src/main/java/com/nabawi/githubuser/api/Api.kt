package com.nabawi.githubuser.api

import com.nabawi.githubuser.data.model.DetailUserResponse
import com.nabawi.githubuser.data.model.User
import com.nabawi.githubuser.data.model.userResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<userResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}