package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.List;

public class EnterData extends AppCompatActivity {

    /*    private EditText nomJoueur1;
        private EditText nomJoueur2;*/
    private String joueur1;
    private String joueur2;
    private Button formatDuMatch;
    private Button formatDuDernierSet;
    private Button demarrer;
    private ImageButton retour;
    private DatabaseManager databaseManager;
    private List<Match> matches;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);


        // Link XML
        joueur1 = String.valueOf(findViewById(R.id.joueur1));
        joueur2 = String.valueOf(findViewById(R.id.joueur2));
        retour = (ImageButton) findViewById(R.id.imageBack);
        demarrer = (Button) findViewById(R.id.demarrer);
        formatDuMatch = (Button) findViewById(R.id.formatMatch);
        formatDuDernierSet = (Button) findViewById(R.id.formatSet);

        // Ajout listener sur boutton
        formatDuMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formatDuMatch();
            }
        });
        formatDuDernierSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formatDuDernierSet();
            }
        });
        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrer();
            }
        });
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retour();
            }
        });

        databaseManager = new DatabaseManager(this);

        // Inserer dans la bdd
        databaseManager.insertMatch( "Alexandra", "Thomas", "oui", "non" );

        // Récuperation de liste d'array de match
        matches = databaseManager.readMatch();
        //Log.d("InEnterData", matches.toString());
        databaseManager.close();

    }

    public void demarrer() {
        Intent intent = new Intent(this, Enregistrement.class);
        startActivity(intent);
    }

    public void retour() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void formatDuDernierSet() {
        Intent intent = new Intent(this, FormatDuDernierSet.class);
        startActivity(intent);
    }

    public void formatDuMatch() {
        Intent intent = new Intent(this, FormatDuMatch.class);
        startActivity(intent);
    }

}
