package kliq.example.otp.kliqotp.data.model;

import java.security.PublicKey;

public class User {

    private long mobileNumber;
    private String authToken;

    public User(long mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public User(String authToken){
        this.authToken = authToken;
    }
}
