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

                onBackPressed();
            }
        });

    }

    public void checkIfClicked(View view)
    {
        boolean checked =((RadioButton) view).isChecked();
        Intent intent = new Intent(this, EnterData.class);
        String boutonCoché;
        switch(view.getId())
        {
            case R.id.tb66a :
                if(checked)
                {
                     boutonCoché = "tb66a";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;

            case R.id.tb55a :
                if(checked)
                {
                     boutonCoché = "tb55a";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;

            case R.id.tb44a :
                if(checked)
                {
                     boutonCoché = "tb44a";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;

            case R.id.tb44 :
                if(checked)
                {
                     boutonCoché = "tb44";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;

            case R.id.tb33 :
                if(checked)
                {
                     boutonCoché = "tb33";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;

            case R.id.tb22 :
                if(checked)
                {
                     boutonCoché = "tb22";
                    intent.putExtra("boutonCoché", boutonCoché);
                }
                break;
        }
        startActivity(intent);
    }

}
