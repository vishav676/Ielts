package vishav.a7star;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupA extends AppCompatActivity {
    Button registerHere;
    TextView signIn;
    private FirebaseDatabase mFirebasedatabase;
    private DatabaseReference mMessagesDatabaseReference;
    EditText inputEmail, inputPassword,inputName,inputNumber;
    boolean connected = false;
    FirebaseAuth auth;
    ProgressBar mprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(signupA.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_signup);
        mprogress = findViewById(R.id.pbsignUp);
        mFirebasedatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebasedatabase.getReference().child("users");
        registerHere = findViewById(R.id.Registerhere);
        inputEmail = findViewById(R.id.etrEmail);
        inputPassword = findViewById(R.id.etrPassword);
        inputName = findViewById(R.id.nametv);
        signIn = findViewById(R.id.tvSignUp);
        inputNumber = findViewById(R.id.numberphone);
        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupA.this, login.class));
                finish();
            }
        });
        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = inputEmail.getText().toString();
                String newPassword = inputPassword.getText().toString();
                String UserName = inputName.getText().toString().trim();
                String MobileNumber = inputNumber.getText().toString().trim();
                mprogress.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(newEmail)) {
                    mprogress.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(newPassword)) {
                    mprogress.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (newPassword.length() < 6) {
                    mprogress.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(newEmail, newPassword)
                        .addOnCompleteListener(signupA.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                mprogress.setVisibility(View.INVISIBLE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(signupA.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(signupA.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
                details friendlyMessage = new details(UserName, MobileNumber, null);
                mMessagesDatabaseReference.push().setValue(friendlyMessage);
            }
        });
    }
}
