package com.example.yousafkhan.maktabajibreel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LocalManager {

    private static final String SHARED_PREF_FILE_NAME = "current_app_language_db";
    private static final String KEY_CURRENT_APP_LANGUAGE = "current_app_language";

    public static void saveAppLanguage(Context c, String language) {
        SharedPreferences prefs = c.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(KEY_CURRENT_APP_LANGUAGE, language);

        editor.apply();
    }

    public static String getAppLanguageFromSharedPrefs(Context c) {
        SharedPreferences prefs = c.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_CURRENT_APP_LANGUAGE, "en");
    }

    public static void loadLanguage(Context context, String languageToLoad) {
        Locale myLocale = new Locale(languageToLoad);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(myLocale);
        res.updateConfiguration(conf, dm);
    }
}
