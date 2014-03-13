package aFreeChart;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

import com.github.graphandphototest.app.R;


public class TruitonMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        TruitonBarChartView mView = new TruitonBarChartView(this);
        setContentView(mView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.truiton_main, menu);
        return true;
    }

}
