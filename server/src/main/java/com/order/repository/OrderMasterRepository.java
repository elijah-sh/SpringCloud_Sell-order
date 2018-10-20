package com.order.repository;

import com.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 13:53
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
