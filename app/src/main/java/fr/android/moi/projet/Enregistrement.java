package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.View.OnClickListener;

public class Enregistrement extends AppCompatActivity implements OnClickListener {

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

        private Button premiereBalle;
        private Button deuxiemeBalle;
        private Button doubleFaute;
        private Button acePremiereBalle;
        private Button aceDeuxiemeBalle;

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




      //  @SuppressLint("MissingPermission")
        @Override
        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_enregistrement);

                longitude=(TextView) findViewById(R.id.longi);
                latitude=(TextView) findViewById(R.id.lat);
                buttonPhoto=(ImageButton) findViewById(R.id.imagePhoto);


                buttonPhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                takePicture();
                        }
                });

                longitude = (TextView) findViewById(R.id.longi);
                latitude = (TextView) findViewById(R.id.lat);

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

                premiereBalle.setOnClickListener(this);
                deuxiemeBalle.setOnClickListener(this);
                doubleFaute.setOnClickListener(this);
                acePremiereBalle.setOnClickListener(this);
                aceDeuxiemeBalle.setOnClickListener(this);


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
                } else {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 150, locationListener);
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
                                /*
                                if(joueur1 == false)
                                {
                                        if(scoreJoueur1 == 0)
                                        {
                                                scoreJoueur1=15;

                                        }
                                        else if(scoreJoueur1 == 15)
                                        {
                                                scoreJoueur1 =30;
                                        }
                                        else if (scoreJoueur1 == 30)
                                        {
                                                scoreJoueur1 =40;
                                        }
                                        else if(scoreJoueur1 == 40)
                                        {
                                                scoreJoueur1 = 0;
                                                scoreJoueur1Jeu++;
                                                scoreSet1Joueur1.setText(String.valueOf(scoreJoueur1Jeu));
                                                joueur1 = true;
                                        }
                                        scoreJeuJoueur1.setText(String.valueOf(scoreJoueur1));
                                }
                                else if(joueur1 == true)
                                {
                                        if(scoreJoueur2 == 0)
                                        {
                                                scoreJoueur2=15;

                                        }
                                        else if(scoreJoueur2 == 15)
                                        {
                                                scoreJoueur2 =30;
                                        }
                                        else if (scoreJoueur2 == 30)
                                        {
                                                scoreJoueur2 =40;
                                        }
                                        else if(scoreJoueur2 == 40)
                                        {
                                                scoreJoueur2 = 0;
                                                scoreJoueur2Jeu++;
                                                scoreSet1Joueur2.setText(String.valueOf(scoreJoueur2Jeu));
                                                joueur1 = true;
                                        }
                                        scoreJeuJoueur2.setText(String.valueOf(scoreJoueur2));
                                }
                                */
                                if(joueur1 == true)
                                {
                                        siDoubleFaute(scoreJeuJoueur1, scoreSet1Joueur1, scoreJoueur1, scoreJoueur1Jeu);
                                }
                                else if (joueur1 == false)
                                {
                                        siDoubleFaute(scoreJeuJoueur2, scoreSet1Joueur2, scoreJoueur2, scoreJoueur2Jeu);
                                }

                                break;
                        case R.id.acePremiereBalle :
                                if(joueur1 == false)
                                {
                                        switch (scoreJoueur2)
                                        {
                                                case 0 :
                                                        scoreJoueur2 = 15;
                                                        break;

                                                case 15 :
                                                        scoreJoueur2 = 30;
                                                        break;

                                                case 30 :
                                                        scoreJoueur2 = 40;
                                                        break;

                                                case 40 : scoreJoueur2 = 0;
                                                scoreJoueur2Jeu ++;
                                                scoreSet1Joueur2.setText(String.valueOf(scoreJoueur2Jeu));
                                                joueur1 = true;
                                                break;

                                        }
                                        scoreJeuJoueur2.setText(String.valueOf(scoreJoueur2));
                                }
                                else if (joueur1 == true)
                                {
                                        switch (scoreJoueur1)
                                        {
                                                case 0 :
                                                        scoreJoueur1 = 15;
                                                        break;

                                                case 15 :
                                                        scoreJoueur1 = 30;
                                                        break;

                                                case 30 :
                                                        scoreJoueur1 = 40;
                                                        break;

                                                case 40 : scoreJoueur1 = 0;
                                                        scoreJoueur1Jeu ++;
                                                        scoreSet1Joueur1.setText(String.valueOf(scoreJoueur1Jeu));
                                                        joueur1 = true;
                                                        break;

                                        }
                                        scoreJeuJoueur1.setText(String.valueOf(scoreJoueur1));

                                }
                                break;

                        case R.id.aceDeuxiemeBalle :
                                if(joueur1 == true)
                                {
                                        switch (scoreJoueur1)
                                        {
                                                case 0 :
                                                        scoreJoueur1 = 15;
                                                        break;

                                                case 15 :
                                                        scoreJoueur1 = 30;
                                                        break;

                                                case 30 :
                                                        scoreJoueur1 = 40;
                                                        break;

                                                case 40 :
                                                        scoreJoueur1 = 0;
                                                        scoreJoueur1Jeu++;
                                                        scoreSet1Joueur1.setText(String.valueOf(scoreJoueur1Jeu));
                                                        joueur1 = false;
                                                        break;

                                        }
                                        scoreJeuJoueur1.setText(String.valueOf(scoreJoueur1));
                                }

                                else if(joueur1 == false)
                                        {

                                        }

                }

        }


        public void siDoubleFaute (TextView scoreJeuJoueur, TextView scoreSetJoueur, int scoreJoueur, int scoreJoueurJeu)
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
                                joueur1 = true;
                        }
                        scoreJeuJoueur.setText(String.valueOf(scoreJoueur));

        }
        public void takePicture()
        {
                Intent intent = new Intent(this, Photo.class);
                startActivity(intent);
        }

}




