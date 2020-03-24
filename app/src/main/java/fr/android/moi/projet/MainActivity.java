package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nouveauMatch;
    private Button historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nouveauMatch=(Button) findViewById(R.id.newMatch);
        historique=(Button) findViewById(R.id.historique);

        nouveauMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterData();
            }
        });
    }

    public void enterData()
    {
        Intent intent = new Intent(this, EnterData.class);
        startActivity(intent);
    }


}
