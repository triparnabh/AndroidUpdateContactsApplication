package com.example.updatecontact;

import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

import static android.R.attr.data;
import static android.content.Intent.ACTION_INSERT;
import static com.example.updatecontact.R.id.button;
import static com.example.updatecontact.R.id.text;
import static com.example.updatecontact.R.id.textView2;


public class SecondActivity extends Activity {

    private String ContactName;
    final Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Button button = (Button) findViewById(R.id.button2);
        final EditText NAME = (EditText) findViewById(R.id.editText);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView Text = (TextView) findViewById(R.id.textView2);// for displaying error and success messages
                ContactName = NAME.getText().toString();
                //non-empty implementation. User cannot proceed without entering a name.
                if (ContactName.matches("")) {
                    Text.setText("Please enter Name");
                    return;
                    //checking for both first and last name
                } else if (ContactName.matches ("[a-zA-Z0-9]+\\s++")) {
                    Text.setText("Please enter both First and Last Name");
                    return;
                    //for checking there is space between first and last name
                } else if (ContactName.matches("[a-zA-Z0-9]+"+"[a-zA-Z0-9]+")) {
                    Text.setText("Please enter space between First and Last Name");
                     return;
                }
                else if(ContactName.matches(("[a-zA-Z0-9]+"+" "+"[a-zA-Z0-9]+")))
                {
                    intent.setAction(ACTION_INSERT);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, ContactName);
                    intent.putExtra("finishActivityOnSaveCompleted", true);
                    startActivityForResult(intent, 1); // 1 is the original code identifying the call

                }
            }
        });
    }
            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                TextView Text = (TextView) findViewById(R.id.textView2);
                if (requestCode == 1 && resultCode == RESULT_OK) { //requestCode == 1  is the original code identifying the call
                        Text.setText("Contact added");
                    }
                    else if (requestCode == 1 && resultCode == RESULT_CANCELED) { // when back button is pressed
                        Text.setText("Contact could not be added");


                    }


                }
            }

