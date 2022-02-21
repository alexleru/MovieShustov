package ru.alexleru.movieshustov.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alexleru.movieshustov.pojo.Popular

interface ApiService {
    //https://api.themoviedb.org/3/movie/popular?api_key=1de610c5c425b261e33f4cb279a870c5&language=en-US&page=1
    @GET("movie/popular")
    fun getPopularMovie(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE,
        @Query(QUERY_PARAM_PAGE) page: Int = 1
    ): Single<Popular>

    //https://api.themoviedb.org/3/search/movie?api_key=1de610c5c425b261e33f4cb279a870c5&language=en-US&query=s&page=2&include_adult=false
    @GET("search/movie")
    fun getSearchMovie(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE,
        @Query(QUERY_PARAM_SEARCH) search: String,
        @Query(QUERY_PARAM_PAGE) page: Int = 1,
        @Query(QUERY_PARAM_IS_ADULT) isAdult: String = "false"
    ): Single<Popular>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LANGUAGE = "language"
        private const val QUERY_PARAM_PAGE = "page"
        private const val QUERY_PARAM_SEARCH = "query"
        private const val QUERY_PARAM_IS_ADULT = "include_adult"

        private const val API = "1de610c5c425b261e33f4cb279a870c5"
        private const val LANGUAGE = "ru"
    }
}