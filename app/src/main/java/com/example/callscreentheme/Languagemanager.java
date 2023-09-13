package com.example.callscreentheme;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class Languagemanager {

    private Context ct;

    public Languagemanager(Context ctx){
        ct = ctx;
    }

    public void updateResources(String code){

        Locale loacale = new Locale(code);
        Locale.setDefault(loacale);
        Resources resources = ct.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = loacale;
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }
}
