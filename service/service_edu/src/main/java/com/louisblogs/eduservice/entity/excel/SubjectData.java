package com.louisblogs.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/10 13:23
 */

@Data
public class SubjectData {

	@ExcelProperty(index = 0)
	private String oneSubjectName;
	@ExcelProperty(index = 1)
	private String twoSubjectName;

}
