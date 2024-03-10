package com.example.democ.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    private static final String PREFERENCES_FILE_KEY = "MyAppSharedPreferences";

    public static void saveStringData(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringData(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }
}

