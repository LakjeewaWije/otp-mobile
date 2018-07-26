package kliq.example.otp.kliqotp.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static kliq.example.otp.kliqotp.util.SharedPrefManager mInstance;
    private static Context mctx;

    private static final String SHARED_PREF_NAME = "sharedPref";
    private static final String KEY_MOBNUMBER = "mobNumber";
    private static final String KEY_AUTH_TOKEN = "authToken";



    private SharedPrefManager(Context mCtx) {
        this.mctx = mCtx;
    }

    public static synchronized kliq.example.otp.kliqotp.util.SharedPrefManager getmInstance(Context context) {
        if(mInstance == null) {
            mInstance = new kliq.example.otp.kliqotp.util.SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userRegister(String mobnumber, String authToken) {

        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_MOBNUMBER, mobnumber);
        editor.putString(KEY_AUTH_TOKEN, authToken);
        editor.apply();

        return true;
    }

    public Boolean retrieveTok(){
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String auth = sharedPreferences.getString(KEY_AUTH_TOKEN,"");
        if(auth.equals("") || auth ==null){
            return true;
        }
        else{
            return false;
            }
    }
    public String retrieveTokAsString(){
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String auth = sharedPreferences.getString(KEY_AUTH_TOKEN,"");
        return auth;
    }


}
