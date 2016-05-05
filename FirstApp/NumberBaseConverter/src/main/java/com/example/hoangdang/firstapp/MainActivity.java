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
        private EditText input;
        private TextView binResult;
        private TextView hexResult;
        private TextView octaResult;
        private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button)findViewById(R.id.button);
        input = (EditText)findViewById(R.id.decInput);
        binResult = (TextView) findViewById(R.id.binResult);
        hexResult = (TextView) findViewById(R.id.hexResult);
        octaResult = (TextView) findViewById(R.id.octaResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        int inp = Integer.parseInt(input.getText().toString());
                        BinaryProcess bin = new BinaryProcess(inp);
                        String binaryResult = bin.convertBin();
                        String hexadecimalResult = bin.convertHex();
                        String octadecimalResult = bin.convertOcta();

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
