package org.humanitypreservationfoundation.pulse.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contactToAdd = (TextView) findViewById(R.id.contact_to_add);
        contactToAdd.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
