// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.bilibilikotlin.mvp.presenter.app.video;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

public final class SummaryPresenter_Factory implements Factory<SummaryPresenter> {
  private final MembersInjector<SummaryPresenter> summaryPresenterMembersInjector;

  public SummaryPresenter_Factory(
      MembersInjector<SummaryPresenter> summaryPresenterMembersInjector) {
    assert summaryPresenterMembersInjector != null;
    this.summaryPresenterMembersInjector = summaryPresenterMembersInjector;
  }

  @Override
  public SummaryPresenter get() {
    return MembersInjectors.injectMembers(summaryPresenterMembersInjector, new SummaryPresenter());
  }

  public static Factory<SummaryPresenter> create(
      MembersInjector<SummaryPresenter> summaryPresenterMembersInjector) {
    return new SummaryPresenter_Factory(summaryPresenterMembersInjector);
  }
}