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

public class Statistiques extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private List<Match> matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        // Récuperation de la bdd
        databaseManager = new DatabaseManager(this);
        matches = databaseManager.readMatch();
        Log.d("InHistorique", matches.toString());
        databaseManager.close();
    }
}
