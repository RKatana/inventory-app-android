package com.app.inventoryapp;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import static org.junit.Assert.assertTrue;

import com.app.inventoryapp.ui.AttendantLoginActivity;
import com.app.inventoryapp.ui.OwnerLoginActivity;
import com.app.inventoryapp.ui.SelectAccountActivity;

//This configures your android to ignore the api version.
@Config(sdk = {Build.VERSION_CODES.O_MR1})

@RunWith(RobolectricTestRunner.class)
public class SelectAccountActivityTest {

    private SelectAccountActivity activity;
    
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(SelectAccountActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent(){
        TextView textSelectAccountTextView = activity.findViewById(R.id.textSelectAccountTextView);
        assertTrue("Select Account".equals(textSelectAccountTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.btnStoreAttendant).performClick();
        Intent expectedIntent = new Intent(activity, AttendantLoginActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void thirdActivityStarted(){
        activity.findViewById(R.id.btnStoreOwner).performClick();
        Intent expectedIntent = new Intent(activity, OwnerLoginActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}