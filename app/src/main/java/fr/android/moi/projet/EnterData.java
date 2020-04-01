package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.List;

public class EnterData extends AppCompatActivity {

    private EditText nomJoueur1;
    private EditText nomJoueur2;
    private String joueur1;
    private String joueur2;
    private Button formatDuMatch;
    private Button formatDuDernierSet;
    private Button demarrer;
    private ImageButton retour;

    private DatabaseManager databaseManager;
    private List<Match> matches;
    String textButtonFormatDuMatch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);


        // Link XML
        nomJoueur2 = (EditText) findViewById(R.id.joueur2);
        nomJoueur1 = (EditText) findViewById(R.id.joueur1);
        retour = (ImageButton) findViewById(R.id.imageBack);
        demarrer = (Button) findViewById(R.id.demarrer);
        formatDuMatch = (Button) findViewById(R.id.formatMatch);
        formatDuDernierSet = (Button) findViewById(R.id.formatSet);

        // Ajout listener sur boutton

        Intent intent = getIntent();
        String typeMatchChoisi = intent.getStringExtra("typeMatchChoisi");
        String typeSetChoisi = intent.getStringExtra("setChoisi");
        textButtonFormatDuMatch = typeMatchChoisi;

        if (textButtonFormatDuMatch != null) {
            formatDuMatch.setText(textButtonFormatDuMatch);
        }

        if (typeSetChoisi != null) {
            formatDuDernierSet.setText(typeSetChoisi);
        }

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
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enregistrement();

            }
        });

        // DATABASE
       // databaseManager = new DatabaseManager(this);
        //databaseManager.insertMatch( "Alexandra", "Thomas", "oui", "non" );
        // Récuperation de liste d'array de match
        //matches = databaseManager.readMatch();
       // databaseManager.close();

    }



        public void enregistrement () {

            joueur1 = nomJoueur1.getText().toString();
            joueur2 = nomJoueur2.getText().toString();

            Intent intentJoueur = new Intent(this, Enregistrement.class);

            intentJoueur.putExtra("nomDuJoueur1", joueur1);
            intentJoueur.putExtra("nomDuJoueur2", joueur2);

            startActivity(intentJoueur);


        }

        public void formatDuDernierSet () {
            Intent intent = new Intent(this, FormatDuDernierSet.class);
            startActivity(intent);
        }

        public void formatDuMatch () {
            Intent intent = new Intent(this, FormatDuMatch.class);
            startActivity(intent);
        }

    }



