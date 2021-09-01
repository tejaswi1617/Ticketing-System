//Author : Akshay Garg

package attachment.abstractfactory;

import java.io.IOException;
import attachment.interfaces.IAttachment;

public interface IAttachmentFactory {

	IAttachment makeAttachmentObject(String attachmentType) throws IOException;

}