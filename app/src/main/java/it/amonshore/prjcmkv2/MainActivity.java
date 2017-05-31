package it.amonshore.prjcmkv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private DataProvider mUserProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: creare provider

        SectionListHelper
                .init(this, (RecyclerView) findViewById(R.id.main_list))
        //                .registerProvider(...)
        //                .registerProvider(...)
        ;
    }

    private void onComicsAdded(Comics comics) {
        // TODO: nuovo fumetto creato dall'utente
        //  passarlo al provider mUserProvider
        //  che si occuperò poi di notificare l'azione alla lista
    }
}
