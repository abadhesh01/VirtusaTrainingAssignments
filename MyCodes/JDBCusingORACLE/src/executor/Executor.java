package executor;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import service.Service;
import service.ServiceImpl;

public class Executor {

	private static final Logger logger = Logger.getLogger(Executor.class);

	public static void main(String[] args) {

		try {

			// Setting up logger.
			Layout layout = new SimpleLayout();
			Appender appender = new ConsoleAppender(layout);
			logger.addAppender(appender);
			logger.setLevel(Level.INFO);

			// Setting up services.
			Service service = new ServiceImpl();

			// Creating connection to database.
			service.setDatbaseConnection(logger);

			// Showing all users' details.
			service.getllUsersList(logger);

			// Closing connection to database and releasing resources.
			service.releaseResourcesAndcloseConnection(logger);

		} catch (Exception exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}

	}
}
