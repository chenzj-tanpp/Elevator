package fool;

public class Floor {

    public static void makeFloorRequest(int floor,String direction, long time) {
        Request FR = new Request(floor,direction,time); //实例化楼层请求FR
        if(FR.checkFloorRequestFormat()==true) {
            RequestQueue.enQueue(FR); //将FR加入队列
        }
        else {
            System.out.println("ERROR");
            System.out.println("#Invalid Input.");
        }
    }

}
