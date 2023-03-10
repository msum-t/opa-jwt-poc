package jwt.opa.poc.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {


    @Autowired
    private PolicyService policyService;


    @GetMapping("/policy")
    public String createPolicy(Policy policy){

        if(policyService.createPolicy(policy))
            return "Policy Created Successfully";
        else
            return "Issue in policy creation !!!!";
    }
}
