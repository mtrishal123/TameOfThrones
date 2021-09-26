package com.Geektrust.TameOfThrones.services;

import com.Geektrust.TameOfThrones.Kingdoms;
import com.Geektrust.TameOfThrones.constants.constants;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {
    public static void processFile(String filename) {

        try {
            File cv = new File(filename);  //Input details
            InputStream targetStream = new FileInputStream(cv);
            InputStreamReader f = new InputStreamReader(targetStream, Charset.defaultCharset());
            BufferedReader br = new BufferedReader(f);
            String lineInput="";
            List<String> allies=new ArrayList<>();
            while((lineInput = br.readLine()) != null) {
                String encrypted="";
                String[] kingdomMessage = lineInput.split(" ");
                String kingdomName = kingdomMessage[0];
                for(int i=1;i<kingdomMessage.length;i++) {
                    encrypted+=kingdomMessage[i];
                }
                Kingdoms kingdoms=new Kingdoms();
                kingdoms.setName(kingdomName);
                kingdoms.setEmblem(constants.Kingdom_Symbol.get(kingdomMessage[0]));
                String final_message=Decryption.decipher(encrypted,kingdoms.getEmblem().length());
                if(MessageValidator.isAllyOrNot(final_message,kingdoms.getEmblem())) {
                    allies=OutputProcessor.allies(kingdoms.getName());
                }
            }
            allies=allies.stream().distinct().collect(Collectors.toList());
            if(allies.size()>= constants.min_allies_count){
                System.out.print("SPACE");
                allies.forEach(ee->System.out.print(" "+ee));
            }
            else
                System.out.println(constants.no_allies);

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
