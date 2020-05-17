package vishav.a7star;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ABC on 3/7/2018.
 */

public class vocabulary extends Fragment {
    List<String> myHeader;
    AdView adView;
    HashMap<String,List<String>> myChild;
    ExpandableListView expList;
    ExpandableListAdapter ListAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.vocab, container, false);
        initData();
        expList = v.findViewById(R.id.listview);
        adView = new com.facebook.ads.AdView(getActivity(), "2028056894188286_2028057174188258", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = v.findViewById(R.id.banner_container2);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        ListAdapter = new ExpandableListAdapter(getActivity(),myHeader,myChild);
        expList.setAdapter(ListAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void initData() {
        myHeader = new ArrayList<String>();
        myChild = new HashMap<String, List<String>>();

        // Adding child data
        myHeader.add("1.Magnanimous");
        myHeader.add("2.Altruist");
        myHeader.add("3.Assiduous");
        myHeader.add("4.Quixotic");
        myHeader.add("5.Virtuoso");
        myHeader.add("6.Gregarious");
        myHeader.add("7.Pollyanna");
        myHeader.add("8.Suave");
        myHeader.add("9.in the heart of city");
        myHeader.add("10.in the outskirt of city");
        myHeader.add("11.at stone throw distance");
        myHeader.add("12.spic and span");
        myHeader.add("13.Alluring");
        myHeader.add("14.Facade");
        myHeader.add("15.Colossal");
        myHeader.add("16.menace");
        myHeader.add("17.curb");
        myHeader.add("18.unravel");
        myHeader.add("19.bed of roses");
        myHeader.add("20.flabbergasted");
        myHeader.add("21.duped");
        myHeader.add("22.Vicissitudes");
        myHeader.add("23.Snag");
        myHeader.add("24.Burgeoning");
        myHeader.add("25.on the nine cloud");
        myHeader.add("26.Unprecedented");
        myHeader.add("27.sinister");
        myHeader.add("28.Pacific");
        myHeader.add("29.Meagre");
        myHeader.add("30.Rudimentary");
        myHeader.add("31.Dearth");
        myHeader.add("32.zenith");
        myHeader.add("33.erroneous");
        myHeader.add("34.lush of gardens");
        myHeader.add("35.top-notch");
        myHeader.add("36.exigencies");
        myHeader.add("37.spend thrift");
        myHeader.add("38.burn a hole in the pocket");
        myHeader.add("39.prudent");
        myHeader.add("40.Chaos");
        myHeader.add("41.Provoke");
        myHeader.add("42.Pompous");
        myHeader.add("43.Versatile");
        myHeader.add("44.Heinous");
        myHeader.add("45.spurt");
        myHeader.add("46.Indigenous");
        myHeader.add("47.Abate");
        myHeader.add("48.Engender");
        myHeader.add("49.From pin to plane");
        myHeader.add("50.In Apple pie order");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Large-Hearted, Generous");
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Caring, one who lends hand");
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Hardworker");
        List<String> Qui = new ArrayList<String>();
        Qui.add("Imaginary, Unrealistic");
        List<String> vir = new ArrayList<String>();
        vir.add("Skilled, Consumate");
        List<String> greg = new ArrayList<String>();
        greg.add("Sociable, Communicative");
        List<String> poll = new ArrayList<String>();
        poll.add("Optimistic, Cheerful");
        List<String> sau = new ArrayList<String>();
        sau.add("Sophisticated, smooth, politic");
        List<String> heart = new ArrayList<String>();
        heart.add("in the centre of city");
        List<String> outskirt = new ArrayList<String>();
        outskirt.add("in the country side of city");
        List<String> stone = new ArrayList<String>();
        stone.add("at small distance");
        List<String> spic = new ArrayList<String>();
        spic.add("neat and clean");
        List<String> alluring = new ArrayList<String>();
        alluring.add("Attractive");
        List<String> facade = new ArrayList<String>();
        facade.add("Main gate");
        List<String> collo = new ArrayList<String>();
        collo.add("Extremely Big");
        List<String> mena = new ArrayList<String>();
        mena.add("Problem");
        List<String> curb = new ArrayList<String>();
        curb.add("Limit");
        List<String> unr = new ArrayList<String>();
        unr.add("Solve");
        List<String> bed = new ArrayList<String>();
        bed.add("easy, comfortable");
        List<String> flabber = new ArrayList<String>();
        flabber.add("Astonished");
        List<String> duped = new ArrayList<String>();
        duped.add("Cheated");
        List<String> Vici = new ArrayList<String>();
        Vici.add("ups and downs, ebb and flaws, thin and thick time of life");
        List<String> bur = new ArrayList<String>();
        bur.add("increasing fast, breakneck pace");
        List<String> cloud = new ArrayList<String>();
        cloud.add("Extremely happy, on the seventh heaven");
        List<String> unpre = new ArrayList<String>();
        unpre.add("Never happened before");
        List<String> sinis = new ArrayList<String>();
        sinis.add("Harmful");
        List<String> pacific = new ArrayList<String>();
        pacific.add("peaceful, quite");
        List<String> mea = new ArrayList<String>();
        mea.add("Small");
        List<String> rudi = new ArrayList<String>();
        rudi.add("Elementary, beginner");
        List<String> dear = new ArrayList<String>();
        dear.add("shortage");
        List<String> ze = new ArrayList<String>();
        ze.add("highest point");
        List<String> err = new ArrayList<String>();
        err.add("incorrect");
        List<String> lus = new ArrayList<String>();
        lus.add("Large gardens");
        List<String> top = new ArrayList<String>();
        top.add("Excellent");
        List<String> exi = new ArrayList<String>();
        exi.add("Urgent needs");
        List<String> spe = new ArrayList<String>();
        spe.add("person who spends money extravagantly");
        List<String> bu = new ArrayList<String>();
        bu.add("someone to be tempted to spend money");
        List<String> pru = new ArrayList<String>();
        pru.add("Judicious");
        List<String> ch = new ArrayList<String>();
        ch.add("complete disorder");
        List<String> pro = new ArrayList<String>();
        pro.add("Incite");
        List<String> po = new ArrayList<String>();
        po.add("Ornate, decorated");
        List<String> ver = new ArrayList<String>();
        ver.add("Multi-talented");
        List<String> hen = new ArrayList<String>();
        hen.add("evil, wicked");
        List<String> spurt = new ArrayList<String>();
        spurt.add("Erupt");
        List<String> ind = new ArrayList<String>();
        ind.add("Native");
        List<String> ab = new ArrayList<String>();
        ab.add("Lessen,small");
        List<String> end = new ArrayList<String>();
        end.add("to give rise to, inculcate");
        List<String> snag = new ArrayList<String>();
        snag.add("an unexpected or hidden obstacle or drawback");
        List<String> pin = new ArrayList<String>();
        pin.add("Everything is available");
        List<String> apple = new ArrayList<String>();
        apple.add("in systematic order");

        myChild.put(myHeader.get(0), top250); // Header, Child data
        myChild.put(myHeader.get(1), nowShowing);
        myChild.put(myHeader.get(2), comingSoon);
        myChild.put(myHeader.get(3), Qui);
        myChild.put(myHeader.get(4), vir);
        myChild.put(myHeader.get(5), greg);
        myChild.put(myHeader.get(6), poll);
        myChild.put(myHeader.get(7), sau);
        myChild.put(myHeader.get(8), heart);
        myChild.put(myHeader.get(9), outskirt);
        myChild.put(myHeader.get(10), stone);
        myChild.put(myHeader.get(11), spic);
        myChild.put(myHeader.get(12), alluring);
        myChild.put(myHeader.get(13), facade);
        myChild.put(myHeader.get(14), collo);
        myChild.put(myHeader.get(15), mena);
        myChild.put(myHeader.get(16), curb);
        myChild.put(myHeader.get(17), unr);
        myChild.put(myHeader.get(18), bed);
        myChild.put(myHeader.get(19), flabber);
        myChild.put(myHeader.get(20), duped);
        myChild.put(myHeader.get(21), Vici);
        myChild.put(myHeader.get(22), snag);
        myChild.put(myHeader.get(23), bur);
        myChild.put(myHeader.get(24), cloud);
        myChild.put(myHeader.get(25), unpre);
        myChild.put(myHeader.get(26), sinis);
        myChild.put(myHeader.get(27), pacific);
        myChild.put(myHeader.get(28), mea);
        myChild.put(myHeader.get(29), rudi);
        myChild.put(myHeader.get(30), dear);
        myChild.put(myHeader.get(31), ze);
        myChild.put(myHeader.get(32), err);
        myChild.put(myHeader.get(33), lus);
        myChild.put(myHeader.get(34), top);
        myChild.put(myHeader.get(35), exi);
        myChild.put(myHeader.get(36), spe);
        myChild.put(myHeader.get(37), bu);
        myChild.put(myHeader.get(38), pru);
        myChild.put(myHeader.get(39), ch);
        myChild.put(myHeader.get(40), pro);
        myChild.put(myHeader.get(41), po);
        myChild.put(myHeader.get(42), ver);
        myChild.put(myHeader.get(43), hen);
        myChild.put(myHeader.get(44), spurt);
        myChild.put(myHeader.get(45), ind);
        myChild.put(myHeader.get(46), ab);
        myChild.put(myHeader.get(47), end);
        myChild.put(myHeader.get(48), pin);
        myChild.put(myHeader.get(49), apple);
    }
}
