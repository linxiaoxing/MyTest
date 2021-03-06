// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.bilibilikotlin.mvp.presenter.live;

import com.example.bilibilikotlin.network.helper.RetrofitHelper;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;

public final class LivePresenter_Factory implements Factory<LivePresenter> {
  private final MembersInjector<LivePresenter> livePresenterMembersInjector;

  private final Provider<RetrofitHelper> retrofitHelperProvider;

  public LivePresenter_Factory(
      MembersInjector<LivePresenter> livePresenterMembersInjector,
      Provider<RetrofitHelper> retrofitHelperProvider) {
    assert livePresenterMembersInjector != null;
    this.livePresenterMembersInjector = livePresenterMembersInjector;
    assert retrofitHelperProvider != null;
    this.retrofitHelperProvider = retrofitHelperProvider;
  }

  @Override
  public LivePresenter get() {
    return MembersInjectors.injectMembers(
        livePresenterMembersInjector, new LivePresenter(retrofitHelperProvider.get()));
  }

  public static Factory<LivePresenter> create(
      MembersInjector<LivePresenter> livePresenterMembersInjector,
      Provider<RetrofitHelper> retrofitHelperProvider) {
    return new LivePresenter_Factory(livePresenterMembersInjector, retrofitHelperProvider);
  }
}
