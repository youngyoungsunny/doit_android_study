package org.techtown.doitmission_10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Fragment_main extends Fragment {
    ViewPager pager;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    MyPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main,container, false);

        pager = rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        adapter = new MyPagerAdapter(getFragmentManager());

        fragment1 = new Fragment1();
        adapter.addItem(fragment1);

        fragment2 = new Fragment2();
        adapter.addItem(fragment2);

        fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);

        return rootView;
    }
    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int position){ //position 위치에 있는 프래그먼트 반환
            return items.get(position);
        }

        @Override
        public int getCount(){ //프래그먼트 갯수
            return items.size();
        }
    }
}
