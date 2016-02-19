package app.com.example.pooja.loginfeatureplusdbconnection;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button etRegister;
    EditText FirstName,LastName,Emailid,Password,ConfirmPassword;
    String strFirstName,strLastName,strEmailId,strPwd,strConPwd;
    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirstName=(EditText)findViewById(R.id.rfirstname);
        LastName=(EditText)findViewById(R.id.rLastname);
        Emailid=(EditText)findViewById(R.id.remailId);
        Password=(EditText)findViewById(R.id.rPassword);
        ConfirmPassword=(EditText)findViewById(R.id.rRepPassword);
        etRegister=(Button)findViewById(R.id.bRegister);
        strFirstName=FirstName.getText().toString();
        strLastName=LastName.getText().toString();
        strEmailId=Emailid.getText().toString();
        strPwd=Password.getText().toString();
        strConPwd=ConfirmPassword.getText().toString();



        etRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
                if(!strPwd.equals(strConPwd))
                {
                    Toast pass= Toast.makeText(RegisterActivity.this,"Password Don't match",Toast.LENGTH_SHORT);
                    pass.show();
                }
                else
                {
                    //insert data into database
                    User user=new User();
                    user.setFirstName(strFirstName);
                    user.setLastName(strLastName);
                    user.setEmailId(strEmailId);
                    user.setPassword(strPwd);
                    helper.insertUser(user);
                }


                break;
        }
    }
}
