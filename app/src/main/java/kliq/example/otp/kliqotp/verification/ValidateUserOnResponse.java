package kliq.example.otp.kliqotp.verification;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface ValidateUserOnResponse {
    void onValidateSucess(JSONObject response);

    void onValidateError(VolleyError error);
}
