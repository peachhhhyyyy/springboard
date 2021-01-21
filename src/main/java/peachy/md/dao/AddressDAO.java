package peachy.md.dao;

import java.util.List;
import peachy.md.domain.Address;

public interface AddressDAO {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
}
