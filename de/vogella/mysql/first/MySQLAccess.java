package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.lang.Math;

import de.vogella.mysql.first.test.ColorImage;
import de.vogella.mysql.first.test.DeActivateItem;
import de.vogella.mysql.first.test.Productua;
import de.vogella.mysql.first.test.ConnectOption;


public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private ArrayList<Integer> sizePrd = new ArrayList<Integer>();
  //private ArrayList<Integer> categoryPrd = new ArrayList<Integer>();
  private HashSet<Integer> categoryPrd = new HashSet<>();

//	HashSet<String> countryHashSet = new HashSet<>();


  public  MySQLAccess()  {

	  	sizePrd.add(214);	//XS
	  	sizePrd.add(46);	//S
	  	sizePrd.add(47);	//M
	  	sizePrd.add(48);	//L
	  	sizePrd.add(103);	//XL
	    sizePrd.add(215); 	//2XL
	    sizePrd.add(216);	//3XL





	    
//    	categoryPrd.add(20); // Для женщин
//    	categoryPrd.add(18); // Для мужчин
    	
//    		categoryPrd.add(32); // UAScrubs
//	  		categoryPrd.add(102); // UAScrubs Butter Soft
//    		categoryPrd.add(110); // UAScrubs Butter Soft Easy    	
//    		categoryPrd.add(85); // wonder wink
//      		categoryPrd.add(105); // UA Scrubs Butter-Soft Stretch    
//			categoryPrd.add(107); // UA Scrubs Advantage Butter-Soft Stretch
    		categoryPrd.add(83); //Cherokee brand
//    		categoryPrd.add(111); //Cherokee Tooniforms Scrubs с рисунком мультфильмов
//    		categoryPrd.add(112); //Zoe+Chloe
//    		categoryPrd.add(113); //Dickies
//    		categoryPrd.add(114); //Barco
//    		categoryPrd.add(121); // UAScrubs Strictly
//	   		categoryPrd.add(63); // Fashion Seal
//	  		categoryPrd.add(122); // Koi



//	  		categoryPrd.add(57); // UA Accessory
//    		categoryPrd.add(66); // UA Scrubs Set Women
//        	categoryPrd.add(65);    //блузы с принтом
//    		categoryPrd.add(26);     //блузы солид женские
//      		categoryPrd.add(59);     //Брюки солид женские
//      	categoryPrd.add(27); // Халаты медицинские женские
      		//categoryPrd.add(46); // Мужские топы
//	  		categoryPrd.add(45); // Мужские брюки солид
//        	categoryPrd.add(104); // Top stretch pant and top      	

  	
//  	     categoryPrd.add(73);    //блузы солид mock wrap
//	    categoryPrd.add(74);    //куртки солид
      	
//        categoryPrd.add(72);    //весенняя коллекция
//      	categoryPrd.add(68);    //новинки
//     	categoryPrd.add(69);    //блузы с принтом животных
//      	categoryPrd.add(71);    //блузы с принтом бабочек
//      	categoryPrd.add(75);    //блузы с принтом праздничные
//      	categoryPrd.add(76);    //блузы с принтом для педиатров
//      	categoryPrd.add(77);    //блузы с принтом 100%
//  	        categoryPrd.add(78);    //блузы с принтом стрейчевые
//           categoryPrd.add(79);    //блузы с принтом тропические
//           categoryPrd.add(80);    //блузы с принтом классические
//           categoryPrd.add(81);    //блузы с принтом цветов
//           categoryPrd.add(82);    //блузы с принтом для стоматологов
//       	categoryPrd.add(90);    //блузы с принтом ceil blue
//       	categoryPrd.add(88);    //блузы с принтом navy
//       	categoryPrd.add(89);    //блузы с принтом Royal
//       	categoryPrd.add(87);    //блузы с принтом Black
       	//categoryPrd.add(91);    //блузы с принтом Teal
       	//categoryPrd.add(92);    //блузы с принтом Turquoise
       	//categoryPrd.add(93);    //блузы с принтом Eggplant
      //categoryPrd.add(94);    //блузы с принтом Wine
//      categoryPrd.add(95);    //блузы с принтом Fuchsia
        //categoryPrd.add(96);    //блузы с принтом Pewter
        //categoryPrd.add(97);    //блузы с принтом Red
      	//categoryPrd.add(98);    //блузы с принтом White
      	//categoryPrd.add(99);    //блузы с принтом Khaki
      	//categoryPrd.add(100);    //блузы с принтом Coffee bean
//      	categoryPrd.add(101);    //Sofies
//      	categoryPrd.add(103);    //Summer 2016
//          	categoryPrd.add(106);    //Fall 2016
//          	categoryPrd.add(108);    //Fall 2016
//  			categoryPrd.add(109);    //Блузы с принтом причудливых животных
//	  			categoryPrd.add(115);    //Winter 2016
//	  			categoryPrd.add(116);    //Winter 2016
//			    categoryPrd.add(117);    //Куртки с принтом
//			    categoryPrd.add(118);    //Куртки с принтом
//			    categoryPrd.add(119);    //Black Friday
//			    categoryPrd.add(120);    //Spring Preview 2017
//			    categoryPrd.add(123);    //SPA
//	  			categoryPrd.add(124);    //Акция
//      			categoryPrd.add(126);    //Summer 2017


  }
  
  //	//Map<String, String> colorsnamehashmap  
  public void writeProductToDataBase(ArrayList<Productua> curlist, Map<String, String> curcolorshashmap, ConnectOption ConnectOpt) throws Exception {
    
	Integer idMax = 1;
    Integer idOptionMax = 1;
    Integer idOptionColorMax = 1;
    Integer idOptionValueMax = 1;
    Integer idCategoryMax = 1;
    Integer idproduct_reward =1;
    Integer idOptionValue_ID_DescrMax =1;
    Integer inum=0;
    boolean newProduct = false;
    String  articulUpdate = "Model2";
    String linkDBMysql ="";
    String name_db ="";
    String name_userdb ="";
    String password_userdb ="";

	float addPriceForXXL =(float) Math.ceil(Productua.kurs*Productua.comission*Productua.kcargo*3/5)*5; // get extra price for XXL

	//  float addPriceForXXL =  Productua.GetUaPriceWithAdd((float)3); // get extra price for XXL

    
    boolean DoNotCreateItem = false;
    boolean UpdateDescription = false;
    
   
    
	  try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://"+ConnectOpt.GetlinkDBMysql()+"/"+ConnectOpt.Getname_db()+"?"
              + "user="+ConnectOpt.Getname_userdb()+"&password="+ConnectOpt.Getpassword_userdb());
      
      
      for(Productua curproduct : curlist){  
    	  
       	  articulUpdate = curproduct.GetArticul();
    	  idOptionMax = 1;
    	  idOptionValueMax = 1;
    	  idOptionColorMax = 1;
    	  idCategoryMax = 1;
    	  idOptionValue_ID_DescrMax = 1;
    	  idproduct_reward =1;
    	  newProduct = false;
    	  idMax=1;

     if (inum==2) {
//    	break;//выходим из цикла на 2-м товаре
     };
     inum++;
    
      // Statements allow to issue SQL queries to the database
/*      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from uamed_db.product limit 0,30");
      writeMetaData(resultSet);
      
      writeResultSet(resultSet);
 */
      preparedStatement = connect
      		  .prepareStatement("select product_id from uamed_db.product where model=?");
      preparedStatement.setString(1, articulUpdate);
      resultSet = preparedStatement.executeQuery();
      System.out.println("Articul="+articulUpdate+"idMax="+ idMax+" "+curproduct.GetArticul());
      while (resultSet.next()) {
    	  idMax = resultSet.getInt(1);
          System.out.println("id("+articulUpdate+") ="+ idMax);
      }

      
      if (idMax == 1 ){ //создаем новую запись

    	  if (DoNotCreateItem) {
        	  continue; //пропускаем создание новой записи    		  
    	  };    	  
              preparedStatement = connect
                  .prepareStatement("insert into  uamed_db.product (model,sku,upc,ean,jan,isbn,mpn,location,quantity,stock_status_id,image,manufacturer_id,price,tax_class_id,date_available,weight_class_id,length_class_id,status)" +
                  							" values ( ?, ?,'','','','','','', ?, ? , ?, ?, ?, ?, ?, ?, ?, ?)");
              newProduct = true;
              System.out.println("Новая запись >"+articulUpdate+"<");
      }//if
      else { //обновляем существующую
    	  newProduct = false;
          preparedStatement = connect
                  .prepareStatement("update uamed_db.product set model=?," +
                  		"sku=?," +
                  		"upc=''," +
                  		"ean=''," +
                  		"jan=''," +
                  		"isbn=''," +
                  		"mpn=''," +
                  		"location=''," +
                  		"quantity=?," +
                  		"stock_status_id=?," +
                  		"image=?," +
                  		"manufacturer_id=?," +
                  		"price=?," +
                  		"tax_class_id=?," +
                  		"date_available=?," +
                  		"weight_class_id=?," +
                  		"length_class_id=?," +
                  		"status=?" +
                  		" where uamed_db.product.product_id=?") ;
          	
    	  
    	  
      };

              preparedStatement.setString(1, curproduct.GetArticul());
              preparedStatement.setString(2, curproduct.GetArticul());
              preparedStatement.setInt(3, 0);
              preparedStatement.setInt(4, 8);
              //preparedStatement.setDate(5, new java.sql.Date(2009, 12, 11));
              preparedStatement.setString(5, curproduct.GetFileNameSite());

		  		preparedStatement.setInt(6, curproduct.GetManufactureID());
//              preparedStatement.setInt(6, 18); //manufactured id UA Scrubs Butter Soft
//              preparedStatement.setInt(6, 17); //manufactured id wonder wink
//              preparedStatement.setInt(6, 20); //manufactured id UA Scrubs Advantage Butter Soft
//                preparedStatement.setInt(6, 10); //manufactured id Scrubs
		  //	preparedStatement.setInt(6, 11); //manufactured id BestBuy
//		   		preparedStatement.setInt(6, 25); //manufactured id UA Strictly Scrubs
//              preparedStatement.setInt(6, 21); //manufactured id UA Scrubs Easy Butter Soft
//             	preparedStatement.setInt(6, 16); //manufactured id Cherockee
//              preparedStatement.setInt(6, 22); //manufactured id Zoe Chloe
//              preparedStatement.setInt(6, 23); //manufactured id Dickies
//              preparedStatement.setInt(6, 24); //manufactured id Barco



              preparedStatement.setDouble(7, curproduct.GetPriceUAH());
              
              preparedStatement.setInt(8, 0);      
              Calendar calendar = Calendar.getInstance();
              java.sql.Date dt = new java.sql.Date(calendar.getTime().getTime());
              
//              preparedStatement.setDate(9, new java.sql.Date(2015, 11, 11));
              preparedStatement.setDate(9, dt);
              preparedStatement.setInt(10, 1);
              preparedStatement.setInt(11, 1);
              preparedStatement.setInt(12, 1);
              if (newProduct != true)  {  
              preparedStatement.setInt(13, idMax);
              }
              preparedStatement.executeUpdate();
              
          if (newProduct==true)  {              
    	  //получаем id новой записи для созданного продукта
    	  preparedStatement = connect
          	//	  .prepareStatement("select MAX(product_id) from uamed_db.product");
    			  .prepareStatement("select product_id from uamed_db.product where model=?");
    	  preparedStatement.setString(1, articulUpdate);
    	  //
          resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
              idMax = resultSet.getInt(1);
              System.out.println("idMax ="+ idMax);
          }//while
          }//if
      
    
      
      
      
  /* 
      // PreparedStatements can use variables and are more efficient
*/

