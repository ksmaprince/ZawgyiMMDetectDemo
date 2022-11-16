package com.kbzbank.mmfont;

import android.content.Context;
import android.content.SharedPreferences;

public class KbzMMFontCheckSP {

    // Shared Preferences
    public static SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static Context mContext;
    // Shared pref mode
    int PRIVATE_MODE = 1;
    // Shared preferences file name
    private static final String PREF_NAME = "iKBZ_Mobile2";

    private static final String KEY_CHOOSE_NOTUNI ="KEY_UNISUPPORT";


    public KbzMMFontCheckSP(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }



    public void setPreferMMSupportUni(String notUni){
        editor.putString(KEY_CHOOSE_NOTUNI,notUni).commit();
    }

    public void removeStatus(){
        editor.remove(KEY_CHOOSE_NOTUNI).commit();
    }

    public static String getMMSupportUni(){
        return pref.getString(KEY_CHOOSE_NOTUNI,"");
    }
}
