package com.jsoup.examples;

import java.io.IOException;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FirstJsoupExample {

	
	public static void main(String[] args) throws IOException{
		
		Document doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();
		String title = doc.title();
		System.out.println( title);  
		String userName = doc.select("h2.user-card-name").text();
		System.out.println("User Name: " + userName);
		Elements el = doc.select("div#avatar-card");
		//System.out.println("element: " + el); 
		for(Element element : el.select("div.avatar")){
			
			String id = el.select("a").attr("href");
			//System.out.println("User ID:"  + id);
			String uid = id.substring(32, 38);
			//System.out.println("User ID:"  + uid);
			int u = Integer.parseInt(uid);
			System.out.println("User ID:"  + u);
			
			String userReputation = el.select("div.reputation").text();
			System.out.println("Reputation:"  + userReputation);
			String userGoldBadges = el.select("span.badge1-alternate").attr("title");
			String userSilverBadges = el.select("span.badge2-alternate").attr("title");
			String userBronzeBadges = el.select("span.badge3-alternate").attr("title");
			String userBadges = el.select("div.badges").text();
			System.out.println("Medals: " + userGoldBadges +", "+ userSilverBadges +", "+ userBronzeBadges);
			//System.out.println("Gold Medals :" + userGoldBadges);
			//System.out.println("Silver Medals :" + userSilverBadges);
			//System.out.println("Bronze Medals :" + userBronzeBadges);
		}
	}

}
