package jwt.opa.poc.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "opa-server",url = "localhost:8181")
public interface FeignClientConfig {

    @PostMapping(value = "/v1/data/prodreg/allow")
    public JsonNode prodregOpa(ObjectNode objectNode);

}
