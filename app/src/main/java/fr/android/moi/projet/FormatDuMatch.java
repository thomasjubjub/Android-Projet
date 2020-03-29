package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class FormatDuMatch extends AppCompatActivity {

    private RadioButton tb66a;
    private RadioButton tb55a;
    private RadioButton tb44a;
    private RadioButton tb44;
    private RadioButton tb33;
    private RadioButton tb22;

    private ImageButton retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format_du_match);

        tb66a = (RadioButton) findViewById(R.id.tb66a);
        tb55a = (RadioButton) findViewById(R.id.tb55a);
        tb44a = (RadioButton) findViewById(R.id.tb44a);
        tb44 = (RadioButton) findViewById(R.id.tb44);
        tb33 = (RadioButton) findViewById(R.id.tb33);
        tb22 = (RadioButton) findViewById(R.id.tb22);





        retour = (ImageButton) findViewById(R.id.imageBack);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                checkIfClicked();
            }
        });

    }

    public void checkIfClicked()
    {
        Intent intent = new Intent(this, EnterData.class);
        String typeMatchChoisi;

        if(tb66a.isChecked())
        {
            typeMatchChoisi = "tb66a";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }
        else if(tb55a.isChecked())
        {
            typeMatchChoisi = "tb55a";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }
        else if(tb44a.isChecked())
        {
            typeMatchChoisi = "tb44a";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }
        else if (tb44.isChecked())
        {
            typeMatchChoisi = "tb44";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }
        else if(tb33.isChecked())
        {
            typeMatchChoisi = "tb33";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }
        else if(tb22.isChecked())
        {
            typeMatchChoisi = "tb22";
            intent.putExtra("typeMatchChoisi", typeMatchChoisi);
        }


        startActivity(intent);
    }

}
