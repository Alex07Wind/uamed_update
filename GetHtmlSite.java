package de.vogella.mysql.first.test;

import de.vogella.mysql.first.MySQLAccess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.OutputStream;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class GetHtmlSite {

//http://www.uniformadvantage.com/img/products/600x720/UA658SBN.png
// www.uniformadvantage.com/pages/dpt/prints-scrubs-new-arrivals.asp	
//<div class="dptitem1">	
//<div class="dptimg"><a href="/pages/prod/song-bird-navy-print-top.asp?navbar=&frmcolor="><img src="/img/products/200x240/UA788SBN.png" border="0" /></a></div>
//	
//
/*	<div class="dptitem1">
	<div class="dptimg"><a href="/pages/prod/song-bird-navy-print-top.asp?navbar=4&frmcolor="><img src="/img/products/200x240/UA788SBN.png" border="0" /></a></div>
	<div class="dptcbgrp"></div>
	<div style="clear:both"></div>
	<div class="dptcopy"><a class="dptcopy" href="/pages/prod/song-bird-navy-print-top.asp?navbar=4&frmcolor=">UA Song Bird Navy Print Scrub Top</a></div>
	<div style="clear:both"></div>
	<div class="dptstyle"><a class="dptstyle" href="/pages/prod/song-bird-navy-print-top.asp?navbar=4&frmcolor=">Style #  UA788SBN</a></div>
	<div class="dptprice">As low as $15.99</div>
	</div>
	<div class="dptitem1">
	<div class="dptimg"><a href="/pages/prod/song-bird-navy-scrub-top.asp?navbar=4&frmcolor="><img src="/img/products/200x240/UA658SBN.png" border="0" /></a></div>

*/	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-regular-scrub-pants.asp?sort_order=&navbar=5&sa_sex=F&sa_color=All&sa_size=All&x=26&y=7"; //Брюки женские
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/spring-ua-scrubs.asp"; // весна 2016
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-summer-scrubs.asp"; //summer 2016
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/fall-scrubs.asp"; //fall 2016 preview
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/winter-print-scrubs.asp"; //winter 2016
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-limited-time-sale.asp"; // Black Friday
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/spring-ua-scrubs.asp"; // Spring Preview 2017
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-strictly-scrubs.asp"; // Stricktly Scrubs

//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-print-scrub-tops.asp"; // все принты
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/surgical-caps.asp"; // аксессуары шапочки

//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/top-rated-scrubs.asp"; // Top Butter-Soft Strech Top and Pants
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/advantage-by-butter-soft.asp"; // Advantage Butter-Soft Strech Top and Pants
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/collections-butter-soft.asp"; //Butter Soft Scrubs
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/dental-prints.asp"; // Dental
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/prints-whimsical-print-scrubs.asp"; // Блузы с принтом причудливых животных
	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/animal-prints.asp";
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/easy-stretch-butter-soft-scrub.asp"; //ButterSoft easy stretch
	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-new-arrivals.asp"; // новинки

//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-solid-mock-wrap-tops.asp"; //солид топ mock wrap
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-solid-scrub-tops.asp"; //солид топ
	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-scrub-pants-all.asp"; //Все брюки
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-regular-scrub-pants.asp";   //Regular Pants
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-petite-scrub-pants.asp"; 		// Petit Scrubs
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-tall-scrub-pants.asp";		// Tall Scrubs
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua_scrub_sets.asp"; //Костюмы scrubs
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-print-scrub-jackets.asp"; //Куртки с принтом scrubs
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/women-print-jackets.asp"; 	//Куртки с принтом scrubs all




//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/best-buy-scrubs.asp"; //Best Buy
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/collections-butter-soft.asp"; //ButterSoft
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-solid-scrub-tops.asp?sort_order=&navbar=5&sa_sex=M&sa_style=All&sa_color=All&sa_size=All&x=21&y=7"; //солид топ мужские
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-mens-scrubs.asp"; //все мужское	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-lab-coats.asp"; //халаты женские
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-scrub-pants-all.asp"; //Брюки UA все женские	
	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/wonder-wink-solid-tops.asp"; //wonder wink solid top
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/wonder-wink-scrub-pants.asp"; //wonder wink pants женские
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/wonder-wink-print-tops.asp"; //wonder wink print top
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/zoe-chloe-scrubs.asp"; // Zoe+Chloe
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/dickies-print-scrub-tops.asp"; // Dickies print
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/barco-print-scrubs.asp";	//Barco
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/fashion-seal.asp";
	
	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=ALL&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=4&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Ceil Blue 1 all	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=4&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Ceil Blue 2
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=3&submitb.x=22&submitb.y=7&submitb=submit"; //блуза с принтом по Navy 1
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=3&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Navy 2	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=3&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Navy 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=3&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Navy 4
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=17&submitb.x=24&submitb.y=9&submitb=submit"; //блуза с принтом по Royal 1
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=17&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Royal 2	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=1&submitb.x=25&submitb.y=7&submitb=submit"; //блуза с принтом по Black	
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 2	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 3		
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=4&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 4
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=5&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 5	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=6&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 6	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=7&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 7
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=8&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=1&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Black 8
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=15&submitb.x=17&submitb.y=9&submitb=submit"; //блуза с принтом по Teal
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=27&submitb.x=21&submitb.y=8&submitb=submit"; //блуза с принтом по Turquoise 1
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=27&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Turquoise 2
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=27&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Turquoise 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=20&submitb.x=18&submitb.y=7&submitb=submit"; //блуза с принтом по Eggplant
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=16&submitb.x=26&submitb.y=1&submitb=submit"; //блуза с принтом по Wine
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=28&submitb.x=27&submitb.y=7&submitb=submit"; //блуза с принтом по Fuchsia
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=28&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Fuchsia 2
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=28&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Fuchsia 3
//	public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=28&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Fuchsia 4
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=22&submitb.x=21&submitb.y=8&submitb=submit"; //блуза с принтом по Pewter / Granite
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=22&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Pewter / Granite 2
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=22&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Pewter / Granite 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=4&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=22&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Pewter / Granite 4	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=5&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=22&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Pewter / Granite 5
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=5&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=22&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Pewter / Granite 6
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=1&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=26&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Red
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=26&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по Red 2	
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=1&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=2&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по White 1
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=2&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=2&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по White 2
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=3&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=2&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по White 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=4&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=2&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по White 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?page=5&shop_section=5&sa_brand=31|B&sa_style=All&sa_size=All&sa_color=2&sa_length=&sa_width=&sort_order=PA&sa_sex=All&onlysale=N"; //блуза с принтом по White 3
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=29&submitb.x=27&submitb.y=5&submitb=submit"; //блуза с принтом по Khaki
	//public String SiteURL = "http://www.uniformadvantage.com/pages/misc/shopping-assistant.asp?sort_order=PA&shop_section=5&sa_sex=All&sa_style=All&sa_brand=31%7CB&sa_size=All&sa_color=23&submitb.x=20&submitb.y=8&submitb=submit"; //блуза с принтом по Cofee bean
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/scrubs_top_picks.asp"; //sofies
	
//public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/ua-new-arrivals.asp"; //новые поступления
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/ua-print-scrub-tops.asp"; //все принты uascrubs
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/animal-prints.asp"; // принты животных
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/spring-ua-scrubs.asp"; // весенняя коллекция

//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/print-butterfly-scrubs.asp"; // принты бабочек
	
//  public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/ua-solid-mock-wrap-tops.asp"; // ua-solid-mock-wrap-tops
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/ua-solid-scrub-jackets.asp"; // ua-solid-jacket-tops

//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/women-solid-jackets.asp"; // Solid All Jacket
	
// 	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/dickies-solid-scrub-tops.asp"; //Dickies Solid Top
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/dickies-scrub-pants.asp"; // dickies-scrub-pants
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/dickies-lab-coats.asp"; // dickies-scrub-coat
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/dickies-solid-scrub-jackets.asp";

//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/cherokee-scrubs-tops.asp"; // cherokee-scrub-top
//	public String SiteURL = "http://www.uniformadvantage.com/pages/dpt/cherokee-scrub-pants.asp"; // cherokee-scrub-pants
	
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/pediatric-prints.asp"; // педиатров
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/holiday-prints.asp"; // праздничные
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/cotton-prints.asp"; // 100% хлопок
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/stretch-print-scrubs.asp"; // стрейчевый
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/tropical-prints.asp"; // тропический
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/prints_reorderables.asp"; // классические
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/floral-print-scrubs.asp"; // цветов
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/dental-prints.asp"; // для стоматологов
	
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/cherokee-tooniforms-scrubs.asp"; //Cherokee Tooniforms Scrubs
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/disney-scrubs.asp";
	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/cherokee-print-scrubs.asp";	//Cherokee Print all

//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/koi-print-tops.asp";	//koi print
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/ud-spa-&-housekeeping-uniforms.asp"; //SPA solid print
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/sale-scrubs-just-reduced.asp?onlysale=y&navbar=6"; // Акция
//	public String SiteURL =	"http://www.uniformadvantage.com/pages/dpt/ua-summer-scrubs.asp"; // Summer 2017
	
	
public String SiteURL1 		= "http://www.uamed.com.ua";
public String SiteURL2 		= "http://www.uniformadvantage.com/pages/misc/help.asp";
public String SiteURLRoot	= "http://www.uniformadvantage.com";
public ArrayList <String> UpdateURL	= new ArrayList<String>();
public ArrayList<Productua> list 	= new ArrayList<Productua>();
public Productua tmpp;
public Productua curproduct;
Map<String, String> colorsnamehashmap = new HashMap<String, String>();
Map<String, Integer> scladlist = new HashMap<String, Integer>();
public String server = "uamed.ftp.ukraine.com.ua";

public ConnectOption ConnectOpt;
public int 		ftp_port = 21;
public String 	ftp_user = "";
public String 	ftp_pass = "";
public String linkDBMysql ="";
public String name_db ="";
public String name_userdb ="";
public String password_userdb ="";


//public double kurs = 29;
//public double comission = 1.25;
//public double kcargo = 1.52;



public GetHtmlSite() {

	UpdateURL.add("http://www.uniformadvantage.com/pages/dpt/pediatric-prints.asp"); 	//for pediatric
	UpdateURL.add("http://www.uniformadvantage.com/pages/dpt/holiday-prints.asp");   	//for holiday
	UpdateURL.add("http://www.uniformadvantage.com/pages/dpt/cotton-prints.asp");		//100% cotton


//	scladlist.put("UA588SAF",532);
	scladlist.put("307",29);
	scladlist.put("CT255",33);
	scladlist.put("UA864C",132);
	scladlist.put("UA746C",43);
	scladlist.put("UA649BOA",1);
	scladlist.put("P4150LFD",1);
//	scladlist.put("UA198MGE",1);
//	scladlist.put("PC61RNW",1);
	scladlist.put("307",1);
	scladlist.put("PC79N",1);
	scladlist.put("UA198TEI",1);
	scladlist.put("PC62WBJ",1);
	scladlist.put("35",1);
	scladlist.put("UA525C",1);
	scladlist.put("61307",1);
	scladlist.put("U61FGW",1);
	
	
	scladlist.put("PC62VPO",1);
	scladlist.put("BSS584",1);
	scladlist.put("PC61SEP",1);
	scladlist.put("958",1);
	scladlist.put("UA628SUN",1);
	scladlist.put("PC62FCS",1);
	scladlist.put("UA32CP",1);
	//scladlist.put("PC61COK",1);
	scladlist.put("WT668BDD",1);
	scladlist.put("WT668CKS",1);
	scladlist.put("PC62DDW",1);
	scladlist.put("UA194CWS",1);
	scladlist.put("BSS996",1);
	scladlist.put("PC61FPR",1);
	scladlist.put("H198FHY",1);
	scladlist.put("STN868",1);
	scladlist.put("7135",1);
	scladlist.put("UAS603C",1);
	scladlist.put("UAS703C",1);

	scladlist.put("H61HIW",1);
//	scladlist.put("UA194MYN",1);
	scladlist.put("UA965SQ",1);
	scladlist.put("UA194CPA",1);
	scladlist.put("H194CAH",1);
	scladlist.put("UA194GWP",1);
	scladlist.put("WT668NWH",1);
	
	ConnectOpt = new ConnectOption();
	
	
	
	
}

public static boolean CheckLine( String strline) {
	String tmpstr;
	String linkstr = "<div class=\"dptimg\">";

	
	
	  tmpstr = strline.substring(0, 20);

	  if  (linkstr.equals(tmpstr)) {
		  //System.out.println(strline);
		  //System.out.println("find string where link");
		  return true;}
	  else {
		  return false;
	  
	  }//endif

	
//	tmpp = list.get(0);
//	tmpp.DownloadFile();
		
	
}

public void GetImg(String strline, Productua curproduct) {
	String linkimg,filenamestr,tmp2str, tmp3str;
	String domainlnk = "http://www.uniformadvantage.com";
	int Pos1,Pos2,Pos3,Pos4;

	  Pos3 = strline.indexOf("<a href="); 
	  Pos4 = strline.indexOf("\"",Pos3+10);
	  
	  Pos1 = strline.indexOf("<img src=");
	  Pos2 = strline.indexOf("\"",Pos1+11);
	  
	  //System.out.println(" ="+strline.substring(Pos1, Pos1+11));
	  tmp2str = strline.substring(Pos1+10, Pos2);
	  linkimg=domainlnk+tmp2str;
	  
	  Pos1 = tmp2str.lastIndexOf("/");
	  filenamestr = tmp2str.substring(Pos1+1);  

	  System.out.println(" ="+linkimg+" fn="+filenamestr);
 	  //list.add(new Productua(linkimg,filenamestr,"C35","Top",15));
	  
	  tmp3str = strline.substring(Pos3+9, Pos4);
	  System.out.println(" href="+domainlnk+tmp3str);
	  
	  curproduct.SetLinkImage(linkimg.replace("200x240","600x720"));
	  curproduct.SetFileName(filenamestr);
	  curproduct.SetFileNameSite("/data/newproduct/"+filenamestr);
	  curproduct.SetLinkHref(domainlnk+tmp3str);
}

public boolean GetName(String strline, Productua curproduct) {
	String pname,tmpstr,pnamenew;
	int Pos1,Pos2;
	String linkstr = "<div class=\"dptcopy\">";
	  tmpstr = strline.substring(0, 21);
	  //System.out.println("Name="+tmpstr);
	  if  (linkstr.equals(tmpstr)) {

		  Pos1 = strline.lastIndexOf("\"");
		  Pos2 = strline.lastIndexOf("</a>");
		  
		  //System.out.println(" ="+strline.substring(Pos1+2, Pos2));
		  pname = strline.substring(Pos1+2, Pos2);
		  System.out.println("Name="+pname);
		  pnamenew = pname;
		  for (int i=0;i < pnamenew.length();i++) {
			  
			  if ((pname.charAt(i))>127) {
				  pnamenew = pname.substring(0, i)+pname.substring(i+1,pname.length());
			  };
		  }
		  
		  
		  System.out.println("Namenew="+pnamenew);
		  curproduct.SetName(pnamenew);



		  curproduct.SetNameUA("Топ женский, мужской(unisex) медицинский");
//		  curproduct.SetNameUA("Брюки женские медицинские");
//		  curproduct.SetNameUA("Халат женский медицинский");
//		  curproduct.SetNameUA("Топ мужской медицинский");
//		  curproduct.SetNameUA("Топ женский медицинский с принтом");
//		  curproduct.SetNameUA("Костюм женский медицинский");
//		  curproduct.SetNameUA("Топ женский медицинский с принтом 100% хлопок");		  
//		  curproduct.SetNameDescriptionUA("Топ женский медицинский с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиэстер/хлопок.");
//		  curproduct.SetNameDescriptionUA("Костюм женский медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиэстер/хлопок.");
		  curproduct.SetNameDescriptionUA("Топ женский, мужской(unisex) медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиэстер/хлопок.");
//
//		  curproduct.SetNameDescriptionUA("Халат женский медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 хлопок/полиестер. Цвета в ассортименте.");
//		  curproduct.SetNameDescriptionUA("Топ женский медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 хлопок/полиестер. Цвета в ассортименте.");
//		  curproduct.SetNameDescriptionUA("Брюки женские медицинские. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 хлопок/полиестер. Цвета в ассортименте.");		  
//		  curproduct.SetNameDescriptionUA("Топ мужской медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 хлопок/полиестер.");
		  
		  
//		  curproduct.SetNameDescriptionUA("Топ женский медицинский с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 100% хлопок.");

//		  curproduct.SetNameUA("Топ женский медицинский с запахом");
//		  curproduct.SetNameDescriptionUA("Топ женский медицинский с запахом. Имеются выточки и боковые разрезы. Изготовлен из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок.");
		  
//		  curproduct.SetNameUA("Куртка женская");
//		  curproduct.SetNameDescriptionUA("Куртка женская. Имеются выточки и боковые разрезы. Изготовлен из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок.");		  		  
		  
		  
		  return true;}
	  else {
		  return false;
	  
		}//endif
	
}
public boolean GetArticul(String strline, Productua curproduct) {
	String pname,tmpstr,tmpstr2;
	int Pos1,Pos2;
	String linkstr = "<div class=\"dptstyle\">";
	String linkstr2 = "Style#";//Style# U198MIN
	int len22,len6;
	 len22 = 22;
	 len6 = 6;

	if (strline.length()<22) {
		 len22 = strline.length();}
	if (strline.length()<6) {
		 len22 = strline.length();
		 len6 = strline.length();}
	
	
	tmpstr = strline.substring(0, len22);
	tmpstr2 = strline.substring(0, len6);
	//System.out.println("Articul="+tmpstr);
	  if  (linkstr.equals(tmpstr)) {

		  Pos1 = strline.lastIndexOf("\"");
		  Pos2 = strline.lastIndexOf("</a>");
		  
		  //System.out.println(" ="+strline.substring(Pos1+11, Pos2));
		  pname = strline.substring(Pos1+11, Pos2);
		  System.out.println("Articul="+pname.trim());
		  curproduct.SetArticul(pname.trim());
		  
		  return true;}
	  else if (linkstr2.equals(tmpstr2)) { 
		  pname = strline.substring(6, strline.length());
		  System.out.println("Articul_search="+pname.trim());
		  curproduct.SetArticul(pname.trim());
		  return true;}
	  else {
		  return false;
	  }
	
	
	
}

/*
public boolean GetPrice(String strline, Productua curproduct) {
	

	String pname,tmpstr,tmpstrsale,tmpstrsoldout,tmpstrDollar;
	float f;
	float fua;
	double fuah;
	int Pos1,Pos2;
	String linkstr 		   = "<div class=\"dptprice\">";
	String linkstrsale     = "<div class=\"dptsale\">";
	String linkstrsoldout  = "<div class=\"dptsoldou";
	String linkstrDollar  = "$";
	int len21,len22,len1;
	//  <div class="dptsoldout">SOLD OUT</div>
//  	<div class="dptsoldout">SOLD OUT</div>
	 len22 = 22;
	 len21 = 21;
	 len1 = 1;

	if (strline.length()<22) {
		 len22 = strline.length();
	}
	if (strline.length()<21) {
		 len22 = strline.length();	
		 len21 = strline.length();
	}
	if (strline.length()<1) {
		 len22 = strline.length();	
		 len21 = strline.length();
		 len1 = strline.length();
	}
	 
	
	tmpstr = strline.substring(0, len22);
	tmpstrsale = strline.substring(0, len21);
	tmpstrsoldout = strline.substring(0, len21);
	tmpstrDollar = strline.substring(0, len1);
	//System.out.println("Price="+tmpstr);
	  if  ( (linkstr.equals(tmpstr)) || (linkstrsale.equals(tmpstrsale)) ) {

		  Pos1 = strline.lastIndexOf("$");
		  Pos2 = strline.lastIndexOf("</div>");
		  
		  //System.out.println(" ="+strline.substring(Pos1+1, Pos2));
		  pname = strline.substring(Pos1+1, Pos2);
		  f = Float.parseFloat(pname.trim()); 
		  //System.out.println("Price="+String.valueOf(f));
		  fuah = Math.ceil(kurs*comission*kcargo*f/5)*5;
		  fua = (float)fuah;
		 System.out.println("Price="+fua);		  
		  curproduct.SetPriceUAH(fua);
		  curproduct.SetPrice(f);
		  
		  return true;}
	  else if (linkstrsoldout.equals(tmpstrsoldout)) {
		  System.out.println("Price=SoldOut");
		  //curproduct.SetSoldOut(true);
		  return false;
	  }
	  else if (linkstrDollar.equals(tmpstrDollar)) {
		  pname = strline.substring(1, strline.length());
		  f = Float.parseFloat(pname.trim()); 
		  //System.out.println("Price="+String.valueOf(f));
		  fuah = Math.ceil(kurs*comission*kcargo*f/5)*5;
		  fua = (float)fuah;
		 System.out.println("Price_search="+fua);		  
		  curproduct.SetPriceUAH(fua);
		  curproduct.SetPrice(f);
		  
		  return true;}
	  
	  else {
	
		  return false;
	  }//endif  


}
*/

public boolean GetItemBegin(String strline) {
	String item1str 		   = "<div class=\"dptitem1\">";
	String item1str2 		   = "<div class=\"dptitem2\">";
	//<div class="dptitem1">

	String tmpstr;
	tmpstr = strline.substring(0, 22);
	
	
	if   (item1str.equals(tmpstr) || item1str2.equals(tmpstr))  {
		//System.out.println("-"+tmpstr);
		return true;
	}
	else 
		System.out.println("strline="+strline);
		return false; 
	
}


public boolean GetColorImage(String strline, Productua curproduct) {
//	String item1str 		   = "<div class=\"dptcbgrp\"><div class=\"dptcb\"";
	String item1str 		   = "<div class=\"dptcbgrp\"><div class=";	
//	String item1str2 		   = "<div class=\"dptitem2\">";
	//<div class="dptitem1">

	String tmpstr;
	if (strline.length()<item1str.length()) {return false;}
	tmpstr = strline.substring(0, item1str.length());
	
	
	if   (item1str.equals(tmpstr) )  {
			System.out.println("Color Line="+tmpstr);
		return true;
	}
	else 
		//System.out.println("strline="+strline);
		return false; 
	
}

public boolean GetEndColorImageLine(String strline) {
	String item1str 		   = "<div style=\"clear:both\"></div>";

	String tmpstr;
	if (strline.length()<item1str.length()) {return false;}
	tmpstr = strline.substring(0, item1str.length());
	
	
	if   (item1str.equals(tmpstr) )  {
			System.out.println("End Color Line="+tmpstr);
		return true;
	}
	else 
		//System.out.println("strline="+strline);
		return false; 
	
}

public List<String> GetItemFromSearch(String strline,String pattern) {

	ArrayList<String> tokens = new ArrayList<String>();
	
	Pattern tokSplitter = Pattern.compile(pattern);
	Matcher m = tokSplitter.matcher(strline);

	while (m.find()) {
		tokens.add(m.group());
	}
	return tokens;
	
}
	
	

public String[] GetLineItemFromSearch(String strline) {

	String[] tokens = {} ;
	Pattern tokSplitter = Pattern.compile("product_table");
	Matcher m = tokSplitter.matcher(strline);
	if (m.find()) {
		 tokens = strline.split("product_table");

	};

	//System.out.println("line="+strline);
/*	while (m.find()) {
		tokens.add(m.group());
		System.out.println("m.group()="+m.group());
	}
*/	
	return tokens;
	
}

public String GetValueFromStringByPattern(String strline, String mypattern) {

	String returnstr="";
	//ArrayList<String> tokens = new ArrayList<String>();
	
	Pattern tokSplitter = Pattern.compile(mypattern);
	Matcher m = tokSplitter.matcher(strline);
	
		while (m.find()) {
		//tokens.add(m.group());
			returnstr = m.group(); 
		}
	return 	returnstr;
}
	
public String ConvertFileNameForColor(String strfilename, String color){
	int pos,pos1;
	String tmpstr,tmpstr1,result;

	pos1 = strfilename.indexOf("_");
	tmpstr = strfilename.substring(0, pos1+1);

	
	pos = strfilename.indexOf(".");
	tmpstr1 = strfilename.substring(pos);
	result = tmpstr.concat(color).concat(tmpstr1);
		
	return result;
}
	
public void UpdateColorsFromHref(String linkHref) {
    String nextLine,str1,str2, str0;
    String colorsString = "";
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader  inStream = null;
    BufferedReader buff = null;
    //List<String>  = new List<String>();
    List<String> listFullcolors;
	
    try{
        // index.html is a default URL's  file name  
         url  = new URL(linkHref);
         urlConn = url.openConnection();
         urlConn.setRequestProperty("User-Agent", "");
         
        inStream = new InputStreamReader( 
                          urlConn.getInputStream(), "UTF8");
          buff  = new BufferedReader(inStream);
          nextLine =buff.readLine();
          System.out.println("linkHref="+linkHref);  
     // Read and print the lines from index.html
       while (true){
    	 
     	  nextLine = buff.readLine();
     	  if (nextLine !=null){
        	  nextLine=nextLine.trim();
        	 // System.out.println("FullColor string1=");
        	  if (nextLine.startsWith("<select name=\"chosencolor\"")) {
        		  //<select name="chosencolor" id="chosencolor" onChange="dcs()">
        		  nextLine = buff.readLine();
        		  nextLine=nextLine.trim();
        		  System.out.println("FullColor string2=");
        		  while (nextLine.startsWith("</select>")!= true){
        			  nextLine = buff.readLine();
        			  nextLine = nextLine.trim();
        			  colorsString = colorsString.concat(nextLine);
        		  }
           // Получаем полные имена цветов со строки
        		  System.out.println("colorsString="+colorsString);
        		  listFullcolors = GetItemFromSearch (colorsString,"=\"[^<]+"); //"frmcolor=[^\"]+"); //Style#[^<]+
        		  System.out.println("listFullcolors="+listFullcolors.size());
        		  for (String items:listFullcolors) {
        			  //System.out.println("FullColor string=" + items);
        			  str1 = GetValueFromStringByPattern(items,"=\"[^\"]+");
        			  str0 = str1.substring(2); 
        			  str2 = items.substring(items.indexOf(">")+1) ;
        			  
//        			  if (colorsnamehashmap.containsKey(str0)!= true) {
        				  colorsnamehashmap.put(str0, str2);
        				  System.out.println("FullColor string=" + items+ " 1="+str0+" 2="+str2+ " colorsnamehashmap="+colorsnamehashmap.size());  
//        			  }
        			  
        			  
        		  }

        	  }

     		  
     	  }
          else{
              break;
          } 
       }//while


		} catch(MalformedURLException e){
		  System.out.println("Please check the URL:" + 
		                                      e.toString() );
		} catch(IOException  e1){
		 System.out.println("Can't read  from the Internet: "+ 
		                                     e1.toString() ); 
		} finally{
			 if (inStream != null){
			   try{	 
				 inStream.close();
				 buff.close();
			   } catch(IOException e1){
				  System.out.println("Can't close the streams: " + e1.getMessage());
			   }
			 }
}

//  for (String key: colorsnamehashmap.keySet())
//  System.out.println("key="+key+ "-"+colorsnamehashmap.get(key));

    
}

public void TransferFileToFTP (ArrayList<Productua> curlist) {
	String FullPathImgFile;
	String ftpDir = "/uamed.com.ua/www/image/data/newproduct/";
	
    FTPClient ftpClient = new FTPClient();
    try {

        ftpClient.connect(server, ConnectOpt.Getftp_port());
        ftpClient.login(ConnectOpt.Getftp_user(), ConnectOpt.Getftp_pass());
        ftpClient.enterLocalPassiveMode();

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        for(Productua curproduct : curlist){
		        
		        FullPathImgFile =  curproduct.imgdir + curproduct.GetFileName();
		        System.out.println("Full path ="+ FullPathImgFile);
		        // APPROACH #1: uploads first file using an InputStream
		        File firstLocalFile = new File(FullPathImgFile);
		
		        String firstRemoteFile = ftpDir + curproduct.GetFileName();
		        InputStream inputStream = new FileInputStream(firstLocalFile);
		
		        System.out.println("Start uploading first file "+FullPathImgFile);
		        boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
		        inputStream.close();
		        if (done) {
		            System.out.println("The first file is uploaded successfully."+firstRemoteFile);
		        }
		        //Загрузим еще и по цветам изображения
		        
		          ArrayList <ColorImage> colorslist = curproduct.GetColors(); 
		          if (colorslist.size() > 1) {
		        	  for(ColorImage curcolor: colorslist){
		        		  
		  		        FullPathImgFile =  curproduct.imgdir + curcolor.GetFileName();
				        System.out.println("Full path color ="+ FullPathImgFile);
				        // APPROACH #1: uploads first file using an InputStream
				        File firstLocalFilecolor = new File(FullPathImgFile);
				
				        String firstRemoteFilecolor = ftpDir + curcolor.GetFileName();
				        InputStream inputStreamcolor = new FileInputStream(firstLocalFilecolor);
				
				        System.out.println("Start uploading first file "+FullPathImgFile);
				        boolean donecolor = ftpClient.storeFile(firstRemoteFilecolor, inputStreamcolor);
				        inputStreamcolor.close();
				        if (donecolor) {
				            System.out.println("The color file is uploaded successfully.");
				        }
		        		  
		        		  
		        		  
		        		  
		        		  
		        	  }
		        	  
		          }
		        
		        
		        
        }       
        
    } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
	
}

public void DoAllProduct() throws Exception {

	MySQLAccess dao = new MySQLAccess();
	int i=1;
	//for (int i=0;i<=2;i++)
	for(Productua curproduct : list){
//		if (i<=2) {
			//curproduct.DownloadFile();
//	}
		i++;
	};
	
	//TransferFileToFTP (list);
///// not used anymore	//dao.writeProductToDataBase( list);
	//dao.writeProductToDataBase( list, colorsnamehashmap, ConnectOpt);

//	dao.RemoveOldProductFromDataBase( list, scladlist, 65, ConnectOpt);
	
}



public void DoReadLine() {
	
/*    String nextLine;
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader  inStream = null;
    BufferedReader buff = null;
    Integer AllStep = 0;
    boolean SkuCompleted = false;
    boolean LineNewItem = false;
    String AllColorsStr;
    String tmpname,tmpcolor;
    boolean needUpdateColor = false;
    
    try{
      // index.html is a default URL's  file name  
       url  = new URL(SiteURL);
       urlConn = url.openConnection();
       urlConn.setRequestProperty("User-Agent", "");
       
      inStream = new InputStreamReader( 
                        urlConn.getInputStream(), "UTF8");
        buff  = new BufferedReader(inStream);
        nextLine =buff.readLine();
        
   // Read and print the lines from index.html
     while (true){
//    	 if (list.size()>11) break;
    	     	     	 
          if (LineNewItem) {
        // пропускаем чтение потому что нашли в блоке по товару начало следующего	  
          }
          else { 
        	  LineNewItem = false;
        	  nextLine = buff.readLine();
        	  
        	  };          
          if (nextLine !=null){
        	  
        	//System.out.println(""+nextLine.length());
        	  nextLine=nextLine.trim();

        	if (nextLine.length()>21) {
        	//System.out.println(">21"+nextLine.length());
     //   	System.out.println(nextLine);
        	  
        	if (GetItemBegin(nextLine)) {
        		//for (int i=1;i<=6;i++) {//считываем остальные строки в блоке
        		curproduct = new Productua();
        		AllStep = 1;        
        		SkuCompleted = false;
        		
        		do {//считываем остальные строки в блоке
        			nextLine = buff.readLine();
        			if (nextLine == null) {break;};
        			if (nextLine.length()>21) {
        				
            			if (CheckLine(nextLine)) { //строка с изображением
	                		GetImg(nextLine, curproduct);
	           				AllStep++;
    					}        				
            			else if (GetColorImage(nextLine, curproduct)) { //строки с изображениями по цветам <div class="dptcbgrp"><div class="dptcb"
            				//цикл по цветам до строки с <div style="clear:both"></div>
            				AllColorsStr = "";
                    		do {//считываем остальные строки в блоке
                    			AllColorsStr = AllColorsStr.concat(nextLine) ;
                    			nextLine = buff.readLine();
                    			if (nextLine == null) {break;};
                    			
                    		} while (GetEndColorImageLine(nextLine)!=true);//do
            				
                    		System.out.println("Длина строки с цветами = "+AllColorsStr.length());
            				
            				//Процедура получения сокр. наименования цвета
            				//Заполнение списка цветов и файлов с изображением 
*//*                    		<div class="dptitem1">
                    		<div class="dptimg"><a href="/pages/prod/pc62c-scrub-tops.asp?navbar=&frmcolor=COOBL"><img src="/img/products/200x240/PC62C_COOBL.png" border="0" /></a></div>
                    		<div class="dptcbgrp"><div class="dptcb" style="border-color:#B2D1C9;background-color:#B2D1C9;"><a href="/pages/prod/pc62c-scrub-tops.asp?&frmcolor=COOBL"><img src="/images/spacer.gif" width="12" height="12" /></a></div>
                    		<div class="dptcb" style="border-color:#DE3F73;background-color:#DE3F73;"><a href="/pages/prod/pc62c-scrub-tops.asp?&frmcolor=FUCHS"><img src="/images/spacer.gif" width="12" height="12" /></a></div>
                    		<div class="dptcb" style="border-color:#B5BA46;background-color:#B5BA46;"><a href="/pages/prod/pc62c-scrub-tops.asp?&frmcolor=GIGRE"><img src="/images/spacer.gif" width="12" height="12" /></a></div>
							&frmcolor=FUCHS"                    		
                    		
*//*
                    		List<String> listcolor = GetItemFromSearch(AllColorsStr,"frmcolor=[^\"]+"); //Style#[^<]+
                    		
                    		needUpdateColor = false;                    		
                    		for (String item : listcolor) {
                    			ColorImage curcolorimg = new ColorImage();
                    			tmpcolor = item.substring(9,item.length());
                    			curcolorimg.SetShortColorName(tmpcolor);
                    			System.out.println("curproduct.GetFileName() ="+curproduct.GetFileName()+" tmpcolor="+tmpcolor);
                    			if (colorsnamehashmap.containsKey(tmpcolor)!= true) { //нет цвета в таблице
                    				colorsnamehashmap.put(tmpcolor, "");
                    				needUpdateColor = true;
                    				System.out.println("needUpdateColor = true;");
                    			 };
                    			
                    			tmpname = ConvertFileNameForColor(curproduct.GetFileName(),tmpcolor);
                    			
                    			curcolorimg.SetFileName(tmpname);
                    			curcolorimg.SetFileNameSite("/data/newproduct/"+tmpname);
                    			//http://www.uniformadvantage.com/img/products/600x720/
                    			curcolorimg.SetLinkImage("http://www.uniformadvantage.com/img/products/600x720/"+tmpname);
                    			
                    			curproduct.addColorImage(curcolorimg);
                    			
                    			System.out.println("цвета = "+curcolorimg.GetShortColorName()+" tmpname="+tmpname);
                    		}
                    		
                    		if (needUpdateColor) {
                    			UpdateColorsFromHref(curproduct.GetLinkHref());
                    			
                    		};
                    		
                    		
            			}
            			            			
            			else if (GetName(nextLine, curproduct)) {
            				AllStep++;
            			}
            			else if (GetArticul(nextLine, curproduct)) {
            				AllStep++;
            			}
            			else if (GetPrice(nextLine, curproduct)) {
            				AllStep++;
            				SkuCompleted = true;
            				LineNewItem = false;
            			}
            			else if (GetItemBegin(nextLine)) {
            				SkuCompleted = true;
            				LineNewItem = true;
            			}
            			else {};
        				
        			}//if length 21
        		} while (SkuCompleted == false); // end do	

        	//Добавляем обьект в список	
	        	if (AllStep >=5 ) {
	        		list.add(curproduct);
	        		System.out.println("Add item "+curproduct.GetArticul()+" "+curproduct.GetName()+" "+curproduct.GetPrice());
	        	}
	        	else {
	        		System.out.println("not all step");
	        		SkuCompleted = false;
	        	}
        	
        	}//endif
        	
        	}//lenght  
             //System.out.println(nextLine); 
          } 
          else{
            break;
          } 
      }
  } catch(MalformedURLException e){
    System.out.println("Please check the URL:" + 
                                        e.toString() );
  } catch(IOException  e1){
   System.out.println("Can't read  from the Internet: "+ 
                                       e1.toString() ); 
  } finally{
 	 if (inStream != null){
 	   try{	 
 		 inStream.close();
 		 buff.close();
 	   } catch(IOException e1){
 		  System.out.println("Can't close the streams: " + e1.getMessage());
 	   }
 	 }
  }

    
//    for (String key: colorsnamehashmap.keySet())
//        System.out.println("key="+key+ "-"+colorsnamehashmap.get(key));
	*/
}
	
public void DoReadLineSearchFormat() {
	
/*
    String nextLine,linkimg,filenamestr;
    String tmpstr,pnamenew,pname;
    int Pos1;
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader  inStream = null;
    BufferedReader buff = null;
    Integer AllStep = 0;
    String[]  strlist;
    boolean SkuCompleted = false;
    boolean LineNewItem = false;
    try{
      // index.html is a default URL's  file name  
       url  = new URL(SiteURL);
       urlConn = url.openConnection();
       urlConn.setRequestProperty("User-Agent", "");
       
      inStream = new InputStreamReader(
                        urlConn.getInputStream(), "UTF8");
        buff  = new BufferedReader(inStream);
        nextLine =buff.readLine();
        
   // Read and print the lines from index.html
     while (nextLine !=null){
        	  
        	//System.out.println(""+nextLine.length());
        	  //nextLine=nextLine.trim();

//        	if (nextLine.length()>21) {
        	//System.out.println(">21"+nextLine.length());

        	 strlist = GetLineItemFromSearch(nextLine);
        	 AllStep = 0;
        	 for (int i=1;i < strlist.length;i++) {
        	   
        		 System.out.println(strlist[i]);
        		 curproduct = new Productua();
        		 
        		 tmpstr = GetValueFromStringByPattern(strlist[i],"/img/products[^\"]+");
        		 System.out.println("linkimg="+tmpstr);
        		 String domainlnk = "http://www.uniformadvantage.com";
        		 
        		 linkimg=domainlnk+tmpstr;
        		  
        		  Pos1 = tmpstr.lastIndexOf("/");
        		  filenamestr = tmpstr.substring(Pos1+1);  

        		  System.out.println(" =_search="+linkimg+" fn="+filenamestr);
        	 	  //list.add(new Productua(linkimg,filenamestr,"C35","Top",15));
        		  

        		  curproduct.SetLinkImage(linkimg.replace("200x240","600x720"));
        		  curproduct.SetFileName(filenamestr);
        		  curproduct.SetFileNameSite("/data/newproduct/"+filenamestr);
      	   
        		 
        		 tmpstr = GetValueFromStringByPattern(strlist[i],"alt=\"[^\"]+");
        		 System.out.println("Name="+tmpstr);

        		 pname = tmpstr.substring(5, tmpstr.length());
        		  pnamenew = pname;
	    		  for (int ii=0;ii < pnamenew.length();ii++) {
	    			  if ((pname.charAt(ii))>127) {
	    				  pnamenew = pname.substring(0, i)+pname.substring(i+1,pname.length());
	    			  };
	    		  }
	    		  System.out.println("Namenew_serach="+pnamenew);
	    		  curproduct.SetName(pnamenew);
	    		  curproduct.SetNameUA("Топ женский медицинский");
	//    		  curproduct.SetNameUA("Брюки женские медицинские");
	//    		  curproduct.SetNameUA("Халат женский медицинский");
	//    		  curproduct.SetNameUA("Топ мужской медицинский");
	//    		  curproduct.SetNameUA("Топ женский медицинский с принтом");
	    		  
	//    		  curproduct.SetNameUA("Топ женский медицинский с принтом 100% хлопок");		  
	//    		  curproduct.SetNameDescriptionUA("Топ женский медицинский с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок.");
	    		  curproduct.SetNameDescriptionUA("Топ женский медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок.");
        		 
        		 tmpstr = GetValueFromStringByPattern(strlist[i],"Style#[^<]+");
        		 System.out.println("Articul="+tmpstr);
        		 if (GetArticul(tmpstr, curproduct)) {
        			 AllStep++;
        		 };

        		 
        		 tmpstr = GetValueFromStringByPattern(strlist[i],"\\$[\\d]+(\\.[\\d]+)?"); //(\.\d+)?
        		 System.out.println("Price="+tmpstr);
        		 if (GetPrice(tmpstr, curproduct)) {
        			 AllStep++;
        		 };
        		 
          		list.add(curproduct);
         		System.out.println("Add item _search_="+curproduct.GetArticul()+" "+curproduct.GetName()+" "+curproduct.GetPrice());
        		 
        	 };//for
        	 

        	 
        	 nextLine = buff.readLine();
             //System.out.println(nextLine); 
          
      }//while
     
  } catch(MalformedURLException e){
    System.out.println("Please check the URL:" + 
                                        e.toString() );
  } catch(IOException  e1){
   System.out.println("Can't read  from the Internet: "+ 
                                       e1.toString() ); 
  } finally{
 	 if (inStream != null){
 	   try{	 
 		 inStream.close();
 		 buff.close();
 	   } catch(IOException e1){
 		  System.out.println("Can't close the streams: " + e1.getMessage());
 	   }
 	 }
  }
*/

}

public Float ConvertTxtPriceToFloat(String strPrice){

	return Float.parseFloat(strPrice.trim());
}



public void GetColorsFromHref (String linkHref, Productua curproduct ) throws IOException{
	String tmpstr;
	Integer tmpi;
	Float f;
	Document doc = Jsoup.connect(linkHref)
			.userAgent("Mozilla")
			.timeout(3*60*1000)
			.get();
	Map<Float, Integer > listPrice = new HashMap<Float, Integer>();
	
	Elements ColorSKUElements = doc.getElementsByClass("cblock-wrapper");
	for (Element colorSKU:ColorSKUElements) {
		
		Elements colorSKUDetails = colorSKU.select("[data-color]");//
		String ShortColorName	 = colorSKUDetails.attr("data-color");
		
		colorSKUDetails = colorSKU.select("[data-fullColorName]");//
		String FullColorName	 = colorSKUDetails.attr("data-fullColorName");

		colorSKUDetails = colorSKU.select("[title]");//
		String PriceTitle	 = colorSKUDetails.attr("title");
		tmpstr = GetValueFromStringByPattern(PriceTitle,"\\$[\\d]+(\\.[\\d]+)?");
		tmpstr = tmpstr.substring(1);
		f = ConvertTxtPriceToFloat(tmpstr);
		System.out.println("priceColor = "+tmpstr);


		ColorImage curcolorimg = new ColorImage();
		curcolorimg.SetPrice(f);
		curcolorimg.SetPriceUAH(curproduct.GetUaPriceWithAdd(f));
		curcolorimg.SetShortColorName(ShortColorName);
		curcolorimg.SetFullColorName(FullColorName);
		
		String tmpname = ConvertFileNameForColor(curproduct.GetFileName(),ShortColorName);
		curcolorimg.SetFileName(tmpname);
		curcolorimg.SetFileNameSite("/data/newproduct/"+tmpname);
		//http://www.uniformadvantage.com/img/products/600x720/
		curcolorimg.SetLinkImage("http://www.uniformadvantage.com/img/products/600x720/"+tmpname);
		
		curproduct.addColorImage(curcolorimg);
		System.out.println("curcolorimg.GetFileNameSite() = "+curcolorimg.GetFileNameSite());

// For get Average Prices, count prices
		tmpi = listPrice.get(f);
		if (tmpi != null) {
			tmpi++;
			listPrice.put(f,tmpi);
		}
		else{
			listPrice.put(f,1);
		};
	}


	System.out.println("priceBefore = "+curproduct.GetPrice());
	int maxcountprice = 0;
	f = (float)0;
	//Set Average Prices
	for (Map.Entry<Float, Integer> ientry : listPrice.entrySet()) {

		if (ientry.getValue() > maxcountprice){
			maxcountprice = ientry.getValue() ;
			f = ientry.getKey() ;
		}

	}
	curproduct.SetPrice(f);
	curproduct.SetPriceUAH(curproduct.GetUaPriceWithAdd(f));
	System.out.println("priceAfter = "+curproduct.GetPrice());

	
}

public void DoReadJsoup() throws IOException {
	String strNameUa;
	//for translate
	Translate MyTranslate = new Translate ();

	//urlConn.setRequestProperty("User-Agent", "");
	Document doc = Jsoup.connect(SiteURL)
			.userAgent("Mozilla")
			.timeout(3*60*1000)
			.get();
	String title = doc.title();
	System.out.println("title = "+title);
	Elements content = doc.getElementsByClass("productList");
	//Elements content = doc.getElementsByClass("dptcopy");


	for (Element elementsSKU:content) {

		String textBlockGoods = elementsSKU.text();
//		System.out.println("1.linkImg1="+textBlockGoods);
//		Elements SKU =	elementsSKU.select("dptitem");
//		Elements SKU =	doc.select("li.dptitem");
		Elements SKU =	elementsSKU.select("li.dptitem");
		
		for (Element elementsSKULow:SKU) {
		
			if (!textBlockGoods.isEmpty()) {
				
				Elements imageSKU =	elementsSKULow.getElementsByClass("dptimg");
				
				Elements imageSKUSrc = imageSKU.select("a[href]");//
				String linkHref = imageSKUSrc.attr("href");
				
				Elements imageSKUSrc2 = imageSKU.select("img[src]");//
				String linkImg0  = imageSKUSrc2.attr("src");
				
				Elements styleSKU =	elementsSKULow.getElementsByClass("dptstyle");
				String styleTxt = styleSKU.text();
	
				Elements NameSKU =	elementsSKULow.getElementsByClass("dptcopy");
				String NameTxt = NameSKU.text();
				
				Elements PriceSKU =	elementsSKULow.getElementsByClass("dptprice");
				String PriceTxt = PriceSKU.text();
				
				if (PriceSKU.isEmpty()) {
					
					PriceSKU =	elementsSKULow.getElementsByClass("dptsale");
					PriceTxt = PriceSKU.text();
					System.out.println("PriceSKU.empty()= Price:"+PriceTxt);
					
					if (PriceSKU.isEmpty()) {
						continue;
					}
									
				};
				

				System.out.println("2.linkImg="+linkImg0+" linkHref="+linkHref+ "styleTxt="+styleTxt+ " NameTxt="+NameTxt+ " PriceTxt="+PriceTxt);

				//Добавляем продукт в список
				curproduct = new Productua();	  			
	  			String domainlnk = "http://www.uniformadvantage.com";
    		    String linkimg = domainlnk+linkImg0;
       		    curproduct.SetLinkImage(linkimg.replace("200x240","600x720"));
       		    
	      		int Pos1 = linkImg0.lastIndexOf("/");
	      		String filenamestr = linkImg0.substring(Pos1+1);  
	      		curproduct.SetFileName(filenamestr);
	      		
	      		curproduct.SetFileNameSite("/data/newproduct/"+filenamestr);
	    	
	      		curproduct.SetName(NameTxt);

				//Top			- Топ
				//Pant			- Брюки
				//Jacket		- Куртка
				//Lab Coat		- Халат
				//3/4 Sleeve    - 3/4 рукав
				//Maternity		- для беременных
				//Drawstring 	- прямые
				//Unisex 		- женский, мужской(unisex)
				//Men			- мужской
				//Men's  		- мужской
				//Women's 		- женский
				//Ladies		- женский
				//PETITE  		- укороченные
				//Petite		- укороченные
				//TALL 			- удлиненные
				//Jean Style
				//Mid Rise
				//8-Pocket 		-
				//Full Length	- полной длины
				//Skirt			- Юбка
				//Contemporary Fit
				//with			- с
				//Back Elastic	- резинкой сзади
				//Elastic Waist - на резинке
				//Zipper Fly 	- на молнии
				//Zip Front 	- на молнии




	    		//curproduct.SetNameUA("Топ женский медицинский с принтом");
				strNameUa = MyTranslate.NameTranslate(NameTxt, curproduct);

//				curproduct.SetNameUA(strNameUa);
				curproduct.SetNameUA(strNameUa+"с принтом");

				//curproduct.SetNameUA("Топ женский, мужской(unisex) медицинский");
	      		//curproduct.SetNameUA("Костюм женский медицинский");
				//curproduct.SetNameUA("Топ женский медицинский");
	      		//curproduct.SetNameUA("Брюки женские медицинские");
	      		//curproduct.SetNameUA("Халат женские медицинский");
//	      		curproduct.SetNameUA("Куртка женская медицинская с рисунком");
	      		
	      		//curproduct.SetNameDescriptionUA("Топ женский медицинский с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 100% хлопок.");
				//  curproduct.SetNameDescriptionUA("Костюм женский медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиестер/хлопок.");
//
// 				curproduct.SetNameDescriptionUA(strNameUa+"с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиэстер/хлопок.");
				curproduct.SetNameDescriptionUA(strNameUa+"с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 100% хлопок.");
//				curproduct.SetNameDescriptionUA(strNameUa+". Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиэстер/хлопок.");
				//curproduct.SetNameDescriptionUA("Топ женский, мужской(unisex) медицинский с принтом. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиэстер/хлопок.");
	    		//curproduct.SetNameDescriptionUA("Брюки женские медицинские. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок. Цвета в ассортименте.");
	    		//curproduct.SetNameDescriptionUA("Халат медицинский. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиестер/хлопок. Цвета в ассортименте.");
	      		//curproduct.SetNameUA("Халат женский медицинский");
	      		//curproduct.SetNameDescriptionUA("Куртка женская медицинская. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 65/35 полиестер/хлопок. Цвета в ассортименте.");
//				  curproduct.SetNameDescriptionUA("Куртка женская медицинская с рисунком. Имеются выточки и боковые разрезы. Медицинская одежда изготовлена из мягкой и легкой в уходе ткани 55/45 полиестер/хлопок. Цвета в ассортименте.");
	    		
	    		String tmpstr = GetValueFromStringByPattern(styleTxt,"#[^<]+");
	    		tmpstr = tmpstr.substring(2);
	       		//System.out.println("Articul="+tmpstr);
	       		curproduct.SetArticul(tmpstr.trim());

       			tmpstr = GetValueFromStringByPattern(PriceTxt,"\\$[\\d]+(\\.[\\d]+)?"); //(\.\d+)?
       			
       			if (tmpstr.isEmpty()) {
       					continue;
       			}
       			
       			tmpstr = tmpstr.substring(1);
       			System.out.println("Price="+tmpstr);
       			float f = ConvertTxtPriceToFloat(tmpstr);
      		    curproduct.SetPrice(f);
       		    curproduct.SetPriceUAH(curproduct.GetUaPriceWithAdd(f));
       		    System.out.println("PriceUA="+curproduct.GetPriceUAH());
	    						
       		    
				//checking for colors and if got it do reading colors
				//Elements SKUcolor =	elementsSKULow.select("li.dptcbgrp");
				Elements cbgrpSKU =	elementsSKULow.getElementsByClass("dptcbgrp");
				Elements colorSKU =	cbgrpSKU.select("li.colorBlock");
				if (!colorSKU.isEmpty()) {
					System.out.println("Find colors: "+colorSKU.size());
//					
					GetColorsFromHref(SiteURLRoot+linkHref, curproduct);
				}

				list.add(curproduct);
         		System.out.println("Add item("+list.size()+")="+curproduct.GetArticul()+" "+curproduct.GetName()+" "+curproduct.GetPrice()+" tr="+NameTxt+" - "+curproduct.GetNameUA()+" Manuf="+curproduct.GetManufactureID());
				//System.out.println("Sex-"+curproduct.GetSex());
				
			}
			
			

		}
	}
	
	
		
}//	DoReadJsoup() {

}//class
