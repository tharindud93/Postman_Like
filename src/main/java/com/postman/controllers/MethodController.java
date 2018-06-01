package com.postman.controllers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class MethodController {
	//===============================================to test GET method=============================================
	@GetMapping("getmeth")
	public static String GetMeth(HttpServletRequest req,Model model){
		
		 // Create an instance of StopWatch.
      // StopWatch stopWatch = new StopWatch();
		String reqhead =req.getParameter("headerval");
		String url=req.getParameter("url");
		String param=req.getParameter("param");
		
		//create httpheader ins
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
        //create resttemplate instance
         RestTemplate restTemplate=new RestTemplate();
        
         //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
                if(!param.isEmpty()) 
                	builder.queryParam("name", param);
        			
        //convert url to urlstring
        String buildedurl=builder.toUriString();
       
        //Create response http entity instance
        HttpEntity<?> entity=new HttpEntity<>(url,headers);
        //stopWatch.start();
        long startTime = System.currentTimeMillis();
        
        //get response as http entity
        HttpEntity<String> response =restTemplate.exchange(buildedurl, HttpMethod.GET, entity, String.class);
        //stopWatch.stop();   stopWatch.getTime()+"ms"
        long endtime = System.currentTimeMillis();
       // String getString=restTemplate.getForObject(buildedurl,String.class);
        long time=endtime-startTime;
        HttpHeaders head=response.getHeaders();
        String bodyy=response.getBody();
        model.addAttribute("time",time+"ms");
        model.addAttribute("url",buildedurl);
        model.addAttribute("head",head);
        model.addAttribute("bodyy",bodyy);
        try {
			writer(buildedurl,"GET",time,head,bodyy);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "get";

    }
	
	//===============================================to test POST method=============================================
	@GetMapping("postmeth")
	 public static String postMeth(HttpServletRequest req,Model model ){
		
		 // Create an instance of StopWatch.
        //StopWatch stopWatch = new StopWatch();
		
		String url=req.getParameter("url");
		String name=req.getParameter("name");
		String lname=req.getParameter("surname");
        
		//create resttemplate instance
        RestTemplate restTemplate=new RestTemplate();
        
        //Create response http entity instance
        HttpEntity<?> entity=new HttpEntity<>(url);
        Map<String,String> user=new HashMap<>();
        user.put("name",name);
        user.put("surname",lname);
        long startTime = System.currentTimeMillis();
        
        //get response as http entity
        HttpEntity<String> response =restTemplate.postForEntity(url, user, String.class,entity);
        long endtTime = System.currentTimeMillis();
        long time=endtTime-startTime;
        //System.out.println("2="+getString);
        model.addAttribute("url",url);
        model.addAttribute("time",time+" ms"); 
        model.addAttribute("head",response.getHeaders());
        model.addAttribute("bodyy",response.getBody());
        try {
			writer(url,"POST",time,response.getHeaders(),response.getBody());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return "post";
    }
	//===============================================to test Delete method=============================================
	@GetMapping("deletemeth")
	public static String DeleteMeth(HttpServletRequest request ,Model model){
		String head=request.getParameter("headerval");
		String url=request.getParameter("url");
		String id=request.getParameter("id");
		
		//create httpheader ins
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        
        //create resttemplate instanse
        RestTemplate restTemplate=new RestTemplate();
        
        //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id",id);
        HttpEntity<?> entity=new HttpEntity<>(url);
        
        //convert url to urlstring
        String buildedurl=builder.toUriString();
       // restTemplate.delete(buildedurl);
        long startTime = System.currentTimeMillis();
        HttpEntity<String> response =restTemplate.exchange(buildedurl, HttpMethod.DELETE, entity, String.class);
        long endtTime = System.currentTimeMillis();
        long time=endtTime-startTime;
        //System.out.println("2="+getString);
        model.addAttribute("url",buildedurl);
        model.addAttribute("time",time+" ms"); 
        model.addAttribute("head",response.getHeaders());
        model.addAttribute("bodyy",response.getBody());
        System.out.println(response.toString());
        try {
			writer(url,"DELETE",time,response.getHeaders(),response.getBody());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "delete";

    }
	//===============================================to test PUT method=============================================
	@GetMapping("putmeth")
	public static String PutMeth(HttpServletRequest request ,Model model){
    
		String head=request.getParameter("headerval");
		String url=request.getParameter("url");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
        RestTemplate restTemplate=new RestTemplate();
        //create resttemplate ins
        Map<String, Object> user=new HashMap<>();
        //create httpheader ins
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //add query parameters to url
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id",id);
        
        HttpEntity<?> entity=new HttpEntity<>(headers);
        String burl=builder.toUriString();
        user.put("id",id);
        user.put("name",name);
        user.put("surname",surname);
        restTemplate.put(burl ,user);
        HttpEntity<String> responsense = restTemplate.exchange(burl, HttpMethod.PUT, entity, String.class, user);
//        System.out.println(response.toString());

     return null;
    }
	
	//================================================write log file===============================================================
	 public static void writer(String url, String type,long time,HttpHeaders head,String bodyy) throws ParseException {
	        //get current date and time------------------
	        Date day = new Date();
	        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
	        SimpleDateFormat gmtdt = new SimpleDateFormat("hh:mm:ss.SSS");
	        SimpleDateFormat gmtdt1 = new SimpleDateFormat("hh:mm:ss");
	//get time of gmt-----------------------------
	        gmtdt.setTimeZone(TimeZone.getTimeZone("GMT"));
	        String dy = dt.format(day);
	        String gmtdy = gmtdt.format(day);
	        
	        FileWriter writer = null;
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(isr);
                writer = new FileWriter("reqresLog.txt", true);
                //log template
                writer.append("----------Request  " + dy + "-----------\n");
                writer.append("url="+url+"\n");
                writer.append("REQ type="+type+"\n");
                writer.append("--------Respond-----------\n");
                writer.append("Time="+time+"ms\n");
                writer.append("Header="+head+"\n");
                writer.append("Body="+bodyy+"\n");
                writer.append("----------END-----------\n");
                writer.append("\n");
                //close the writer
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

	    }

}
