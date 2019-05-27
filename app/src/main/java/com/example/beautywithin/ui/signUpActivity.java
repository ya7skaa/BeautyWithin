package com.example.beautywithin.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beautywithin.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import bolts.Task;
import butterknife.BindView;
import butterknife.ButterKnife;

public class signUpActivity extends AppCompatActivity {
    private static final int MY_REQUEST_CODE =7000 ;
    List<AuthUI.IdpConfig> providers;


    @BindView(R.id.signUpButton) Button msignUpButton;
//    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.intro) TextView mAppNameTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOptions();


        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Beauty.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        msignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AuthUI.getInstance()
                       .signOut(signUpActivity.this)
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                               msignUpButton.setEnabled(false);
                               showSignInOptions();
                           }
                       }).addOnFailureListener(new OnFailureListener(){
                           @Override
                   public void onFailure (@NonNull Exception e){
                               Toast.makeText(signUpActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                           }

               });


            }
        });
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTheme(R.style.MyTheme)
                .build(),MY_REQUEST_CODE
        );


}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)   {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQUEST_CODE)
        {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if(resultCode == RESULT_OK)
            {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                 Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
                 msignUpButton.setEnabled(true);

            }
            else
            {
                Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
