package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contactToAdd = (TextView) findViewById(R.id.contact_to_add);
        contactToAdd.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void call911(View view) {
        String phoneNumber = "911";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void openAllResources(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.ALL_RESOURCES);
        startActivity(intent);
    }

    public void openChildAbuse(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.CHILD_ABUSE);
        startActivity(intent);
    }

    public void openBullying(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.BULLYING);
        startActivity(intent);
    }

    public void openDomesticViolence(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.DOMESTIC_VIOLENCE);
        startActivity(intent);
    }
}
