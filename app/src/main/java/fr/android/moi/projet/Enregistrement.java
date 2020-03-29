package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class Enregistrement extends AppCompatActivity {

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



        @SuppressLint("MissingPermission")
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


                // on fait appel à un nouveau service système pour accéder à localisation
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                // on cherche un provider
                ArrayList<LocationProvider> providers = new ArrayList<LocationProvider>();
                ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);
                for (String name : names) providers.add(locationManager.getProvider(name));

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
                }

        }

        public void takePicture()
        {
                Intent intent = new Intent(this, Photo.class);
                startActivity(intent);
        }

}



