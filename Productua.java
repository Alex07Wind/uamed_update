package de.vogella.mysql.first.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import de.vogella.mysql.first.test.Sex;




public class Productua {

	public static double kurs = 27.5;
	public static double comission = 1.25;
	public static double kcargo = 1.52;


	public String linkimage;
	public String articul;
	public String name;
	public String nameua;
	public String namedescrua;
	public String filename;
	public String filenamesite;
	public float price;
	public float priceuah;
	public Sex   sex;
	//public String imgdir = "/home/alexander/Downloads/top/new/";
//	public String imgdir = "/home/alexander/Downloads/top/solid/";
	public String imgdir = "/home/alex/Downloads/top/solid/";
// 	public String imgdir = "/home/alexander/Downloads/top/cherokee/";
//	public String imgdir = "/home/alexander/Downloads/top/spa/";
//	public String imgdir = "/home/alexander/Downloads/top/sale/";
//	public String imgdir = "/home/alexander/Downloads/top/winter2016/";

//	public String imgdir = "/home/alexander/Downloads/top/spring2016/";
//	public String imgdir = "/home/alexander/Downloads/top/topstretch/";
//	public String imgdir = "/home/alexander/Downloads/top/fall2016/";
	public ArrayList <ColorImage> colors;
	public String linkhref;
	public Integer manufactureID;
	public ArrayList <Integer> categoryID;

	public Productua() {
		colors 		= new ArrayList <ColorImage>();
		categoryID 	= new ArrayList <Integer>();

/*		this.linkimage = linkimage;
		this.filename = filename;
		this.articul = articul;
		this.name = name;
		this.price = price;
*/
	}
	public void SetName( String newname) {
		name = newname;
	}
	public void SetNameUA( String newnameua) {
		nameua = newnameua;
	}
	public void SetNameDescriptionUA( String newnamedescrua) {
		namedescrua = newnamedescrua;
	}
	public void SetFileName( String newfname) {
		filename = newfname;
	}
	public void SetFileNameSite( String newfnamesite) {
		filenamesite = newfnamesite;
	}
	
	public void SetLinkImage( String newlink) {
		linkimage = newlink;
	}
	public void SetArticul( String newarticul) {
		articul = newarticul;
	}
	public void SetPrice( float newprice) {
		price = newprice;
	}
	public void SetPriceUAH( float newpriceuah) {
		priceuah = newpriceuah;
	}
	public void addColorImage( ColorImage newcolors) {
		colors.add(newcolors) ;
	}
	public void SetLinkHref( String newlink) {
		linkhref = newlink;
	}
	public void SetSex(Sex newsex) { this.sex = newsex;	}
	public void SetManufactureID(Integer newid) { this.manufactureID = newid;	}
	public void AddCategoryID (Integer newid) {
			this.categoryID.add(newid);
	}

	public String GetName() {
		return name;
	}
	public String GetNameUA() {
		return nameua;
	}
	public String GetNameDescriptionUA() {
		return namedescrua;
	}
	public String GetFileName() {
		return filename;
	}
	public String GetFileNameSite() {
		return filenamesite;
	}
	
	public String GetLinkImage() {
		return linkimage;
	}
	public String GetArticul() {
		return articul;
	}
	public float GetPrice() {
		return price;
	}
	public float GetPriceUAH() {
		return priceuah;
	}
	public ArrayList <ColorImage> GetColors() {
		return colors;
	}
	public String GetLinkHref() {
		return linkhref;
	}
	public Sex GetSex() { return sex;	}
	public Integer GetManufactureID() { return manufactureID; }
	public ArrayList <Integer> GetCategoryID() { return categoryID; }

