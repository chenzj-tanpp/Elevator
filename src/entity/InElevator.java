package entity;

import fool.Request;
import fool.RequestQueue;

public class InElevator implements El {
    public void makeRequest(int f, String a, long t) {
        Request ER = new Request(f, a,t);  //实例化楼层请求FR
        if(ER.checkElevatorRequestFormat()==true) {
            RequestQueue.enQueue(ER); //将ER加入队列
        }
        else {
            System.out.println("ERROR");
            System.out.println("#Invalid Input.");
        }

    }
}
