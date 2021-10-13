package com.app.inventoryapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.app.inventoryapp.ui.AttendantLoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AttendantLoginActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<AttendantLoginActivity> activityRule =
            new ActivityScenarioRule<>(AttendantLoginActivity.class);

    @Test
    public void validateEditText_Email() {
        onView(withId(R.id.emailEditText)).perform(typeText("john@gmail.com"))
                .check(matches(withText("john@gmail.com")));
    }

    @Test
    public void validateEditText_Password() {
        onView(withId(R.id.passwordEditText)).perform(typeText("123456"))
                .check(matches(withText("123456")));
    }
}
