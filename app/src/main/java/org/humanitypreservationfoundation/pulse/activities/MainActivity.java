/*
        Copyright 2018 The Humanity Preservation Foundation

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.humanitypreservationfoundation.pulse.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.content.res.AppCompatResources;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); //needed so that vector drawables can be used in backgrounds
        setContentView(R.layout.activity_main);

        TextView contactToAdd = (TextView) findViewById(R.id.contact_to_add);
        contactToAdd.setMovementMethod(LinkMovementMethod.getInstance());

        setCategoryButtonHeight(R.id.all_resources);
        setCategoryButtonHeight(R.id.child_abuse);
        setCategoryButtonHeight(R.id.bullying);
        setCategoryButtonHeight(R.id.domestic_violence);

        setCategoryButtonBackground(R.id.all_resources);
        setCategoryButtonBackground(R.id.child_abuse);
        setCategoryButtonBackground(R.id.bullying);
        setCategoryButtonBackground(R.id.domestic_violence);

    }

    /**
     * Sets the category button's background. Needed in order to set vector drawable as
     * background for API 20 and below
     */
    private void setCategoryButtonBackground(int id) {
        TextView categoryButton = (TextView) findViewById(id);
        categoryButton.setBackground(AppCompatResources.getDrawable(this, R.drawable.ic_blue_button_caret_right));

    }

    /**
     * Sets the category buttons height to a percent of the device's height
     */
    private void setCategoryButtonHeight(int id) {
        TextView categoryButton = (TextView) findViewById(id);
        ViewGroup.LayoutParams params = categoryButton.getLayoutParams();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int deviceHeight = displayMetrics.heightPixels;
        double buttonHeight;

        TypedValue decimal = new TypedValue();
        this.getResources().getValue(R.dimen.main_button_height_decimal, decimal, true);

        buttonHeight = deviceHeight * decimal.getFloat();
        params.height = (int) buttonHeight;
        categoryButton.setLayoutParams(params);
    }

    /**
     * Open's user's phone client with 911 populated
     */
    public void call911(View view) {
        String phoneNumber = "911";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    /**
     * Opens the MapActivity for All Resources
     */
    public void openAllResources(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.ALL_RESOURCES);
        startActivity(intent);
    }

    /**
     * Opens the MapActivity for Child Abuse category
     */
    public void openChildAbuse(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.CHILD_ABUSE);
        startActivity(intent);
    }

    /**
     * Opens the MapActivity for Bullying category
     */
    public void openBullying(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.BULLYING);
        startActivity(intent);
    }

    /**
     * Opens the MapActivity for Domestic Violence category
     */
    public void openDomesticViolence(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(Config.intents.ACTIVITY_EXTRA, Config.categories.DOMESTIC_VIOLENCE);
        startActivity(intent);
    }
}
