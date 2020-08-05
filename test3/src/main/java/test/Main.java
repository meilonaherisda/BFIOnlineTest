package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		// System.out.println(jsonGetRequest("https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json"));
		try {
			List<String> listString = new ArrayList<String>();
			Scanner sc = new Scanner(System.in);
			System.err.print("cari kota :");
			String input = sc.nextLine();
			System.err.println("wait : "+input);
			String data = jsonGetRequest("https://raw.githubusercontent.com/lutangar/cities.json/master/cities.json");
			JSONArray jsonArr = new JSONArray(data);			
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				if(jsonObj.get("country").toString().equalsIgnoreCase("ID")){
					if(StringUtils.getJaroWinklerDistance(jsonObj.get("name").toString(), input)>=0.8){
						listString.add(jsonObj.get("name").toString());						
					}
				}
			}
			System.err.println("output : "+listString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String streamToString(InputStream inputStream) {
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z")
				.next();
		return text;
	}

	public static String jsonGetRequest(String urlQueryString) {
		String json = null;
		try {
			URL url = new URL(urlQueryString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}
}
