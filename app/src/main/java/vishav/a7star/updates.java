package vishav.a7star;

import android.app.AlertDialog;
import com.apptracker.android.listener.AppModuleListener;
import com.apptracker.android.track.AppTracker;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.facebook.ads.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;

public class updates extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    public static final String ANONYMOUS = "anonymous";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    private ListView mMessageListView;
    ProgressDialog progressDialog;
    private updatesAdapter mMessageAdapter;
    private FirebaseDatabase mFirebasedatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener childEventListener;
    private String mUsername;
    ImageView imageView;
    boolean connected = false;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        mUsername = ANONYMOUS;
        imageView = findViewById(R.id.bbtun);
        imageView.setOnClickListener(this);
        adView = new AdView(this, "2028056894188286_2028057174188258", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = findViewById(R.id.banner_container1);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Wait a minute"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();
                finish();
            }
        });
        progressDialog.show(); // Display Progress Dialog
        mFirebasedatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebasedatabase.getReference().child("messages");

        // Initialize references to views
        mMessageListView = findViewById(R.id.messageListView);
        final List<friendly> friendly = new ArrayList<>();
        mMessageAdapter = new updatesAdapter(this, R.layout.list_updates, friendly);
        mMessageListView.setAdapter(mMessageAdapter);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //we are connected to a network
        connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;

        if (connected) {
            childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    friendly friendlyMessage = dataSnapshot.getValue(friendly.class);
                    mMessageAdapter.add(friendlyMessage);
                    progressDialog.dismiss();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            mMessagesDatabaseReference.addChildEventListener(childEventListener);
        }
        else{
            progressDialog.dismiss();
            AlertDialog.Builder builder = new AlertDialog.Builder(updates.this);
            builder.setTitle("No Internet Connection Found");
            builder.setMessage("Turn on Mobile Data or Wifi");
            builder.setNeutralButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent i = new Intent(updates.this,updates.class);
                    finish();
                    startActivity(i);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
