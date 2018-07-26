package kliq.example.otp.kliqotp.register;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface RecievePinOnResponse {

    void onRecieveSucess(JSONObject response);

    void onRecieveError(VolleyError error);

}
