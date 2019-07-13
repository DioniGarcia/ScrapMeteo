package com.example.administrador.scrapmeteo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main3Activity extends AppCompatActivity {
    TextView texVista, texXodos, texAdz,texVf,texValde, texVm, texOnd, texAlc, texTor, texPue, texMos, texMon, texBron;
    Button but;
    private static final String TAG = "Main3Activity";

    private Map<String,String> estaciones = new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        texVista = (TextView) findViewById(R.id.t1);
        texXodos = (TextView) findViewById(R.id.t2);
        texAdz = (TextView) findViewById(R.id.t3);
        texVf = (TextView) findViewById(R.id.t4);
        texValde = (TextView) findViewById(R.id.t5);
        texVm = (TextView) findViewById(R.id.t6);
        texOnd = (TextView) findViewById(R.id.t7);
        texAlc = (TextView) findViewById(R.id.t8);
        texTor = (TextView) findViewById(R.id.t9);
        texPue = (TextView) findViewById(R.id.t10);
        texMos = (TextView) findViewById(R.id.t11);
        texMon = (TextView) findViewById(R.id.t12);
        texBron = (TextView) findViewById(R.id.t13);

        estaciones.put("Vistabella","https://www.avamet.org/mxo_i.php?id=c04m139e01");
        estaciones.put("Xodos","https://www.avamet.org/mxo_i.php?id=c04m055e02");
        estaciones.put("Atzeneta","https://www.avamet.org/mxo_i.php?id=c04m001e02");
        estaciones.put("Valdelinares","https://www.avamet.org/mxo_i.php?id=c99m044e15");
        estaciones.put("Villamalur","https://www.avamet.org/mxo_i.php?id=c08m131e01");

        estaciones.put("Onda","https://www.avamet.org/mxo_i.php?id=c06m084e02");
        estaciones.put("Alcalá de la selva","https://www.avamet.org/mxo_i.php?id=c99m044e01");
        estaciones.put("El Toro","https://www.avamet.org/mxo_i.php?id=c07m115e01");
        estaciones.put("Puebla de San Miguel","https://www.avamet.org/mxo_i.php?id=c09m201e01");
        estaciones.put("Villafranca","http://www.aemet.es/va/eltiempo/observacion/ultimosdatos?k=val&l=8489X&w=1&datos=img");
        estaciones.put("Mosqueruela","http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=1&datos=img");
        estaciones.put("Montanejos","http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=val&l=8472A&w=1&datos=img&f=tmax");
        estaciones.put("Bronchales","https://meteosabi.es/el-tiempo-en-bronchales-teruel");


        but = (Button) findViewById(R.id.b1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        new doit().execute();

    }

    public class doit extends AsyncTask<Void,Void,Void>{

        public String [] stats = {"Vistabella","Xodos","Atzeneta","Valdelinares","Villamalur","Onda","Alcalá de la selva",
                "El Toro","Puebla de San Miguel","Villafranca","Mosqueruela","Montanejos", "Bronchales"};

        String textIncomeVista = "";
        String textIncomeXodos= "";
        String textIncomeAtz= "";
        String textIncomeVf= "";
        String textIncomeVal= "";
        String textIncomeVm= "";
        String textIncomeAlc= "";
        String textIncomeOnd= "";
        String textIncomePue= "";
        String textIncomeTor= "";
        String textIncomeMos= "";
        String textIncomeMon= "";
        String textIncomeBron= "";

        @Override
        protected Void doInBackground(Void... voids) {
            int i = 0;

            textIncomeVista = "Vistabella: "+isOnline(estaciones.get(stats[0]));
            textIncomeXodos= "Xodos: "+isOnline(estaciones.get(stats[1]));
            textIncomeAtz= "Atzeneta: "+isOnline(estaciones.get(stats[2]));
            textIncomeVf= "Villafranca: "+isOnline(estaciones.get(stats[9]));
            textIncomeVal= "Valdelinares: "+isOnline(estaciones.get(stats[3]));
            textIncomeVm= "Villamalur: "+isOnline(estaciones.get(stats[4]));
            textIncomeAlc= "Alcalá de la selva: "+isOnline(estaciones.get(stats[6]));
            textIncomeOnd="Onda: "+isOnline(estaciones.get(stats[5]));
            textIncomePue= "Puebla de San Miguel: "+isOnline(estaciones.get(stats[8]));
            textIncomeTor= "El Toro: "+isOnline(estaciones.get(stats[7]));
            textIncomeMos= "Mosqueruela: "+isOnline(estaciones.get(stats[10]));
            textIncomeMon= "Montanejos: "+isOnline(estaciones.get(stats[11]));
            textIncomeBron= "Bronchales: "+isOnline(estaciones.get(stats[12]));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            texVista.setText(textIncomeVista);
            texXodos.setText(textIncomeXodos);
            texAdz.setText(textIncomeAtz);
            texValde.setText(textIncomeVal);
            texVm.setText(textIncomeVm);
            texAlc.setText(textIncomeAlc);
            texOnd.setText(textIncomeOnd);
            texTor.setText(textIncomeTor);
            texPue.setText(textIncomePue);
            texVf.setText(textIncomeVm);
            texMos.setText(textIncomeMos);
            texMon.setText(textIncomeMon);
            texBron.setText(textIncomeBron);

            Toast.makeText(getApplicationContext(),"TESTING OK" ,Toast.LENGTH_LONG).show();

        }

        public String cutBeforeData(String orgData){
            int idx = 0;
            for (int i=0;i<orgData.length();i++){
                if (Character.isDigit(orgData.charAt(i))) {
                    idx = i;
                    break;
                }
            }
            // Contemplar temperaturas negativas
            if (idx != 0 && orgData.charAt(idx-1) == '-'){
                return orgData.substring(idx-1,orgData.length());
            }
            return orgData.substring(idx,orgData.length());
        }


        public String isOnline(String url){
            try {
                Connection conn = Jsoup.connect(url);
                conn.timeout(1500);
                Document doc = conn.get();
            }
            catch (Exception e) {

                return "NOT WORKING";
            }
            return "WORKING OK!";
        }
    }
}
