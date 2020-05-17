package vishav.a7star;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class readwrite extends Fragment {
    ListView lv;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_TITTLE = "com.example.myfirstapp.Tittle";
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_writing, container, false);
        adView = new AdView(getActivity(), "2028056894188286_2028057174188258", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = v.findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        final String[] charactersDC = {"GLOBAL WARMING","JUVENILE DELINQUENCY","BRAIN DRAIN","ADVERTISING","CRIME","FASHION","JOB HOPPING","GLOBALISATION"};
        lv = v.findViewById(R.id.lvwriting);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,charactersDC);
        lv.setAdapter(listViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView) view).getText().toString();
                Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),global.class);
                String prayer = getResources().getStringArray(R.array.content)[position];
                i.putExtra(EXTRA_MESSAGE,prayer);
                String tittle = charactersDC[position];
                i.putExtra(EXTRA_TITTLE,tittle);
                startActivity(i);
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
