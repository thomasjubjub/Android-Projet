package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Statistiques extends AppCompatActivity {


    private TextView nomJ1;
    private TextView scoreJ1Set1;
    private TextView scoreJ1Set2;
    private TextView scoreJ1Set3;
    private TextView nomJ2;
    private TextView scoreJ2Set1;
    private TextView scoreJ2Set2;
    private TextView scoreJ2Set3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        TextView nomJ1 = (TextView) findViewById(R.id.nomJ1);
        TextView scoreJ1Set1 = (TextView) findViewById(R.id.scoreJ1Set1);
        TextView scoreJ1Set2 = (TextView) findViewById(R.id.scoreJ1Set2);
        TextView scoreJ1Set3 = (TextView) findViewById(R.id.scoreJ1Set3);
        TextView nomJ2 = (TextView) findViewById(R.id.nomJ2);
        TextView scoreJ2Set1 = (TextView) findViewById(R.id.scoreJ2Set1);
        TextView scoreJ2Set2 = (TextView) findViewById(R.id.scoreJ2Set2);
        TextView scoreJ2Set3 = (TextView) findViewById(R.id.scoreJ2Set3);



        // récupère l'objet match que dont on souhait afficher les infos
        Intent i = new Intent();;
        Match match = getIntent().getParcelableExtra("match");
        Log.d("InStatistiques", String.valueOf(match));

        // affichage des données
        nomJ1.setText(match.getJoueur1());
        Log.d("InStatistiques", match.getJoueur1());
        scoreJ1Set1.setText(match.getScoreJ1Set1());
        //Log.d("InStatistiques", match.getScoreJ1Set1());
        scoreJ1Set2.setText(match.getScoreJ1Set2());
        scoreJ1Set3.setText(match.getScoreJ1Set3());
        nomJ2.setText(match.getJoueur2());
        scoreJ2Set1.setText(match.getScoreJ2Set1());
        scoreJ2Set2.setText(match.getScoreJ2Set2());
        scoreJ2Set3.setText(match.getScoreJ2Set3());


    }
}
