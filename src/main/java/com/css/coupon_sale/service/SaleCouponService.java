package com.css.coupon_sale.service;

import com.css.coupon_sale.dto.response.BusinessEarningsDTO;
import com.css.coupon_sale.dto.response.PurchaseCouponResponse;
import com.css.coupon_sale.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleCouponService {

    boolean insertSaleCoupon(int orderId);

    List<PurchaseCouponResponse> getAllCouponsByUserId(Long userId);

    PurchaseCouponResponse getBySaleCouponId(int id);

    List<BusinessEarningsDTO> getBusinessEarnings();

    BusinessEarningsDTO getEarningsByBusinessId(int businessId);

    Double getCurrentMonthEarnings(int businessId);

    Double getCurrentYearEarnings(int businessId);
}
