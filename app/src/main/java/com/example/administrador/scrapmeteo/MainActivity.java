package com.example.administrador.scrapmeteo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;




public class MainActivity extends AppCompatActivity {


    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toLluvias(View view) {
        Intent next = new Intent(this, Main2Activity.class);
        startActivity(next);
    }

    public void toTest(View view) {
        Intent next = new Intent(this, Main3Activity.class);
        startActivity(next);
    }
}
