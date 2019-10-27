// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.bilibilikotlin.di.module;

import com.example.bilibilikotlin.network.api.AppService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ApiModule_ProvideAppServiceFactory implements Factory<AppService> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideAppServiceFactory(ApiModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public AppService get() {
    return Preconditions.checkNotNull(
        module.provideAppService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AppService> create(ApiModule module, Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideAppServiceFactory(module, retrofitProvider);
  }
}