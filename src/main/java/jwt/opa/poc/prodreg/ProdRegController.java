package jwt.opa.poc.prodreg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping( "/products")
public class ProdRegController {


    @PostMapping
    @PreAuthorize("@opaClientProdReg.allow('post', T(java.util.Map).of('type', 'products'))")
    public String createProduct(){
        log.info("create product api");
        return "Product created successfully";
    }

    @PutMapping("/{id}")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'approver'))")
    public String approveProduct( @PathVariable Integer id){
        log.info("approved product api");

        return "Product approved successfully";
    }

    @PutMapping("/{id}/dealersapi")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'dealer'))")
    public String dealer(@PathVariable Integer id){
        log.info("dealer api");
        return "This is from dealer api";
    }

    @PutMapping("/{id}/opsapi")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'ops'))")
    public String ops(){
        log.info("ops api");
        return "This is from ops api";
    }

    @GetMapping("/rejectedProductList")
    @PreAuthorize("@opaClientProdReg.allow('get', T(java.util.Map).of('type', 'rejectedProductList'))")
    public String rejectedProductList(){
        log.info("rejected product list");
        return "This is from rejected product  list";
    }
    @GetMapping("/approvedProductList")
    @PreAuthorize("@opaClientProdReg.allow('get', T(java.util.Map).of('type', 'approvedProductList'))")
    public String approvedProductList(){
        log.info("approved product api");
        return "approved product api";
    }
}
