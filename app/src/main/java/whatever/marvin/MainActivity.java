package whatever.marvin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.net.Uri;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    Vibrator v;
    long[] vPattern = {0, 1000, 200};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hides notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, CameraFragment.newInstance())
                    .commit();
        }

        // vibrate !!!
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(vPattern, 0);
    }
}
