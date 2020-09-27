package id.ac.ui.cs.mobileprogramming.helloworld.TextOnViewTest;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;


import org.junit.Rule;

import org.junit.Test;
import org.junit.runner.RunWith;
import id.ac.ui.cs.mobileprogramming.helloworld.MainActivity;
import id.ac.ui.cs.mobileprogramming.helloworld.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//comment



@RunWith(AndroidJUnit4.class)
@MediumTest
public class HelloWorldTest {

    private final String TAG = "hello world test";
    //

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void textHelloWorldTest(){

        onView(withText("Hello World!")).check(matches(isDisplayed()));

    }
    @Test
    public void textCounterTest(){

        String textBeforeClick = "Number of clicks: 0";
        onView(withId(R.id.numOfClicks)).check(matches(withText(textBeforeClick)));







    }


}
