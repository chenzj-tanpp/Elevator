import fool.Elevator;
import fool.Scheduler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import entity.InElevator;
import entity.OutElevator;
import entity.El;
public class FileReadMain {
    private static final String REGEX_FR="\\(FR,\\+?\\d{1,8},(UP|DOWN),\\+?\\d{1,18}\\)";
    private static final String REGEX_ER="\\(ER,\\+?\\d{1,8},\\+?\\d{1,18}\\)";
    private static  El elevator;
    public static void main(String[] args) {

        try {
//        	String fileway=temp1+temp3+temp2;
            FileReader fr=new FileReader("test/input-39.txt");
            BufferedReader br =new BufferedReader(fr);

            String str;

                while(!(str= br.readLine()).equals("RUN")) {
                str = str.replaceAll(" +\\(", ""); //去掉字符串里的空格
//                count++;
                if(str.matches(REGEX_FR)) {
                	elevator =new OutElevator();
                    String[] strSplit = str.split("[,\\)]");
                    int floor = Integer.parseInt(strSplit[1]);
                    long time = Long.parseLong(strSplit[3]);
                    elevator.makeRequest(floor,strSplit[2],time);
                }
                else if(str.matches(REGEX_ER)) {
                	elevator = new InElevator();
                    String[] strSplit = str.split("[,\\)]");
                    int floor = Integer.parseInt(strSplit[1]);
                    long time = Long.parseLong(strSplit[2]);
                    elevator.makeRequest(floor,strSplit[0],time);
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
