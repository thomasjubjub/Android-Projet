package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.List;
import android.view.Menu;
import android.view.View.OnClickListener;

public class Historique extends AppCompatActivity  implements OnClickListener  {

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

        // link XML
        buttonMatch1 = (Button) findViewById(R.id.match1);
        buttonMatch2 = (Button) findViewById(R.id.match2);
        buttonMatch3 = (Button) findViewById(R.id.match3);
        buttonMatch4 = (Button) findViewById(R.id.match4);
        buttonMatch5 = (Button) findViewById(R.id.match5);
        retour = (ImageButton) findViewById(R.id.imageBack);

        // listener
        buttonMatch1.setOnClickListener(this);
        buttonMatch2.setOnClickListener(this);
        buttonMatch3.setOnClickListener(this);
        buttonMatch4.setOnClickListener(this);
        buttonMatch5.setOnClickListener(this);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Récuperation de la bdd
        databaseManager = new DatabaseManager(this);
        matches = databaseManager.readMatch();
        Log.d("InHistorique", matches.toString());
        databaseManager.close();
    }

    public void onClick(View v) {

        Intent intent = new Intent(this, Statistiques.class);

        switch (v.getId()) {
            case R.id.match1:

                Match match_1 = new Match();
                match_1 = matches.get(4);
                Log.d("InHistorique", match_1.toString());
                intent.putExtra("match", match_1);
                break;

            case R.id.match2:

                Match match_2 = new Match();
                match_2 = matches.get(3);
                Log.d("InHistorique", match_2.toString());
                intent.putExtra("match", match_2);
                break;

            case R.id.match3:

                Match match_3 = new Match();
                match_3 = matches.get(2);
                Log.d("InHistorique", match_3.toString());
                intent.putExtra("match", match_3);
                break;

            case R.id.match4:

                Match match_4 = new Match();
                match_4 = matches.get(1);
                Log.d("InHistorique", match_4.toString());
                intent.putExtra("match", match_4);
                break;

            case R.id.match5:

                Match match_5 = new Match();
                match_5 = matches.get(0);
                Log.d("InHistorique", match_5.toString());
                intent.putExtra("match", match_5);
                break;
        }

        startActivity(intent);
    }

}
