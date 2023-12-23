import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTests {
    public ParkingLot parkingLot;

    @Before
    public void before() {
        parkingLot = new ParkingLot();
    }

    @Test
    public void parkVehicle() {
        Vehicle vehicle = new Vehicle("V1", "blue", "Number 1", 4);
        boolean status = parkingLot.parkVehicle(vehicle);
        assertTrue(status);
    }

    @Test
    public void unParkVehicle() {
        Vehicle v1 = new Vehicle("V1", "blue", "Number 1", 4);
        parkingLot.parkVehicle(v1);
        Vehicle v2 = new Vehicle("V2", "green", "Number 2", 6);
        boolean statusV1 = parkingLot.unParkVehicle(v1);
        boolean statusV2 = parkingLot.unParkVehicle(v2);
        assertTrue(statusV1);
        assertFalse(statusV2);
    }

    @Test
    public void isFull(){

    }
}
