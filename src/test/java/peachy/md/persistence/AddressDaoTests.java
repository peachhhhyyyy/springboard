package peachy.md.persistence;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;
import peachy.md.dao.AddressDAO;
import peachy.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressDaoTests {
	/*@Autowired
	private AddressDao addressDao;
	*/
	/*
	@Inject
	private AddressDao addressDao;
	*/
	
	//@Resource(name="addressDao") 또는 @Resource
	@Resource
	private AddressDAO addressDao;
	
	/*@Test
	public void testList() {
		List<Address> list = addressDao.list();
	    log.info("#list(1): " + list);
	}
	
	@Test
	public void testInsert() {
		Address address = new Address(-1, "홍길동", "서울시", null);
		addressDao.insert(address);
		
		List<Address> list = addressDao.list();
	    log.info("#list(2): " + list);
	}*/
	
	@Test
	public void testDelete() {
		addressDao.delete(6);
		List<Address> list = addressDao.list();
	    log.info("#list(3): " + list);
	}
}
