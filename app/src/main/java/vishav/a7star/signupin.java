package vishav.a7star;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class signupin extends AppCompatActivity {
    Button signIn, singUp;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(signupin.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_signupin);
        signIn = findViewById(R.id.sgnin);
        singUp = findViewById(R.id.sgnup);
        singUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupin.this,signupA.class));
            }
        });
        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signupin.this,login.class));
            }
        });

    }
}
