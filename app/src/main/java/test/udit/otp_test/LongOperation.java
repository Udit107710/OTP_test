package test.udit.otp_test;


import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;


public class LongOperation extends AsyncTask<Void, Void, String> {

    private String email;
    private String fees;
    private String name;
    private String otp;
    private final static String ACM_EMAIL = "@gmail.com";               //ACM's gmail address
    private final static String ACM_PASSWORD = "";                      //ACM's gmsil sccount'd password

    public LongOperation(String email, String fees, String name) {
        this.email = email;                                             //Recipient's email address
        this.fees = fees;                                               //AMount to be paid
        this.name = name;                                               //Name of the person registering or paying the amount
    }

    @Override
    protected String doInBackground(Void... params) {


        try {

            GMailSender sender = new GMailSender(ACM_EMAIL, ACM_PASSWORD);          //Constructor call to LogIn
            sender.sendMail("This is a testing mail",bodyMail(),ACM_EMAIL,   //Include Subject, body, Sender's gmail and recipient's email
                    email);

        } catch (Exception e) {
            Log.d("error", e.getMessage(), e);
            return "Email Not Sent";
        }
        return "Email Sent";
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("LongOperation",result+"");
    }


    @Override
    protected void onPreExecute() {
    }


    @Override
    protected void onProgressUpdate(Void... values) {
    }

    private String bodyMail(){
        Random random = new Random();
        otp = String.valueOf(random.nextLong());
        otp += email.charAt(3) + email.charAt(0) + fees.length();

        String body = name + "wants to pay you" + fees + ". The OTP is: " + otp;
        return body;
    }                                               //Body of the mail

}