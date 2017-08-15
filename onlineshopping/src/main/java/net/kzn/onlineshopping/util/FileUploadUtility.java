package net.kzn.onlineshopping.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "/Users/shadyaab/Sady/Java/online-shopping/onlineshopping/src/main/webapp/assets/images";
	
	private static String REAL_PATH = "";

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//get real path
		REAL_PATH= request.getSession().getServletContext().getRealPath("/assets/images/");
	}
	
}
