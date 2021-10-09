package com.app.inventoryapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.app.inventoryapp.ui.AddStoreActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddStoreActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<AddStoreActivity> activityRule =
            new ActivityScenarioRule<>(AddStoreActivity.class);

    @Test
    public void validateEditText_ShopName() {
        onView(withId(R.id.shopNameEditText)).perform(typeText("john gen shop"))
                .check(matches(withText("john gen shop")));
    }

    @Test
    public void validateEditText_Location() {
        onView(withId(R.id.locationEditText)).perform(typeText("Maralal"))
                .check(matches(withText("Maralal")));
    }
}
