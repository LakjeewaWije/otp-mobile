package kliq.example.otp.kliqotp.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kliq.example.otp.kliqotp.R;
import kliq.example.otp.kliqotp.verification.Verify;

public class MainActivity extends AppCompatActivity {
    ImageView wisenetlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wisenetlogo = (ImageView) findViewById(R.id.wisenetlogo);

        wisenetlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Verify.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
