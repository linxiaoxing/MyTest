// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.bilibilikotlin.module.app.video;

import com.example.bilibilikotlin.base.BaseInjectActivity;
import com.example.bilibilikotlin.mvp.presenter.app.video.VideoDetailPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VideoDetailActivity_MembersInjector
    implements MembersInjector<VideoDetailActivity> {
  private final Provider<VideoDetailPresenter> mPresenterProvider;

  public VideoDetailActivity_MembersInjector(Provider<VideoDetailPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<VideoDetailActivity> create(
      Provider<VideoDetailPresenter> mPresenterProvider) {
    return new VideoDetailActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(VideoDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseInjectActivity) instance).mPresenter = mPresenterProvider.get();
  }
}
