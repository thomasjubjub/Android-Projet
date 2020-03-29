package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class FormatDuDernierSet extends AppCompatActivity {

    private ImageButton retour;
    private RadioButton setNormal;
    private RadioButton tieBreak7Points;
    private RadioButton superTierBreak10Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format_du_dernier_set);

        setNormal = (RadioButton) findViewById(R.id.setNormal);
        tieBreak7Points =(RadioButton) findViewById(R.id.tieBreak7Points);
        superTierBreak10Points = (RadioButton) findViewById(R.id.superTieBreak10Points);

        retour = (ImageButton) findViewById(R.id.imageBack);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfClicked();
            }
        });
    }

    private void checkIfClicked() {
        Intent intent = new Intent(this, EnterData.class);
        String setChoisi;
        if(setNormal.isChecked())
        {
            setChoisi="setNormal";
            intent.putExtra("setChoisi", setChoisi);
        }
        else if(tieBreak7Points.isChecked())
        {
            setChoisi="tieBreak7Points";
            intent.putExtra("setChoisi", setChoisi);
        }
        else if(superTierBreak10Points.isChecked())
        {
            setChoisi="superTierBreak10Points";
            intent.putExtra("setChoisi", setChoisi);
        }

        startActivity(intent);
    }
}
