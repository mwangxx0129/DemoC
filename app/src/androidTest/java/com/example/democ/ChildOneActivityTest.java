package com.example.democ;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ChildOneActivityTest {

    private Context context;

    @Before
    public void setUp() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // Clear SharedPreferences before each test
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyAppSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    @Test
    public void saveDataToSharedPreferences() {
        try (ActivityScenario<ChildOneActivity> scenario = ActivityScenario.launch(ChildOneActivity.class)) {
            // Simulate user input
            onView(withId(R.id.inputOne)).perform(typeText("Test Input One"));
            onView(withId(R.id.inputTwo)).perform(typeText("Test Input Two"));
            Espresso.closeSoftKeyboard(); // Close the keyboard

            // Click on the save button
            onView(withId(R.id.saveButton)).perform(click());

            // Validate data saved in SharedPreferences
            SharedPreferences sharedPreferences = context.getSharedPreferences("MyAppSharedPreferences", Context.MODE_PRIVATE);
            String textOne = sharedPreferences.getString("textOne", null);
            String textTwo = sharedPreferences.getString("textTwo", null);

            assertEquals("Test Input One", textOne);
            assertEquals("Test Input Two", textTwo);
        }
    }
}