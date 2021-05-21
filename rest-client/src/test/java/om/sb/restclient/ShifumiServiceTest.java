package om.sb.restclient;

import com.sb.restclient.adapter.Choice;
import com.sb.restclient.adapter.RestApiException;
import com.sb.restclient.adapter.ShifumiService;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.sb.restclient.adapter.Choice.PAPER;
import static javax.ws.rs.core.Response.Status.TOO_MANY_REQUESTS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
@QuarkusTestResource(WiremockShifumi.class)
public class ShifumiServiceTest {

    @Inject
    @RestClient
    ShifumiService service;

    @Test
    public void test() {

        stubFor(
                post(urlEqualTo("/play"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("\"PAPER\""))
        );

        Choice result = service.play();

        assertThat(result, is(PAPER));
    }

    @Test
    public void quotaLimitExceeded() {

        stubFor(
                post(urlEqualTo("/play"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatus(TOO_MANY_REQUESTS.getStatusCode())
                                .withBody("{\"error\": \"QUOTA_LIMIT_EXCEEDED\", \"error_description\": \"You used all your credits\"}"))
        );

        RestApiException e = assertThrows(
                RestApiException.class,
                () -> service.play()
        );

        assertThat(e.getMessage(), is("QUOTA_LIMIT_EXCEEDED: You used all your credits"));
    }
}
