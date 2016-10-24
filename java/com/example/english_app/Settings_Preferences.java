package com.example.english_app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;



/**
 * Created by Администратор on 16.03.2016.
 */
public class Settings_Preferences extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content , new Fragment_Preference()).commit();
    }


    public static class Fragment_Preference extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
        }
    }


}
