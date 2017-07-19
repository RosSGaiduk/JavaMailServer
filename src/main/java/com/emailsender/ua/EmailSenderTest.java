package com.emailsender.ua;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Rostyslav on 10.06.2017.
 */
public class EmailSenderTest {
    private static final String USER_AGENT = "Mozilla/5.0";
    public static String fromAddr = "rgaidukevich9@gmail.com";
    private static final String crunchifyConfFile = "emailSenderBean.xml";
    private static ConfigurableApplicationContext context;
    private static EmailSenderAPI emailSenderAPI;

    public static void sendEmail(EmailSenderAPI emailSenderAPI, String toAddress, String subject, String body){
        emailSenderAPI.crunchifyReadyToSendEmail(toAddress, fromAddr, subject, body);
    }

    private static void sendGet() throws Exception {

        String url = "http://techmagic-table-tennis-developer-edition.eu11.force.com/PostPage";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");


        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    private static void sendPost() throws Exception {
        String url = "http://techmagic-table-tennis-developer-edition.eu11.force.com/PostPage";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "param1=someParam";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
    }


    public static void main(String[] args) {
        /*
        try {
            sendPost();
        } catch (Exception ex){
            System.out.println("exception");
        }
        */
    }
}
