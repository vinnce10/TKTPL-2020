package id.ac.ui.cs.mobileprogramming.helloworld.TextOnViewTest;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import static androidx.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.containsString;



import org.junit.Rule;

import org.junit.Test;
import org.junit.runner.RunWith;
import id.ac.ui.cs.mobileprogramming.helloworld.MainActivity;
import id.ac.ui.cs.mobileprogramming.helloworld.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//comment



@RunWith(AndroidJUnit4.class)
@MediumTest
public class HelloWorldTest {


    private final String TAG = "hello world test";
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
    String helloWorld = "Hello World!";
    String textBeforeClick = "0";
    String textAfterClick = "1";
    String textButton = "CLICK ME !";

    @Test
    public void textHelloWorldTest(){

        onView(withText(helloWorld)).check(matches(isDisplayed()));

    }
    @Test
    public void textCounterTest(){


        onView(withId(R.id.numOfClicks)).check(matches(withText(containsString(textBeforeClick))));

    }

    @Test

    public void buttonTest(){

        onView(withId(R.id.button1)).check(matches(withText(textButton)));
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.numOfClicks)).check(matches(withText(containsString(textAfterClick))));



    }


}
