package in.tech.solutions.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import in.tech.solutions.model.BaseEntity;

/**
 * The Class HelperUtilsTest.
 */
public class HelperUtilsTest {

	/**
	 * Test parse file.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testParseFile() throws IOException {

		BaseEntity parseFile = HelperUtils.parseFile(TestUtils.copyFileToUseForTestAsFile());
		assertTrue(parseFile.isValidInput());
	}

	@Test
	public void testMultipartToFile() throws IOException {
		MockMultipartFile file = new MockMultipartFile("feedData", "orig", null,
				TestUtils.copyFileToUseForTestAsByteArray());
		HelperUtils.multipartToFile(file);
		BaseEntity parseFile = HelperUtils.parseFile(TestUtils.copyFileToUseForTestAsFile());
		assertTrue(parseFile.isValidInput());
	}

	@Test
	public void testMax() throws IOException {
		assertTrue(HelperUtils.max(1, 2) == 2);
		assertFalse(HelperUtils.max(7, 2) == 2);
	}

}
