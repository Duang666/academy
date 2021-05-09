package com.louisblogs.codegenerator.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/9 16:39
 */

@Data
public class DemoData {

	//设置excel表头名称
	@ExcelProperty("学生编号")
	private Integer sno;
	@ExcelProperty("学生姓名")
	private String sname;

}
