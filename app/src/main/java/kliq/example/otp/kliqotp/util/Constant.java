package kliq.example.otp.kliqotp.util;

public class Constant {

    public static final String BASE_URL  = "http://192.168.8.100:9000";


    public interface User {

        public  final String RECIEVE_OTP_URL = Constant.BASE_URL.concat("/message");

        public  final String VALIDATE_URL =  Constant.BASE_URL.concat("/verify");



    }

}
