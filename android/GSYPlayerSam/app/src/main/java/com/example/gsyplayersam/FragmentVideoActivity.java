package com.example.gsyplayersam;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.gsyplayersam.fragment.VideoFragment;

public class FragmentVideoActivity extends AppCompatActivity{
    VideoFragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow( ).requestFeature( Window.FEATURE_CONTENT_TRANSITIONS );
            getWindow( ).setEnterTransition( new Explode( ) );
            getWindow( ).setExitTransition( new Explode( ) );
        }
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fragment );

        newFragment = new VideoFragment( );
        FragmentTransaction transaction = getSupportFragmentManager( ).beginTransaction( );
        transaction.replace( R.id.frameLayout, newFragment );
        transaction.addToBackStack( null );
        transaction.commit( );
    }

    @Override
    public void onBackPressed() {
        if (newFragment.onBackPressed( )) {
            return;
        }
        finish( );
    }
}
