package id.ac.ui.cs.mobileprogramming.helloworld.Counter;


import android.view.View;
import android.widget.Button;

import org.junit.Test;

import id.ac.ui.cs.mobileprogramming.helloworld.MainActivity;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CounterTest {

    MainActivity mainActivity = new MainActivity();


    @Test
    public void testCounter(){
        int numberOfClickBefore = this.mainActivity.numberOfClicks;
        this.mainActivity.handleOnClick(mock(View.class));
        int numberOfClickAfter = this.mainActivity.numberOfClicks;
        assertTrue(numberOfClickAfter>numberOfClickBefore);
    }

}
