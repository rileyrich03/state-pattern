package state;

public class PostalService { 

    private Mover deliveryMan;

    public PostalService(int choice) {

	if(choice % 2 == 0) {
	    deliveryMan = new Runner();
	}
	else {
	    deliveryMan = new Walker();
	}
    }

    public void deliver(int distance) {

	System.out.printf("Delivering letter %d feet away.\n", distance);
	System.out.printf("Success! Letter was delivered in %f seconds\n\n\n", deliveryMan.move(distance));
 
    }

}
