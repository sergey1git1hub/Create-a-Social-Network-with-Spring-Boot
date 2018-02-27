package com.caveofprogramming.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.caveofprogramming.App;
import com.caveofprogramming.model.StatusUpdate;
import com.caveofprogramming.model.StatusUpdateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class) // points to spring boot configuration
@WebAppConfiguration
@Transactional
public class StatusTest {

	@Autowired
	private StatusUpdateDao statusUpdateDao;

	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is a test ststus update.");
		statusUpdateDao.save(status);
		Assert.assertNotNull("ID not null", status.getId());
		Assert.assertNotNull("Date not null", status.getAdded());

		StatusUpdate retrieved = statusUpdateDao.findOne(status.getId());
		Assert.assertEquals("Matching StatusUpdate", status, retrieved);
	}

	@Test
	public void testFindLatest() {
		Calendar calendar = Calendar.getInstance();
		StatusUpdate lastStatusUpdate = null;
		for (int i = 0; i < 10; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			StatusUpdate status = new StatusUpdate("Status update " + i, calendar.getTime());
			statusUpdateDao.save(status);
			lastStatusUpdate = status;
		}
		
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();
		Assert.assertEquals("Latest status update", lastStatusUpdate, retrieved);
	}
}