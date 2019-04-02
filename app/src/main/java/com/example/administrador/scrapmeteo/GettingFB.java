package com.example.administrador.scrapmeteo;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class GettingFB {

    private int month;
    private ArrayList<Double> monthly;
    private ArrayList<Double> anuals;
    private FirebaseFirestore db;
    private Map<String, Object> rains;






    public GettingFB(){
        monthly = new ArrayList<>();
        anuals = new ArrayList<>();
        month= Integer.parseInt(new SimpleDateFormat("dd-MM-yyyy").format(new Date()).split("-")[1]) -1;
        db = FirebaseFirestore.getInstance();
        rains = new HashMap<>();
    }

    public ArrayList<Double> getMonthly(){
        return monthly;
    }

    public ArrayList<Double> getAnnuals(){
        return monthly;
    }

    public void fillData(){
        DocumentReference docRef = db.collection("Lluvias").document("Estaciones");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        rains = document.getData();

                        Log.d(TAG,"twe_DONE_accediendo FB!!!!");

                        //Log.d(TAG,"twe_"+rains.toString());

                        ArrayList<Double> ad = null;

                        // fill anuals
                        for(int stat=0; stat<= 12; stat++){
                            ad =(ArrayList<Double>) rains.get("E"+Integer.toString(stat));
                            Double total = 0.0;
                            for (Double numb : ad){
                                total+=numb;
                            }
                            anuals.add(stat, total);
                            monthly.add(stat, ad.get(month));
                        }
                        Log.d(TAG,"twe: "+anuals.toString());
                        Log.d(TAG,"twe: "+monthly.toString());


                    } else {
                        Log.d(TAG, "twe No ENCUENTRA LA BBDD");
                    }
                } else {
                    Log.d(TAG, "twe ERROR DE DATOS ", task.getException());
                }
            }
        });
    }
}
