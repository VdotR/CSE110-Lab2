package edu.ucsd.cse110.lab2;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import static org.junit.Assert.assertEquals;


import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        try(var scenario = ActivityScenario.launch(MainActivity.class)){
            scenario.moveToState(Lifecycle.State.CREATED);
            scenario.moveToState(Lifecycle.State.STARTED);
            scenario.onActivity(activity -> {
                Button b1 = activity.findViewById(R.id.btn_one);
                b1.performClick();
                Button b2 = activity.findViewById(R.id.btn_plus);
                b2.performClick();
                b1.performClick();
                Button b3 = activity.findViewById(R.id.btn_equals);
                b3.performClick();

                TextView tv = activity.findViewById(R.id.display);
                assertEquals("2", tv.getText());
            });
        }
    }
}
