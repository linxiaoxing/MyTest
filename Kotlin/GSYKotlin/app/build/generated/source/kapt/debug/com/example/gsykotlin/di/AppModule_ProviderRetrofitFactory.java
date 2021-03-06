// Generated by Dagger (https://dagger.dev).
package com.example.gsykotlin.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProviderRetrofitFactory implements Factory<Retrofit> {
  private final AppModule module;

  public AppModule_ProviderRetrofitFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return providerRetrofit(module);
  }

  public static AppModule_ProviderRetrofitFactory create(AppModule module) {
    return new AppModule_ProviderRetrofitFactory(module);
  }

  public static Retrofit providerRetrofit(AppModule instance) {
    return Preconditions.checkNotNull(instance.providerRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
