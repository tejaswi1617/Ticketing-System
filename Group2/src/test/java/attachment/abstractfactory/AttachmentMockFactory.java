//Author : Akshay Garg

package attachment.abstractfactory;

import attachment.FileAttachment;
import attachment.FileAttachmentDaoMock;
import attachment.interfaces.IAttachment;
import attachment.interfaces.IAttachmentDao;

public class AttachmentMockFactory implements IAttachmentFactory {

	public final String FILE_ATTACHMENT = "file";

	private static IAttachmentFactory uniqueInstance = null;

	private AttachmentMockFactory() {

	}

	public static IAttachmentFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new AttachmentMockFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IAttachment makeAttachmentObject(String attachmentType) {

		if (attachmentType == null) {
			return null;
		}

		if (attachmentType.equalsIgnoreCase(FILE_ATTACHMENT)) {
			IAttachmentDao attachmentDao = new FileAttachmentDaoMock();
			return new FileAttachment(attachmentDao);
		}

		return null;
	}
}
