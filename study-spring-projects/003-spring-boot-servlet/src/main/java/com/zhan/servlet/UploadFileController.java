package com.zhan.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
	
	
	@RequestMapping("/uploadFile")
	public void uploadFile(MultipartFile file, HttpServletResponse response) throws IOException {
		file.transferTo(new File("D:\\Users\\ZHAN\\Desktop\\aaaaaaaaaaaaaaaaaaaaa.txt"));
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<h1>成功</h1>");
	}

	
	@RequestMapping("/testJSP")
	public String testJSP(Model model) throws IOException {
		model.addAttribute("jsp","JJSSPP");
		return "testJSP";
	}
	
	@RequestMapping("/testFreeMarker")
	public String testFreeMarker(Model model) throws IOException {
		model.addAttribute("jsp","JJSSPP");
		return "index";
	}
}
