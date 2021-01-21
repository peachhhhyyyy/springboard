package peachy.md.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peachy.md.domain.Address;
import peachy.md.mapper.AddressMapper;

@Service("addressService1")
public class AddressServiceImpl1 implements AddressService {
	//@Autowired
	@Resource
	private AddressMapper addressMapper;
	
	@Override
	public List<Address> listS() {
		return addressMapper.list();
	}

	@Override
	public void insertS(Address address) {
		addressMapper.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		addressMapper.delete(seq);
	}
}