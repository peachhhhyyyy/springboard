package peachy.md.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import peachy.md.dao.AddressDAO;
import peachy.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private AddressService addressService;
	
	@Test
	public void testList() {
		List<Address> list = addressService.listS();
	    log.info("@list(1): " + list);
	}
	@Test
	public void testInsert() {
		Address address = new Address(-1, "이순신", "광주시", null);
		addressService.insertS(address);
		
		List<Address> list = addressService.listS();
	    log.info("@list(2): " + list);
	}
	@Test
	public void testDelete() {
		addressService.deleteS(5);
		List<Address> list = addressService.listS();
	    log.info("@list(3): " + list);
	}
}
