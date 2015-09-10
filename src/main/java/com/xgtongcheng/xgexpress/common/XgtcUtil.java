package com.xgtongcheng.xgexpress.common;

import com.alibaba.fastjson.JSONObject;

public class XgtcUtil {
	
	/**
	 * 返回值json
	 * @param resState  1成功
	 * @param info
	 * @return
	 */
	public static String getResultInfo(String resState,String info){
		JSONObject j = new JSONObject();
		j.put("info", info);
		j.put("result", resState);
		
		return j.toJSONString();
	}
}
