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

    public static final String BUNDLE_STATE_MATCH = "formatDuMatch";
    public static final String BUNDLE_STATE_SET = "formatSet";
    public static final String BUNDLE_STATE_J1 = "nomJ1_key";
    public static final String BUNDLE_STATE_J2 = "nomJ2_key";
    private EditText nomJoueur1;
    private EditText nomJoueur2;
    private String nomJ1;
    private String nomJ2;
    private Button formatDuMatch;
    private Button formatDuDernierSet;
    private Button demarrer;
    private ImageButton retour;
    private DatabaseManager databaseManager;
    private List<Match> matches;
    private Match match;
    String textButtonFormatDuMatch;
    String textButtonFormatSet;

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

        // récupère les données match si on les a récupérer avant
        Intent intent = getIntent();
        Match match_format_match = getIntent().getParcelableExtra("match_format_match");
        Match match_format_set = getIntent().getParcelableExtra("match_format_set");

        String typeMatchChoisi = match_format_match.getFormatMatch();
        String typeSetChoisi = match_format_set.getFormatSet();
        match.setFormatMatch(typeMatchChoisi);
        match.setFormatSet(typeSetChoisi);

        Log.d("InStatistiques", String.valueOf(match));


        if(typeMatchChoisi != null) {
            match.setFormatMatch(typeMatchChoisi);
            formatDuMatch.setText(textButtonFormatDuMatch);
        }
        else{
            textButtonFormatDuMatch = savedInstanceState.getString(BUNDLE_STATE_MATCH);
            if(textButtonFormatDuMatch!= null){
                formatDuMatch.setText(textButtonFormatDuMatch);
            }
        }

        if(typeSetChoisi != null) {
            match.setFormatSet(typeSetChoisi);
            formatDuDernierSet.setText(typeSetChoisi);
        }

        // si un des deux ou les deux sont save
        if (savedInstanceState != null) {
            Log.d("InEnterData", "Acitivité reloaded");
            // récupère données save
            textButtonFormatDuMatch = savedInstanceState.getString(BUNDLE_STATE_MATCH);
            textButtonFormatSet = savedInstanceState.getString(BUNDLE_STATE_SET);
            nomJ1 = savedInstanceState.getString(BUNDLE_STATE_J1);
            nomJ2 = savedInstanceState.getString(BUNDLE_STATE_J2);

            // si format match pas choisi
            if(textButtonFormatDuMatch == null){
                textButtonFormatDuMatch = typeMatchChoisi;
                formatDuDernierSet.setText(typeSetChoisi);
            }

            // si set pas choisi
            if(textButtonFormatSet == null){
                textButtonFormatSet = typeSetChoisi;
                formatDuMatch.setText(textButtonFormatDuMatch);
            }
        }
        // si aucun n'est save
        else {
            textButtonFormatDuMatch = typeMatchChoisi;
            textButtonFormatSet = typeSetChoisi;

                if(textButtonFormatDuMatch!= null){
                    formatDuMatch.setText(textButtonFormatDuMatch);
                }

            if(textButtonFormatSet!= null){
                formatDuDernierSet.setText(typeSetChoisi);
            }
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

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(BUNDLE_STATE_MATCH, textButtonFormatDuMatch);
        outState.putString(BUNDLE_STATE_SET, textButtonFormatSet);
        outState.putString(BUNDLE_STATE_J1, nomJoueur1.getText().toString());
        outState.putString(BUNDLE_STATE_J2, nomJoueur2.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        nomJoueur1.setText(savedInstanceState.getString(BUNDLE_STATE_J1));
        nomJoueur2.setText(savedInstanceState.getString(BUNDLE_STATE_J2));
    }

    public void enregistrement () {

        //nomJoueur1.setText(nomJ1);
       // nomJoueur2.setText(nomJ2);

        nomJ1 = nomJoueur1.getText().toString();
        nomJ2 = nomJoueur2.getText().toString();

        Intent intentJoueur = new Intent(this, Enregistrement.class);
        intentJoueur.putExtra("nomDuJoueur1", nomJ1);
        intentJoueur.putExtra("nomDuJoueur2", nomJ2);

        intentJoueur.putExtra("match", match);

        startActivity(intentJoueur);

    }

    public void formatDuDernierSet () {
        Intent intent = new Intent(this, FormatDuDernierSet.class);
        intent.putExtra("match", match);
        startActivity(intent);
    }

    public void formatDuMatch () {
        Intent intent = new Intent(this, FormatDuMatch.class);
        intent.putExtra("match", match);
        startActivity(intent);
    }

}