/*
      preparedStatement = connect
          //.prepareStatement("SELECT myuser, webpage, datum, summery, COMMENTS from feedback.comments");
    		  .prepareStatement("select * from uamed_db.product limit 0,30");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);
      writeResultSet(resultSet);
 
 */
     
      
      

 	  //writeMetaData(resultSet);
          //новый запрос для update 
          if (newProduct) {
          preparedStatement = connect
              .prepareStatement("insert into uamed_db.product_description (product_id,language_id,name,description,meta_description,meta_keyword,seo_title,seo_h1,tag)" +
              							" values ( ?,1,?,?,?,?,?,?,''),( ?,2,?,?,?,?,?,?,'')");
          preparedStatement.setInt(1, idMax);
          preparedStatement.setString(2, curproduct.GetNameUA()+" ("+curproduct.GetArticul()+")");
          preparedStatement.setString(3, curproduct.GetNameDescriptionUA());
          preparedStatement.setString(4, curproduct.GetNameUA()+", медицинская одежда медичний одяг топ с рисунком блуза с принтом медицинский костюм халат куртка блуза с длинным рукавом"); //
//          preparedStatement.setString(4, curproduct.GetNameUA()+", медицинская одежда медичний одяг");
          preparedStatement.setString(5, curproduct.GetNameUA()+" ("+curproduct.GetArticul()+")"+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом"); // c рисунком
          preparedStatement.setString(6, curproduct.GetNameUA()+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом");
          preparedStatement.setString(7, curproduct.GetNameUA()+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом");
          preparedStatement.setInt(8, idMax);
          preparedStatement.setString(9, curproduct.GetName());
          preparedStatement.setString(10, curproduct.GetName());
          preparedStatement.setString(11, curproduct.GetName());
          preparedStatement.setString(12, curproduct.GetName());
          preparedStatement.setString(13, curproduct.GetName());
          preparedStatement.setString(14, curproduct.GetName());
          
          preparedStatement.executeUpdate();
          
      // 
	        preparedStatement = connect
	                    .prepareStatement("insert into uamed_db.product_reward (product_id,customer_group_id,points) values (?,1,0)");
	        preparedStatement.setInt(1, idMax);
	        preparedStatement.executeUpdate();
            

          }else{
        	  //UPDATE `uamed_db`.`product_description` SET `meta_description` = '2' WHERE `product_description`.`product_id` = 158 AND `product_description`.`language_id` = 1;
        	  if (UpdateDescription) {
        	  
	          preparedStatement = connect
	                      .prepareStatement("UPDATE `uamed_db`.`product_description` SET " +
	                      		"`name`=?," +
	                      		"`description`=?," +
	                      		"`meta_description`=?," +
	                      		"`meta_keyword`=?," +
	                      		"`seo_title`=?," +
	                      		"`seo_h1`=?," +
	                      		"`tag`='' WHERE `product_description`.`product_id`=? and `product_description`.`language_id`=1;");
	          preparedStatement.setString(1, curproduct.GetNameUA()+" ("+curproduct.GetArticul()+")");
	          preparedStatement.setString(2, curproduct.GetNameDescriptionUA());
	          preparedStatement.setString(3, curproduct.GetNameUA()+", медицинская одежда медичний одяг топ с рисунком блуза с принтом медицинский костюм халат куртка блуза с длинным рукавом"); //с рисунком с принтом
	          preparedStatement.setString(4, curproduct.GetNameUA()+" ("+curproduct.GetArticul()+")"+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом");// c рисунком
	          preparedStatement.setString(5, curproduct.GetNameUA()+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом");
	          preparedStatement.setString(6, curproduct.GetNameUA()+", медицинская одежда, медичний одяг, топ с рисунком, блуза с принтом, медицинский костюм халат куртка блуза с длинным рукавом");
	          preparedStatement.setInt(7, idMax);
	          //System.out.println("curproduct.GetNameUA() ="+ curproduct.GetNameUA());
	          preparedStatement.executeUpdate();
	          
	          
	          preparedStatement = connect
	                  .prepareStatement("update uamed_db.product_description set " +
	                      		"name=?," +
	                      		"description=?," +
	                      		"meta_description=''," +
	                      		"meta_keyword=''," +
	                      		"seo_title=''," +
	                      		"seo_h1=''," +
	                      		"tag='' where ((uamed_db.product_description.product_id=?) and (uamed_db.product_description.language_id=2));");
	
	          preparedStatement.setString(1, curproduct.GetName());
	          preparedStatement.setString(2, curproduct.GetName());
	          preparedStatement.setInt(3, idMax);
	          preparedStatement.executeUpdate();
        	  }//Update Description
          
          preparedStatement = connect
          		  .prepareStatement("select product_reward_id from uamed_db.product_reward where product_id=?");
          preparedStatement.setInt(1, idMax);
          resultSet = preparedStatement.executeQuery();
          
          idproduct_reward = 1;
          while (resultSet.next()) {
        	  idproduct_reward = resultSet.getInt(1);
        	  //System.out.println("product_reward_idMax уже есть запись ="+ idproduct_reward+" idMax="+idMax);
          }//while
          	
          
          if (idproduct_reward==1) {
        	  
        	preparedStatement = connect
	                    .prepareStatement("insert into uamed_db.product_reward (product_id,customer_group_id,points) values (?,1,0)");
	        preparedStatement.setInt(1, idMax);
	        preparedStatement.executeUpdate();
         
        	  
          } else {
          
          
	        preparedStatement = connect
            .prepareStatement("update uamed_db.product_reward set customer_group_id=1, points=0 where product_id=?");
	        preparedStatement.setInt(1, idMax);
	        preparedStatement.executeUpdate();
          }
        	  
          };//else
          
          
          
/* // в одном запросе
/*      preparedStatement = connect
                  .prepareStatement("insert into uamed_db.product_reward (product_id,customer_group_id,points) values (?,1,0)");
      preparedStatement.setInt(1, idMax);
      preparedStatement.executeUpdate();
*/  
  // в одном запросе   // INSERT INTO table (id,name,age) VALUES('1','Mohammad','21') ON DUPLICATE KEY UPDATE name='Mohammad',age='21'
      preparedStatement = connect
      .prepareStatement("insert into uamed_db.product_to_store (product_id, store_id) value (?,0) ON DUPLICATE KEY UPDATE store_id=0");      
      preparedStatement.setInt(1, idMax);
      preparedStatement.executeUpdate();
      
      
      
      

//      idMax = 156;
// Добавляем размеры
 //новый запрос для update если по старому ноль
      
	  preparedStatement = connect
      		  .prepareStatement("select product_option_id from uamed_db.product_option where product_id=? and option_id=11");
	  preparedStatement.setInt(1, idMax);	  
      resultSet = preparedStatement.executeQuery();
      
      idOptionMax = 1;
      while (resultSet.next()) {
    	  idOptionMax = resultSet.getInt(1);
    	  //System.out.println("product_option_idMax уже есть запись ="+ idOptionMax);
      }//while
      	  
      if (idOptionMax == 1) { 
      
	      preparedStatement = connect
	              .prepareStatement("insert into uamed_db.product_option (product_id, option_id, option_value, required) value (?,11,'',1)");      
	            preparedStatement.setInt(1, idMax);
	            preparedStatement.executeUpdate();
	            
	      // Получаем product_option_id                  
	      preparedStatement = connect
	      		  .prepareStatement("select MAX(product_option_id) from uamed_db.product_option");
	      resultSet = preparedStatement.executeQuery();
	      while (resultSet.next()) {
	          idOptionMax = resultSet.getInt(1);
	          //System.out.println("product_option_idMax ="+ idOptionMax);
	      }//while
      
      };//if
    	  
      
      
      
//Добавляем размеры в product_option_value
//тоже сначала проверка по тем, что уже есть product_option_id product_id option_id option_value_i
//Цикл idSize по размерам	          

          for(Integer idSize: sizePrd){
			      float addprice = 0;
	        	  preparedStatement = connect
	              		  .prepareStatement("select product_option_value_id	 from uamed_db.product_option_value where product_option_id=? and product_id=? and option_id=11 and option_value_id=?");
                  preparedStatement.setInt(1, idOptionMax);
	              preparedStatement.setInt(2, idMax);
	              preparedStatement.setInt(3, idSize);
	              resultSet = preparedStatement.executeQuery();
	              
	              idOptionValueMax = 1;
	            //  System.out.println("begin");
	              while (resultSet.next()) {
	            	  idOptionValueMax = resultSet.getInt(1);
	            	 // System.out.println("product_option_value_id уже есть запись(idOptionMax,idMax,idSize) idOptionValueMax ="+ idOptionMax+" "+idMax+" "+idSize+" ->"+idOptionValueMax);
	              }//while
	              //System.out.println("end");
	              
	              if (idOptionValueMax==1) {

					  if (idSize==215 || idSize==216) {
						  addprice = addPriceForXXL;		//price add for 2XL and 3XL
					  };


	            	  	  preparedStatement = connect
	                        .prepareStatement("insert into uamed_db.product_option_value (product_option_id, product_id, option_id, option_value_id, quantity, subtract, price, price_prefix, points, points_prefix, weight, weight_prefix) " +
	                        							"value (?,?,11,?,99,1,?,'+',0,'+',0,'+')");
	                      preparedStatement.setInt(1, idOptionMax);
	                      preparedStatement.setInt(2, idMax);
	                      preparedStatement.setInt(3, idSize);
					  	  preparedStatement.setDouble(4, addprice);
	                      preparedStatement.executeUpdate();
	                      System.out.println("insert into uamed_db.product_option_value");
	              } else { //уже есть размер нужен update
	              
	              };
          }//for
  //Добавляем цвета для выбора
          
        	  
          //перебор по доступным цветам у артикула и добавление цветов в option_value_description
          
          ArrayList <ColorImage> colorslist = curproduct.GetColors(); 
          if (colorslist.size() > 1) {
        	  //заполняем таблицы option и option_description если есть цвета
        	  
        	  preparedStatement = connect
              		  .prepareStatement("select option_id from uamed_db.option_description where name=? and language_id=1");
        	  preparedStatement.setString(1, curproduct.GetArticul().concat(" Color"));
              resultSet = preparedStatement.executeQuery();
              
              idOptionColorMax = 1;
              while (resultSet.next()) {
            	  idOptionColorMax = resultSet.getInt(1);
            	  System.out.println("uamed_db.option_description уже есть запись idOptionColorMax="+ idOptionColorMax);
              }//while
              
              if (idOptionColorMax == 1) { 
            	  //	создаем одну запись в option и option_description для артикула
            	  System.out.println("создаем одну запись в option и option_description для артикула");
        	      preparedStatement = connect
        	              .prepareStatement("insert into uamed_db.option (type, sort_order) value ('image',0)");      
        	              preparedStatement.executeUpdate();

        	      preparedStatement = connect
        		      		  .prepareStatement("select MAX(option_id) from uamed_db.option");
        		      resultSet = preparedStatement.executeQuery();
        		      while (resultSet.next()) {
        		          idOptionMax = resultSet.getInt(1);
        		          //System.out.println("product_option_idMax ="+ idOptionMax);
        		      }//while
           	    //Добавляем запись в option_description для "Art Color"
              		preparedStatement = connect
              				.prepareStatement("insert into uamed_db.option_description (option_id, language_id, name) value (?,1,?)");      
              		preparedStatement.setInt(1, idOptionMax);
              		preparedStatement.setString(2, curproduct.GetArticul().concat(" Color"));
        	        preparedStatement.executeUpdate();

              		preparedStatement = connect
              				.prepareStatement("insert into uamed_db.option_description (option_id, language_id, name) value (?,2,?)");      
              		preparedStatement.setInt(1, idOptionMax);
              		preparedStatement.setString(2, curproduct.GetArticul().concat(" Color"));
        	        preparedStatement.executeUpdate();
        	        
              	  preparedStatement = connect
                  		  .prepareStatement("select option_id from uamed_db.option_description where name=? and language_id=1");
            	  preparedStatement.setString(1, curproduct.GetArticul().concat(" Color"));
                  resultSet = preparedStatement.executeQuery();
                  idOptionColorMax = 1;
                  while (resultSet.next()) {
                	  idOptionColorMax = resultSet.getInt(1);
                	  System.out.println("uamed_db.option_description создали запись с idOptionColorMax="+ idOptionColorMax);
                  }//while

            	  
              }
              else {//уже есть запись
            	  System.out.println("Уже есть запись option_description="+ idOptionColorMax);
              };
        	  //Создали или получили запись в option_description и ее id в idOptionColorMax
        	  
              
              //Delete records in product_image_id for new image
        	  
              preparedStatement = connect
              		  .prepareStatement("delete from uamed_db.product_image where product_id=? ");
        	  preparedStatement.setInt(1, idMax);
              preparedStatement.executeUpdate();

              System.out.println("uamed_db.product_image deleted all record with idMax="+ idMax);
              
              //Delete records in product_option_value for new image
        	  
              preparedStatement = connect
              		  .prepareStatement("delete from uamed_db.product_option_value where product_id=? and option_id=? ");
        	  preparedStatement.setInt(1, idMax);
        	  preparedStatement.setInt(2, idOptionColorMax);        	  
              preparedStatement.executeUpdate();

              System.out.println("uamed_db.product_option_value deleted all record with product_id="+ idMax+" option_id="+idOptionColorMax);
              
              
              
              
              
              
              
              int numColor = 0;
        	  for(ColorImage curcolor: colorslist){
        		  numColor++;
            	  preparedStatement = connect
                  		  .prepareStatement("select option_value_id from uamed_db.option_value_description  where option_id=? and language_id=1 and name=?");
            	  preparedStatement.setInt(1, idOptionColorMax);
//            	  preparedStatement.setString(2, curcolorshashmap.get(curcolor.GetShortColorName()).toUpperCase());
            	  preparedStatement.setString(2, curcolor.GetFullColorName());
                  resultSet = preparedStatement.executeQuery();
                  
                  //System.out.println("idOptionColorMax="+ idOptionColorMax+" GetShortColorName="+curcolorshashmap.get(curcolor.GetShortColorName()).toUpperCase());
                  System.out.println("idOptionColorMax="+ idOptionColorMax+" GetShortColorName="+curcolor.GetFullColorName()+" "+numColor);
                  
                  idOptionValue_ID_DescrMax = 1;
                  while (resultSet.next()) {
                	  idOptionValue_ID_DescrMax = resultSet.getInt(1);
                	  System.out.println("In option_value_description уже есть запись ="+ idOptionValue_ID_DescrMax);
                  }//while
                  	  
                  if (idOptionValue_ID_DescrMax == 1) { //нет записи в option_value_description
                  
            	      preparedStatement = connect
            	              .prepareStatement("insert into uamed_db.option_value (option_id, image, sort_order) value (?,?,?)");      
            	            preparedStatement.setInt(1, idOptionColorMax);
            	            preparedStatement.setString(2, curcolor.GetFileNameSite());
            	            preparedStatement.setInt(3, numColor);
            	            preparedStatement.executeUpdate();
            	            
            	      // Получаем option_value_id                  
            	      preparedStatement = connect
            	      		  .prepareStatement("select MAX(option_value_id) from uamed_db.option_value");
            	      resultSet = preparedStatement.executeQuery();
            	      while (resultSet.next()) {
            	          idOptionMax = resultSet.getInt(1);
            	          System.out.println("product_option_idMax ="+ idOptionMax);
            	      }//while
                  
            	    //Добавляем запись в option_value_description
                		preparedStatement = connect
                				.prepareStatement("insert into uamed_db.option_value_description (option_value_id, language_id, option_id, name) value (?,1,?,?)");      
                		preparedStatement.setInt(1, idOptionMax);
                		preparedStatement.setInt(2, idOptionColorMax);
	      	            preparedStatement.setString(3, curcolor.GetFullColorName());
	      	            preparedStatement.executeUpdate();

                		preparedStatement = connect
            	              .prepareStatement("insert into uamed_db.option_value_description (option_value_id, language_id, option_id, name) value (?,2,?,?)");      
                		preparedStatement.setInt(1, idOptionMax);
                		preparedStatement.setInt(2, idOptionColorMax);
        	            preparedStatement.setString(3, curcolor.GetFullColorName());
        	            preparedStatement.executeUpdate();
        	            idOptionValue_ID_DescrMax = idOptionMax; // option_value_id из таблицы option_value_description
        	            
        	            
        	            
        	            
        	            
        	            
                  };//if по наличию цвета в option_value_description
        		  
                  
                  
            	  //Добавляем записи в product_option
            	  
            	  preparedStatement = connect
                  		  .prepareStatement("select product_option_id from uamed_db.product_option where product_id=? and option_id=?");
            	  preparedStatement.setInt(1, idMax);
            	  preparedStatement.setInt(2, idOptionColorMax);
                  resultSet = preparedStatement.executeQuery();
                  
                  idOptionMax = 1;
                  while (resultSet.next()) {
                	  idOptionMax = resultSet.getInt(1);
                	  System.out.println("In product_option уже есть запись ="+ idOptionMax);
                  }//while
                  
                  if (idOptionMax == 1) { 
                      
            	      preparedStatement = connect
            	              .prepareStatement("insert into uamed_db.product_option (product_id, option_id, option_value, required) value (?,?,'',1)");      
            	            preparedStatement.setInt(1, idMax);
            	            preparedStatement.setInt(2, idOptionColorMax);
            	            preparedStatement.executeUpdate();
            	            
            	      // Получаем product_option_id                  
            	      preparedStatement = connect
            	      		  .prepareStatement("select MAX(product_option_id) from uamed_db.product_option");
            	      resultSet = preparedStatement.executeQuery();
            	      while (resultSet.next()) {
            	          idOptionMax = resultSet.getInt(1);
            	          //System.out.println("product_option_idMax ="+ idOptionMax);
            	      }//while
                  
                  };//if

    	          //Добавляем записи в product_option_value для отображения цветов и добавляем кол-во
                  
            	  preparedStatement = connect
                  		  .prepareStatement("select product_option_value_id	 from uamed_db.product_option_value where product_option_id=? and product_id=? and option_id=? and option_value_id=?");
                  preparedStatement.setInt(1, idOptionMax); //product_option_id
                  preparedStatement.setInt(2, idMax);		//product_id
                  preparedStatement.setInt(3, idOptionColorMax);		//option_id
                  preparedStatement.setInt(4, idOptionValue_ID_DescrMax);		//option_value_id
                  resultSet = preparedStatement.executeQuery();
                  
                  idOptionValueMax = 1;
                //  System.out.println("begin");
                  while (resultSet.next()) {
                	  idOptionValueMax = resultSet.getInt(1);
                	 // System.out.println("product_option_value_id уже есть запись(idOptionMax,idMax,idSize) idOptionValueMax ="+ idOptionMax+" "+idMax+" "+idSize+" ->"+idOptionValueMax);
                  }//while
                  //System.out.println("end");
                  
                  if (idOptionValueMax==1) {
					  	  float delta =0;
                	  	  preparedStatement = connect
                            .prepareStatement("insert into uamed_db.product_option_value (product_option_id, product_id, option_id, option_value_id, quantity, subtract, price, price_prefix, points, points_prefix, weight, weight_prefix) " +
                            							"value (?,?,?,?,99,1,?,?,0,'+',0,'+')");
                          preparedStatement.setInt(1, idOptionMax); //product_option_id
                          preparedStatement.setInt(2, idMax);		//product_id
                          preparedStatement.setInt(3, idOptionColorMax);		//option_id
                          preparedStatement.setInt(4, idOptionValue_ID_DescrMax);		//option_value_id
					  // Set Price colors +-
					      float mainprice = curproduct.GetPriceUAH();
					  	  float colorprice = curcolor.GetPriceUAH();

					      if (mainprice > colorprice) {
							  delta = mainprice-colorprice;
							  preparedStatement.setDouble(5, delta);
							  preparedStatement.setString(6,"-");
					  		};

					      if (mainprice < colorprice) {
							  delta = colorprice-mainprice;
							  preparedStatement.setDouble(5, delta);
							  preparedStatement.setString(6,"+");

					      };
						  if (mainprice == colorprice) {
							  preparedStatement.setDouble(5, 0);
							  preparedStatement.setString(6,"+");

						  };

                          preparedStatement.executeUpdate();
                          System.out.println("insert into uamed_db.product_option_value "+idOptionMax+" "+idMax+" "+idOptionColorMax+" "+idOptionValue_ID_DescrMax+" Delta="+delta);
                  } else { //уже есть запись нужен update
                  
                  };
                  
    	          //Добавляем записи в product_image для отображения изображений по цветам          
                  
            	  preparedStatement = connect
                  		  .prepareStatement("select product_image_id from uamed_db.product_image where product_id=? and image=?");
            	  preparedStatement.setInt(1, idMax);
            	  preparedStatement.setString(2, curcolor.GetFileNameSite());
                  resultSet = preparedStatement.executeQuery();
                  
                  idOptionMax = 1;
                  while (resultSet.next()) {
                	  idOptionMax = resultSet.getInt(1);
                	  System.out.println("In product_image уже есть запись ="+ idOptionMax);
                  }//while
                  
                  if (idOptionMax == 1) { 
                      
            	      preparedStatement = connect
            	              .prepareStatement("insert into uamed_db.product_image (product_id, image) value (?,?)");      
            	            preparedStatement.setInt(1, idMax);
            	            preparedStatement.setString(2, curcolor.GetFileNameSite());
            	            preparedStatement.executeUpdate();
            	            System.out.println("In product_image добавляем запись ="+ idMax+" "+curcolor.GetFileNameSite());            	            
                  
                  };//if
                  
                  
                  
                  
                  
                  
        		  
        	  }//for
        	  

              
        	  
        	  
          }





//      		categoryPrd.add(59);     //Брюки солид женские
//      		categoryPrd.add(45);     //Брюки солид мужские
// Set sex in Category

		  switch (curproduct.GetSex()) {
			  case Men:
				  	categoryPrd.remove(20);
				  	categoryPrd.add(18);
//						  categoryPrd.add(45);     //Брюки солид мужские
//						  categoryPrd.remove(59);     //Брюки солид	женские

//						  categoryPrd.add(46);     //Top солид мужские
//						  categoryPrd.remove(26);     //Top солид	женские

//			  	     categoryPrd.remove(27); // Халаты медицинские женские
//				     categoryPrd.add(61);  // Халаты медицинские мужские


		    		break;
			  case Women:
					categoryPrd.remove(18);
					categoryPrd.add(20);
//			      		categoryPrd.add(59);     //Брюки солид женские
//				  		categoryPrd.remove(45);     //Брюки солид мужские

//				  categoryPrd.add(26);     //Top солид женские
//				  categoryPrd.remove(46);     //Top солид мужские

//				  categoryPrd.remove(61); // Халаты медицинские мужские
//				  categoryPrd.add(27);  // Халаты медицинские женские


				    break;
			  case Unisex:
				  	categoryPrd.add(18);
					categoryPrd.add(20);
//						categoryPrd.add(59);     //Брюки солид женские
//						categoryPrd.add(45);     //Брюки солид мужские

//				  categoryPrd.add(46);     //Top солид мужские
//				  categoryPrd.add(26);     //Top солид	женские

//				  categoryPrd.add(61); // Халаты медицинские мужские
//				  categoryPrd.add(27);  // Халаты медицинские женские


				    break;
			  default:
		   		  categoryPrd.remove(18);
				  categoryPrd.add(20);
//					  categoryPrd.add(59);     //Брюки солид женские
//					  categoryPrd.remove(45);     //Брюки солид мужские

//				  categoryPrd.add(26);     //Top солид женские
//				  categoryPrd.remove(46);     //Top солид	мужские

//				  categoryPrd.remove(61); // Халаты медицинские мужские
//				  categoryPrd.add(27);  // Халаты медицинские женские

				  break;

		  }

// Set main category from product
		  for(Integer idcat: curproduct.GetCategoryID()){
			  categoryPrd.add(idcat);
		  }




 //  в одном запросе
//        	  idMax = 156;
          for(Integer idcategory: categoryPrd){
			   System.out.println("idcategory="+ idcategory);
        	  preparedStatement = connect
              		  .prepareStatement("select category_id	from uamed_db.product_to_category where product_id=? and category_id=?");
              preparedStatement.setInt(1, idMax);
              preparedStatement.setInt(2, idcategory);
              resultSet = preparedStatement.executeQuery();
  
              idCategoryMax = 1;
              while (resultSet.next()) {
            	  idCategoryMax = resultSet.getInt(1);
            	 // System.out.println("product_to_category уже есть запись ="+ idCategoryMax);
              }//while

        	  if (idCategoryMax==1) {
          	  	preparedStatement = connect
                        .prepareStatement("insert into uamed_db.product_to_category (product_id, category_id, main_category) " +
                        							"value (?,?,?)");
                      preparedStatement.setInt(1, idMax);
                      preparedStatement.setInt(2,idcategory);
                      if (idcategory == 20){
                      	preparedStatement.setInt(3, 1);
                      }
                      else {
                      	preparedStatement.setInt(3, 0);	
                      }
                      
                      preparedStatement.executeUpdate();
        		  
        		  
        	  } else {//уже есть запись с категорией
        		  //удаляем

//        		  if (idcategory==26) {
//                	  	preparedStatement = connect
//                                .prepareStatement("delete from uamed_db.product_to_category where product_id=? and category_id=? and main_category=0 ");
//                              preparedStatement.setInt(1, idMax);
//                              preparedStatement.setInt(2,idcategory);
//                              preparedStatement.executeUpdate();
//
//        		  }
//				  if (idcategory==59){
//						preparedStatement = connect
//									.prepareStatement("delete from uamed_db.product_to_category where product_id=? and category_id=? and main_category=0 ");
//							  preparedStatement.setInt(1, idMax);
//							  preparedStatement.setInt(2,idcategory);
//							  preparedStatement.executeUpdate();
//
//				  }

        		  
        	  };



        	
        	  

          }//for      
          
      }//for list 

		  DeActivateItem deActivate = new DeActivateItem();
		  for (String articul:deActivate.listDeActivate
				  ) {
			  System.out.println("Articul on site to deActivate=" + articul);
			  preparedStatement = connect
					  .prepareStatement("UPDATE  `uamed_db`.`product` SET  `status` =  '0' WHERE uamed_db.product.model=?");
			  preparedStatement.setString(1, articul);
			  preparedStatement.executeUpdate();
			  //System.out.println("ID Hide="+ articul);
		  }


          
      // Remove again the insert comment
/*      preparedStatement = connect
      .prepareStatement("delete from feedback.comments where myuser= ? ; ");
      preparedStatement.setString(1, "Test");
      preparedStatement.executeUpdate();
     
      resultSet = statement
      .executeQuery("select * from feedback.comments");
      writeMetaData(resultSet);
*/      
      	        
	  }//try    
     catch (Exception e) {
      throw e;
    } finally {
      close();
    }//finally
      

    
  }





  public void RemoveOldProductFromDataBase(ArrayList<Productua> curlist, Map<String, Integer> scladlist, int idcategory, ConnectOption ConnectOpt ) throws Exception {
	  Map<String, Integer> siteProduct = new HashMap<String, Integer>();
	  String curArticul;
	  
	  try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	              .getConnection("jdbc:mysql://"+ConnectOpt.GetlinkDBMysql()+"/"+ConnectOpt.Getname_db()+"?"
	                  + "user="+ConnectOpt.Getname_userdb()+"&password="+ConnectOpt.Getpassword_userdb());

	      preparedStatement = connect
          		  .prepareStatement("SELECT `model`,`product_id` FROM `product` WHERE `status`=1 and `manufacturer_id`=10 and `product_id` in (SELECT `product_id` from `product_to_category` where `category_id`=?)");
          preparedStatement.setInt(1, idcategory);
//          preparedStatement.setInt(2, idcategory);
          resultSet = preparedStatement.executeQuery();
          System.out.println("begin Articul on site =");
          // idCategoryMax = 1;
          while (resultSet.next()) {
        	  siteProduct.put(resultSet.getString(1), resultSet.getInt(2)) ;
        	  System.out.println("Articul on site ="+ resultSet.getString(1)+"ID="+resultSet.getInt(2));
          };//while
          
          System.out.println("Articul on site Total="+ siteProduct.size());
          
          for (Productua element:curlist ){
        	  curArticul = element.GetArticul();
        	  if (siteProduct.containsKey(curArticul)) {
        		  System.out.println("Articul still on="+ element.GetArticul()+"=");
        		  siteProduct.remove(curArticul);
        	  }
        	  else {
        		  System.out.println("Articul Sold="+ element.GetArticul()+"=");
        		  
        	  }
        	  
          };
          
          for (String articulSclad:scladlist.keySet()) {  //По складу проверка
        	  if (siteProduct.containsKey(articulSclad)) {
        		  System.out.println("Articul still on sclad="+ articulSclad+"=");
        		  siteProduct.remove(articulSclad);
        	  }

          }

    	  System.out.println("Articul on site to delete="+ siteProduct.size());


          //Помечаем, что не нужно отображать артикула из списка siteProduct
    	  int i=0;


    	  for (Integer idProduct:siteProduct.values()) {
    		  i++;
	    	  //if (idProduct<1000) {
    		  
	          preparedStatement = connect
	                  .prepareStatement("UPDATE  `uamed_db`.`product` SET  `status` =  '0' WHERE uamed_db.product.product_id=?") ;
	          	      preparedStatement.setInt(1, idProduct);
	          	      preparedStatement.executeUpdate();
	          	    System.out.println("ID Hide="+ idProduct);
	          	    
	    	  //}
    	  }


		  DeActivateItem deActivate = new DeActivateItem();
		  for (String articul:deActivate.listDeActivate
				  ) {
			  System.out.println("Articul on site to deActivate="+articul);
			  preparedStatement = connect
					  .prepareStatement("UPDATE  `uamed_db`.`product` SET  `status` =  '0' WHERE uamed_db.product.model=?") ;
			  preparedStatement.setString(1, articul);
			  preparedStatement.executeUpdate();
			  //System.out.println("ID Hide="+ articul);


		  }


	  }//try    
	  catch (Exception e) {
	   throw e;
	 } finally {
	   close();
	 }//finally

  }
  
  
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String sku = resultSet.getString("sku");
      String product_id = resultSet.getString("product_id");
      String image = resultSet.getString("image");
      Float price = resultSet.getFloat("price");
      String comment = resultSet.getString("model");
      System.out.println("sku: " + sku);
      System.out.println("product id: " + product_id);
      System.out.println("image: " + image);
      System.out.println("price: " + price);
      System.out.println("Comment: " + comment);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
