package com.gap.utils;

import com.gap.domain.Product;

//数据改变类
public class ChangeDataUtils {

	//处理直销
	public static Origin changeProductToOrigin(Product p, String placeName, String placeAddress){
		Origin ori = new Origin();
		String pid = p.getProductId_rep();
		String yy = pid.substring(0, 4);
		String mm = pid.substring(4, 6);
		String dd = pid.substring(6, 8);
		String hour = pid.substring(9, 11);
		String min = pid.substring(11, 13);
		String riqi = yy + "年" + mm + "月" + dd + "日" + hour + "时" + min + "分";
		
		//设置处理日期
		ori.setPickTime(riqi);
		//设置地点名称
		ori.setPlaceName(placeName);
		//设置地址
		ori.setPlaceAddress(placeAddress);
		//设置产品号
		ori.setProductId(p.getProductId_rep());
		//设置产品名
		ori.setProductName(p.getName_rep());
		//设置价格
		ori.setPrice(p.getSellPrice_rep()+"元/" +p.getSellUnit_rep());
		
		return ori;
	}
}
