package com.louisblogs.eduservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/4 18:02
 */

@Component
@FeignClient("service-order")
public interface OrdersClient {

	//根据课程id和用户id查询订单表中订单状态
	@GetMapping("/eduorder/paylog/isBuyCourse/{courseId}/{memberId}")
	public boolean isBuyCourse(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);

}
