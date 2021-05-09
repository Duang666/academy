package com.louisblogs.eduservice.service;

import com.louisblogs.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.louisblogs.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-11
 */
public interface EduChapterService extends IService<EduChapter> {

	//课程大纲列表,根据课程id进行查询
	List<ChapterVo> getChapterVideoByCourseId(String courseId);

	//删除章节
	boolean deleteChapter(String chapterId);

	//2 根据课程id删除章节
	void removeChapterByCourseId(String courseId);
}
