package peachy.md.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import peachy.md.domain.Address;
import peachy.md.mapper.AddressMapper2;

@Service("addressService2")
public class AddressServiceImpl2 implements AddressService {
	//@Autowired
	@Resource
	private AddressMapper2 addressMapper2;
	
	@Override
	public List<Address> listS() {
		return addressMapper2.list();
	}

	@Override
	public void insertS(Address address) {
		addressMapper2.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		addressMapper2.delete(seq);
	}
}
