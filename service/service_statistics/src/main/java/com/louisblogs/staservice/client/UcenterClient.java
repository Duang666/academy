package com.louisblogs.staservice.client;

import com.louisblogs.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/4 23:22
 */

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

	//查询某一天注册人数
	@GetMapping("/educenter/member/countRegister/{day}")
	public R countRegister(@PathVariable("day") String day);

}
