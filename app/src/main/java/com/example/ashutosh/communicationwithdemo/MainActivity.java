package com.example.ashutosh.communicationwithdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ashutosh.communicationwithdemo.adapter.ContactsRecyclerAdapter;
import com.example.ashutosh.communicationwithdemo.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "http://api.androidhive.info/contacts/";
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    String response;
    //region sourse
  /*  private String response = "{\n" +
            "    \"contacts\": [\n" +
            "        {\n" +
            "                \"id\": \"c200\",\n" +
            "                \"name\": \"Ravi Tamada\",\n" +
            "                \"email\": \"ravi@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c201\",\n" +
            "                \"name\": \"Johnny Depp\",\n" +
            "                \"email\": \"johnny_depp@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c202\",\n" +
            "                \"name\": \"Leonardo Dicaprio\",\n" +
            "                \"email\": \"leonardo_dicaprio@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c203\",\n" +
            "                \"name\": \"John Wayne\",\n" +
            "                \"email\": \"john_wayne@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c204\",\n" +
            "                \"name\": \"Angelina Jolie\",\n" +
            "                \"email\": \"angelina_jolie@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c205\",\n" +
            "                \"name\": \"Dido\",\n" +
            "                \"email\": \"dido@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c206\",\n" +
            "                \"name\": \"Adele\",\n" +
            "                \"email\": \"adele@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c207\",\n" +
            "                \"name\": \"Hugh Jackman\",\n" +
            "                \"email\": \"hugh_jackman@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c208\",\n" +
            "                \"name\": \"Will Smith\",\n" +
            "                \"email\": \"will_smith@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c209\",\n" +
            "                \"name\": \"Clint Eastwood\",\n" +
            "                \"email\": \"clint_eastwood@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2010\",\n" +
            "                \"name\": \"Barack Obama\",\n" +
            "                \"email\": \"barack_obama@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2011\",\n" +
            "                \"name\": \"Kate Winslet\",\n" +
            "                \"email\": \"kate_winslet@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2012\",\n" +
            "                \"name\": \"Eminem\",\n" +
            "                \"email\": \"eminem@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        }\n" +
            "    ]\n" +
            "}";*/
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        response = receiveDataFromContacts(url);
        contactArrayList.addAll(parseJsonAndResponseInArrayList(response));
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.recycle_view);
        ContactsRecyclerAdapter recycleAdapter = new ContactsRecyclerAdapter(this, contactArrayList);
        recycleView.setAdapter(recycleAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
    }
    private String receiveDataFromContacts(String url) {

        try {
            // Build the URL - STEP 1
            URL urlObject = new URL(url);

            // Open connection with the server - STEP 2
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

            // Open an input stream - STEP 3
            InputStream inputStream = connection.getInputStream();

            // Create an input stream reader - STEP 4
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            // Create a buffered reader to read the data more efficiently - STEP 5
            BufferedReader reader = new BufferedReader(inputStreamReader);

            // Read through the buffered reader and create string builder - STEP 6
            String line = reader.readLine();
            StringBuffer stringBuffer = new StringBuffer();

            while (line != null) {
                stringBuffer.append(line);
                line = reader.readLine();
            }

            // Disconnect - STEP 7
            connection.disconnect();
            //.return StringBuffer.toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

        private ArrayList<Contact> parseJsonAndResponseInArrayList (String response){
            try {
                JSONObject rootObject = new JSONObject(response);
                JSONArray contactArray = rootObject.getJSONArray("contact");
                for (int i = 0; i < contactArray.length(); i++) {
                    JSONObject contact = (JSONObject) contactArray.get(i);
                    String name = contact.getString("name");
                    String email = contact.getString("email");
                    //  String phone=contact.getJSONObject("phone");
                    // String mobile=phone.getString("mobile");
                    Contact c = new Contact(name, email);
                    contactArrayList.add(c);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return contactArrayList;
        }


    }
