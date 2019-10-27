package com.example.musicplayersam.viewmodel;

import java.lang.System;

/**
 * view model for MusicController
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/example/musicplayersam/viewmodel/MusicControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "pauseOrPlay", "", "playNext", "playPrevious", "quiet", "app_debug"})
public final class MusicControllerViewModel extends androidx.lifecycle.ViewModel {
    
    /**
     * pause if playing
     * play if not playing
     *
     * @see tech.soit.quiet.player.QuietMusicPlayer.playPause
     */
    public final void pauseOrPlay() {
    }
    
    /**
     * @see tech.soit.quiet.player.QuietMusicPlayer.playPrevious
     */
    public final void playPrevious() {
    }
    
    /**
     * @see tech.soit.quiet.player.QuietMusicPlayer.playNext
     */
    public final void playNext() {
    }
    
    /**
     * @see tech.soit.quiet.player.QuietMusicPlayer.quiet
     */
    public final void quiet() {
    }
    
    public MusicControllerViewModel() {
        super();
    }
}