package peachy.md.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;
import peachy.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressTests {
	@Autowired
	private AddressMapper addressMapper;
	
	/*
	@Test
	public void testList() {
		log.info("#AddressTests addressMapper: " + addressMapper);
		log.info("#AddressTests testList(): " + addressMapper.list());
	}
	@Test
	public void testInsert() {
		Address address = new Address(-1, "오늘은", "금요일", null);
		addressMapper.insert(address);
		log.info("#AddressTests insert() 수행 완료");
	}
	*/
	@Test
	public void testDelete() {
		long seq = 11L;
		addressMapper.delete(seq);
		log.info("#AddressTests delete() 수행 완료");
	}
}
