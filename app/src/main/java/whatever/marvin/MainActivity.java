package whatever.marvin;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;

public class MainActivity extends Activity implements CameraFragment.OnFragmentInteractionListener {

    Vibrator v;
    long[] vPattern = {0, 1000, 200};

    MarvinFragment marvin = null;
    MediaPlayer mediaPlayer;
    public void onPanicChange(boolean panic){

        // vibrate !!!
        // Log.i("MainActivity", "I'M PANICKING");

        // lol async hacks
        if (marvin == null) {
            marvin = (MarvinFragment) getFragmentManager().findFragmentById(R.id.fragment_marvin);
        }
        if (marvin != null) {
            marvin.onPanicChange(panic);
        }

        if (!panic) return;

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(vPattern, -1);

        Uri uri = null;
        if(mediaPlayer!=null) {
            if (!mediaPlayer.isPlaying()) {
                Random gen = new Random();
                int i = gen.nextInt(5);
                Log.i("MainActivity",String.valueOf(i));
                switch (i) {
                    case 0:
                        mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_02);
                        break;
                    case 1:
                        mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_04);
                        break;
                    case 2:
                        mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_05);
                        break;
                    case 3:
                        mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_01);
                        break;
                    case 4:
                        mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_03);
                        break;
                }
                mediaPlayer.start();
            }
        }
        else
        {
            Random gen = new Random();
            int i = gen.nextInt(5);
            Log.i("MainActivity",String.valueOf(i));
            switch (i) {
                case 0:
                    mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_02);
                    break;
                case 1:
                    mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_04);
                    break;
                case 2:
                    mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_05);
                    break;
                case 3:
                    mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_01);
                    break;
                case 4:
                    mediaPlayer = MediaPlayer.create(this, R.raw.robonoise_03);
                    break;
            }
            mediaPlayer.start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hides notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (marvin != null) {
            Log.i("MainActivity", "marvin is: "+marvin.toString());
        } else {
            Log.i("MainActivity", "no marvin ]:");
        }

        setContentView(R.layout.activity_main);
    }
}
