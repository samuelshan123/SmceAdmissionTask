package me.samuel.smceadmissiontask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {

private TextView textView,mGrade,myname;
private  DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        textView =(TextView)findViewById(R.id.outOf);

        Intent inten =getIntent();
        int score = inten.getIntExtra("score", 0);
        textView.setText("Your score :"+score);
        mGrade =(TextView)findViewById(R.id.grade);
        /*
        TextView coupondes =(TextView)findViewById(R.id.coupdesc);
        TextView couponcode =(TextView)findViewById(R.id.couponno);

*/ myname =(TextView)findViewById(R.id.nametv);

        Intent inte =getIntent();
        String my = inte.getStringExtra("plyname");
        myname.setText(my);





        textView =(TextView)findViewById(R.id.outOf);
        mGrade =(TextView)findViewById(R.id.grade);
        myname =(TextView)findViewById(R.id.nametv);

        String Score = textView.getText().toString().trim();
        String grade = mGrade.getText().toString().trim();
        String myName = myname.getText().toString().trim();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("RESULTS");


        HashMap<String, String>hashMap =new HashMap<String,String>();
        hashMap.put("Name",myName);
        hashMap.put("Score",Score);
        databaseReference.push().setValue(hashMap);


        Button btn =(Button)findViewById(R.id.button);
        if (score == 9){
            mGrade.setText("Outstanding");
            btn.setVisibility(View.VISIBLE);
            /*
            couponcode.setVisibility(View.INVISIBLE);
            coupondes.setVisibility(View.INVISIBLE);

             */
        }else if (score == 8){
            mGrade.setText("Good Work");
            btn.setVisibility(View.VISIBLE);
            /*
            couponcode.setVisibility(View.INVISIBLE);
            coupondes.setVisibility(View.INVISIBLE);

             */
        }else if (score == 7) {
            mGrade.setText("Good Effort");
            btn.setVisibility(View.VISIBLE);
               /*
            couponcode.setVisibility(View.INVISIBLE);
            coupondes.setVisibility(View.INVISIBLE);

                */

        }else if(score<7) {
            mGrade.setText("Thanks for participating in this contest.You need to score atleast 7.... ");
            mGrade.setTextSize(15);
            btn.setVisibility(View.GONE);
               /*
            couponcode.setVisibility(View.VISIBLE);
            coupondes.setVisibility(View.VISIBLE);

                */

        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        // resume tasks
    }
    @Override
    protected void onPause() {
        super.onPause();
        // pauze tasks
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}
