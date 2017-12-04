

package com.example.minu.movieapp.dragger;

import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  private static final String NAME_BASE_URL = "NAME_BASE_URL";

  @Provides
  @Named(NAME_BASE_URL)
  String provideBaseUrlString() {
    return ApiList.BASE_URL;
  }

  @Provides
  @Singleton
  Converter.Factory provideGsonConverter() {
    return GsonConverterFactory.create();
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(converter)
        .build();
  }

  @Provides
  @Singleton
  ApiInterface provideUsdaApi(Retrofit retrofit) {
    return retrofit.create(ApiInterface.class);
  }
}
