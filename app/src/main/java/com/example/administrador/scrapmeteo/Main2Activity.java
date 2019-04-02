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
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main2Activity extends AppCompatActivity {
    TextView texVista, texXodos, texAdz,texVf,texValde, texVm, texOnd, texAlc, texTor, texPue, texMos, texMon, texBron;
    Button but;
    private static final String TAG = "Main2Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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

        String textIncomeVista = "NOT WORKING";
        String textIncomeXodos= "NOT WORKING";
        String textIncomeAtz= "NOT WORKING";
        String textIncomeVf= "NOT WORKING";
        String textIncomeVal= "NOT WORKING";
        String textIncomeVm= "NOT WORKING";
        String textIncomeAlc= "NOT WORKING";
        String textIncomeOnd= "NOT WORKING";
        String textIncomePue= "NOT WORKING";
        String textIncomeTor= "NOT WORKING";
        String textIncomeMos= "NOT WORKING";
        String textIncomeMon= "NOT WORKING";
        String textIncomeBron= "NOT WORKING";



        @Override
        protected Void doInBackground(Void... voids) {

            GettingFB gFb = new GettingFB();
            gFb.fillData();

            try{
                int i = 0;
                String titulo="";

                Document docVista = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m139e01").get();

                textIncomeVista = docVista.getElementById("estacio").text();
                textIncomeVista += "\n"+ "Humedad relativa: " + cutBeforeData( docVista.getElementById("hrel").text());
                textIncomeVista += "   Viento: " + cutBeforeData( docVista.getElementById("vent").text());
                textIncomeVista += "\n"+ "Lluvia: " + cutBeforeData( docVista.getElementById("prec").text() );

                for (Element e : docVista.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVista += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeVista += "   Anual: "+  cutBeforeData( e.text() );
                        i=0;
                        break;
                    }
                    i+=1;
                }

                textIncomeVista += "\n"+ "T.Min: " + cutBeforeData( docVista.getElementById("temp_min").text() );
                textIncomeVista += "   T.Max: " + cutBeforeData( docVista.getElementById("temp_max").text() );





                Document docXodos = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m055e02").get();

                textIncomeXodos = docXodos.getElementById("estacio").text();
                textIncomeXodos += "\n"+ "Humedad relativa: " + cutBeforeData( docXodos.getElementById("hrel").text());
                textIncomeXodos += "   Viento: " + cutBeforeData( docXodos.getElementById("vent").text());
                textIncomeXodos += "\n"+ "Lluvia: " + cutBeforeData( docXodos.getElementById("prec").text() );

                i=0;
                for (Element e : docXodos.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeXodos += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeXodos += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }

                textIncomeXodos += "\n"+ "T.Min: " + cutBeforeData( docXodos.getElementById("temp_min").text() );
                textIncomeXodos += "   T.Max: " + cutBeforeData( docXodos.getElementById("temp_max").text() );



                Document docAtz = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m001e02").get();

                textIncomeAtz = docAtz.getElementById("estacio").text();
                textIncomeAtz += "\n"+ "Humedad relativa: " + cutBeforeData( docAtz.getElementById("hrel").text());
                textIncomeAtz += "   Viento: " + cutBeforeData( docAtz.getElementById("vent").text());
                textIncomeAtz += "\n"+ "Lluvia: " + cutBeforeData( docAtz.getElementById("prec").text() );
                i=0;
                for (Element e : docAtz.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeAtz += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeAtz += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeAtz += "\n"+ "T.Min: " + cutBeforeData( docAtz.getElementById("temp_min").text() );
                textIncomeAtz += "   T.Max: " + cutBeforeData( docAtz.getElementById("temp_max").text() );






                Document docVal = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e15").get();

                textIncomeVal = docVal.getElementById("estacio").text();
                textIncomeVal += "\n"+ "Humedad relativa: " + cutBeforeData( docVal.getElementById("hrel").text());
                textIncomeVal += "   Viento: " + cutBeforeData( docVal.getElementById("vent").text());
                textIncomeVal += "\n"+ "Lluvia: " + cutBeforeData( docVal.getElementById("prec").text() );
                i=0;
                for (Element e : docVal.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVal += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeVal += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeVal += "\n"+ "T.Min: " + cutBeforeData( docVal.getElementById("temp_min").text() );
                textIncomeVal += "   T.Max: " + cutBeforeData( docVal.getElementById("temp_max").text() );



                Document docVm = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c08m131e01").get();

                textIncomeVm = docVm.getElementById("estacio").text();
                textIncomeVm += "\n"+ "Humedad relativa: " + cutBeforeData( docVm.getElementById("hrel").text());
                textIncomeVm += "   Viento: " + cutBeforeData( docVm.getElementById("vent").text());
                textIncomeVm += "\n"+ "Lluvia: " + cutBeforeData( docVm.getElementById("prec").text() );
                i=0;
                for (Element e : docVm.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVm += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeVm += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeVm += "\n"+ "T.Min: " + cutBeforeData( docVm.getElementById("temp_min").text() );
                textIncomeVm += "   T.Max: " + cutBeforeData( docVm.getElementById("temp_max").text() );



                Document docOnd= Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c06m084e02").get();

                textIncomeOnd = docOnd.getElementById("estacio").text();
                textIncomeOnd += "\n"+ "Humedad relativa: " + cutBeforeData( docOnd.getElementById("hrel").text());
                textIncomeOnd += "   Viento: " + cutBeforeData( docOnd.getElementById("vent").text());
                textIncomeOnd += "\n"+ "Lluvia: " + cutBeforeData( docOnd.getElementById("prec").text() );
                i=0;
                for (Element e : docOnd.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeOnd += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeOnd += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeOnd += "\n"+ "T.Min: " + cutBeforeData( docOnd.getElementById("temp_min").text() );
                textIncomeOnd += "   T.Max: " + cutBeforeData( docOnd.getElementById("temp_max").text() );



                Document docAlc = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e01").get();

                textIncomeAlc = docAlc.getElementById("estacio").text();
                textIncomeAlc += "\n"+ "Humedad relativa: " + cutBeforeData( docAlc.getElementById("hrel").text());
                textIncomeAlc += "   Viento: " + cutBeforeData( docAlc.getElementById("vent").text());
                textIncomeAlc += "\n"+ "Lluvia: " + cutBeforeData( docAlc.getElementById("prec").text() );
                i=0;
                for (Element e : docAlc.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeAlc += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeAlc += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeAlc += "\n"+ "T.Min: " + cutBeforeData( docAlc.getElementById("temp_min").text() );
                textIncomeAlc += "   T.Max: " + cutBeforeData( docAlc.getElementById("temp_max").text() );




                Document docTor= Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c07m115e01").get();

                textIncomeTor = docTor.getElementById("estacio").text();
                textIncomeTor += "\n"+ "Humedad relativa: " + cutBeforeData( docTor.getElementById("hrel").text());
                textIncomeTor += "   Viento: " + cutBeforeData( docTor.getElementById("vent").text());
                textIncomeTor += "\n"+ "Lluvia: " + cutBeforeData( docTor.getElementById("prec").text() );
                i=0;
                for (Element e : docTor.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeTor += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeTor += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeTor += "\n"+ "T.Min: " + cutBeforeData( docTor.getElementById("temp_min").text() );
                textIncomeTor += "   T.Max: " + cutBeforeData( docTor.getElementById("temp_max").text() );



                Document docPue = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c09m201e01").get();

                textIncomePue = docPue.getElementById("estacio").text();
                textIncomePue += "\n"+ "Humedad relativa: " + cutBeforeData( docPue.getElementById("hrel").text());
                textIncomePue += "   Viento: " + cutBeforeData( docPue.getElementById("vent").text());
                textIncomePue += "\n"+ "Lluvia: " + cutBeforeData( docPue.getElementById("prec").text() );
                i=0;
                for (Element e : docPue.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomePue += "   Mensual: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomePue += "   Anual: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomePue += "\n"+ "T.Min: " + cutBeforeData( docPue.getElementById("temp_min").text() );
                textIncomePue += "   T.Max: " + cutBeforeData( docPue.getElementById("temp_max").text() );





                Document docVf = Jsoup.connect("http://www.aemet.es/va/eltiempo/observacion/ultimosdatos?k=val&l=8489X&w=1&datos=img").get();
                textIncomeVf = "Villafranca del cid";
                String [] meteo = new String[6];

                int idx=0;

                for(Element e : docVf.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeVf+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeVf+="   Lluvia: "+meteo[4]+"mm";
                textIncomeVf+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeVf+="   T.Max: "+meteo[0].split(" ")[0];



                // AEMET Mosqueruela

                Document docMos = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=1&datos=img").get();
                titulo = docMos.getElementsByClass("titulo").text();

                idx=0;
                for(int j=20; j<titulo.length();j++){
                    if (titulo.charAt(j)==' '){
                        idx = j;
                        break;
                    }
                }
                textIncomeMos = titulo.substring(20,idx);

                meteo = new String[6];
                idx=0;

                for(Element e : docMos.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeMos+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMos+="   Lluvia: "+meteo[4]+"mm";
                textIncomeMos+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeMos+="   T.Max: "+meteo[0].split(" ")[0];

                // AEMET Montanejos________________________________________________________________________________

                Document docMon = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=val&l=8472A&w=1&datos=img&f=tmax").get();
                titulo = docMon.getElementsByClass("titulo").text();

                idx=0;
                for(int j=20; j<titulo.length();j++){
                    if (titulo.charAt(j)==' '){
                        idx = j;
                        break;
                    }
                }
                textIncomeMon = titulo.substring(20,idx);

                meteo = new String[6];

                idx=0;

                for(Element e : docMon.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeMon+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMon+="   Lluvia: "+meteo[4]+"mm";
                textIncomeMon+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeMon+="   T.Max: "+meteo[0].split(" ")[0];

                // meteosabi.es________________________________________________________________________________

                Document docBron = Jsoup.connect("https://meteosabi.es/el-tiempo-en-bronchales-teruel").get();
                titulo = "Bronchales (Camping)";
                textIncomeBron = titulo;
                textIncomeBron+= "\nViento: "+docBron.getElementById("WindAverage").text()+"km/h";
                textIncomeBron+="   Lluvia: "+docBron.getElementById("RainToday").text()+"mm";
                textIncomeBron+= "\nT.Min: "+docBron.getElementById("LowTempToday").text();
                textIncomeBron+= "   T.Max: "+docBron.getElementById("HighTempToday").text();

                //Log.d(TAG,"mobilito_"+isOnline2("https://www.avamet.org/mxo_i.php?id=c04m055e02"));
                //Toast.makeText(getApplicationContext()," TOstada!" ,Toast.LENGTH_SHORT).show();


            }catch( Exception e ){

                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            texVista.setText(textIncomeVista);
            texXodos.setText(textIncomeXodos);
            texAdz.setText(textIncomeAtz);
            texValde.setText((textIncomeVal));
            texVm.setText((textIncomeVm));
            texAlc.setText((textIncomeAlc));
            texOnd.setText((textIncomeOnd));
            texTor.setText((textIncomeTor));
            texPue.setText((textIncomePue));
            texVf.setText((textIncomeVf));
            texMos.setText((textIncomeMos));
            texMon.setText(textIncomeMon);
            texBron.setText(textIncomeBron);

            //Toast.makeText(getApplicationContext()," TOAST!" ,Toast.LENGTH_SHORT).show();

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


        public boolean isOnline2(String url){
            try {
                URL myURL = new URL(url);

                URLConnection myURLConnection = myURL.openConnection();
                myURLConnection.setReadTimeout(1500);
                myURLConnection.connect();
            }
            catch (MalformedURLException e) {
                // new URL() failed
                // ...
                return false;
            }
            catch (IOException e) {
                // openConnection() failed
                // ...
                Log.d(TAG,"Fails Connexion IOException HERE!");
                return false;
            }
            return true;
        }
        public boolean isOnline() {
            try {
                int timeoutMs = 1500;
                Socket sock = new Socket();
                SocketAddress sockaddr = new InetSocketAddress("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=1&datos=img", 8080);

                sock.connect(sockaddr, timeoutMs);
                sock.close();

                return true;
            } catch (IOException e) { return false; }
        }
    }
}
