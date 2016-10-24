package com.example.english_app.FragmentTabsPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.english_app.R;

/**
 * Created by Администратор on 06.03.2016.
 */
public class FragmentWorldmap extends Fragment
{

    public FragmentWorldmap ()
    {

    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate (R.layout.fragmentworldmap, container, false);
    }

}