package in.tech.solutions.endpoint;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import in.tech.solutions.service.SatisfactionService;
import in.tech.solutions.utils.TestUtils;

/**
 * The Class RestaurantSatisfactionControllerTest.
 * 
 * @author hari kaja
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantSatisfactionController.class)
public class RestaurantSatisfactionControllerTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The satisfaction service. */
	@Autowired
	SatisfactionService satisfactionService;

	/**
	 * Test find max satisfaction.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfaction() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThan(0)));
	}

	/**
	 * Test find max satisfaction false data.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionFalseData() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData", "1212 122".getBytes()))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	/**
	 * Test find max satisfaction no feed data.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionNoFeedData() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData", null))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	/**
	 * Test find max satisfaction test case 1.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase1.txt")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThan(0)));
	}

	/**
	 * Test find max satisfaction test case 2.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase2.txt")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThan(0)));
	}

	/**
	 * Test find max satisfaction test case 3.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase3() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase3.txt")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThan(0)));
	}

	/**
	 * Test find max satisfaction test case 4.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase4() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase4.txt")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThanOrEqualTo(0)));
	}

	/**
	 * Test find max satisfaction test case 5.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase5InvalidDataFormat() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase5.txt")))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	/**
	 * Test find max satisfaction test case 6.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindMaxSatisfactionTestCase6() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/satisfaction").file("feedData",
				TestUtils.copyFileToUseForTestAsByteArray("testcase6.txt")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.result", Matchers.greaterThan(0)));
	}

}