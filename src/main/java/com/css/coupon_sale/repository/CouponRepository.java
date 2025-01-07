package com.css.coupon_sale.repository;

import com.css.coupon_sale.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity,Integer> {
    List<CouponEntity> findByProduct_Business_Id(int businessId);
    List<CouponEntity> findByProduct_BusinessId(int businessId);
    @Query("SELECT sc.id as saleCouponId, sc.business.id as businessId, SUM(sc.quantity) as soldCount, DATE(sc.buyDate) as buyDate " +
            "FROM SaleCouponEntity sc " +
            "WHERE sc.business.id = :businessId " +
            "GROUP BY sc.id, sc.business.id, DATE(sc.buyDate)")
    List<Object[]> getSoldCouponCountByBusiness(@Param("businessId") Integer businessId);
}
