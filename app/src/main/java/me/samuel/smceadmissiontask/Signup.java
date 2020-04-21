package me.samuel.smceadmissiontask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
    private EditText nameEditText, school,dob,group, address, passwordEditText;
    private EditText phoneEditText, emailEditText;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";
    private static final String TAG = "Signup";
    private FirebaseAuth mAuth;
    private  User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    }

    public void submit(View view) {

        passwordEditText =findViewById(R.id.passwordreg);
        dob = (EditText) findViewById(R.id.dobreg);
        group = (EditText) findViewById(R.id.groupreg);
        nameEditText = (EditText) findViewById(R.id.namereg);
        school = (EditText) findViewById(R.id.schoolreg);
        address = (EditText) findViewById(R.id.addressreg);
        phoneEditText = (EditText) findViewById(R.id.phonereg);
        passwordEditText = (EditText) findViewById(R.id.passwordreg);
        emailEditText = (EditText) findViewById(R.id.emailreg);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();

        String  email = emailEditText.getText().toString();
        String   password = passwordEditText.getText().toString();
        String  fname = nameEditText.getText().toString();
        String   phone = phoneEditText.getText().toString();
        String   schoolname = school.getText().toString();
        String   addressname = address.getText().toString();
        String  groupname = group.getText().toString();
        String   dobname = dob.getText().toString();


        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)||TextUtils.isEmpty(fname)||TextUtils.isEmpty(dobname)
                ||TextUtils.isEmpty(phone)||TextUtils.isEmpty(schoolname)||TextUtils.isEmpty(groupname)
                ||TextUtils.isEmpty(addressname)) {
            emailEditText.setError("please fill out these fields");
            passwordEditText.setError("please fill out these fields");
            nameEditText.setError("please fill out these fields");
            phoneEditText.setError("please fill out these fields");
            school.setError("please fill out these fields");
            address.setError("please fill out these fields");
            group.setError("please fill out these fields");
            dob.setError("please fill out these fields");
            return;
        }



        user = new User(fname, email,password,dobname,  phone,schoolname,groupname,addressname);
        registerUser(email,password);

    }


    public void registerUser(String email ,String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(Signup.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    public void updateUI(FirebaseUser currentUser) {
        String keyid = mDatabase.push().getKey();
        mDatabase.child(keyid).setValue(user);
        //adding user info to database
        Intent ProfileIntent = new Intent(this, Profile.class);
        startActivity(ProfileIntent);
    }


}

