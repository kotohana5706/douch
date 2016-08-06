package com.ajk.douch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

/**
 * Created by ahnju on 2016-08-06.
 */
public class MainViewFragments extends Fragment {

    private ObservableScrollView mScrollView;

    public static MainViewFragments newInstance(){
        return new MainViewFragments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstance){
        super.onViewCreated(view, savedInstance);
        mScrollView = (ObservableScrollView) view.findViewById(R.id.MainScroll);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }

}
