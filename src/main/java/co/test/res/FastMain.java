package co.test.res;

import java.io.*;

public class FastMain {
    public static void main(String[] args) {
        InputStream is = Main.class.getClassLoader().getResourceAsStream("logback.xml");
        //String path = "C:\\Users\\Ahnjoongwon\\Desktop\\SPRING BASIC\\src\\main\\resources\\dao.xml";
        //File file = new File(path);

        //InputStream is = null;

//        try{
//             is = new FileInputStream(file);
//
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }

        // 배열은 객체다
        byte[] bytes = new byte[256];
        StringBuilder sb = new StringBuilder();

        int len = 0;
        while(true)
        {
            try{
                if(is != null) len = is.read(bytes, 0, bytes.length);
                if(len == -1) break;
                sb.append(new String(bytes, 0, len));

            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

        try{
            is.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println(sb);

    }
}
