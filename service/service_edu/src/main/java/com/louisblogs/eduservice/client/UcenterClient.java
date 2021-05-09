package com.louisblogs.eduservice.client;

import com.louisblogs.commonutils.ordervo.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/4 19:54
 */

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

	//根据用户id获取用户信息
	@PostMapping("/educenter/member/getUserInfoOrder/{memberId}")
	public UcenterMemberOrder getUcenterPay(@PathVariable("memberId") String memberId);

}
