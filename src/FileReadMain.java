import fool.Elevator;
import fool.Floor;
import fool.Scheduler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import entity.InElevator;
public class FileReadMain {
    private static final String REGEX_FR="\\(FR,\\+?\\d{1,8},(UP|DOWN),\\+?\\d{1,18}\\)";
    private static final String REGEX_ER="\\(ER,\\+?\\d{1,8},\\+?\\d{1,18}\\)";
    private static int count=0;  // count为输入输入请求的个数
    public static void main(String[] args) {
//    	String temp1="test/input-",temp2=".txt",temp3;
//    	for(int i=1;i<=39;i++){
//    		temp3="";
//    		System.out.println(i);
//    		System.out.println(i);
//    		temp3 =String.valueOf(i);

        try {
//        	String fileway=temp1+temp3+temp2;
            FileReader fr=new FileReader("test/input-39.txt");
            BufferedReader br =new BufferedReader(fr);

            String str;

                while(!(str= br.readLine()).equals("RUN")) {
                str = str.replaceAll(" +\\(", ""); //去掉字符串里的空格
//                count++;
                if(str.matches(REGEX_FR)) {
//                	System.out.println("      1        ");
                    String[] strSplit = str.split("[,\\)]");
                    int floor = Integer.parseInt(strSplit[1]);
                    long time = Long.parseLong(strSplit[3]);
                    InElevator.makeRequest(floor,strSplit[2],time);
                }
                else if(str.matches(REGEX_ER)) {
//                	System.out.println("      2        ");l
                    String[] strSplit = str.split("[,\\)]");
                    int floor = Integer.parseInt(strSplit[1]);
                    long time = Long.parseLong(strSplit[2]);
                    InElevator.makeRequest(floor,strSplit[0],time);
                }
                else {
//                	System.out.println("      4        ");
                    System.out.println("ERROR");
                    System.out.println("#Incorrect input format.");
                }


            }

            if(str.equals("RUN")) {
//            	System.out.println("      3        ");
                Scheduler scheduler = new Scheduler();
                scheduler.work();
            }
            else {
//            	System.out.println("       5        ");
                System.out.println("ERROR");
                System.out.println("#Too many input requests.");
            }
//            System.exit(0);

        }
        catch (Throwable ex) {
            System.out.println("ERROR");
            System.out.println("#A fatal exception has occurred.");
        }


    	}


//    }

}
