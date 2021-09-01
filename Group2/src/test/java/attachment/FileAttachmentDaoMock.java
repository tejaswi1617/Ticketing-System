package attachment;

import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;
import attachment.interfaces.IAttachmentDao;

public class FileAttachmentDaoMock implements IAttachmentDao {

	private InputStream inputStream;
	private String attachmentId;

	@Override
	public boolean uploadFileAttachment(String attachmentId, InputStream inputStream) throws Exception {
		this.attachmentId = attachmentId;
		this.inputStream = inputStream;
		return true;
	}

	@Override
	public InputStream downloadFileAttachment(String attachmentId) throws Exception {
		if (StringUtils.isNotBlank(attachmentId) && attachmentId.trim().equalsIgnoreCase(this.attachmentId)) {
			return this.inputStream;
		}
		return null;
	}
}
