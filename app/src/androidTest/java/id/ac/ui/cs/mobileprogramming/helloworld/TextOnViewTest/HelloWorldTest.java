package id.ac.ui.cs.mobileprogramming.helloworld.TextOnViewTest;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;


import org.junit.Rule;

import org.junit.Test;
import org.junit.runner.RunWith;
import id.ac.ui.cs.mobileprogramming.helloworld.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
//comment



@RunWith(AndroidJUnit4.class)
@MediumTest
public class HelloWorldTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void textHelloWorldTest(){

        onView(withText("Hello World!")).check(matches(isDisplayed()));

    }


}
