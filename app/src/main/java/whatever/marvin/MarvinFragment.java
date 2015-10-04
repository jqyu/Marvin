package whatever.marvin;

import android.os.Bundle;
import android.app.Fragment;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarvinFragment extends Fragment {

    FrameLayout mContainer;
    TextView mFace;


    public void onPanicChange(boolean panic) {
        if (mContainer == null) {
            mContainer = (FrameLayout) getView().findViewById(R.id.fragment_marvin);
        }
        if (mContainer != null) {
            mContainer.setBackgroundColor(getResources().getColor(panic ? R.color.red_overlay : R.color.green_overlay));
        }
        if (mFace == null) {
            mFace = (TextView) getView().findViewById(R.id.marvin_face);
        }
        if (mFace != null) {
            mFace.setText(getString(panic ? R.string.marvin_panic : R.string.marvin_happy));
            mFace.setBackgroundColor(getResources().getColor(panic ? R.color.red_panic : R.color.green_happy));
        }
    }


    public MarvinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marvin, container, false);
    }


}
