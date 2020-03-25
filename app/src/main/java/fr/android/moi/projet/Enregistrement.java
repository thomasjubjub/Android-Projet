package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Enregistrement extends AppCompatActivity {

        private ImageButton menu;
        private TextView nomJoueur1;
        private TextView nomJoueur2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_enregistrement);

                nomJoueur1 = (TextView) findViewById(R.id.textJoueur1);
                nomJoueur2 = (TextView) findViewById(R.id.textJoueur2);

                Intent intent = getIntent();

                String joueur1 = intent.getStringExtra("nomDuJoueur1");
                nomJoueur1.setText(joueur1);
                String joueur2 = intent.getStringExtra("nomDuJoueur2");
                nomJoueur2.setText(joueur2);

                menu = findViewById(R.id.imageMenu);
                menu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                deploiement();
                        }
                });


        }

        public void deploiement() {

        }


}
