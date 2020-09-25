package fool;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
public class RequestQueue {

//    private static Request[] requestQueue = new Request[210];
    private static ConcurrentLinkedQueue<Request> requestQueue = new ConcurrentLinkedQueue<Request>();
    private static int front = 0;
    private static int rear = -1;
    private static int count = 0;

    public static boolean enQueue(Request r) {
    	requestQueue.add(r);
//    	 System.out.println("      9        ");
    	return true;
    }

    static Request deQueue() {
        if(!requestQueue.isEmpty()) {
            Request r = (Request)requestQueue.poll();
            return r;
        }
        return null;
    }
 static boolean isEmpty() {
	 return requestQueue.isEmpty();
 }
    static void checkValidity(Request r, double finishTime) {//finishTime涓鸿姹俽鎵ц瀹屾垚鐨勬椂闂�
    	Iterator <Request> iterator = requestQueue.iterator();
        while (iterator.hasNext()){
//            System.out.println();
            Request re= (Request)iterator.next();
            if(re.getTime()<=finishTime) {
            	if(re.getDirection().equals(r.getDirection()) && re.getFloor()==r.getFloor()) {
                    re.setInvalid();
                }
            }
            
        }
        /*for(int i=front; i<=rear && requestQueue[i].getTime()<=finishTime; i++) {
            if(requestQueue[i].getDirection().equals(r.getDirection()) && requestQueue[i].getFloor()==r.getFloor()) {
                requestQueue[i].setInvalid();
            }
        }*/
    }

}