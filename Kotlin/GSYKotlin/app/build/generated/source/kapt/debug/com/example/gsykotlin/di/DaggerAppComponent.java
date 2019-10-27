// Generated by Dagger (https://dagger.dev).
package com.example.gsykotlin.di;

import android.app.Activity;
import android.app.Application;
import com.example.gsykotlin.GSYGithubApplication;
import com.example.gsykotlin.GSYGithubApplication_MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.Preconditions;
import java.util.Collections;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private DaggerAppComponent(Application application) {

  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newInstance(Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>emptyMap(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @Override
  public void inject(GSYGithubApplication gsyGithubApplication) {
    injectGSYGithubApplication(gsyGithubApplication);}

  private GSYGithubApplication injectGSYGithubApplication(GSYGithubApplication instance) {
    GSYGithubApplication_MembersInjector.injectDispatchingAndroidInjector(instance, getDispatchingAndroidInjectorOfActivity());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerAppComponent(application);
    }
  }
}