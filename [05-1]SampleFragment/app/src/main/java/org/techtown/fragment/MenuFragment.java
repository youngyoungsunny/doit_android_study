package org.techtown.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
    //onCreateView()메서드의 파라미터로 LayoutInflater 객체가 전달되므로, 이 객체의 inflate()메서드를 바로 호출할 수 있음.
    //inflate()메서드로 전달되는 첫번째 파라미터 : XML레이아웃 파일 --> 그래서 여기서는 R.layout.fragment_main이 입력되어있음.
    //두번째 파라미터:이 XML레이아웃이 설정될 뷰그룹 객체가 되는데, onCreateView()메서드로 전달되는 두번째 파라미터가 이 프래그먼트의 가장 상위 레이아웃임. 따라서 container객체를 전달하면 됨.

    //결과 : ViewGrouo 객체가 반환됨.


    /*
    * 이 프래그먼트를 메인 액티비티에 추가하는 방법 2가지
    * 1. 메인액티비티의 XML레이아웃에 태그로 추가하는 방법
    * 2. 메인 액티비티의 소스 코드에서 추가하는 방법
    * */

}
