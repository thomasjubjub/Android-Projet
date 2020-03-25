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

    /*    private EditText nomJoueur1;
        private EditText nomJoueur2;*/
    private String joueur1;
    private String joueur2;
    private Button formatDuMatch;
    private Button formatDuDernierSet;
    private ImageButton retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        joueur1 = String.valueOf(findViewById(R.id.joueur1));
        joueur2 = String.valueOf(findViewById(R.id.joueur2));

        retour = (ImageButton) findViewById(R.id.imageBack)

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
