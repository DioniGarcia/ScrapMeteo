package com.example.administrador.scrapmeteo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

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

        String textIncomeVista = "VIstabella - NOT WORKING - AVAMET";
        String textIncomeXodos= "Xodos - NOT WORKING - AVAMET";
        String textIncomeAtz= "Atzeneta - NOT WORKING - AVAMET";
        String textIncomeVf= "Villafranca - NOT WORKING";
        String textIncomeVal= "Valdelinares - NOT WORKING - AVAMET";
        String textIncomeVm= "Villamalur - NOT WORKING - AVAMET";
        String textIncomeAlc= "Alcalá selva - NOT WORKING - AVAMET";
        String textIncomeOnd= "Onda - NOT WORKING - AVAMET";
        String textIncomePue= "Puebla de San Miguel - NOT WORKING - AVAMET";
        String textIncomeTor= "El Toro - NOT WORKING - AVAMET";
        String textIncomeMos= "Mosqueruela - NOT WORKING - AeMET";
        String textIncomeMon= "Montanejos - NOT WORKING - AeMET";
        String textIncomeBron= "Bronchales - NOT WORKIN - Sabiñanigo";



        @Override
        protected Void doInBackground(Void... voids) {
            int timeout = 5000;
            int i = 0;
            String titulo="";

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m139e01");
                c.timeout(timeout);
                Document docVista = c.get();

                textIncomeVista = "San Juan de Peñagolosa";
                textIncomeVista += "\n"+ "Humedad relativa: " + cutNumericData(docVista.getElementById("hrel").text())+"%";
                textIncomeVista += "   Viento: " + cutNumericData( docVista.getElementById("vent").text())+"km/h";
                textIncomeVista += "\n"+ "Hoy: " + cutNumericData( docVista.getElementById("prec").text() )+"mm";

                for (Element e : docVista.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVista += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeVista += "   Año: "+  cutNumericData( e.text() )+"mm";
                        i=0;
                        break;
                    }
                    i+=1;
                }
                textIncomeVista += "\n"+ "T.Min: " + cutNumericData( docVista.getElementById("temp_min").text() )+"ºC";
                textIncomeVista += "   T.Max: " + cutNumericData( docVista.getElementById("temp_max").text() )+"ºC";


            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{
                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m055e02");
                c.timeout(timeout);
                Document docXodos = c.get();

                textIncomeXodos = "Xodos";
                textIncomeXodos += "\n"+ "Humedad relativa: " + cutNumericData( docXodos.getElementById("hrel").text())+"%";
                textIncomeXodos += "   Viento: " + cutNumericData( docXodos.getElementById("vent").text())+"km/h";
                textIncomeXodos += "\n"+ "Hoy: " + cutNumericData( docXodos.getElementById("prec").text() )+"mm";

                i=0;
                for (Element e : docXodos.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeXodos += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeXodos += "   Año: "+  cutNumericData( e.text() )+"mm";
                        break;
                    }
                    i+=1;
                }

                textIncomeXodos += "\n"+ "T.Min: " + cutNumericData( docXodos.getElementById("temp_min").text() )+"ºC";
                textIncomeXodos += "   T.Max: " + cutNumericData( docXodos.getElementById("temp_max").text() )+"ºC";

            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c04m001e02");
                c.timeout(timeout);
                Document docAtz = c.get();


                textIncomeAtz = "Adzaneta";
                textIncomeAtz += "\n"+ "Humedad relativa: " + cutNumericData( docAtz.getElementById("hrel").text())+"%";
                textIncomeAtz += "   Viento: " + cutNumericData( docAtz.getElementById("vent").text())+"km/h";
                textIncomeAtz += "\n"+ "Hoy: " + cutNumericData( docAtz.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docAtz.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeAtz += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeAtz += "   Año: "+  cutNumericData( e.text() )+"mm";
                        break;
                    }
                    i+=1;
                }


                textIncomeAtz += "\n"+ "T.Min: " + cutNumericData( docAtz.getElementById("temp_min").text() )+"ºC";
                textIncomeAtz += "   T.Max: " + cutNumericData( docAtz.getElementById("temp_max").text() )+"ºC";



            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e15");
                c.timeout(timeout);
                Document docVal = c.get();


                textIncomeVal = "Valdelinares (pistas)";
                textIncomeVal += "\n"+ "Humedad relativa: " + cutNumericData( docVal.getElementById("hrel").text())+"%";
                textIncomeVal += "   Viento: " + cutNumericData( docVal.getElementById("vent").text())+"km/h";
                textIncomeVal += "\n"+ "Hoy: " + cutNumericData( docVal.getElementById("prec").text() )+"mm";
                textIncomeVal += "   Mes: "+formatRains(gFb.getMonthly().get(4).toString())+"mm";
                textIncomeVal += "   Año: "+formatRains(gFb.getAnnuals().get(4).toString())+"mm";
                textIncomeVal += "\n"+ "T.Min: " + cutNumericData( docVal.getElementById("temp_min").text() )+"ºC";
                textIncomeVal += "   T.Max: " + cutNumericData( docVal.getElementById("temp_max").text() )+"ºC";

            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c08m131e01");
                c.timeout(timeout);
                Document docVm = c.get();

                textIncomeVm = "Villamalur";
                textIncomeVm += "\n"+ "Humedad relativa: " + cutNumericData( docVm.getElementById("hrel").text())+"%";
                textIncomeVm += "   Viento: " + cutNumericData( docVm.getElementById("vent").text())+"km/h";
                textIncomeVm += "\n"+ "Hoy: " + cutNumericData( docVm.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docVm.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVm += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeVm += "   Año: "+  cutNumericData( e.text() )+"mm";
                        break;
                    }
                    i+=1;
                }


                textIncomeVm += "\n"+ "T.Min: " + cutNumericData( docVm.getElementById("temp_min").text() )+"ºC";
                textIncomeVm += "   T.Max: " + cutNumericData( docVm.getElementById("temp_max").text() )+"ºC";

            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c06m084e02");
                c.timeout(timeout);
                Document docOnd = c.get();

                textIncomeOnd = "Onda";
                textIncomeOnd += "\n"+ "Humedad relativa: " + cutNumericData( docOnd.getElementById("hrel").text())+"%";
                textIncomeOnd += "   Viento: " + cutNumericData( docOnd.getElementById("vent").text())+"km/h";
                textIncomeOnd += "\n"+ "Hoy: " + cutNumericData( docOnd.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docOnd.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeOnd += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeOnd += "   Año: "+  cutNumericData( e.text() )+"mm";
                        break;
                    }
                    i+=1;
                }


                textIncomeOnd += "\n"+ "T.Min: " + cutNumericData( docOnd.getElementById("temp_min").text() )+"ºC";
                textIncomeOnd += "   T.Max: " + cutNumericData( docOnd.getElementById("temp_max").text() )+"ºC";

            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c99m044e01");
                c.timeout(timeout);
                Document docAlc = c.get();

                textIncomeAlc = "Alcalá de la selva";
                textIncomeAlc += "\n"+ "Humedad relativa: " + cutNumericData( docAlc.getElementById("hrel").text())+"%";
                textIncomeAlc += "   Viento: " + cutNumericData( docAlc.getElementById("vent").text())+"km/h";
                textIncomeAlc += "\n"+ "Hoy: " + cutNumericData( docAlc.getElementById("prec").text() )+"mm";
                textIncomeAlc +="   Mes: "+formatRains(gFb.getMonthly().get(7).toString())+"mm";
                textIncomeAlc += "   Año: "+ formatRains(gFb.getAnnuals().get(7).toString())+"mm";


                textIncomeAlc += "\n"+ "T.Min: " + cutNumericData( docAlc.getElementById("temp_min").text() )+"ºC";
                textIncomeAlc += "   T.Max: " + cutNumericData( docAlc.getElementById("temp_max").text() )+"ºC";


            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c07m115e01");
                c.timeout(timeout);
                Document docTor = c.get();

                textIncomeTor = "El Toro";
                textIncomeTor += "\n"+ "Humedad relativa: " + cutNumericData( docTor.getElementById("hrel").text())+"%";
                textIncomeTor += "   Viento: " + cutNumericData( docTor.getElementById("vent").text())+"km/h";
                textIncomeTor += "\n"+ "Hoy: " + cutNumericData( docTor.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docTor.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeTor += "   Mes: "+  cutNumericData( e.text() )+"mm";

                    }else if (i==6){
                        textIncomeTor += "   Año: "+  cutNumericData( e.text() )+"mm";
                        break;
                    }
                    i+=1;
                }


                textIncomeTor += "\n"+ "T.Min: " + cutNumericData( docTor.getElementById("temp_min").text() )+"ºC";
                textIncomeTor += "   T.Max: " + cutNumericData( docTor.getElementById("temp_max").text() )+"ºC";


            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }

            try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c09m201e01");
                c.timeout(timeout);
                Document docPue = c.get();

                textIncomePue = "Puebla de San Miguel";
                textIncomePue += "\n"+ "Humedad relativa: " + cutNumericData( docPue.getElementById("hrel").text())+"%";
                textIncomePue += "   Viento: " + cutNumericData( docPue.getElementById("vent").text())+"km/h";
                textIncomePue += "\n"+ "Hoy: " + cutNumericData( docPue.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docPue.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomePue += "   Mes: "+  cutNumericData( e.text() )+"mm" ;

                    }else if (i==6){
                        textIncomePue += "   Año: "+  cutNumericData( e.text() )+"mm" ;
                        break;
                    }
                    i+=1;
                }


                textIncomePue += "\n"+ "T.Min: " + cutNumericData( docPue.getElementById("temp_min").text() )+"ºC";
                textIncomePue += "   T.Max: " + cutNumericData( docPue.getElementById("temp_max").text() )+"ºC";



            }catch( Exception e ){

                e.printStackTrace();
                Log.d(TAG,"ESTA PETANDO");

            }


                int idx=0;
                String [] meteo = new String[6];


                try{

                Connection c = Jsoup.connect("https://www.avamet.org/mxo_i.php?id=c02m129e02");
                c.timeout(timeout);
                Document docVf = c.get();

                textIncomeVf = "Villafranca del cid";

                textIncomeVf += "\n"+ "Humedad relativa: " + cutNumericData( docVf.getElementById("hrel").text())+"%";
                textIncomeVf += "   Viento: " + cutNumericData( docVf.getElementById("vent").text())+"km/h";
                textIncomeVf += "\n"+ "Hoy: " + cutNumericData( docVf.getElementById("prec").text() )+"mm";
                i=0;
                for (Element e : docVf.getElementById("mesdades").children()) {
                    if (i == 5 ) {
                        textIncomeVf += "   Mes: "+  cutNumericData( e.text() )+"mm" ;

                    }else if (i==6){
                        textIncomeVf += "   Año: "+  cutNumericData( e.text() )+"mm" ;
                        break;
                    }
                    i+=1;
                }

                textIncomeVf += "\n"+ "T.Min: " + cutNumericData( docVf.getElementById("temp_min").text() )+"ºC";
                textIncomeVf += "   T.Max: " + cutNumericData( docVf.getElementById("temp_max").text() )+"ºC";

                }catch( Exception e ){

                    e.printStackTrace();
                    Log.d(TAG,"ESTA PETANDO");

                }

                try{

                // AEMET Mosqueruela

                Connection c = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=1&datos=img");
                c.timeout(timeout);
                Document docMos = c.get();

                textIncomeMos = "Mosqueruela";

                meteo = new String[6];
                idx=0;

                for(Element e : docMos.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }

                Connection c2 = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=arn&l=8486X&w=0&datos=det");
                c2.timeout(timeout);
                Document mosHum = c2.get();

                String humedad = "";
                ArrayList<Element> aE = mosHum.getElementById("table").child(1).children();

                for(Element e : aE){
                    if (e.children().size() == 10){
                        humedad = e.children().get(9).text();
                    }
                    break;
                }

                textIncomeMos +="\nHumedad relativa: "+humedad+"%";
                textIncomeMos+= "   Viento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMos+="\nHoy: "+formatRains(meteo[4])+"mm";
                textIncomeMos += "   Mes: "+formatRains(gFb.getMonthly().get(10).toString())+"mm";
                textIncomeMos += "   Año: "+ formatRains(gFb.getAnnuals().get(10).toString())+"mm";
                textIncomeMos+="\nT.Min: "+meteo[1].split(" ")[0]+"ºC";
                textIncomeMos+="   T.Max: "+meteo[0].split(" ")[0]+"ºC";

                }catch( Exception e ){

                    e.printStackTrace();
                    Log.d(TAG,"ESTA PETANDO");

                }

                try{

                // AEMET Montanejos________________________________________________________________________________

                Connection c = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=val&l=8472A&w=1&datos=img&f=tmax");
                c.timeout(timeout);
                Document docMon = c.get();

                textIncomeMon = "Montanejos";

                meteo = new String[6];

                idx=0;

                for(Element e : docMon.getElementsByClass("fila_impar")){
                    meteo[idx] = e.text();
                    idx+=1;
                }

                Connection c2 = Jsoup.connect("http://www.aemet.es/es/eltiempo/observacion/ultimosdatos?k=val&l=8472A&w=0&datos=det");
                c2.timeout(timeout);
                Document monHum = c2.get();

                String humedad = "";
                ArrayList<Element> aE = monHum.getElementById("table").child(1).children();

                for(Element e : aE){
                    if (e.children().size() == 10){
                        humedad = e.children().get(9).text();
                    }
                    break;
                }

                textIncomeMon +="\nHumedad relativa: "+humedad+"%";
                textIncomeMon+= "   Viento: "+meteo[3].split(" ")[0]+"km/h";
                textIncomeMon+="\nHoy: "+formatRains(meteo[4])+"mm";
                textIncomeMon += "   Mes: "+formatRains(gFb.getMonthly().get(11).toString())+"mm";
                textIncomeMon += "   Año: "+formatRains(gFb.getAnnuals().get(11).toString())+"mm";
                textIncomeMon+="\nT.Min: "+meteo[1].split(" ")[0]+"ºC";
                textIncomeMon+="   T.Max: "+meteo[0].split(" ")[0]+"ºC";

                }catch( Exception e ){

                    e.printStackTrace();
                    Log.d(TAG,"ESTA PETANDO");

                }

                try{


                // meteosabi.es________________________________________________________________________________


                Connection c = Jsoup.connect("https://meteosabi.es/el-tiempo-en-bronchales-teruel");
                c.timeout(timeout);
                Document docBron = c.get();

                titulo = "Bronchales (Camping)";
                textIncomeBron = titulo;
                textIncomeBron +="\nHumedad relativa: " + docBron.getElementById("OutdoorHum").text()+"%";
                textIncomeBron+= "   Viento: "+cutNumericData(docBron.getElementsByClass("caja-temperatura").get(0).child(4).text())+"km/h";
                textIncomeBron+="\nHoy: "+docBron.getElementById("RainToday").text()+"mm";
                textIncomeBron += "   Mes: "+formatRains(gFb.getMonthly().get(12).toString())+"mm";
                textIncomeBron += "   Año: "+formatRains(gFb.getAnnuals().get(12).toString())+"mm";
                textIncomeBron+= "\nT.Min: "+ cutNumericData(docBron.getElementsByClass("div-temp2").get(0).child(1).toString())+"ºC";
                textIncomeBron+= "   T.Max: "+ cutNumericData(docBron.getElementsByClass("div-temp2").get(0).child(0).toString())+"ºC";

                }catch( Exception e ){

                    e.printStackTrace();
                    Log.d(TAG,"ESTA PETANDO");

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

        public String cutNumericData(String orgData){
            int start = -1, end = -1;
            orgData = orgData.trim();
            for (int i=0;i<orgData.length();i++){
                if (Character.isDigit(orgData.charAt(i))) {
                    start = i;
                    break;
                }
            }
            for (int i = orgData.length()-1; i>=0 ;i--){

                if(Character.isDigit(orgData.charAt(i))){
                    end = i;
                    break;
                }
            }
            // Contemplar temperaturas negativas


            if (start != -1 && orgData.charAt(start-1) == '-'){
                return orgData.substring(start-1,end+1);

            }
            return orgData.substring(start,end+1);

        }

        public String oneDecimal(String cipher){
            int idxPoint = cipher.indexOf('.');
            return cipher.substring(0,idxPoint+2);
        }

        public Double formatRains(String orgData){
            Double result;

            // Coger el índice sobre el primer caracter que sea un valor numérico
            int idx = 0;
            for (int i=0;i<orgData.length();i++){
                if (Character.isDigit(orgData.charAt(i))) {
                    idx = i;
                    break;
                }
            }

            try{
                orgData=orgData.replace(',','.');
                int pointIdx = orgData.indexOf('.');
                orgData=orgData.substring(idx,pointIdx+2);
                result = Double.parseDouble(orgData);

            }catch( NumberFormatException e){
                return 0.0;
            }
            return result;
        }

    }
}
