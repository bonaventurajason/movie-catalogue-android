package com.bonaventurajason.moviecatalogue.di

import com.bonaventurajason.moviecatalogue.BuildConfig
import com.bonaventurajason.moviecatalogue.data.source.FilmDataSource
import com.bonaventurajason.moviecatalogue.data.source.FilmRepository
import com.bonaventurajason.moviecatalogue.data.source.remote.api.FilmApi
import com.bonaventurajason.moviecatalogue.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFilmRepository(
        api: FilmApi
    ) = FilmRepository(api) as FilmDataSource


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideFilmApi(retrofit: Retrofit): FilmApi =
        retrofit.create(FilmApi::class.java)


    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


}