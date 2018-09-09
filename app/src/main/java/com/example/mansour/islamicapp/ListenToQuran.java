package com.example.mansour.islamicapp;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mansour on 8/22/2018.
 */

public class ListenToQuran extends Fragment {
    View mView;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    MyRecyclerViewAdapter mRecyclerViewAdapter;
    List<Readers> mReaders;
    public static ListenToQuranService mListenToQuranService;
    boolean isBound = false;

    /*String url = "";
    String [] QuranReaders = {"عبد الباسط عبد الصمد","عبد الباسط عبد الصمد - مجود","محمد صديق المنشاوى",
            "محمد صديق المنشاوى - مجود","محمود على البنا - مجود",
            "مشاري العفاسى","ماهر المعيقلي","أحمد العجمى",
            "عبد الرحمن السديس","سعود الشريم","ناصر القطامى","سعد الغامدي",
            "خالد القحطانى","إدريس أبكر","محمد جبريل","محمود الحصرى","محمود الحصرى - مجود"};*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_listen_to_quran, container, false);
        //makeQuranReadersViewList();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        initializeAdapter();

        return mView;
    }

    public void initializeData(){
        mReaders = new ArrayList<>();
        Log.i("info", "initialized");
        mReaders.add(new Readers("عبد الباسط عبد الصمد", "http://live.mp3quran.net:9980/", R.drawable.abd_elbaset));
        mReaders.add(new Readers("عبد الباسط عبد الصمد - مجود", "http://live.mp3quran.net:9974/", R.drawable.abd_elbaset));
        mReaders.add(new Readers("محمد صديق المنشاوى", "http://live.mp3quran.net:9978/", R.drawable.mohamed_sedek_elmenshawi));
        mReaders.add(new Readers("محمد صديق المنشاوى - مجود", "http://live.mp3quran.net:9826/", R.drawable.mohamed_sedek_elmenshawi));
        mReaders.add(new Readers("محمود على البنا - مجود","http://live.mp3quran.net:9810/", R.drawable.mahmoud_ali_elbna));
        mReaders.add(new Readers("مشاري العفاسى","http://live.mp3quran.net:9982/", R.drawable.mshari_elafasi));
        mReaders.add(new Readers("ماهر المعيقلي","http://live.mp3quran.net:9996/", R.drawable.maher_al_muaiqly));
        mReaders.add(new Readers("أحمد العجمى","http://live.mp3quran.net:9990/", R.drawable.ahmed_alagamy));
        mReaders.add(new Readers("عبد الرحمن السديس", "http://live.mp3quran.net:9988/", R.drawable.abd_elrahman_elsodes));
        mReaders.add(new Readers("سعود الشريم", "http://live.mp3quran.net:9986/", R.drawable.soud_elshrem_2));
        mReaders.add(new Readers("ناصر القطامى", "http://live.mp3quran.net:9994/", R.drawable.naser_elktamy));
        mReaders.add(new Readers("سعد الغامدي", "http://live.mp3quran.net:9976/", R.drawable.saad_elghamdi));
        mReaders.add(new Readers("خالد القحطانى", "http://live.mp3quran.net:9970/", R.drawable.khaled_elkhtani));
        mReaders.add(new Readers("إدريس أبكر", "http://live.mp3quran.net:9968/", R.drawable.idriss_abkar));
        mReaders.add(new Readers("محمد جبريل", "http://live.mp3quran.net:9962/", R.drawable.mohamed_gbriel_2));
        mReaders.add(new Readers("محمود الحصرى", "http://live.mp3quran.net:9958/", R.drawable.mahmoud_alhusarey));
        mReaders.add(new Readers("محمود الحصرى - مجود", "http://live.mp3quran.net:9806/", R.drawable.mahmoud_alhusarey));
    }
    public void initializeAdapter(){
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(mReaders);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        Intent intent = new Intent(getActivity(), ListenToQuranService.class);
        getActivity().bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        getActivity().startService(intent);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unbindService(mServiceConnection);
        isBound = false;
    }

   /* private void makeQuranReadersViewList(){
        ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, QuranReaders);
        ListView listView = (ListView)mView.findViewById(R.id.listViewQuranReaders);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mReaderName = String.valueOf(adapterView.getItemAtPosition(i));
                switch (mReaderName) {
                    case "عبد الباسط عبد الصمد":
                        url = "http://live.mp3quran.net:9980/";
                        break;
                    case "عبد الباسط عبد الصمد - مجود":
                        url = "http://live.mp3quran.net:9974/";
                        break;
                    case "محمد صديق المنشاوى":
                        url = "http://live.mp3quran.net:9978/";
                        break;
                    case "محمد صديق المنشاوى - مجود":
                        url = "http://live.mp3quran.net:9826/";
                        break;
                    case "محمود على البنا - مجود":
                        url = "http://live.mp3quran.net:9810/";
                        break;
                    case "مشاري العفاسى":
                        url = "http://live.mp3quran.net:9982/";
                        break;
                    case "ماهر المعيقلي":
                        url = "http://live.mp3quran.net:9996/";
                        break;
                    case "أحمد العجمى":
                        url = "http://live.mp3quran.net:9990/";
                        break;
                    case "عبد الرحمن السديس":
                        url = "http://live.mp3quran.net:9988/";
                        break;
                    case "سعود الشريم":
                        url = "http://live.mp3quran.net:9986/";
                        break;
                    case "ناصر القطامى":
                        url = "http://live.mp3quran.net:9994/";
                        break;
                    case "سعد الغامدي":
                        url = "http://live.mp3quran.net:9976/";
                        break;
                    case "خالد القحطانى":
                        url = "http://live.mp3quran.net:9970/";
                        break;
                    case "إدريس أبكر":
                        url = "http://live.mp3quran.net:9968/";
                        break;
                    case "محمد جبريل":
                        url = "http://live.mp3quran.net:9962/";
                        break;
                    case "محمود الحصرى":
                        url = "http://live.mp3quran.net:9958/";
                        break;
                    case "محمود الحصرى - مجود":
                        url = "http://live.mp3quran.net:9806/";
                        break;
                    default:
                        Toast.makeText(getActivity(), "Not Implemented Yet", Toast.LENGTH_SHORT).show();
                }
                Log.i("URL: ",url);
                mListenToQuranService.setUrl(url);
                //mListenToQuranService = new ListenToQuranService(url);

            }
        });
    }
*/

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenToQuranService.LocalBinder binder = (ListenToQuranService.LocalBinder) iBinder;
            mListenToQuranService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };
}