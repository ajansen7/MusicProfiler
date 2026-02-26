package me.alexjansen.musicprofiler;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.ListFragment;
import java.util.Collection;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Period;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class ResultsFragment extends ListFragment implements OnClickListener{
	
    // TODO: Move API credentials to BuildConfig or secure storage
    private static String apiKey = "YOUR_API_KEY";
    private static String user = "ajansen7";
	
    public ResultsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnSubmit = (Button)rootView.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        return rootView;
    }

	@Override
	public void onClick(View v) {
		TextView output = (TextView)v.getRootView().findViewById(R.id.txt_output);
		EditText input = (EditText)v.getRootView().findViewById(R.id.edit_username);
		user = input.getText().toString();
		
		Caller.getInstance().setDebugMode(true);
		
		Collection<Track> topTracks = User.getTopTracks(user, Period.OVERALL, apiKey);
		
	    for (Track t : topTracks) {
	    	Collection<Tag> tags = t.getTopTags(t.getArtist().toString(), t.getMbid(), apiKey);
	    	for (Tag tag : tags){
	    		Log.d("tag", String.format("%s: %s", t.getName(), tag.getName()));
	    	}
	    }
	}
}
