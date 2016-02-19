package app.com.example.pooja.loginfeatureplusdbconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogout;
    EditText regFirstName,regLastName,regEmailId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regFirstName=(EditText)findViewById(R.id.etfirstname1);
        regLastName=(EditText)findViewById(R.id.etLastname1);
        regEmailId=(EditText)findViewById(R.id.etemailId1);

        btnLogout=(Button)findViewById(R.id.blogOut);


        btnLogout.setOnClickListener(this);



            }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blogOut:

                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}



