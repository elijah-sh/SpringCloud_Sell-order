package com.order.repository;

import com.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 13:51
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
