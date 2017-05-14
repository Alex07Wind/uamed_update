package de.vogella.mysql.first.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import de.vogella.mysql.first.test.Sex;




/**
 * Created by alexander on 29.01.17.
 */
public class Translate {
    public enum Apparel { Pant, Top, Jacket, Skirt, Dress, Set, Hoodie};
    //public enum Sex { Men, Mens, Women, Womens, Unisex};
    public Map<String, String> listApparel = new HashMap<String, String>();
    public Map<String, String> listSex1 = new HashMap<String, String>();
    public Map<String, String> listSex2 = new HashMap<String, String>();
    public Map<String, String> listSex3 = new HashMap<String, String>();
    public Map<String, String> listSex4 = new HashMap<String, String>();
    public ArrayList<String> listNameConsist = new ArrayList<String>();
    public Map<String, int[] > listManufacture = new HashMap<String, int[]>();

public Translate() {
        listApparel.put("Pant","Брюки");        //2
        listApparel.put("Top","Топ");           //1
        listApparel.put("Jacket","Куртка");     //3
        listApparel.put("Skirt","Юбка");        //3
        listApparel.put("Dress","Платье");      //4
        listApparel.put("Set","Костюм");        //1
        listApparel.put("Hoodie","Куртка с капюшоном"); //3
        listApparel.put("Hat","Шапка"); //3
        listApparel.put("Bag","Сумка"); //3
        listApparel.put("Coat","Халат"); //1
        listApparel.put("Cap","Шапка"); //3


        //For Tops - 1
        listSex1.put("Men","мужской медицинский");
        listSex1.put("Men's","мужской медицинский");
        listSex1.put("Women","женский медицинский");
        listSex1.put("Women's","женский медицинский");
        listSex1.put("Unisex","женский, мужской(unisex) медицинский");

        //For Pants - 2
        listSex2.put("Men","мужские медицинские");
        listSex2.put("Men's","мужские медицинские");
        listSex2.put("Women","женские медицинские");
        listSex2.put("Women's","женские медицинские");
        listSex2.put("Unisex","женские, мужские(unisex) медицинские");

        //For Jackets - 3
        listSex3.put("Men","мужская медицинская");
        listSex3.put("Men's","мужская медицинская");
        listSex3.put("Women","женская медицинская");
        listSex3.put("Women's","женская медицинская");
        listSex3.put("Unisex","женская, мужская(unisex) медицинская");

        //For Dress - 4
        listSex4.put("Men","мужские медицинские");
        listSex4.put("Men's","мужские медицинские");
        listSex4.put("Women","женские медицинские");
        listSex4.put("Women's","женские медицинские");
        listSex4.put("Unisex","женские, мужские(unisex) медицинские");

    //{manufacture,category}
        int[] asbs      = {20,107};
        int[] bb        = {11,60};
        int[] bs        = {18,102};
        int[] bss       = {19,105};
        int[] esbs      = {21,110};
        int[] hs        = {5,28};
        int[] ss        = {25,121};
        int[] ds        = {23,113};
        int[] ww        = {17,85};
        int[] ks        = {26,122};
        int[] zc        = {22,112};
        int[] fs        = {12,63};

        listManufacture.put("Advantage STRETCH By Butter-Soft",asbs);
        listManufacture.put("Best Buy",bb);
        listManufacture.put("Butter-Soft Scrubs",bs);
        listManufacture.put("Butter-Soft STRETCH Scrubs",bss);
        listManufacture.put("Easy Stretch by Butter-Soft",esbs);
        listManufacture.put("Happy Scrubs",hs);
        listManufacture.put("Strictly Scrubs",ss);
        listManufacture.put("Dickies",ds);
        listManufacture.put("WonderWink",ww);
        listManufacture.put("koi Scrubs",ks);
        listManufacture.put("Zoe + Chloe",zc);
        listManufacture.put("Fashion Seal",fs);









}

