package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.View.OnClickListener;
import java.util.List;

public class QuatreJeux extends AppCompatActivity implements OnClickListener {

        private TextView longitude;
        private TextView latitude;

        private ImageButton buttonPhoto;

        private LocationManager locationManager;
        private LocationListener locationListener;
        private String provider;

        private String nomJoueur1;
        private String nomJoueur2;

        private TextView textJoueur1;
        private TextView textJoueur2;
        private Button buttonFinir;
        private DatabaseManager databaseManager;
        private List<Match> matches;


        private Button premiereBalle;
        private Button deuxiemeBalle;
        private Button doubleFaute;
        private Button acePremiereBalle;
        private Button aceDeuxiemeBalle;
        private Button pointGagnantJoueur1;
        private Button pointGagnantJoueur2;
        private Button fauteDirecteJoueur1;
        private Button fauteDirecteJoueur2;
        private Button fauteProvoqueeJoueur1;
        private Button fauteProvoqueeJoueur2;

        private TextView scoreSet1Joueur1;
        private TextView scoreSet2Joueur1;
        private TextView scoreSet3Joueur1;
        private TextView scoreJeuJoueur1;

        private TextView scoreSet1Joueur2;
        private TextView scoreSet2Joueur2;
        private TextView scoreSet3Joueur2;
        private TextView scoreJeuJoueur2;

        private int scoreJoueur1Set = 0;
        private int scoreJoueur1Jeu = 0;
        private int scoreJoueur1 = 0;
        private int scoreJoueur2Set = 0;
        private int scoreJoueur2Jeu = 0;
        private int scoreJoueur2 = 0;


        private boolean joueur1 = true;

        enum NumeroJeu
        {
                SET1,
                SET2,
                SET3
        };
        private NumeroJeu numeroDeJeu = NumeroJeu.SET1;



