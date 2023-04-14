package jwt.opa.poc.prodreg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jwt.opa.poc.dto.ColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProdRegController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @PreAuthorize("@opaClientProdReg.allow('post', T(java.util.Map).of('type', 'create-product'))")
    public String createProduct() {
        log.info("create product api");
        return "Product create successfully";
    }

    @PutMapping("/{id}")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'approver'))")
    public String  approveProduct(@PathVariable Integer id) {
        log.info("approved product api");
        return "Product approved by approver";
    }

    @PutMapping("/{id}/dealersapi")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'dealer'))")
    public String  dealer(@PathVariable Integer id) {
        log.info("dealer api");
        return "Dealer Api";
    }

    @PutMapping("/{id}/opsapi")
    @PreAuthorize("@opaClientProdReg.allow('put', T(java.util.Map).of('type', 'ops'))")
    public  String  ops() {
        log.info("ops api");
        return "Ops Api";
    }


    @GetMapping("/rejectedProductList")
    @PreAuthorize("@opaClientProdReg.allow('get', T(java.util.Map).of('type', 'rejectedProductList'))")
    public String rejectedProductList() {
        log.info("rejected product list");
        return "Rejected product list";
    }

    @GetMapping("/approvedProductList")
    @PreAuthorize("@opaClientProdReg.allow('get', T(java.util.Map).of('type', 'approvedProductList'))")
    public  String approvedProductList() {
        log.info("approved product api");
       return  "approved product list !!!";
    }

    @GetMapping("/getProductColumn")
    @PreAuthorize("@opaClientProdReg.allow('get', T(java.util.Map).of('type', 'getProductColumn'))")
    public  List<ColumnDTO> getProductColumn() {
        return productService.retrieveColsData();
    }
}

