package jwt.opa.poc.salary;

import jwt.opa.poc.policy.Policy;
import jwt.opa.poc.policy.PolicyRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SalaryController {

    private final SalaryService service;

    private final PolicyRepo policyRepo;

    public SalaryController(SalaryService service, PolicyRepo policyRepo) {
        this.service = service;
        this.policyRepo = policyRepo;
    }

    @GetMapping("/salary/{username}")
    public Salary getSalary(@PathVariable String username) {
        return service.getSalaryByUsername(username);
    }

    @GetMapping("/ui/{username}")
    public Salary getSalaryFromUi(@PathVariable String username) {
        Optional<Policy> byUsername = policyRepo.findByUsername(username);
        System.out.println(byUsername.get());
        return service.getSalaryByUsername(username,byUsername.get().getServicesName());
    }
}