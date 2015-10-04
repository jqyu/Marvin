package whatever.marvin;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;

public class MainActivity extends Activity implements CameraFragment.OnFragmentInteractionListener {

    Vibrator v;
    long[] vPattern = {0, 1000, 200};

    MarvinFragment marvin = null;
    MediaPlayer mediaPlayer;
    public void panic(){

        // vibrate !!!
        // Log.i("MainActivity", "I'M PANICKING");
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(vPattern, -1);

        if (marvin != null) {
            marvin.panic();
        }
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

        marvin = (MarvinFragment) getFragmentManager().findFragmentById(R.layout.fragment_marvin);

        setContentView(R.layout.activity_main);
    }
}
