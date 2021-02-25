package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ListFragment.ImageSelectionCallback {

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.KakaoTalk_20180912_130101707, R.drawable.summer, R.drawable.KakaoTalk_20180912_130101707};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment)manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment)manager.findFragmentById(R.id.viewerFragment);
    }

    @Override
    public void onImageSelected(int position){
        viewerFragment.setImage(images[position]);
    }
}
