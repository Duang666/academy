package com.louisblogs.eduservice.mapper;

import com.louisblogs.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.louisblogs.eduservice.entity.frontvo.CourseFrontVo;
import com.louisblogs.eduservice.entity.frontvo.CourseWebVo;
import com.louisblogs.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-11
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

	public CoursePublishVo getPublishCourseInfo(String courseId);

	//根据课程id，编写sql语句查询课程信息
	CourseWebVo getBaseCourseInfo(String courseId);
}
