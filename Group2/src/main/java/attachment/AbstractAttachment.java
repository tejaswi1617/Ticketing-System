package attachment;

import java.util.UUID;
import attachment.interfaces.IAttachment;

public abstract class AbstractAttachment implements IAttachment {

	public String generateAttachmentId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
