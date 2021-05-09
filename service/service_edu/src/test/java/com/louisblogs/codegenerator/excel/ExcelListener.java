package com.louisblogs.codegenerator.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;

import java.util.Map;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/10 12:38
 */

public class ExcelListener extends AnalysisEventListener<DemoData> {

	//一行一行读取excel内容
	@Override
	public void invoke(DemoData data, AnalysisContext analysisContext) {
		System.out.println("*****"+data);
	}

	//读取表头内容
	@Override
	public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
		System.out.println("表头："+headMap);
	}

	//读取完成之后
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}

}
