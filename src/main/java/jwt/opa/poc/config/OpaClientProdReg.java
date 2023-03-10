package jwt.opa.poc.config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OpaClientProdReg {

    @Autowired
    private FeignClientConfig feignClientConfig;

    private static final String URI = "http://localhost:8181/v1/data/prodreg/allow";
    private static final Logger LOG = LoggerFactory.getLogger(OpaClientProdReg.class);

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean allow(String action, Map<String, Object> resourceAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || action == null || resourceAttributes == null || resourceAttributes.isEmpty()) {
            return false;
        }

        String name = authentication.getName();
        List<String> authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toUnmodifiableList());
        Map<String, Object> subjectAttributes = Map.of(
                "name", name,
                "authorities", authorities
        );


        Map<String, Object> input = Map.of(
                "subject", subjectAttributes,
                "resource", resourceAttributes,
                "action", action
        );
        System.out.println(resourceAttributes);
        ObjectNode requestNode = objectMapper.createObjectNode();
        requestNode.set("input", objectMapper.valueToTree(input));
        LOG.info("Authorization request:\n" + requestNode.toPrettyString());

        //JsonNode responseNode = Objects.requireNonNull(restTemplate.postForObject(URI, requestNode, JsonNode.class));

        JsonNode responseNode =  Objects.requireNonNull(feignClientConfig.prodregOpa(requestNode));

        LOG.info("Authorization response:\n" + responseNode.toPrettyString());

        return responseNode.has("result") && responseNode.get("result").asBoolean();
    }
}