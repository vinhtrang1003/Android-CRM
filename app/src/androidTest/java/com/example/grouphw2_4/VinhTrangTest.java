package com.example.grouphw2_4;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.example.grouphw2_4.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import java.lang.reflect.Type;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class VinhTrangTest{
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void chooseProduct() {
        //Click Account
        onView(withId(R.id.AccountButton)).perform(click());
        onView(withId(R.id.ListAccountButton)).perform(click());

        //Click on Vinh Account
        onView(withId(R.id.rvAnimals)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));

        //Click on List Product Button
        onView(withId(R.id.ListProductsButton)).perform(click());

        //Click on  PC-1
        onView(withId(R.id.rvAnimals)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));

        Espresso.onView(withId(R.id.tvProductName)).check(matches(withText("PC1")));
    }


}