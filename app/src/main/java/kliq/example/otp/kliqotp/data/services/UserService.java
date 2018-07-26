package kliq.example.otp.kliqotp.data.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import kliq.example.otp.kliqotp.util.RequestHandler;
import kliq.example.otp.kliqotp.util.SharedPrefManager;

public class UserService {
    SharedPrefManager sharedPref;
    String s;

//    public void loginUser(JSONObject jsonobj, final LoginOnResponse loginOnResponse) throws JSONException {
//        s = Constant.User.LOGIN_URL;
//        JsonObjectRequest loginUserRequest = new JsonObjectRequest(Request.Method.POST, s, jsonobj, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                loginOnResponse.onLoginSucess(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                loginOnResponse.onLoginError(error);
//            }
//        });
//
//        RequestHandler.getInstance((Context) loginOnResponse).addToRequestQueue(loginUserRequest);
//
//    }
}
