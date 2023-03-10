package jwt.opa.poc.prodreg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProdRegController {


    @PostMapping("/create-product")
    @PreAuthorize("@opaClientProdReg.allow('create', T(java.util.Map).of('type', 'create-product'))")
    public String createProduct(){
        log.info("create product api");
        return "Product created successfully";
    }

    @PutMapping("/approve-product")
    @PreAuthorize("@opaClientProdReg.allow('approved', T(java.util.Map).of('type', 'approve-product'))")
    public String approveProduct(){
        log.info("approved product api");

        return "Product approved successfully";
    }

    @GetMapping("/dealer")
    @PreAuthorize("@opaClientProdReg.allow('read', T(java.util.Map).of('type', 'dealer'))")
    public String dealer(){
        log.info("dealer api");
        return "This is from dealer api";
    }

    @DeleteMapping("/ops")
    @PreAuthorize("@opaClientProdReg.allow('remove', T(java.util.Map).of('type', 'ops'))")
    public String ops(){
        log.info("ops api");
        return "This is from ops api";
    }

    @GetMapping("/reject-product-list")
    @PreAuthorize("@opaClientProdReg.allow('read', T(java.util.Map).of('type', 'reject-product-list'))")
    public String rejectedProductList(){
        log.info("rejected product  list");
        return "This is from rejected product  list";
    }
    @GetMapping("/approved-product-list")
    @PreAuthorize("@opaClientProdReg.allow('read', T(java.util.Map).of('type', 'approved-product-list'))")
    public String approvedProductList(){
        log.info("approved product api");
        return "approved product api";
    }
}
