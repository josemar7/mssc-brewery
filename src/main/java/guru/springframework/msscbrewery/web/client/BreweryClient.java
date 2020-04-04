package guru.springframework.msscbrewery.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "sfg.users", ignoreUnknownFields = false)
public class BreweryClient {

    public final String USERS_PATH = "/public-api/users/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Object getUser(Integer user) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer h3sdSWMlgGeFDW7BhMWgAL1ijta6Q4L9uk9Q");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Object> o = new RestTemplate().exchange(apihost + USERS_PATH + user.toString(), HttpMethod.GET, request, Object.class);
        return o;
    }

    public void setApiHost(String apiHost) {
        this.apihost = apiHost;
    }
}
