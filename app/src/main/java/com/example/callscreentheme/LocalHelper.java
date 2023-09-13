package com.example.callscreentheme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import com.bumptech.glide.load.engine.Resource;
import com.example.callscreentheme.Fragment.Fragment1;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class LocalHelper {

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    public static  Context setlocale(Context context, String language){

        persist(context,language);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
            return updateResources(context,language);
        }

        return updateResources(context,language);
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static void persist(Context context, String language) {
        SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = Preferences.edit();
        editor.putString(SELECTED_LANGUAGE,language);
        editor.apply();
    }
    private static Context updateResourcesLegacy(Context context,String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }

        resources.updateConfiguration(configuration , resources.getDisplayMetrics());
        return context;
    }

    @NotNull
    public static Context setLocale(@NotNull Object any, @NotNull String s) {
        return null;
    }
}
