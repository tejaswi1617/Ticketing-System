//Author : Akshay Garg

package attachment;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import com.mysql.cj.jdbc.Blob;
import attachment.interfaces.IAttachmentDao;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;
import mailservice.ReadPropertiesFile;

public class FileAttachmentDao implements IAttachmentDao {

	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();
	private final String uploadAttachment = "upload_attachment";
	private final String downloadAttachment = "download_attachment";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";

	public FileAttachmentDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String) properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}

	@Override
	public boolean uploadFileAttachment(String attachmentId, InputStream inputStream) throws Exception {

		if (connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");
		}

		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		procedureCall = connection.prepareCall("call " + uploadAttachment + "(?,?)");
		procedureCall.setString(1, attachmentId);
		procedureCall.setBlob(2, inputStream);

		boolean result = databaseOperations.executeUpdateCommand(procedureCall);
		connectionManager.closeConnection();
		return result;

	}

	@Override
	public InputStream downloadFileAttachment(String attachmentId) throws Exception {

		if (connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");
		}

		InputStream inputStream = null;
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;

		procedureCall = connection.prepareCall("call " + downloadAttachment + "(?)");
		procedureCall.setString(1, attachmentId);

		boolean isResultSet = databaseOperations.executeCommand(procedureCall);

		if (isResultSet) {
			ResultSet resultSet = procedureCall.getResultSet();
			if (resultSet.next()) {
				inputStream = ((Blob) resultSet.getBlob(1)).getBinaryStream();
			}
		}
		connectionManager.closeConnection();
		return inputStream;
	}

}
