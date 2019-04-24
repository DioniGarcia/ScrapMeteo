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
import java.text.DecimalFormat;
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

    final GettingFB gFb = new GettingFB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gFb.fillData();

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

            try{
                int i = 0;
                String titulo="";

                Document docVista = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m139e01").get();


                textIncomeVista = "San Juan de Peñagolosa";
                textIncomeVista += "\n"+ "Humedad relativa: " + cutBeforeData( docVista.getElementById("hrel").text());
                textIncomeVista += "   Viento: " + cutBeforeData( docVista.getElementById("vent").text());
                textIncomeVista += "\n"+ "Hoy: " + cutBeforeData( docVista.getElementById("prec").text() );

                for (Element e : docVista.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVista += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeVista += "   Año: "+  cutBeforeData( e.text() );
                        i=0;
                        break;
                    }
                    i+=1;
                }

                //textIncomeVista += "   Mensual(prova): "+gFb.getMonthly().get(0);
                //textIncomeVista += "   Anual(prova): "+ gFb.getAnnuals().get(0);

                textIncomeVista += "\n"+ "T.Min: " + cutBeforeData( docVista.getElementById("temp_min").text() );
                textIncomeVista += "   T.Max: " + cutBeforeData( docVista.getElementById("temp_max").text() );





                Document docXodos = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m055e02").get();

                textIncomeXodos = "Xodos";
                textIncomeXodos += "\n"+ "Humedad relativa: " + cutBeforeData( docXodos.getElementById("hrel").text());
                textIncomeXodos += "   Viento: " + cutBeforeData( docXodos.getElementById("vent").text());
                textIncomeXodos += "\n"+ "Hoy: " + cutBeforeData( docXodos.getElementById("prec").text() );

                i=0;
                for (Element e : docXodos.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeXodos += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeXodos += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }

                textIncomeXodos += "\n"+ "T.Min: " + cutBeforeData( docXodos.getElementById("temp_min").text() );
                textIncomeXodos += "   T.Max: " + cutBeforeData( docXodos.getElementById("temp_max").text() );



                Document docAtz = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m001e02").get();

                textIncomeAtz = "Adzaneta";
                textIncomeAtz += "\n"+ "Humedad relativa: " + cutBeforeData( docAtz.getElementById("hrel").text());
                textIncomeAtz += "   Viento: " + cutBeforeData( docAtz.getElementById("vent").text());
                textIncomeAtz += "\n"+ "Hoy: " + cutBeforeData( docAtz.getElementById("prec").text() );
                i=0;
                for (Element e : docAtz.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeAtz += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeAtz += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeAtz += "\n"+ "T.Min: " + cutBeforeData( docAtz.getElementById("temp_min").text() );
                textIncomeAtz += "   T.Max: " + cutBeforeData( docAtz.getElementById("temp_max").text() );






                Document docVal = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e15").get();

                textIncomeVal = "Valdelinares (pistas)";
                textIncomeVal += "\n"+ "Humedad relativa: " + cutBeforeData( docVal.getElementById("hrel").text());
                textIncomeVal += "   Viento: " + cutBeforeData( docVal.getElementById("vent").text());
                textIncomeVal += "\n"+ "Hoy: " + cutBeforeData( docVal.getElementById("prec").text() );
                textIncomeVal += "   Mes: "+oneDecimal(gFb.getMonthly().get(4).toString())+"mm";
                i=0;
                for (Element e : docVal.getElementById("mesdades").children()) {
                    if (i==6){
                        textIncomeVal += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeVal += "\n"+ "T.Min: " + cutBeforeData( docVal.getElementById("temp_min").text() );
                textIncomeVal += "   T.Max: " + cutBeforeData( docVal.getElementById("temp_max").text() );



                Document docVm = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c08m131e01").get();

                textIncomeVm = "Villamalur";
                textIncomeVm += "\n"+ "Humedad relativa: " + cutBeforeData( docVm.getElementById("hrel").text());
                textIncomeVm += "   Viento: " + cutBeforeData( docVm.getElementById("vent").text());
                textIncomeVm += "\n"+ "Hoy: " + cutBeforeData( docVm.getElementById("prec").text() );
                i=0;
                for (Element e : docVm.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVm += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeVm += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeVm += "\n"+ "T.Min: " + cutBeforeData( docVm.getElementById("temp_min").text() );
                textIncomeVm += "   T.Max: " + cutBeforeData( docVm.getElementById("temp_max").text() );



                Document docOnd= Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c06m084e02").get();

                textIncomeOnd = "Onda";
                textIncomeOnd += "\n"+ "Humedad relativa: " + cutBeforeData( docOnd.getElementById("hrel").text());
                textIncomeOnd += "   Viento: " + cutBeforeData( docOnd.getElementById("vent").text());
                textIncomeOnd += "\n"+ "Hoy: " + cutBeforeData( docOnd.getElementById("prec").text() );
                i=0;
                for (Element e : docOnd.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeOnd += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeOnd += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeOnd += "\n"+ "T.Min: " + cutBeforeData( docOnd.getElementById("temp_min").text() );
                textIncomeOnd += "   T.Max: " + cutBeforeData( docOnd.getElementById("temp_max").text() );



                Document docAlc = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e01").get();

                textIncomeAlc = "Alcalá de la selva";
                textIncomeAlc += "\n"+ "Humedad relativa: " + cutBeforeData( docAlc.getElementById("hrel").text());
                textIncomeAlc += "   Viento: " + cutBeforeData( docAlc.getElementById("vent").text());
                textIncomeAlc += "\n"+ "Hoy: " + cutBeforeData( docAlc.getElementById("prec").text() );
                textIncomeAlc +="   Mes: "+oneDecimal(gFb.getMonthly().get(7).toString())+"mm";
                i=0;
                for (Element e : docAlc.getElementById("mesdades").children()) {
                    if (i==6){
                        textIncomeAlc += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeAlc += "\n"+ "T.Min: " + cutBeforeData( docAlc.getElementById("temp_min").text() );
                textIncomeAlc += "   T.Max: " + cutBeforeData( docAlc.getElementById("temp_max").text() );




                Document docTor= Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c07m115e01").get();

                textIncomeTor = "El Toro";
                textIncomeTor += "\n"+ "Humedad relativa: " + cutBeforeData( docTor.getElementById("hrel").text());
                textIncomeTor += "   Viento: " + cutBeforeData( docTor.getElementById("vent").text());
                textIncomeTor += "\n"+ "Hoy: " + cutBeforeData( docTor.getElementById("prec").text() );
                i=0;
                for (Element e : docTor.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeTor += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomeTor += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomeTor += "\n"+ "T.Min: " + cutBeforeData( docTor.getElementById("temp_min").text() );
                textIncomeTor += "   T.Max: " + cutBeforeData( docTor.getElementById("temp_max").text() );



                Document docPue = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c09m201e01").get();

                textIncomePue = "Puebla de San Miguel";
                textIncomePue += "\n"+ "Humedad relativa: " + cutBeforeData( docPue.getElementById("hrel").text());
                textIncomePue += "   Viento: " + cutBeforeData( docPue.getElementById("vent").text());
                textIncomePue += "\n"+ "Hoy: " + cutBeforeData( docPue.getElementById("prec").text() );
                i=0;
                for (Element e : docPue.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomePue += "   Mes: "+  cutBeforeData( e.text() );

                    }else if (i==6){
                        textIncomePue += "   Año: "+  cutBeforeData( e.text() );
                        break;
                    }
                    i+=1;
                }


                textIncomePue += "\n"+ "T.Min: " + cutBeforeData( docPue.getElementById("temp_min").text() );
                textIncomePue += "   T.Max: " + cutBeforeData( docPue.getElementById("temp_max").text() );






                int idx=0;
                String [] meteo = new String[6];

                Document docVf = Jsoup.connect("http://www.aemet.es/va/eltiempo/observacion/ultimosdatos?k=val&l=8489X&w=1&datos=img").get();
                textIncomeVf = "Villafranca del cid";

                for(Element e : docVf.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeVf+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeVf+="\nHoy: "+meteo[4]+"mm";
                textIncomeVf += "   Mes: "+oneDecimal(gFb.getMonthly().get(3).toString())+"mm";
                textIncomeVf += "   Año: "+ oneDecimal(gFb.getAnnuals().get(3).toString())+"mm";
                textIncomeVf+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeVf+="   T.Max: "+meteo[0].split(" ")[0];



                // AEMET Mosqueruela

                Document docMos = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=1&datos=img").get();

                textIncomeMos = "Mosqueruela";

                meteo = new String[6];
                idx=0;

                for(Element e : docMos.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeMos+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMos+="\nHoy: "+meteo[4]+"mm";
                textIncomeMos += "   Mes: "+oneDecimal(gFb.getMonthly().get(10).toString())+"mm";
                textIncomeMos += "   Año: "+ oneDecimal(gFb.getAnnuals().get(10).toString())+"mm";
                textIncomeMos+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeMos+="   T.Max: "+meteo[0].split(" ")[0];



                // AEMET Montanejos________________________________________________________________________________

                Document docMon = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=val&l=8472A&w=1&datos=img&f=tmax").get();

                textIncomeMon = "Montanejos";

                meteo = new String[6];

                idx=0;

                for(Element e : docMon.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }
                textIncomeMon+= "\nViento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMon+="\nHoy: "+meteo[4]+"mm";
                textIncomeMon += "   Mes: "+oneDecimal(gFb.getMonthly().get(11).toString())+"mm";
                textIncomeMon += "   Año: "+oneDecimal(gFb.getAnnuals().get(11).toString())+"mm";
                textIncomeMon+="\nT.Min: "+meteo[1].split(" ")[0];
                textIncomeMon+="   T.Max: "+meteo[0].split(" ")[0];



                // meteosabi.es________________________________________________________________________________

                Document docBron = Jsoup.connect("https://meteosabi.es/el-tiempo-en-bronchales-teruel").get();
                titulo = "Bronchales (Camping)";
                textIncomeBron = titulo;
                textIncomeBron+= "\nViento: "+docBron.getElementById("WindAverage").text()+"km/h";
                textIncomeBron+="\nHoy: "+docBron.getElementById("RainToday").text()+"mm";
                textIncomeBron += "   Mes: "+oneDecimal(cutBeforeData(gFb.getMonthly().get(12).toString()))+"mm";
                textIncomeBron += "   Año: "+oneDecimal(cutBeforeData(gFb.getAnnuals().get(12).toString()))+"mm";
                textIncomeBron+= "\nT.Min: "+docBron.getElementById("LowTempToday").text();
                textIncomeBron+= "   T.Max: "+docBron.getElementById("HighTempToday").text();





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

        public String oneDecimal(String cipher){
            int idxPoint = cipher.indexOf('.');
            return cipher.substring(0,idxPoint+2);
        }

    }
}
