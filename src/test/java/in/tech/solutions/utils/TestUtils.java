package in.tech.solutions.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * The Class TestUtils.
 */
public class TestUtils {

	/**
	 * Copy file to use for test as file.
	 *
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static File copyFileToUseForTestAsFile() throws IOException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("data/feedData.txt");

		Path tempFileUpload = Files.createTempFile("tieout-junit", "." + "txt");
		FileUtils.copyInputStreamToFile(inputStream, tempFileUpload.toFile());
		return tempFileUpload.toFile();

	}

	/**
	 * Copy file to use for test as byte array.
	 *
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] copyFileToUseForTestAsByteArray() throws IOException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("data/feedData.txt");

		return IOUtils.toByteArray(inputStream);

	}

	/**
	 * Copy file to use for test as byte array.
	 *
	 * @param filename
	 *            the filename
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] copyFileToUseForTestAsByteArray(String filename) throws IOException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("data/" + filename);

		return IOUtils.toByteArray(inputStream);

	}
}
