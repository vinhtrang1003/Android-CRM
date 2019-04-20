package com.example.grouphw2_4;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.example.grouphw2_4.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class TungNguyenTest{
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void chooseList() {
        Espresso.onView(withId(R.id.AccountButton)).perform(click());
        Espresso.onView(withId(R.id.CreateAccountButton)).perform(click());
        Espresso.onView(withId(R.id.newAccInfoButton)).perform(click());
        Espresso.onView(withId(R.id.ListAccountButton)).perform(click());

        Espresso.onView(withId(R.id.rvAnimals)).perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));

        Espresso.onView(withId(R.id.contactButton)).perform(click());
        Espresso.onView(withId(R.id.newContactButton)).perform(click());
        Espresso.onView(withId(R.id.contactCreateButton)).perform(click());
        Espresso.onView(withId(R.id.listContactButton)).perform(click());
        Espresso.onView(withId(R.id.rvContactList)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        Espresso.onView(withId(R.id.tvContactName)).check(matches(withText("Name")));

    }

    @Test
    public void file(){
        Espresso.onView(withId(R.id.fileButton)).perform(click());
        Espresso.onView(withId(R.id.saveButton)).perform(click());
        Espresso.onView(withId(R.id.loadButton)).perform(click());
    }


}