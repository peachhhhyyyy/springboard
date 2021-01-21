package peachy.md.service;

import java.util.List;
import peachy.md.domain.Address;

public interface AddressService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
}