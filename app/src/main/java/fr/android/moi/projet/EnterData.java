package fr.android.moi.projet;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

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
    String textButtonFormatDuMatch;
    String textButtonFormatSet;

    private Button demarrer;
    private RadioButton tb44;
    private RadioButton tb33;
    private RadioButton troisiemeSet;
    private RadioButton tieBreak;

    private ImageButton retour;
    private DatabaseManager databaseManager;
    private List<Match> matches;
    private Match match;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        // Link XML
        nomJoueur2 = (EditText) findViewById(R.id.joueur2);
        nomJoueur1 = (EditText) findViewById(R.id.joueur1);
        retour = (ImageButton) findViewById(R.id.imageBack);
        demarrer = (Button) findViewById(R.id.demarrer);
        tb44 = (RadioButton) findViewById(R.id.tb44);
        tb33 = (RadioButton) findViewById(R.id.tb33);
        troisiemeSet = (RadioButton) findViewById(R.id.troisiemeSet);
        tieBreak = (RadioButton) findViewById(R.id.tieBreak);
        retour = (ImageButton) findViewById(R.id.imageBack);

        // Listener
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

        // si on a save au préalable
        if (savedInstanceState != null) {
            Log.d("InEnterData", "Acitivité reloaded");
            // récupère données save
            nomJ1 = savedInstanceState.getString(BUNDLE_STATE_J1);
            nomJ2 = savedInstanceState.getString(BUNDLE_STATE_J2);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        //outState.putString(BUNDLE_STATE_MATCH, textButtonFormatDuMatch);
       // outState.putString(BUNDLE_STATE_SET, textButtonFormatSet);
        outState.putString(BUNDLE_STATE_J1, nomJoueur1.getText().toString());
        outState.putString(BUNDLE_STATE_J2, nomJoueur2.getText().toString());

        super.onSaveInstanceState(outState);
    }

    public void enregistrement () {


        nomJ1 = nomJoueur1.getText().toString();
        nomJ2 = nomJoueur2.getText().toString();
        String dernierSet = null;


        if(tieBreak.isChecked()){
             dernierSet = "tieBreak";
        }
        else if(troisiemeSet.isChecked()){

             dernierSet = "troisiemeSet";
        }

        if (tb44.isChecked())
        {
            Intent intent = new Intent(this, QuatreJeux.class);
            intent.putExtra("nomDuJoueur1", nomJ1);
            intent.putExtra("nomDuJoueur2", nomJ2);
            intent.putExtra("formatSet", dernierSet);
            startActivity(intent);

        }
        else if(tb33.isChecked())
        {
            Intent intent = new Intent(this, CinqJeux.class);
            intent.putExtra("nomDuJoueur1", nomJ1);
            intent.putExtra("nomDuJoueur2", nomJ2);
            startActivity(intent);
        }

    }

}
