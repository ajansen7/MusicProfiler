package me.alexjansen.musicprofiler;

import java.util.Collection;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Period;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class ResultsFragment extends ListFragment implements OnClickListener{
	private static String userAgent = "tst";
	private static String user = "ajansen7"; //api user
	private static String password = "insc547"; 
	private static String apiKey ="66d929cedd598a4c86e6a594de6a0a2a"; // api key
	private static String apiSecret = "9f7f1d221b4f933b23543b6cdff1c79a";   // api secret
	
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
//		Caller.getInstance().setCache(null);
		
//	    String token = Authenticator.getToken(key);
//	    Session session = Authenticator.getSession(token, key, secret);
//	    
////	    Session session = Authenticator.getMobileSession(user, password, key, secret);
//	    Playlist playlist = Playlist.create("example playlist", "description", session);
		Collection<Track> topTracks = User.getTopTracks(user, Period.OVERALL, apiKey);
		
//	    Collection<Tag> chart = User.getTopTags(user, key);
	    for (Track t : topTracks) {
	    	Collection<Tag> tags = t.getTopTags(t.getArtist().toString(), t.getMbid(), apiKey);
	    	for (Tag tag : tags){
	    		Log.d("tag", String.format("%s: %s", t.getName(), tag.getName()));
	    	}
	    }
	    
	    
	    
	}

}
