package ro.unibuc.hello.e2e.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import ro.unibuc.hello.dto.AuditoriumDTO;
import ro.unibuc.hello.e2e.util.HeaderSetup;
import ro.unibuc.hello.e2e.util.ResponseErrorHandler;
import ro.unibuc.hello.e2e.util.ResponseResults;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@CucumberContextConfiguration
@SpringBootTest
public class AuditoriumSteps {

    public static ResponseResults latestResponse = null;
    private String baseUrl = "http://localhost:8080";

    @Autowired
    protected RestTemplate restTemplate;

    @Given("^the client calls (.+)$")
    public void the_client_issues_GET_auditorium(String path) {
        baseUrl = baseUrl + path;
    }

    @And("^the searched auditorium has the id (.+)$")
    public void GET_auditorium_by_id(String id) {
        executeGet(String.format(baseUrl + "/" + id));
    }

    @And("^the searched auditorium has the name (.+)$")
    public void GET_auditorium_by_name(String name) {
        executeGet(String.format(baseUrl + "/" + name));
    }

    @And("^the searched movie has the id (.+)$")
    public void GET_auditoriums_by_movie(String id) {
        executeGet(String.format(baseUrl + "/" + id));
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives the name (.+)")
    public void the_client_receives_name(String name) throws JsonProcessingException {
        String latestResponseBody = latestResponse.getBody();

        AuditoriumDTO auditoriumDTO = new ObjectMapper().readValue(latestResponseBody, AuditoriumDTO.class);

        assertThat("Response received is incorrect (name): ", auditoriumDTO.getName(), is(name));
    }

    @And("^the client receives the id (.+)")
    public void the_client_receives_id(String id) throws JsonProcessingException {
        String latestResponseBody = latestResponse.getBody();

        AuditoriumDTO auditoriumDTO = new ObjectMapper().readValue(latestResponseBody, AuditoriumDTO.class);

        assertThat("Response received is incorrect (id): ", auditoriumDTO.getId(), is(id));
    }

    @And("^the seat number (.+) of the auditorium$")
    public void the_client_receives_seatNumber(int seatNumber) throws JsonProcessingException {
        String latestResponseBody = latestResponse.getBody();

        AuditoriumDTO auditoriumDTO = new ObjectMapper().readValue(latestResponseBody, AuditoriumDTO.class);

        assertThat("Response received is incorrect (seatNumber): ", auditoriumDTO.getSeatNumber(), is(seatNumber));
    }

    @And("^the auditorium with the id (.+) is in the list$")
    public void check_auditorium_in_list(int id) throws JsonProcessingException {
        String latestResponseBody = latestResponse.getBody();

        AuditoriumDTO auditoriumDTO = new AuditoriumDTO("1234567890", "room1", 101);

        List<AuditoriumDTO> auditoriumDTOList = Arrays.asList(new ObjectMapper().readValue(latestResponseBody, AuditoriumDTO[].class));

        assertThat("Response received is incorrect (auditorium not in list):", true, is(auditoriumDTOList.contains(auditoriumDTO)));
    }

    public void executeGet(String url) {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSetup requestCallback = new HeaderSetup(headers);
        final ResponseErrorHandler errorHandler = new ResponseErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.getHadError()) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }

}
