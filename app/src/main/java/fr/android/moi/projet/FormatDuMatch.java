package fr.android.moi.projet;

import androidx.appcompat.app.AppCompatActivity;

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
                onBackPressed();
            }
        });

    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.tb66a :
                if(checked)
                {

                }
        }
    }
}
