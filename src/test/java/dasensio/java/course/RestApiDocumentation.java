package dasensio.java.course;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import dasensio.java.course.domain.attendee.Attendee;
import dasensio.java.course.service.attendee.IAttendeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CourseApplication.class)
@WebAppConfiguration
public class RestApiDocumentation {

	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private IAttendeeService attendeeService;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation)).alwaysDo(document("{method-name}")).build();
	}

	// TODO @Test
	public void indexExample() throws Exception {

	}

	@Test
	public void errorExample() throws Exception {
		this.mockMvc
				.perform(get("/error").requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
						.requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/rest/attendee").requestAttr(
								RequestDispatcher.ERROR_MESSAGE,
								"The tag 'http://localhost:8080/rest/attendee/123' does not exist"))
				.andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("error", is("Bad Request")))
				.andExpect(jsonPath("timestamp", is(notNullValue()))).andExpect(jsonPath("status", is(400)))
				.andExpect(jsonPath("path", is(notNullValue())))
				.andDo(document("error-example",
						responseFields(
								fieldWithPath("error").description("The HTTP error that occurred, e.g. `Bad Request`"),
								fieldWithPath("message").description("A description of the cause of the error"),
								fieldWithPath("path").description("The path to which the request was made"),
								fieldWithPath("status").description("The HTTP status code, e.g. `400`"),
								fieldWithPath("timestamp")
										.description("The time, in milliseconds, at which the error occurred"))));
	}

	@Test
	public void attendeeListExample() throws Exception {
		createAttendee("Mary", "Floyd Autumn", "NYRIS");
		createAttendee("Bess", "Buck Lloyd", "BIABLI");
		createAttendee("Sean", "Parker Blaine", "SNADO");
		createAttendee("Derek", "Glen Penny", "ROBOSONIC");
		createAttendee("Tristan", "Kip Joan", "EFVY");

		this.mockMvc.perform(get("/rest/attendee")).andExpect(status().isOk())
				.andDo(document("attendee-list-example",
						responseFields(fieldWithPath("[]").description("An array of [Attende] resources"),
								fieldWithPath("[]id").description("The id of the attendee"),
								fieldWithPath("[]name").description("The name of the attendee"),
								fieldWithPath("[]lastname").description("The lastname of the attendee"),
								fieldWithPath("[]company").description("The company of the attendee"))));
	}

	@Test
	public void attendeeCreateExample() throws Exception {
		Map<String, Object> attendee = new HashMap<>();
		attendee.put("name", "Sean");
		attendee.put("lastname", "Parker Blaine");
		attendee.put("company", "SNADO");

		this.mockMvc
				.perform(post("/rest/attendee").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(attendee)))
				.andExpect(status().isCreated())
				.andDo(document("attendee-create-example",
						requestFields(fieldWithPath("name").description("The name of the attendee"),
								fieldWithPath("lastname").description("The lastname of the attendee").optional(),
								fieldWithPath("company").description("The company of the attendee").optional())));
	}

	// TODO @Test
	public void attendeeUpdateExample() throws Exception {
		List<Attendee> attendees = attendeeService.getAttendees();
		if (attendees.isEmpty()) {
			createAttendee("Sean", "Parker Blaine", "SNADO");
			attendees = attendeeService.getAttendees();
		}

		Map<String, Object> attendee = new HashMap<>();
		attendee.put("name", "Sean");
		attendee.put("lastname", "Parker Blaine");
		attendee.put("company", "VERIFY");

		this.mockMvc
				.perform(put("rest/attendee/{id}", attendees.get(0).getId()).contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(attendee)))
				.andExpect(status().isOk())
				.andDo(document("attendee-update-example",
						requestFields(fieldWithPath("name").description("The name of the attendee"),
								fieldWithPath("lastname").description("The lastname of the attendee").optional(),
								fieldWithPath("company").description("The NEW company of the attendee").optional())));
	}

	// TODO @Test
	public void attendeeDeleteExample() throws Exception {
		List<Attendee> attendees = attendeeService.getAttendees();
		if (attendees.isEmpty()) {
			createAttendee("Sean", "Parker Blaine", "SNADO");
			attendees = attendeeService.getAttendees();
		}

		this.mockMvc.perform(delete("rest/attendee/{id}", attendees.get(0).getId())).andExpect(status().isNoContent());
		// FIXME andDo(document("attendee-delete-example", ...)
	}

	private void createAttendee(final String name, final String lastname, final String company) {
		Attendee attendee = new Attendee();
		attendee.setName(name);
		attendee.setLastname(lastname);
		attendee.setCompany(company);

		attendeeService.create(attendee);
	}
}
