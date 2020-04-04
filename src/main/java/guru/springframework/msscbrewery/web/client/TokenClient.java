package guru.springframework.msscbrewery.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(value = "sfg.token", ignoreUnknownFields = false)
public class TokenClient {

    public final String TOKEN_PATH = "/oauth/token/?grant_type={credentials}&client_id={clientId}&client_secret={clientSecret}";
    private String apihost;

    private final RestTemplate restTemplate;

    public TokenClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Object getToken() {
        Map<String, String> vars = new HashMap<>();
        vars.put("credentials", "client_credentials");
        vars.put("clientId", "tcvjzINFxAgQk3m4pe9ZuDl5YCgHF0VL3cAztmBB");
        vars.put("clientSecret", "pkfu5WfQRWEyeTfbOWo9Lz1WHs41agcwnRtmchthz8R98EoEjOcHzODfLF9oLXzGji8kinPSqWRGnLa81uOr250necguo5FQiqJbtjNaCprUS7kQtigZg4AUz768Gjoo");
        Object o = restTemplate.postForObject(apihost + TOKEN_PATH, null, Object.class, vars);
        return o;
    }

    public void setApiHost(String apiHost) {
        this.apihost = apiHost;
    }
}
