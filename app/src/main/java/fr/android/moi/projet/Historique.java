package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Historique extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private List<Match> matches;
    private Button buttonMatch1;
    private Button buttonMatch2;
    private Button buttonMatch3;
    private Button buttonMatch4;
    private Button buttonMatch5;
    private ImageButton retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        buttonMatch1 = (Button) findViewById(R.id.match1);
        buttonMatch2 = (Button) findViewById(R.id.match2);
        buttonMatch3 = (Button) findViewById(R.id.match3);
        buttonMatch4 = (Button) findViewById(R.id.match4);
        buttonMatch5 = (Button) findViewById(R.id.match5);
        retour = (ImageButton) findViewById(R.id.imageBack);


        // Récuperation des infos dans la bdd
        databaseManager = new DatabaseManager(this);
        matches = databaseManager.readMatch();
        Log.d("InHistorique", matches.toString());
        databaseManager.close();

        Intent intent = getIntent();

    }
}
