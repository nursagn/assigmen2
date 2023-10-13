package proxy_design_pattern;

// DatabaseExecuter interface defines the method for executing database queries
interface DatabaseExecuter {
	void executeDatabase(String query) throws Exception;
}

// DatabaseExecuterImpl class implements the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// DatabaseExecuterProxy class acts as a proxy for the DatabaseExecuter
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query);
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		// Create a proxy for non-admin user
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		// Try executing a query (spelling mistake in "DELETE")
		nonAdminExecuter.executeDatabase("DELEE");

		// Create another proxy for non-admin user
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		// Try executing a "DELETE" query, which should throw an exception
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		// Create a proxy for admin user
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		// Admin executes a "DELETE" query
		adminExecuter.executeDatabase("DELETE");
	}
}
