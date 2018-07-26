package kliq.example.otp.kliqotp.verification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import kliq.example.otp.kliqotp.R;
import kliq.example.otp.kliqotp.data.services.UserService;
import kliq.example.otp.kliqotp.reciever.SmsReceiver;
import kliq.example.otp.kliqotp.register.MainActivity;
import kliq.example.otp.kliqotp.util.SharedPrefManager;

public class VerifyActivity extends AppCompatActivity implements ValidateUserOnResponse{
    public TextView digitOne;
    public TextView digitTwo;
    public TextView digitThree;
    public TextView digitFour;
    public static String messageText;
    public TextView resendCodeText;
    SharedPrefManager sharedPrefManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        digitOne = (TextView) findViewById(R.id.digitone);
        digitTwo = (TextView) findViewById(R.id.digittwo);
        digitThree = (TextView) findViewById(R.id.digithree);
        digitFour = (TextView) findViewById(R.id.digitfour);
        resendCodeText = (TextView) findViewById(R.id.resendCodeText);
        registerReceiver(broadcastReceiver, new IntentFilter("broadCastName"));
        Intent serviceIntent = new Intent(this, SmsReceiver.class);
        startService(serviceIntent);

        resendCodeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    MainActivity mainActivity = new MainActivity();
                    mainActivity.recievePin();
                }catch (Exception e){

                }

            }
        });
    }
    BroadcastReceiver broadcastReceiver =  new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle extras = intent.getExtras();

            //        Toast.makeText(this, "Waiting for message", Toast.LENGTH_LONG).show();
            messageText =  extras.getString("message");
            if (messageText != null) {
                Toast.makeText(context, "Message is  " +  messageText, Toast.LENGTH_LONG).show();
                String array[] = messageText.split("");
                digitOne.setText(array[1]);
                digitTwo.setText(array[2]);
                digitThree.setText(array[3]);
                digitFour.setText(array[4]);
                try {
                    validateUser();
                }catch (Exception e){

                }
            }else {

            }
        }
    };
    public void validateUser() throws JSONException {

        JSONObject registerUserRequestBody = new JSONObject();
        sharedPrefManager = SharedPrefManager.getmInstance((Context) this);
        String tokn = sharedPrefManager.retrieveTokAsString();
        registerUserRequestBody.put("token",tokn);
        registerUserRequestBody.put("OTP",messageText);
        UserService userService = new UserService();
        userService.validateUser(registerUserRequestBody,this);
    }

    @Override
    public void onValidateSucess(JSONObject response) {
        Toast.makeText(VerifyActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(VerifyActivity.this, MainActivity.class);
//        startActivity(intent);
//        finish();
    }

    @Override
    public void onValidateError(VolleyError error) {
        Toast.makeText(VerifyActivity.this, "Error, Please Try again", Toast.LENGTH_SHORT).show();
    }
}
