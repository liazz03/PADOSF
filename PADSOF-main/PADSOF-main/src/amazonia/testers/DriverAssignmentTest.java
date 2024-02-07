package amazonia.testers;

import static org.junit.Assert.*;

import org.junit.Test;

import amazonia.trucks.*;
import amazonia.users.*;

/*
 * Test method for DriverAssignment
 */
 public class DriverAssignmentTest {

    private TruckAssignment ta;
    private Truck t;

    /*
     * Test for DriverAssignment
     */
    @Test
    public void testDriverAssignment() {
        t = new Truck(3500.0, "2322BBC", false, false, TruckType.REFRIGERATED);
        ta = new TruckAssignment(t);
        DriverAssignment driverAssignment = new DriverAssignment(new Driver("Manolo", "1234", 917364761), ta);
        assertNotNull(driverAssignment);
    }
}