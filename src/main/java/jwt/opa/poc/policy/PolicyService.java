package jwt.opa.poc.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PolicyService {


    @Autowired
    private PolicyRepo policyRepo;

    public Boolean createPolicy(Policy policy) {
        Policy policy1 = Policy.builder().policyName("TestUI")
                .servicesName(List.of("abc", "cde", "salary")).username("sumitp1").build();
        Policy save = policyRepo.save(policy1);
        return save.getId() != null ? true : false;


    }
    @PostConstruct
    public void createPolicy1() {
        Policy policy1 = Policy.builder().policyName("TestUI")
                .servicesName(List.of("abc", "cde", "salary")).username("alice").build();
        Policy save = policyRepo.save(policy1);

    }
}
