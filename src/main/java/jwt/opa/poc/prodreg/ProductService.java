package jwt.opa.poc.prodreg;

import jwt.opa.poc.config.QueryGenerator;
import jwt.opa.poc.config.RoleBaseColumnConfig;
import jwt.opa.poc.dto.ColumnDTO;
import jwt.opa.poc.prodreg.jdbc.JdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RoleBaseColumnConfig roleBaseColumnConfig;

    @Autowired
    private QueryGenerator queryGenerator;


    @Autowired
    private JdbcImpl jdbcDAO;


    public List<Object> retrieveSalesCols(){
        return productRepo.findAllWithSalesColumnValues(roleBaseColumnConfig.generateColumnValue().getColumnValue(),roleBaseColumnConfig.generateColumnValue().getDtoClass());

    }


    public List<ColumnDTO> retrieveColsData(){

        return jdbcDAO.retrieveDynamical(roleBaseColumnConfig.generateColumnValue().getColumnValue());
    }





}
