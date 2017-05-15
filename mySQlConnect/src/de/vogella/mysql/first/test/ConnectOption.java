package de.vogella.mysql.first.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ConnectOption {
	public int		ftp_port = 21;
	public String 	ftp_user = "";
	public String 	ftp_pass = "";
	public String linkDBMysql ="";
	public String name_db ="";
	public String name_userdb ="";
	public String password_userdb ="";
	public ConnectOption() {

	    JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("/home/alex/uamed/setup.json"));

			JSONObject jsonObject = (JSONObject) obj;

			linkDBMysql = (String) jsonObject.get("link_to_db_mysql");
			System.out.println("linkDBMysql="+linkDBMysql);
			

			name_db = (String) jsonObject.get("name_db");
			System.out.println("name_db="+name_db);

			name_userdb = (String) jsonObject.get("name_userdb");
			System.out.println("name_userdb="+name_userdb);

			password_userdb = (String) jsonObject.get("password_userdb");
			System.out.println("password_userdb="+password_userdb);
			
			ftp_port = (int) (long)  jsonObject.get("ftp_port");
			System.out.println("ftp_port="+ftp_port);

			ftp_user = (String) jsonObject.get("ftp_user");
			System.out.println("ftp_user="+ftp_user);

			ftp_pass = (String) jsonObject.get("ftp_pass");
			System.out.println("ftp_pass="+ftp_pass);
//			long age = (Long) jsonObject.get("age");
//			System.out.println(age);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}//connectOption

public void SetlinkDBMysql( String newname) {
			linkDBMysql = newname;
}
public String GetlinkDBMysql() {
	return linkDBMysql;
}
public void Setname_db( String newname) {
	name_db = newname;
}
public String Getname_db() {
	return name_db;
}
public void Setname_userdb( String newname) {
	name_userdb = newname;
}
public String Getname_userdb() {
		return name_userdb;
}
public void Setpassword_userdb( String newname) {
	password_userdb = newname;
}
public String Getpassword_userdb() {
		return password_userdb;
}
public void Setftp_port( Integer newint) {
	ftp_port = newint;
}
public Integer Getftp_port() {
		return ftp_port;
}

public void Setftp_user( String newname) {
	ftp_user = newname;
}
public String Getftp_user() {
		return ftp_user;
}

public void Setftp_pass( String newname) {
	ftp_pass = newname;
}
public String Getftp_pass() {
		return ftp_pass;
}

	
}//class
