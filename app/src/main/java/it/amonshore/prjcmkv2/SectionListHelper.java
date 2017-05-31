package it.amonshore.prjcmkv2;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by narsenico on 31/05/17.
 */

class SectionListHelper {

    static abstract class Section {

    }

    static class SectionViewHolder extends RecyclerView.ViewHolder {
        SectionViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class SectionListAdapter extends RecyclerView.Adapter<SectionViewHolder>
        implements DataProvider.OnNotificationListener {

        // uso un Vector perché l'accesso ai dati può avvenire in contemporanea da più parti
        //  grazie al fatto di avere più provider
        private Vector<Section> mDataManager;
        // elenco dei provider, l'aggiornamento della lista potrà avvenire solo dai provider
        //  (oltre che direttamente dall'interazione dell'utente con la stessa)
        private ArrayList<DataProvider> mDataProviders;

        private SectionListAdapter() {
            mDataManager = new Vector<>();
        }

        SectionListAdapter registerProvider(DataProvider provider) {
            provider.addOnNotificaitonListener(this);
            mDataProviders.add(provider);
            return this;
        }

        SectionListAdapter unregisterProvider(DataProvider provider) {
            provider.removeNotificationListener(this);
            mDataProviders.remove(provider);
            return this;
        }

        @Override
        public SectionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(SectionViewHolder sectionViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
        public void onComicsAdded(Comics... comics) {

        }

        @Override
        public void onComicsRemoved(Comics... comics) {

        }

        @Override
        public void onComicsUpdated(Comics... comics) {

        }
    }

    private SectionListHelper() {

    }

    static SectionListAdapter init(Context context, RecyclerView recyclerView) {
        final SectionListAdapter adapter = new SectionListAdapter();
        // inizializzo la lista
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(adapter);

        return adapter;
    }
}
