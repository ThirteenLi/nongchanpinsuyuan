package com.gap.utils;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

import com.gap.domain.Product;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class GenerateQRCode {
/*	//二维码生成类
	public static BitMatrix MakeQRCode(String url, int width, int height) throws Exception{
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(); 
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
		return new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);		
	}*/
	
	
	public static BufferedImage generateQRCode(Product p) throws Exception{
		String str = "http://193.112.57.249:8080/gap/ProductAction_searchOriginInformation?productId_rep=";
		String id = p.getProductId_rep();
		String url = str + id;
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(); 
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);
		BufferedImage bi = MatrixToImageWriter.toBufferedImage(bitMatrix);
		return bi;
	}
	
}
