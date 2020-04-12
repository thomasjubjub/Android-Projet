package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.ImageView;
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
    private Button terminer;
    private Button back;
    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        terminer = (Button) findViewById(R.id.buttonTerminer);
        back = (Button) findViewById(R.id.back);
        terminer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                terminer();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView nomJ1 = (TextView) findViewById(R.id.nomJ1);
        TextView scoreJ1Set1 = (TextView) findViewById(R.id.scoreJ1Set1);
        TextView scoreJ1Set2 = (TextView) findViewById(R.id.scoreJ1Set2);
        TextView scoreJ1Set3 = (TextView) findViewById(R.id.scoreJ1Set3);
        TextView nomJ2 = (TextView) findViewById(R.id.nomJ2);
        TextView scoreJ2Set1 = (TextView) findViewById(R.id.scoreJ2Set1);
        TextView scoreJ2Set2 = (TextView) findViewById(R.id.scoreJ2Set2);
        TextView scoreJ2Set3 = (TextView) findViewById(R.id.scoreJ2Set3);

        TextView gagnantJoueur1 = (TextView) findViewById(R.id.gagnantJoueur1);
        TextView gagnantJoueur2 = (TextView) findViewById(R.id.gagnantJoueur2);
        TextView aceJoueur1 = (TextView) findViewById(R.id.aceJoueur1);
        TextView aceJoueur2 = (TextView) findViewById(R.id.aceJoueur2);
        TextView doubleFauteJoueur1 = (TextView) findViewById(R.id.doubleFauteJoueur1);
        TextView doubleFauteJoueur2 = (TextView) findViewById(R.id.doubleFauteJoueur2);
        TextView fauteJoueur1 = (TextView) findViewById(R.id.fauteJoueur1);
        TextView fauteJoueur2 = (TextView) findViewById(R.id.fauteJoueur2);

        imageView = (ImageView) findViewById(R.id.photoMatch);



        // récupère l'objet match que dont on souhait afficher les infos
        Intent i = new Intent();;
        Match match = getIntent().getParcelableExtra("match");
        Log.d("InStatistiques", String.valueOf(match));

        // affichage des données
        nomJ1.setText(match.getJoueur1());
        scoreJ1Set1.setText(match.getScoreJ1Set1());
        scoreJ1Set2.setText(match.getScoreJ1Set2());
        scoreJ1Set3.setText(match.getScoreJ1Set3());
        nomJ2.setText(match.getJoueur2());
        scoreJ2Set1.setText(match.getScoreJ2Set1());
        scoreJ2Set2.setText(match.getScoreJ2Set2());
        scoreJ2Set3.setText(match.getScoreJ2Set3());

        gagnantJoueur1.setText(match.getGagnantJoueur1());
        gagnantJoueur2.setText(match.getGagnantJoueur2());
        aceJoueur1.setText(match.getAceJoueur1());
        aceJoueur2.setText(match.getAceJoueur2());
        doubleFauteJoueur1.setText(match.getDoubleFauteJoueur1());
        doubleFauteJoueur2.setText(match.getDoubleFauteJoueur2());
        fauteJoueur1.setText(match.getFauteJoueur1());
        fauteJoueur2.setText(match.getFauteJoueur2());

        imageView.setImageBitmap(getImage(match.getImage()));
       // Log.d("InStatistiques", );


    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public  void terminer(){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
