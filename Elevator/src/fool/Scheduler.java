package fool;

import java.text.DecimalFormat;

public class Scheduler {

    private double currentTime;
    private DecimalFormat doubleFormat;


    public Scheduler() {
        currentTime = 0;
        doubleFormat = new DecimalFormat("0.0");
    }


    public void work() {

        Elevator elevator = new Elevator();
//        System.out.println("      6        ");
        while (!RequestQueue.isEmpty()) {  //!dewenti
        	
            Request request = RequestQueue.deQueue();
//System.out.println(" safdsa"+ request.getDirection());
            if(request.getValidity()==true) {

                if(currentTime >= request.getTime()) {
                    currentTime = currentTime + Math.abs(request.getFloor() - elevator.getFloor())*0.5+1;
                }
                else {
                    currentTime = request.getTime() + Math.abs(request.getFloor() - elevator.getFloor())*0.5+1;
                }


                if(request.getFloor() > elevator.getFloor()) {
                    System.out.println("("+request.getFloor()+",UP,"+doubleFormat.format(currentTime-1)+")");
                }
                else if(request.getFloor() < elevator.getFloor()) {
                    System.out.println("("+request.getFloor()+",DOWN,"+doubleFormat.format(currentTime-1)+")");
                }
                else {
                    System.out.println("("+request.getFloor()+",STILL,"+doubleFormat.format(currentTime)+")");
                }

                RequestQueue.checkValidity(request, currentTime);
                elevator.updateFloor(request.getFloor());

            }
            else {
                System.out.println("#Ignored same request.");
            }

        }

    }


}