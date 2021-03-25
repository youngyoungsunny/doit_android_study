package org.techtown.diary;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import lib.kingja.switchbutton.SwitchMultiButton;

public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    NoteAdapter adapter;

    Context context;
    TabLayout.OnTabSelectedListener listener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.context = context;

        if(context instanceof TabLayout.OnTabSelectedListener){
            listener = (TabLayout.OnTabSelectedListener)context;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();

        if(context != null){
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView){

        Button todayWriteButton = rootView.findViewById(R.id.todayWriteButton);
        todayWriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(listener != null){
                   // listener.onTabSelected(1);
                }
            }
        });

        SwitchMultiButton switchButton = rootView.findViewById(R.id.switchButton);
        switchButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(getContext(), tabText, Toast.LENGTH_SHORT).show();

                adapter.switchLayout(position);

                adapter.notifyDataSetChanged();
            }
        });

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new NoteAdapter();

        adapter.addItem(new Note(0, "0", "강남구 삼성동", "", "","오늘 너무 행복해!", "0", "capture1.jpg", "2월 10일"));
        adapter.addItem(new Note(1, "1", "강남구 삼성동", "", "","친구와 재미있게 놀았어", "0", "capture1.jpg", "2월 11일"));
        adapter.addItem(new Note(2, "0", "강남구 역삼동", "", "","집에 왔는데 너무 피곤해 ㅠㅠ", "0", null, "2월 13일"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnNoteItemClickListener() {
            @Override
            public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position) {
                Note item = adapter.getItem(position);

                Toast.makeText(getContext(), "아이템 선택됨 : " + item.getContents(), Toast.LENGTH_LONG).show();
            }
        });

    }


}