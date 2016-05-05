package com.example.hoangdang.firstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private EditText input;         //This is the input box to get user's input
        private TextView binResult;     //This is the binary conversion result box
        private TextView hexResult;     //This is the hexadecimal conversion result box
        private TextView octaResult;    //This is the octaldecimal conversion result box
        private Button button;          //This is the convert button.

    //At onCreate find all view and put them into class variable.
    //Method used (ViewType)findViewByID(location)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //NOTE**: it is recommended that the private variable is the same name
        //as the id we set for the view.
        button = (Button)findViewById(R.id.button);             //Find button view
        input = (EditText)findViewById(R.id.decInput);          //Find user input box view
        binResult = (TextView) findViewById(R.id.binResult);    //Find binary result text field view
        hexResult = (TextView) findViewById(R.id.hexResult);    //Find hexadecimal result text field view
        octaResult = (TextView) findViewById(R.id.octaResult);  //Find octaldecimal result text field view
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /*
        onResume we get the input and process the input by calling method from the BinaryProcess class.
     */
    @Override
    protected void onResume() {
        super.onResume();

        //Make a listen event and listen to process when the user click submit button.
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        //get input from user. Input is in EditedText type so we convert it to string.
                        int inp = Integer.parseInt(input.getText().toString());

                        BinaryProcess bin = new BinaryProcess(inp);     //new instance of BinaryProcess class
                        String binaryResult = bin.convertBin();         //convert to binary
                        String hexadecimalResult = bin.convertHex();    //convert to hexadecimal
                        String octadecimalResult = bin.convertOcta();   //convert to octaldecimal

                        //Set three result text field calculated result.
                        binResult.setText(binaryResult);
                        hexResult.setText(hexadecimalResult);
                        octaResult.setText(octadecimalResult);
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
