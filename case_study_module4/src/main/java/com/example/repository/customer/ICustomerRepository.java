package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

//    @Query(value = "select  * " +
//            "from  customer" +
//            " join customer_type on customer.customer_type_id = customer_type.id" +
//            " where" +
//            " customer.name like %:nameSearch%" +
//            " and " +
//            "customer.email like %:emailSearch%" +
//            " and " +
//            "customer_type.name like %:customerTypeNameSearch%" +
//            " and " +
//            "customer.delete_status = false ",
//            nativeQuery = true)
//    Page<Customer>  searchCustomer (@Param("nameSearch") String nameSearch,
//                                    @Param("emailSearch") String emailSearch,
//                                    @Param("customerTypeNameSearch") String customerTypeNameSearch, Pageable pageable);

    @Query(value = "select  * " +
            "from  customer" +
            " where" +
            " customer.name like %:nameSearch%" +
            " and " +
            "customer.email like %:emailSearch%" +
            " and " +
            "customer.address like %:addressSearch%" +
            " and " +
            "customer.delete_status = 0 ",
            nativeQuery = true)
    Page<Customer>  searchCustomer (@Param("nameSearch") String nameSearch,
                                    @Param("emailSearch") String emailSearch,
                                    @Param("addressSearch") String addressSearch, Pageable pageable);

    @Modifying
    @Query(value = "update customer set delete_status = 1 where id = :idDelete",nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);


}
