package co.test.res;

import java.io.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Ahnjoongwon\\Desktop\\SPRING BASIC\\src\\main\\resources\\application.properties";
        String copyPath = "C:\\Users\\Ahnjoongwon\\Desktop\\SPRING BASIC\\src\\main\\resources\\application-copy.properties";

        File file = new File(path);
        InputStream is = new FileInputStream(file);

        File copyFile = new File(copyPath);
        OutputStream os = new FileOutputStream(copyFile);

        byte[] bytes = new byte[256];
        int len = 0;

        while(true)
        {
            try{
                len = is.read(bytes, 0, bytes.length);
                if(len == -1) break;

                os.write(bytes, 0, len);
            }catch(IOException e)
            {
                e.printStackTrace();
            }

        } // END OF WHILE

        try
        {
            os.close();
            is.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
