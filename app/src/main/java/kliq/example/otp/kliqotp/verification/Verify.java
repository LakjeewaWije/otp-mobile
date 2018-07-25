package kliq.example.otp.kliqotp.verification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import kliq.example.otp.kliqotp.R;
import kliq.example.otp.kliqotp.reciever.SmsReceiver;

public class Verify extends AppCompatActivity {
    public TextView digitOne;
    public TextView digitTwo;
    public TextView digitThree;
    public TextView digitFour;
    public static String messageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        digitOne = (TextView) findViewById(R.id.digitone);
        digitTwo = (TextView) findViewById(R.id.digittwo);
        digitThree = (TextView) findViewById(R.id.digithree);
        digitFour = (TextView) findViewById(R.id.digitfour);
        registerReceiver(broadcastReceiver, new IntentFilter("broadCastName"));
        Intent serviceIntent = new Intent(this, SmsReceiver.class);
        startService(serviceIntent);
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
            }else {

            }
        }
    };
}
