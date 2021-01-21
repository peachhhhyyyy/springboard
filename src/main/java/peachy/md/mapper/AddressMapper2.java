package peachy.md.mapper;

import java.util.List;

import peachy.md.domain.Address;

public interface AddressMapper2 {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
}
