package app.com.example.pooja.loginfeatureplusdbconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText Username,Password;
    TextView RegisterLink;
    DatabaseHelper helperdb=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = (EditText) findViewById(R.id.lUsername);
        Password = (EditText) findViewById(R.id.lPassword);
        btnLogin = (Button) findViewById(R.id.blogin);
        RegisterLink = (TextView) findViewById(R.id.reghere);

        btnLogin.setOnClickListener(this);
        RegisterLink.setOnClickListener(this);
    }

        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.blogin:
                    Username = (EditText) findViewById(R.id.lUsername);
                    String strUsername=Username.getText().toString();
                    Password = (EditText) findViewById(R.id.lPassword);
                    String strPassword=Password.getText().toString();
                    String password=helperdb.searchUser(strUsername);
                    if(password.equals(strPassword))
                    {
                        Intent i=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        {
                            Toast pass= Toast.makeText(LoginActivity.this,"Username and Password Don't match.Please register",Toast.LENGTH_SHORT);
                            pass.show();

                        }
                    }


                    break;

                case R.id.reghere:

                    startActivity(new Intent(this, RegisterActivity.class));

                    break;
            }

        }

}
