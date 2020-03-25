package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Enregistrement extends AppCompatActivity {

        private TextView longitude;
        private TextView latitude;
        private ImageButton buttonPhoto;
        private LocationManager locationManager;
        private LocationListener locationListener;
        private Camera mCamera = null;


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
                                //takePicture();
                        }
                });

                // on fait appel à un nouveau service système pour accéder à localisation
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                // on cherche un provider
                ArrayList<LocationProvider> providers = new ArrayList<LocationProvider>();
                ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);
                for(String name : names) providers.add(locationManager.getProvider(name));

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
                        public void onStatusChanged(String provider, int status, Bundle extras) { }

                        @Override
                        public void onProviderEnabled(String provider) { }

                        // check si GPS est on
                        @Override
                        public void onProviderDisabled(String provider) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                        }
                };

                // attributs: provider, nb de sec entre chaque refresh, distance à laquelle on update position, listener
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.INTERNET
                                },10);
                                return;
                        }
                        else{
                                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 150, locationListener);
                        }
                }

        }
/*/
        private void takePicture(Camera camera) {
                // Jouera un son au moment où on prend une photo
                Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {
                        public void onShutter() {
                                MediaPlayer media = MediaPlayer.create(getBaseContext(), R.raw.sonnerie);
                                media.start();
                                // Une fois la lecture terminée
                                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        public  void onCompletion(MediaPlayer mp) {
                                                // On libère le lecteur multimédia
                                                mp.release();
                                        }
                                });
                        }
                };

                // Sera lancée une fois l'image traitée, on enregistre l'image sur le support externe
                Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {
                        public void onPictureTaken(byte[] data, Camera camera) {
                                FileOutputStream stream = null;
                                try {
                                        String path = Environment.getExternalStorageDirectory() + "\\photo.jpg";
                                        stream = new FileOutputStream(path);
                                        stream.write(data);
                                } catch (Exception e) {

                                } finally {
                                        try { stream.close();} catch (Exception e) {}
                                }
                        }
                };

                camera.takePicture(shutterCallback, null, jpegCallback);
        }
/*/

}
