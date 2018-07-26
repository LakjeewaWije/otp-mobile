package kliq.example.otp.kliqotp.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {
    String number = "+94778079883";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle pudsBundle = intent.getExtras();
        Object[] pdus = (Object[]) pudsBundle.get("pdus");
        SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[0]);

//        if (messages.getOriginatingAddress().equals("+94778079883")){
            Intent i = new Intent("broadCastName");
            i.putExtra("message", messages.getMessageBody());

            context.sendBroadcast(i);
//        }


    }


}