      //  @SuppressLint("MissingPermission")
        @Override
        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_tb33);

                longitude=(TextView) findViewById(R.id.longi);
                latitude=(TextView) findViewById(R.id.lat);
                buttonPhoto=(ImageButton) findViewById(R.id.imagePhoto);
                buttonFinir = (Button) findViewById(R.id.buttonFinir);


                buttonPhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) { takePicture(); }
                });
                buttonFinir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                finir();
                        }
                });

                textJoueur1 = (TextView) findViewById(R.id.textJoueur1);
                textJoueur2 = (TextView) findViewById(R.id.textJoueur2);

                Intent intent = getIntent();
                nomJoueur1 = intent.getStringExtra("nomDuJoueur1");
                nomJoueur2 = intent.getStringExtra("nomDuJoueur2");

                textJoueur1.setText(nomJoueur1);
                textJoueur2.setText(nomJoueur2);

                scoreSet1Joueur1 = (TextView) findViewById(R.id.scoreSet1Joueur1);
                scoreSet2Joueur1 = (TextView) findViewById(R.id.scoreSet2Joueur1);
                scoreSet3Joueur1 = (TextView) findViewById(R.id.scoreSet3Joueur1);
                scoreJeuJoueur1 = (TextView) findViewById(R.id.scoreJeuJoueur1);

                scoreSet1Joueur2 = (TextView) findViewById(R.id.scoreSet1Joueur2);
                scoreSet2Joueur2 = (TextView) findViewById(R.id.scoreSet2Joueur2);
                scoreSet3Joueur2 = (TextView) findViewById(R.id.scoreSet3Joueur2);
                scoreJeuJoueur2 = (TextView) findViewById(R.id.scoreJeuJoueur2);

                premiereBalle = (Button) findViewById(R.id.premiereBalle);
                deuxiemeBalle = (Button) findViewById(R.id.deuxiemeBalle);
                doubleFaute = (Button) findViewById(R.id.doubleFaute);
                acePremiereBalle = (Button) findViewById(R.id.acePremiereBalle);
                aceDeuxiemeBalle = (Button) findViewById(R.id.aceDeuxiemeBalle);
                pointGagnantJoueur1 = (Button) findViewById(R.id.pointGagnantJoueur1);
                pointGagnantJoueur2 = (Button) findViewById(R.id.pointGagnantJoueur2);
                fauteDirecteJoueur1 = (Button) findViewById(R.id.fauteDirectJoueur1);
                fauteDirecteJoueur2 = (Button) findViewById(R.id.fauteDirectJoueur2);
                fauteProvoqueeJoueur1 = (Button) findViewById(R.id.fauteProvoqueeJoueur1);
                fauteProvoqueeJoueur2 = (Button) findViewById(R.id.fauteProvoqueeJoueur2);

                premiereBalle.setOnClickListener(this);
                deuxiemeBalle.setOnClickListener(this);
                doubleFaute.setOnClickListener(this);
                acePremiereBalle.setOnClickListener(this);
                aceDeuxiemeBalle.setOnClickListener(this);
                pointGagnantJoueur1.setOnClickListener(this);
                pointGagnantJoueur2.setOnClickListener(this);
                fauteDirecteJoueur1.setOnClickListener(this);
                fauteDirecteJoueur2.setOnClickListener(this);
                fauteProvoqueeJoueur2.setOnClickListener(this);
                fauteProvoqueeJoueur1.setOnClickListener(this);


                // on fait appel à un nouveau service système pour accéder à localisation
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                // on cherche un provider
                ArrayList<LocationProvider> providers = new ArrayList<LocationProvider>();
                ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);
                for (String name : names) providers.add(locationManager.getProvider(name));


                /*
        locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                        double lat = location.getLatitude();
                        double longi = location.getLongitude();

                        longitude.setText(" longitude:" + longi);
                        latitude.setText(" latitude:" + lat);
                        //localisation.setText("Latitude:" + latitude + " longitude" + longitude);
                }


                locationListener = new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                                double lat = location.getLatitude();
                                double longi = location.getLongitude();
                                longitude.setText(" longitude:" + longi);
                                latitude.setText(" latitude:" + lat);
                                //localisation.setText("Latitude:" + latitude + " longitude" + longitude);
                        }


                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                        }

                        // check si GPS est on
                        @Override
                        public void onProviderDisabled(String provider) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                        }
                };

                // attributs: provider, nb de sec entre chaque refresh, distance à laquelle on update position, listener
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.INTERNET
                                }, 10);
                                return;
                        }
                        else {
                                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 150, locationListener);
                        }
                }
        } */


        }


        public void onClick(View v)
        {

                switch (v.getId())
                {
                        case R.id.premiereBalle :
                              //premier service
                        break;

                        case R.id.deuxiemeBalle :
                                //deuxieme service
                        break;

                        case R.id.doubleFaute :

                                if(joueur1)
                                {
                                        if(scoreJoueur2 == 40)
                                        {
                                               joueur1 = !joueur1;
                                        }
                                        if(numeroDeJeu == NumeroJeu.SET1)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet1Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet1Joueur2.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET2;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }
                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET2)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet2Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet2Joueur2.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET3;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }
                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET3)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet3Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet3Joueur2.getText().toString());
                                                }
                                        }


                                        scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur1 = 0;
                                                scoreJeuJoueur1.setText("0");
                                        }
                                }
                                else
                                {
                                        if(scoreJoueur1 == 40)
                                        {
                                                joueur1 = !joueur1;
                                        }

                                        if(numeroDeJeu == NumeroJeu.SET1)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet1Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if (scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet1Joueur1.getText().toString());
                                                }
                                                if(scoreJoueur1Jeu == 6 || scoreJoueur2Jeu==6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET2;
                                                        scoreJoueur1Jeu = 0;
                                                        scoreJoueur2Jeu = 0;
                                                }

                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET2)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet2Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if (scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet2Joueur1.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET3;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }

                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET3)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet3Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if(scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet3Joueur1.getText().toString());
                                                }
                                        }

                                        scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                        if(scoreJoueur1 == 0)
                                        {
                                                scoreJoueur2 = 0;
                                                scoreJeuJoueur2.setText("0");
                                        }

                                }

                                break;
                        case R.id.acePremiereBalle :

                        case R.id.aceDeuxiemeBalle :


                                if(!joueur1)
                                {
                                        if(scoreJoueur2 == 40)
                                        {
                                                joueur1 = !joueur1;
                                        }

                                        if(numeroDeJeu == NumeroJeu.SET1)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet1Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet1Joueur2.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET2;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }
                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET2)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet2Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet2Joueur2.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET3;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }
                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET3)
                                        {
                                                marqueUnPoint(scoreJeuJoueur2, scoreSet3Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                                if(scoreJoueur2 == 0)
                                                {
                                                        scoreJoueur2Jeu = Integer.parseInt(scoreSet3Joueur2.getText().toString());
                                                }
                                        }

                                        scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur1 = 0;
                                                scoreJeuJoueur1.setText("0");
                                        }
                                }
                                else
                                {
                                        if(scoreJoueur1 == 40)
                                        {
                                                joueur1 = !joueur1;
                                        }

                                        if(numeroDeJeu == NumeroJeu.SET1)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet1Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if(scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet1Joueur1.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET2;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }
                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET2)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet2Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if (scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet2Joueur1.getText().toString());
                                                }
                                                if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                                {
                                                        numeroDeJeu = NumeroJeu.SET3;
                                                        scoreJoueur2Jeu = 0;
                                                        scoreJoueur1Jeu = 0;
                                                }

                                        }
                                        else if (numeroDeJeu == NumeroJeu.SET3)
                                        {
                                                marqueUnPoint(scoreJeuJoueur1, scoreSet3Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                                scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                                if(scoreJoueur1 == 0)
                                                {
                                                        scoreJoueur1Jeu = Integer.parseInt(scoreSet3Joueur1.getText().toString());
                                                }
                                        }
                                        if(scoreJoueur1 == 0)
                                        {
                                                scoreJoueur2 = 0;
                                                scoreJeuJoueur2.setText("0");
                                        }
                                }
                                break;

                        case R.id.fauteDirectJoueur2 :

                        case R.id.pointGagnantJoueur1 :

                        case R.id.fauteProvoqueeJoueur2 :

                        {
                                if(scoreJoueur1 == 40)
                                {
                                        joueur1 = !joueur1;
                                }

                                if(numeroDeJeu == NumeroJeu.SET1)
                                {
                                        marqueUnPoint(scoreJeuJoueur1, scoreSet1Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                        scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                        if(scoreJoueur1 == 0)
                                        {
                                                scoreJoueur1Jeu = Integer.parseInt(scoreSet1Joueur1.getText().toString());
                                        }
                                        if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                        {
                                                numeroDeJeu = NumeroJeu.SET2;
                                                scoreJoueur2Jeu = 0;
                                                scoreJoueur1Jeu = 0;
                                        }
                                }
                                else if (numeroDeJeu == NumeroJeu.SET2)
                                {
                                        marqueUnPoint(scoreJeuJoueur1, scoreSet2Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                        scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                        if (scoreJoueur1 == 0)
                                        {
                                                scoreJoueur1Jeu = Integer.parseInt(scoreSet2Joueur1.getText().toString());
                                        }
                                        if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                        {
                                                numeroDeJeu = NumeroJeu.SET3;
                                                scoreJoueur2Jeu = 0;
                                                scoreJoueur1Jeu = 0;
                                        }

                                }
                                else if (numeroDeJeu == NumeroJeu.SET3)
                                {
                                        marqueUnPoint(scoreJeuJoueur1, scoreSet3Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                        scoreJoueur1 = Integer.parseInt(scoreJeuJoueur1.getText().toString());
                                        if(scoreJoueur1 == 0)
                                        {
                                                scoreJoueur1Jeu = Integer.parseInt(scoreSet3Joueur1.getText().toString());
                                        }
                                }
                                if(scoreJoueur1 == 0)
                                {
                                        scoreJoueur2 = 0;
                                        scoreJeuJoueur2.setText("0");
                                }
                        }
                                break;

                        case R.id.fauteDirectJoueur1 :

                        case R.id.pointGagnantJoueur2 :

                        case R.id.fauteProvoqueeJoueur1 :

                        {
                                if(scoreJoueur2 == 40)
                                {
                                        joueur1 = !joueur1;
                                }

                                if(numeroDeJeu == NumeroJeu.SET1)
                                {
                                        marqueUnPoint(scoreJeuJoueur2, scoreSet1Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                        scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur2Jeu = Integer.parseInt(scoreSet1Joueur2.getText().toString());
                                        }
                                        if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                        {
                                                numeroDeJeu = NumeroJeu.SET2;
                                                scoreJoueur2Jeu = 0;
                                                scoreJoueur1Jeu = 0;
                                        }
                                }
                                else if (numeroDeJeu == NumeroJeu.SET2)
                                {
                                        marqueUnPoint(scoreJeuJoueur2, scoreSet2Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                        scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur2Jeu = Integer.parseInt(scoreSet2Joueur2.getText().toString());
                                        }
                                        if(scoreJoueur2Jeu == 6 || scoreJoueur1Jeu == 6)
                                        {
                                                numeroDeJeu = NumeroJeu.SET3;
                                                scoreJoueur2Jeu = 0;
                                                scoreJoueur1Jeu = 0;
                                        }
                                }
                                else if (numeroDeJeu == NumeroJeu.SET3)
                                {
                                        marqueUnPoint(scoreJeuJoueur2, scoreSet3Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                        scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur2Jeu = Integer.parseInt(scoreSet3Joueur2.getText().toString());
                                        }
                                }

                                scoreJoueur2 = Integer.parseInt(scoreJeuJoueur2.getText().toString());
                                if(scoreJoueur2 == 0)
                                {
                                        scoreJoueur1 = 0;
                                        scoreJeuJoueur1.setText("0");
                                }
                        }
                                break;


                }


        }


        public void marqueUnPoint (TextView scoreJeuJoueur, TextView scoreSetJoueur, int scoreJoueur, int scoreJoueurJeu)
        {

                        if(scoreJoueur == 0)
                        {
                                scoreJoueur=15;

                        }
                        else if(scoreJoueur == 15)
                        {
                                scoreJoueur =30;
                        }
                        else if (scoreJoueur == 30)
                        {
                                scoreJoueur =40;
                        }
                        else if(scoreJoueur == 40)
                        {
                                scoreJoueur = 0;
                                scoreJoueurJeu++;
                                scoreSetJoueur.setText(String.valueOf(scoreJoueurJeu));

                        }
                        scoreJeuJoueur.setText(String.valueOf(scoreJoueur));

        }
        public void takePicture()
        {
                Intent intent = new Intent(this, Photo.class);
                startActivity(intent);
        }

        public void finir(){

                // ENREGISTREMENT DANS LA BDD

                databaseManager = new DatabaseManager(this);
                databaseManager.insertMatch( nomJoueur1, nomJoueur2, "oui", "non",
                        scoreSet1Joueur1.getText().toString(), scoreSet2Joueur1.getText().toString(), scoreSet3Joueur1.getText().toString(), scoreSet1Joueur2.getText().toString(), scoreSet2Joueur2.getText().toString(), scoreSet3Joueur2.getText().toString());
                Log.d("joueur1", nomJoueur1);
                Log.d("joueur2", nomJoueur2);

                matches = databaseManager.readMatch(); // Récuperation de liste d'array de match
                Match match = new Match();
                match = matches.get(0); // récupère le match qu'on vient d'ajouter
                Log.d("InEnregistrement", match.toString());
                databaseManager.close();

                // ENVOI MATCH POUR AFFICHAGE STATISTIQUES
               // Log.d("EnregistrementFinir", match.toString());
                Intent intent = new Intent(this, Statistiques.class);
                intent.putExtra("match", match);
                startActivity(intent);
        }

}



