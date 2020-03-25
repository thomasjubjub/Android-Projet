package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EnterData extends AppCompatActivity {

    private EditText nomJoueur1;
    private EditText nomJoueur2;
    private String joueur1;
    private String joueur2;
    private Button formatDuMatch;
    private Button formatDuDernierSet;
    private Button demarrer;
    private ImageButton retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        nomJoueur2 = (EditText) findViewById(R.id.joueur2);
        nomJoueur1 = (EditText) findViewById(R.id.joueur1);

        demarrer = (Button) findViewById(R.id.demarrer);

        retour = (ImageButton) findViewById(R.id.imageButton);

        formatDuMatch = (Button) findViewById(R.id.formatMatch);
        formatDuDernierSet = (Button) findViewById(R.id.formatSet);

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
    }

    public void enregistrement() {

        joueur1 = nomJoueur1.getText().toString();
        joueur2 = nomJoueur2.getText().toString();

        Intent intentJoueur = new Intent(this, Enregistrement.class);

        intentJoueur.putExtra("nomDuJoueur1",joueur1);
        intentJoueur.putExtra("nomDuJoueur2", joueur2);

        startActivity(intentJoueur);

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