	public void DownloadFile(){
		  String tmplink, tmpfname;	
		  InputStream in=null;
		  FileOutputStream fOut=null;

		  try{
		    URL remoteFile=new URL(linkimage);
		    URLConnection fileStream=remoteFile.openConnection();
		    fileStream.setRequestProperty("User-Agent", "");
		    
		    // Open output and input streams
		    fOut=new FileOutputStream(imgdir+filename);
		  
		    in=fileStream.getInputStream();

		    // Save the file
		    int data;
		    while((data=in.read())!=-1){
		         fOut.write(data);
		    }  

		  } catch (Exception e){
		     //e.printStackTrace();
		     System.out.println("try whith jpg");
			  try{
				  tmplink= GetLinkImage();
				  
				  SetLinkImage(tmplink.replace(".png",".jpg"));
				  
				  
				  	URL remoteFile=new URL(GetLinkImage());
				    URLConnection fileStream=remoteFile.openConnection();
				    fileStream.setRequestProperty("User-Agent", "");
				    
				    // Open output and input streams
				    
				    tmpfname = GetFileName();
				    SetFileName(tmpfname.replace(".png",".jpg"));
				    
				    tmpfname = GetFileNameSite();
				    SetFileNameSite(tmpfname.replace(".png",".jpg"));
				    
				    
				    
				    fOut=new FileOutputStream(imgdir+GetFileName());
				  
				    
				    in=fileStream.getInputStream();
				    // Save the file
				    int data;
				    while((data=in.read())!=-1){
				         fOut.write(data);
				    }  

			  } catch (Exception ejpg){
				  	ejpg.printStackTrace();
				     System.out.println("try whith jpg also failed");    
			  } finally{
				  
			  };    

		  
		  } finally{
			//  System.out.println("The file " + linkimage + 
			//	" has been downloaded successfully as " + articul);
			  System.out.println("file download "+linkimage);
		     try{
		       in.close();
		       fOut.flush(); 
		       fOut.close();      
		     } catch(Exception e){e.printStackTrace();}
		  }
			
		 //если нужно загружать цвета
		  for (ColorImage item : colors) {
			  
			  try{
				    URL remoteFile=new URL(item.GetLinkImage());
				    URLConnection fileStream=remoteFile.openConnection();
				    fileStream.setRequestProperty("User-Agent", "");
				    
				    // Open output and input streams
				    fOut=new FileOutputStream(imgdir+item.GetFileName());
				  
				    
				    in=fileStream.getInputStream();
				    // Save the file
				    int data;
				    while((data=in.read())!=-1){
				         fOut.write(data);
				    }  


				  } catch (Exception e){
				     //e.printStackTrace();
				     System.out.println("try whith jpg");
				     
					  try{
						  tmplink= item.GetLinkImage();
						  
						  item.SetLinkImage(tmplink.replace(".png",".jpg"));
						  
						  
						  	URL remoteFile=new URL(item.GetLinkImage());
						    URLConnection fileStream=remoteFile.openConnection();
						    fileStream.setRequestProperty("User-Agent", "");
						    
						    // Open output and input streams
						    
						    tmpfname = item.GetFileName();
						    item.SetFileName(tmpfname.replace(".png",".jpg"));
						    
						    tmpfname = item.GetFileNameSite();
						    item.SetFileNameSite(tmpfname.replace(".png",".jpg"));
						    
						    
						    
						    fOut=new FileOutputStream(imgdir+item.GetFileName());
						  
						    
						    in=fileStream.getInputStream();
						    // Save the file
						    int data;
						    while((data=in.read())!=-1){
						         fOut.write(data);
						    }  

					  } catch (Exception ejpg){
						  	ejpg.printStackTrace();
						     System.out.println("try whith jpg also failed");    
					  } finally{
						  
					  };    
				     
				     
				     
				  } finally{
					//  System.out.println("The file " + linkimage + 
					//	" has been downloaded successfully as " + articul);
					  System.out.println("file download "+item.GetLinkImage()+" to "+item.GetFileName());
				     try{
				       in.close();
				       fOut.flush(); 
				       fOut.close();      
				     } catch(Exception e){e.printStackTrace();}
				  }
			  
			  
		  }
		///если нужно загружать цвета 
		  
		  
		  
		  
		  
		 }

	public static Float GetUaPriceWithAdd(Float fPrice){

		double fuah = Math.ceil(kurs*comission*kcargo*fPrice/5)*5;

		return (float)fuah;
	}


}
