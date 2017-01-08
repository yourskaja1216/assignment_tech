package in.tech.solutions.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import in.tech.solutions.model.BaseEntity;

/**
 * The Class HelperUtils.
 * 
 * @author hari kaja
 */
public class HelperUtils {

	private HelperUtils() {
	}

	/**
	 * Multipart to file.
	 *
	 * @param multipart
	 *            the multipart
	 * @return the file
	 * @throws IllegalStateException
	 *             the illegal state exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		String originalFilename = multipart.getOriginalFilename();
		String extension = ".tmp";
		int i = originalFilename.lastIndexOf('.');
		if (i > 0) {
			extension = originalFilename.substring(i);
		}
		File tempFile = File.createTempFile("UploadedFile", extension);
		multipart.transferTo(tempFile);
		return tempFile;
	}

	/**
	 * Parses the file.
	 *
	 * @param uploadedFile
	 *            the uploaded file
	 * @return the list
	 */
	public static BaseEntity parseFile(File uploadedFile) {
		BaseEntity basePair = new BaseEntity();
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(uploadedFile);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;

			boolean isFirst = true;
			while ((line = bufferedReader.readLine()) != null) {
				String[] dataArray = line.split(" ");

				int satisfaction = Integer.parseInt(dataArray[0]);
				int timeTaken = Integer.parseInt(dataArray[1]);

				if (isFirst) {
					basePair.setGivenTime(satisfaction);
					basePair.setNumberOfItems(timeTaken);
					isFirst = false;
				} else {
					basePair.getAmountOfSatisfaction().add(satisfaction);
					basePair.getTimeTaken().add(timeTaken);
				}
			}

		} catch (FileNotFoundException e) {
			basePair = null;
		} catch (IOException e) {
			basePair = null;
		} finally {
			IOUtils.closeQuietly(bufferedReader);
			IOUtils.closeQuietly(fileReader);
		}
		return basePair;
	}

	/**
	 * Max.
	 *
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return the int
	 */
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
