package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contactToAdd = (TextView) findViewById(R.id.contact_to_add);
        contactToAdd.setMovementMethod(LinkMovementMethod.getInstance());

        setCategoryButtonHeight(R.id.all_resources);
        setCategoryButtonHeight(R.id.child_abuse);
        setCategoryButtonHeight(R.id.bullying);
        setCategoryButtonHeight(R.id.domestic_violence);
    }

    private void setCategoryButtonHeight(int id) {
        TextView categoryButton = (TextView) findViewById(id);
        ViewGroup.LayoutParams params = categoryButton.getLayoutParams();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int deviceHeight = displayMetrics.heightPixels;
        double buttonHeight;
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        if (isTablet) {
            //todo implement for tablets
        } else {
            switch (Utils.getScreenDensity(this)) {
                case LDPI:
                case HDPI:
                case MDPI://todo make sure this is working after w200dp layout created
                    buttonHeight = deviceHeight * 0.05;
                    params.height = (int) buttonHeight;
                    categoryButton.setLayoutParams(params);
                    break;
                case XHDPI:
                    buttonHeight = deviceHeight * 0.07;
                    params.height = (int) buttonHeight;
                    categoryButton.setLayoutParams(params);
                    break;
                case XXHDPI:
                    buttonHeight = deviceHeight * 0.09;
                    params.height = (int) buttonHeight;
                    categoryButton.setLayoutParams(params);
                    break;
                case XXXHDPI:
                    buttonHeight = deviceHeight * 0.11;
                    params.height = (int) buttonHeight;
                    categoryButton.setLayoutParams(params);
                    break;
            }
        }
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
