package kliq.example.otp.kliqotp.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import kliq.example.otp.kliqotp.R;
import kliq.example.otp.kliqotp.data.model.User;
import kliq.example.otp.kliqotp.data.services.UserService;
import kliq.example.otp.kliqotp.util.SharedPrefManager;
import kliq.example.otp.kliqotp.verification.VerifyActivity;

public class MainActivity extends AppCompatActivity implements RecievePinOnResponse {
    ImageView wisenetlogo;
    User user;
    SharedPreferences sharedPreferences;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wisenetlogo = (ImageView) findViewById(R.id.wisenetlogo);

        wisenetlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    recievePin();
                }catch (Exception e){

                }
            }
        });
    }

    public void recievePin() throws JSONException {

                JSONObject registerUserRequestBody = new JSONObject();
                registerUserRequestBody.put("mobileNo","+94713713221");

                UserService userService = new UserService();
                userService.recievePin(registerUserRequestBody,this);


    }

    @Override
    public void onRecieveSucess(JSONObject response) {
        try {


            //Retrieving the o JSON object data to few variables
            String authToken = response.getString("data"); // current User Auth Token

//            user = new User(authToken); // current user initialised
            // saving values in shared preferences0


            sharedPrefManager = SharedPrefManager.getmInstance(getApplicationContext());

            if(sharedPrefManager.userRegister(authToken)) {//save string in shared preference.
                Intent intent = new Intent(MainActivity.this, VerifyActivity.class);
                startActivity(intent);
                finish();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }  catch (Resources.NotFoundException e){
            e.printStackTrace();
        }   catch (NullPointerException e){
            e.getMessage();
        }
    }

    @Override
    public void onRecieveError(VolleyError error) {
        Toast.makeText(MainActivity.this, "Please Check The Credentials Before Entering", Toast.LENGTH_SHORT).show();
    }
}
