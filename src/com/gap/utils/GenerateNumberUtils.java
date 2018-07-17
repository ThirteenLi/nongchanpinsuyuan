package com.gap.utils;

public class GenerateNumberUtils {
	
	public static String generatePictureName(String phoneNum, String category){
		String picName = TimeUtils.getDate() + "_" + phoneNum + "_" + category;
		return picName;
	}
	
	public static String generateProductId(String id){
		String picName = TimeUtils.getDate() + "_" + id;
		return picName;
	}
}
