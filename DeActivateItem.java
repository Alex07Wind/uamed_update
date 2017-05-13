package de.vogella.mysql.first.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexander on 06.01.17.
 */
public class DeActivateItem {
final public String FileNameList = "/home/alex/uamed/deActivate.txt";
      public ArrayList<String> listDeActivate = new ArrayList<String>();
      public DeActivateItem(){
          //construction
          ReadFileTxt();
      }
    public void ReadFileTxt() {

        BufferedReader br = null;
        FileReader fr = null;
        listDeActivate.clear();

        try {

            fr = new FileReader(FileNameList);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FileNameList));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("Item to deActivate"+sCurrentLine);
                listDeActivate.add(sCurrentLine.trim());

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
