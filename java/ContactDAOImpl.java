import java.util.List;

import net.codejava.contact.Contact;
import net.codejava.contact.dao.ContactDAO;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public int save(Contact contact) {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int delete(Integer contactId) {
		return contactId;
		// TODO Auto-generated method stub
	
	}

	@Override
	public Contact get(int contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
