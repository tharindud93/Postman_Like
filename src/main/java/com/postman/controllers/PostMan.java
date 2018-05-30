package com.postman.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class PostMan {

   public  RestTemplate restTemplate=new RestTemplate();


    public static String GetMeth(String url, String param){
        //create resttemplate obj
         RestTemplate restTemplate=new RestTemplate();
         //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("name",param);
        //convert url to urlstring
        String buildedurl=builder.toUriString();
        //Create response http entity obj
        HttpEntity<?> entity=new HttpEntity<>(url);
        //get response as http entity
        HttpEntity<String> response =restTemplate.exchange(buildedurl, HttpMethod.GET, entity, String.class);

        String getString=restTemplate.getForObject(buildedurl,String.class);


        System.out.println("2="+getString);
        System.out.println("3="+response.getHeaders());
        System.out.println("4="+response.getBody());
        return buildedurl;

    }
    public static String postMeth(String url,String name,String lname){
        //create resttemplate obj
        RestTemplate restTemplate=new RestTemplate();
        //Create response http entity obj
        HttpEntity<?> entity=new HttpEntity<>(url);
        Map<String,String> user=new HashMap<>();
        user.put("name",name);
        user.put("surname",lname);

//        HttpEntity<String> response = restTemplate.exchange("http://localhost:8080/user/add",HttpMethod.POST,entity, String.class,user);
        //get response as http entity
        HttpEntity<String> response =restTemplate.postForEntity(url, user, String.class,entity);
        //System.out.println("2="+getString);
        System.out.println("3="+response.getHeaders());
        System.out.println("4="+response.getBody());
        System.out.println(response);
       return null;
    }

    public static String DeleteMeth(String url,int id){
        //create resttemplate obj
        RestTemplate restTemplate=new RestTemplate();
        //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id",id);
        HttpEntity<?> entity=new HttpEntity<>(url);
        //convert url to urlstring
        String buildedurl=builder.toUriString();
       // restTemplate.delete(buildedurl);
        HttpEntity<String> response =restTemplate.exchange(buildedurl, HttpMethod.DELETE, entity, String.class);
        System.out.println(response.toString());
        return null;

    }
    public static String PutMeth(String url,int id,String name,String surname){
        //create resttemplate obj
        RestTemplate restTemplate=new RestTemplate();
        Map<String, Object> user=new HashMap<>();
        //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id",id);
        HttpEntity<?> entity=new HttpEntity<>(url);
        String burl=builder.toUriString();
        user.put("id",id);
        user.put("name",name);
        user.put("surname",surname);
        restTemplate.put(burl ,user);
        HttpEntity<String> response =restTemplate.exchange(burl, HttpMethod.PUT, entity, String.class,user);
        System.out.println(response.toString());

     return null;
    }
    
    public static void Writer(String url, String name, String type) throws ParseException {
        //get current date and time------------------
        Date day = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        SimpleDateFormat gmtdt = new SimpleDateFormat("hh:mm:ss.SSS");
        SimpleDateFormat gmtdt1 = new SimpleDateFormat("hh:mm:ss");
//get time of gmt-----------------------------
        gmtdt.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dy = dt.format(day);
        String gmtdy = gmtdt.format(day);
        System.out.println(dy);
        System.out.println(gmtdy);
        
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        try {
			FileWriter writer = new FileWriter("reqresLog.txt", true);
			writer.append("--------Respond" + dy + "-----------\n");
			writer.append("url="+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
