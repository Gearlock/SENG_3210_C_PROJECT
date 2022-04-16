package com.example.seng3210project;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class registerVoterTest {
    @Rule
    public ActivityTestRule mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void registerNewVoter() {
        //Voter info

        String voterFirstname = "Sam";
        String voterLastname = "Dom";
        String voterPassword = "password123";
        String voterAge = "26";

        onView(withId(R.id.registerVoter)).perform(click());
        ViewInteraction newVoterFirstnameEdit = onView(withId(R.id.voterFirstName));
        newVoterFirstnameEdit.perform(clearText(),typeText(voterFirstname),closeSoftKeyboard());
        ViewInteraction newVoterLastnameEdit = onView(withId(R.id.voterLastName));
        newVoterLastnameEdit.perform(clearText(),typeText(voterLastname),closeSoftKeyboard());
        ViewInteraction newVoterPasswordEdit = onView(withId(R.id.voterPassword));
        newVoterPasswordEdit.perform(clearText(),typeText(voterPassword),closeSoftKeyboard());
        ViewInteraction newVoterAgeEdit = onView(withId(R.id.voterAge));
        newVoterAgeEdit.perform(clearText(),typeText(voterAge),closeSoftKeyboard());
        onView(withId(R.id.registerVotertoDB)).perform(click());
    }
}
