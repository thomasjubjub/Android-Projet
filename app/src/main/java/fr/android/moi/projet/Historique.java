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
                   // intent.putExtra("IdMatch", typeMatchChoisi);
                break;

            case R.id.match2:

                break;
        }

        startActivity(intent);
    }

}
