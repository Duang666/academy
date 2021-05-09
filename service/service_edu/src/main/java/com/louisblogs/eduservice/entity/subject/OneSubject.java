package com.louisblogs.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：luqi
 * @description：一级分类
 * @date ：2021/4/11 13:15
 */

@Data
public class OneSubject {

	private String id;
	private String title;

	//一个一级分类有多个二级分类
	private List<TwoSubject> children = new ArrayList<>();

}
