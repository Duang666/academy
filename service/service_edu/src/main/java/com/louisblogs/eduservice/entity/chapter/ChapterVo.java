package com.louisblogs.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/12 20:37
 */

@Data
public class ChapterVo {

	private String id;
	private String title;

	//表示小节
	private List<VideoVo> children = new ArrayList<>();

}
