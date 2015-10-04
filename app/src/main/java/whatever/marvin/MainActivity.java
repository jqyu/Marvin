package whatever.marvin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.net.Uri;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements CameraFragment.OnFragmentInteractionListener {

    Vibrator v;
    long[] vPattern = {0, 1000, 200};

    MarvinFragment marvin = null;

    public void panic(){

        // vibrate !!!
        // Log.i("MainActivity", "I'M PANICKING");
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(vPattern, -1);

        if (marvin != null) {
            marvin.panic();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hides notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        marvin = (MarvinFragment) getFragmentManager().findFragmentById(R.layout.fragment_marvin);

        setContentView(R.layout.activity_main);
    }
}
