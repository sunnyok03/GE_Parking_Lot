import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTests {
    public ParkingLot parkingLot;
    public Vehicle v1,v2;

    @Before
    public void before() {
        parkingLot = new ParkingLot();
        v1 = new Vehicle("V1", "blue", "Number 1", 4);
        v2 = new Vehicle("V2", "green", "Number 2", 6);
    }

    @Test
    public void parkVehicle() {
        boolean status = parkingLot.parkVehicle(v1);
        if(ParkingLot.parkedCount < ParkingLot.CAPACITY){
            assertTrue(status);
        }else{
            assertFalse(status);
        }
    }

    @Test
    public void unParkVehicle() {
        parkingLot.parkVehicle(v1);
        boolean statusV1 = parkingLot.unParkVehicle(v1); // parked
        boolean statusV2 = parkingLot.unParkVehicle(v2); // not parked
        assertTrue(statusV1);
        assertFalse(statusV2);
    }

}
