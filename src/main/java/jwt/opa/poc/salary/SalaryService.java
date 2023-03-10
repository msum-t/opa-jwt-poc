package jwt.opa.poc.salary;

import jwt.opa.poc.policy.Policy;
import jwt.opa.poc.policy.PolicyRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

        private final SalaryRepository repository;



        public SalaryService(SalaryRepository repository, PolicyRepo policyRepo) {
            this.repository = repository;
        }
   // @PreAuthorize("@opaClient.allow('read', T(java.util.Map).of('type', 'salary', 'user', #username))")
        public Salary getSalaryByUsername(String username) {
            return repository.findByUsername(username)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        public Salary username(String username){

            return null;
        }


    //@PreAuthorize("@opaClient.allow('read', T(java.util.Map).of('type', #services, 'user', #username))")
    public Salary getSalaryByUsername(String username, List<String> services) {
        System.out.println(services);
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
