package amazonia.testers;

import amazonia.packages.Notification;
import amazonia.packages.Order;
import amazonia.users.Company;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**	
 * Test method for Notification
 */
public class NotificationTest {

  private Notification notification;
  private Company company;
  private Order order;

  @Before
  public void setUp() {
	company = new Company("Mercedes", "mercedes123", "1234567890123456", 28559593, "mercedes@gmail.com", "Brackley", 9701);
    order = new Order(false, LocalDate.now(), false, false, company);
    notification = new Notification("Your order has reached its maximum number of retries",order);
  }

  /*
	 * Test for getters and setters
	 */
  @Test
  public void testGettersAndSetters() {
    assertNotNull(notification);
    assertEquals("Your order has reached its maximum number of retries", notification.getText());
    notification.setText("Your order has reached its maximum number of retries");
    assertNotNull(order);
    assertEquals(order, notification.getOrder());
    notification.setOrder(order);
  }
}
