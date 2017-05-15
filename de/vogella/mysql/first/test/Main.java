package de.vogella.mysql.first.test;

import de.vogella.mysql.first.MySQLAccess;

public class Main {
	public static Productua curproduct;
	public static void main(String[] args) throws Exception {
    //MySQLAccess dao = new MySQLAccess();
    //dao.writeProductToDataBase();
	GetHtmlSite MyGetSite = new GetHtmlSite ();
//	MyGetSite.DoReadLineSearchFormat();
	//MyGetSite.DoReadLine();

	MyGetSite.DoReadJsoup();
	MyGetSite.DoAllProduct();
	
	
	// MyGetSite.CheckLine("<div class=\"dptimg\"><a href=\"/pages/prod/song-bird-navy-print-top.asp?navbar=&frmcolor=\"><img src=\"/img/products/200x240/UA788SBN.png\" border=\"0\" /></a></div>");
//	curproduct = new Productua();
	
//	MyGetSite.GetImg("<div class=\"dptimg\"><a href=\"/pages/prod/song-bird-navy-print-top.asp?navbar=&frmcolor=\"><img src=\"/img/products/200x240/UA788SBN.png\" border=\"0\" /></a></div>", curproduct);
	
//	curproduct.DownloadFile();
//	MyGetSite.TransferFileToFTP (curproduct);
	//MyGetSite.GetName("<div class=\"dptcopy\"><a class=\"dptcopy\" href=\"/pages/prod/song-bird-navy-print-top.asp?navbar=4&frmcolor=\">UA Song Bird Navy Print Scrub Top</a></div>", curproduct);
	//MyGetSite.GetArticul("<div class=\"dptstyle\"><a class=\"dptstyle\" href=\"/pages/prod/song-bird-navy-print-top.asp?navbar=4&frmcolor=\">Style #  UA788SBN</a></div>", curproduct);
	//MyGetSite.GetPrice("<div class=\"dptprice\">As low as $15.99</div>", curproduct);
	}

} 
