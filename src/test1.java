import java.util.concurrent.ConcurrentLinkedQueue;

import fool.Request;
import java.util.*;
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String a="(FRR , 2 , DOWN , 0)",b="havfhahfva";
			a=a.replaceAll("[ \\(]", "");
			String [] c=a.split("[,. \\)]");
			for (int i=0;i<c.length;i++) {
				System.out.println(c[i]);
			}
	}

}