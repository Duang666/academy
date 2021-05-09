package com.louisblogs.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.louisblogs.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author luqi
 * @since 2021-04-10
 */

public interface EduTeacherService extends IService<EduTeacher> {

	//分页查询讲师的方法
	Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);

}
