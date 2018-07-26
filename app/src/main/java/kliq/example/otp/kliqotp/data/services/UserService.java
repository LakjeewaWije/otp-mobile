package kliq.example.otp.kliqotp.data.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import kliq.example.otp.kliqotp.register.RecievePinOnResponse;
import kliq.example.otp.kliqotp.util.Constant;
import kliq.example.otp.kliqotp.util.RequestHandler;
import kliq.example.otp.kliqotp.util.SharedPrefManager;
import kliq.example.otp.kliqotp.verification.ValidateUserOnResponse;

public class UserService {
    SharedPrefManager sharedPref;
    String s;

    public void recievePin(JSONObject jsonobj, final RecievePinOnResponse recievePinOnResponse) throws JSONException {
        s = Constant.User.RECIEVE_OTP_URL;
        JsonObjectRequest loginUserRequest = new JsonObjectRequest(Request.Method.POST, s, jsonobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                recievePinOnResponse.onRecieveSucess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                recievePinOnResponse.onRecieveError(error);
            }
        });

        RequestHandler.getInstance((Context) recievePinOnResponse).addToRequestQueue(loginUserRequest);

    }

    public void validateUser(JSONObject jsonobj, final ValidateUserOnResponse validateUserOnResponse) throws JSONException {
        s = Constant.User.VALIDATE_URL;
        JsonObjectRequest loginUserRequest = new JsonObjectRequest(Request.Method.POST, s, jsonobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                validateUserOnResponse.onValidateSucess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                validateUserOnResponse.onValidateError(error);
            }
        });

        RequestHandler.getInstance((Context) validateUserOnResponse).addToRequestQueue(loginUserRequest);

    }
}
