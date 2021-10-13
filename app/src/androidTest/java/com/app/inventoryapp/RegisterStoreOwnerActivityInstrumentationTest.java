package com.app.inventoryapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.app.inventoryapp.ui.RegisterStoreOwnerActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterStoreOwnerActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<RegisterStoreOwnerActivity> activityRule =
            new ActivityScenarioRule<>(RegisterStoreOwnerActivity.class);

    @Test
    public void validateEditText_Name() {
        onView(withId(R.id.nameEditText)).perform(typeText("john"))
                .check(matches(withText("john")));
    }

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

    @Test
    public void validateEditText_PasswordConfirm() {
        onView(withId(R.id.confirmPasswordEditText)).perform(typeText("123456"))
                .check(matches(withText("123456")));
    }
}
