package peachy.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peachy.md.dao.AddressDAO;
import peachy.md.domain.Address;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDao;
	
	@Override
	public List<Address> listS() {
		return addressDao.list();
	}
	@Override
	public void insertS(Address address) {
		addressDao.insert(address);
	}
	@Override
	public void deleteS(long seq) {
		addressDao.delete(seq);
	}
}
