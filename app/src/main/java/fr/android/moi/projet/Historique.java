package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Historique extends AppCompatActivity extends ActionBarActivity {

    private DatabaseManager databaseManager;
    private List<Match> matches;
    private TextView textHistorique;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        mListView = (ListView) findViewById(R.id.listView);

        // Récuperation des infos dans la bdd
        databaseManager = new DatabaseManager(this);
        matches = databaseManager.readMatch();
        Log.d("InHistorique", matches.toString());
        databaseManager.close();

        // creation adapter
        MatchAdapter adapter = new MatchAdapter(Historique.this, matches);
        mListView.setAdapter(adapter);


    }
}
