package com.louisblogs.eduorder.client;

import com.louisblogs.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/5/3 21:26
 */

@Component
@FeignClient("service-edu")
public interface EduClient {

	//根据课程id查询课程信息
	@PostMapping("/eduservice/coursefront/getCourseInfoOrder/{id}")
	public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);

}
