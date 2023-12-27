import com.bridgelabz.parkinglot.Parking;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTests {

    public Parking parking;
    public ParkingLot parkingLot1, parkingLot2;
    public Vehicle v1, v2, v3, v4;

    @Before
    public void before() {
        parking = new Parking(2);
        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(1);
        parking.addLot(parkingLot1);
        parking.addLot(parkingLot2);
        v1 = new Vehicle("V1", "blue", "Number 1", 4);
        v2 = new Vehicle("V2", "green", "Number 2", 6);
        v3 = new Vehicle("V3", "blue", "Number 3", 6);
        v4 = new Vehicle("V4", "green", "Number 4", 6);
    }

    @Test
    public void parkVehicle() {
        boolean status = parkingLot1.parkVehicle(v1);
        if (parkingLot1.getParkedCount() < parkingLot1.getCapacity()) {
            parkingLot1.parkVehicle(v1);
            assertTrue(status);
        } else {
            assertFalse(status);
        }
    }

    @Test
    public void unParkVehicle() {
        parkingLot1.parkVehicle(v1);
        boolean statusV1 = parkingLot1.unParkVehicle(v1); // parked
        boolean statusV2 = parkingLot1.unParkVehicle(v2); // not parked
        assertTrue(statusV1);
        assertFalse(statusV2);
    }

    @Test
    public void isFull() {
        parkingLot1.parkVehicle(v1);
        assertFalse(parkingLot1.isFull());
        parkingLot1.parkVehicle(v2);
        assertTrue(parkingLot1.isFull());
    }

    @Test
    public void hasSpace() {
        parkingLot1.parkVehicle(v1);
        assertTrue(parkingLot1.hasSpace());
        parkingLot1.parkVehicle(v2);
        assertFalse(parkingLot1.hasSpace());
    }

    @Test
    public void getParkedCount() {
        parkingLot1.parkVehicle(v1);
        assertEquals(1, parkingLot1.getParkedCount());
    }

    @Test
    public void getPositionOfVehicle() {
        parkingLot1.parkVehicle(v1);
        assertArrayEquals(new int[]{1, 1}, parking.getPositionOfVehicle(v1));
        assertArrayEquals(new int[]{-1, -1}, parking.getPositionOfVehicle(v2));
    }

    @Test
    public void parkToNearestFree() {
        parking.parkToNearestFree(v1);
        assertArrayEquals(new int[]{2, 1}, parking.parkToNearestFree(v2));
        assertArrayEquals(new int[]{1, 2}, parking.parkToNearestFree(v3));
        assertArrayEquals(new int[]{-1, -1}, parking.parkToNearestFree(v4));
    }

    @Test
    public void parkEvenly() {
        assertArrayEquals(new int[]{1, 1}, parking.parkEvenly(v1));
        assertArrayEquals(new int[]{2, 1}, parking.parkEvenly(v2));
        assertArrayEquals(new int[]{1, 2}, parking.parkEvenly(v3));
        assertArrayEquals(new int[]{-1, -1}, parking.parkEvenly(v4));
    }

    @Test
    public void parkLargeVehicle() {
        assertArrayEquals(new int[]{1, 1}, parking.parkLargeVehicle(v1));
        assertArrayEquals(new int[]{1, 2}, parking.parkLargeVehicle(v2));
        assertArrayEquals(new int[]{2, 1}, parking.parkLargeVehicle(v3));
        assertArrayEquals(new int[]{-1, -1}, parking.parkLargeVehicle(v4));
    }

}
