//Author : Akshay Garg

package attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import attachment.interfaces.IAttachmentDao;

public class FileAttachment extends AbstractAttachment {

	private IAttachmentDao fileAttachmentDao = null;

	public FileAttachment(IAttachmentDao fileAttachmentDao) {
		this.fileAttachmentDao = fileAttachmentDao;
	}

	public String upload(String sourcePath) throws Exception {
		String attachmentId = null;

		if (StringUtils.isNotBlank(sourcePath)) {
			try {
				attachmentId = generateAttachmentId();
				File file = new File(sourcePath);
				InputStream fileInputStream = new FileInputStream(file);
				fileAttachmentDao.uploadFileAttachment(attachmentId, fileInputStream);
			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException("File is not present at the specified path");
			}
		}

		return attachmentId;
	}

	public boolean download(String attachmentId, String destinationPath) throws Exception {
		boolean downloadedSuccessfully = false;

		if (StringUtils.isNotBlank(attachmentId) && StringUtils.isNotBlank(destinationPath)) {
			File outputFile = new File(destinationPath);
			InputStream dbStoredFile = fileAttachmentDao.downloadFileAttachment(attachmentId);
			FileUtils.copyInputStreamToFile(dbStoredFile, outputFile);
			downloadedSuccessfully = true;
		}

		return downloadedSuccessfully;
	}
}