    public boolean CheckValueFromStringByPattern(String strline, String mypattern) {

        String returnstr="";
        //ArrayList<String> tokens = new ArrayList<String>();

        Pattern tokSplitter = Pattern.compile(mypattern);
        Matcher m = tokSplitter.matcher(strline);
        //System.out.println("mypattern="+mypattern+" "+strline);
        if (m.find()) {
             return true;}
        else
        {return false;         }

    }
    public void SetSexInProduct(String sexTxt, Productua linkProduct) {
        switch(sexTxt) {
            case "Men":
                linkProduct.SetSex(Sex.Men);
                break;
            case "Men's":
                linkProduct.SetSex(Sex.Men);
                break;
            case "Women":
                linkProduct.SetSex(Sex.Women);
                break;
            case "Women's":
                linkProduct.SetSex(Sex.Women);
                break;
            case "Unisex":
                linkProduct.SetSex(Sex.Unisex);
                break;
            default:
                linkProduct.SetSex(Sex.Women);
                break;

        }

    }
    public String NameTranslate(String engNameStr, Productua linkProduct) {

        boolean NotFoundApparel = true;
        boolean NotFoundSex = true;
        boolean NotFoundManuf = true;
        String foundApparel="Top";
        String foundSex="Women";
        Integer foundManuf=10;  //id Scrubs

        listNameConsist.clear();

        //For Manufacture
        for (String key: listManufacture.keySet()) {
            if (CheckValueFromStringByPattern(engNameStr,key) ) {

                foundManuf = listManufacture.get(key)[0];
                NotFoundManuf = false;
                linkProduct.SetManufactureID(foundManuf);
                linkProduct.AddCategoryID(listManufacture.get(key)[1]);
                //System.out.println("Name="+listApparel.get(key)+ "- found type of apparel.");
                break;
            }

        }

            if (NotFoundManuf){
                linkProduct.SetManufactureID(foundManuf);
                linkProduct.AddCategoryID(32);  //UA Scrubs
                //System.out.println("Name="+engNameStr+ "- can not found type of apparel.");
            }



        //For some sort of Apparel
        for (String key: listApparel.keySet()) {
            if (CheckValueFromStringByPattern(engNameStr,key) ) {
                listNameConsist.add(listApparel.get(key));
                foundApparel =  key;
                NotFoundApparel = false;
                SetSexInProduct(key,linkProduct);
                //System.out.println("Name="+listApparel.get(key)+ "- found type of apparel.");
                break;
            }

        }

        if (NotFoundApparel){
            listNameConsist.add(listApparel.get("Top"));
            SetSexInProduct(foundSex,linkProduct);
            //System.out.println("Name="+engNameStr+ "- can not found type of apparel.");

        }

        //System.out.println("swith foundApparel="+foundApparel+".");
        switch(foundApparel) {

            case "Top" :
                for (String  key : listSex1.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr,key)) {
                        listNameConsist.add(listSex1.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        System.out.println("FoundSex="+key);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex1.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                    System.out.println(" NotFoundSex="+NotFoundSex);
                };
                break;
            case "Pant" :
                for (String  key : listSex2.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex2.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex2.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Jacket" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Skirt" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Dress" :
                for (String  key : listSex4.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex4.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex4.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Set" :
                for (String  key : listSex1.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex1.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex1.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Hoodie" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Hat" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Bag" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Coat" :
                for (String  key : listSex1.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex1.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex1.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;
            case "Cap" :
                for (String  key : listSex3.keySet()) {
                    if (CheckValueFromStringByPattern(engNameStr, key)) {
                        listNameConsist.add(listSex3.get(key));
                        NotFoundSex = false;
                        SetSexInProduct(key,linkProduct);
                        break;
                    }
                }
                if(NotFoundSex) {
                    listNameConsist.add(listSex3.get("Women"));
                    SetSexInProduct(foundSex,linkProduct);
                };
                break;

            default:
                listNameConsist.add(listSex1.get("Women"));
                SetSexInProduct(foundSex,linkProduct);
                break;



        }
        //listNameConsist.add("медицинский");
        String strReturn="";
        for (String str :listNameConsist) {
            //System.out.println(" listNameConsist="+str);
            strReturn=strReturn+str+" ";

        }
        //System.out.println("strReturn="+strReturn);
        return strReturn;

    }
}
