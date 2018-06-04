package test.udit.otp_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText mFees;
    private EditText mEmail ;
    private Button mButton ;
    private EditText mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.edittext_name);                    //Name of the person registering or paying the amount
        mFees = (EditText) findViewById(R.id.edittext_fees);                    //Amount to be paid
        mEmail = (EditText) findViewById(R.id.edittext_email);                  //Email if the comitte member(The person who is receiving the amount)
        mButton = (Button) findViewById(R.id.pay_button);                       //Button to sejd the mail

        mButton.setEnabled(false);                                              // =BY default turned off

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("TAG:","Inside button");

                checkFields();

                LongOperation l = new LongOperation(mEmail.getText().toString(), mFees.getText().toString(), mName.getText().toString());   //Constructor call to the class
                l.execute();  //sends the email in background
                Toast.makeText(getBaseContext(), "Completed successfully !!!", Toast.LENGTH_SHORT).show();


            }
        });

        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mFees.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void checkFields() {
        if(mEmail.getText().toString().isEmpty() || mFees.getText().toString().isEmpty() || mName.getText().toString().isEmpty()){
            mButton.setEnabled(false);
            //Toast.makeText(getBaseContext(), "Please fill all the fields before proceeding", Toast.LENGTH_LONG).show();
        }
        else{
            mButton.setEnabled(true);
        }
    }                                          //Fucntion to check the fields
}
