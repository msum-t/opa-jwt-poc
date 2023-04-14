package jwt.opa.poc.prodreg;

import jwt.opa.poc.config.QueryGenerator;
import jwt.opa.poc.config.RoleBaseColumnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdregCustomImpl implements ProdregCustom {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private QueryGenerator queryGenerator;




    @Override
    @PreAuthorize("@opaClientProdReg.allow(T(java.util.Map).of('columnValue', (T(java.util.Arrays).#columnValue.split(','))))")
    public List<Object> findAllWithSalesColumnValues(String columnValue ,Class dtoClass) {
        List<String> dynamicCols = Arrays.asList(columnValue.split(","));
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> query = cb.createQuery(dtoClass);
        Root<Product> root = query.from(Product.class);

        List<Selection<?>> selectList = new ArrayList<>();
        for (String col : dynamicCols) {
            selectList.add(root.get(col));
        }

        query.select(cb.construct(dtoClass, selectList.toArray(new Selection[0])));

        return em.createQuery(query).getResultList();

//        return em.createNativeQuery(
//                queryGenerator.generateSelectQuery("product_tble", roleBaseColumnConfig.generateColumnValue(),
//                        null)).getResultList();

    }


    public static <T> T createObject(Class<T> clazz, List<String> fieldValues) {
        Constructor<T> constructor = null;
        T object = null;
        try {
            constructor = clazz.getDeclaredConstructor();

            constructor.setAccessible(true);

            object = constructor.newInstance();

            for (String fieldName : fieldValues) {
                System.out.println(fieldName);
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return object;
    }

}


