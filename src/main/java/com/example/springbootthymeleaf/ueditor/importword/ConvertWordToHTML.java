package com.example.springbootthymeleaf.ueditor.importword;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.State;
import com.example.springbootthymeleaf.controller.ConvertController;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 
 * @author TH_FengYuan
 *
 */
public class ConvertWordToHTML {
	private HttpServletRequest request;
	private Map<String, Object> config;
	private String fileType;

	public ConvertWordToHTML(HttpServletRequest request, Map<String, Object> config) {
		this.request = (HttpServletRequest)request;
		this.config = config;
	}

	/**
	 *   WOrd文档转换为html 元素
	 * @return true/flase  成功/失败
	 */
	public State convert() {
		try {
			String rootPath = config.get("rootPath").toString();
			String savePath = PathFormat.parse(config.get("savePath").toString());
			// 强转成为接受文件的  request
			MultipartHttpServletRequest murequest=(MultipartHttpServletRequest )request;
			List<MultipartFile> files = murequest.getFiles("upfile");
			FileItem fileItem =null;
			for(int i=0;i<files.size();i++)
			{
				// 文件格式相互转换
				MultipartFile multipartFile = files.get(i);
				File file = ConvertController.multipartFileToFile(multipartFile);
				fileItem=  createFileItem(file,file.getName());
			}
//			FileItem fileItem = getFile();
			if(fileItem==null){
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}
			State state = check(fileItem);
			if(!state.isSuccess()){
				return state;
			}
//			Word2HtmlUtil word2HtmlUtil = Word2HtmlUtil.getInstance(fileItem.getInputStream(), fileType, rootPath + savePath, savePath);
			// savePath 第一个savePath是文档保存的 具体位置  第二个是文档返回到Ueditor的位置
			Word2HtmlUtil word2HtmlUtil = Word2HtmlUtil.getInstance(fileItem.getInputStream(), fileType, savePath, savePath);
			// 转换成Html的格式文档
			String html = word2HtmlUtil.getHTML();
			html = parseHTML(html);
			// content 是返回到Ueditor的Html内容
			state.putInfo("content", html);
			return state;
		} catch (Exception e) {
			return new BaseState(false,"解析失败，请稍后再试!");
		}
	}

	private FileItem getFile() throws FileUploadException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(factory);
		List<FileItem> fileItems = uploader.parseRequest(request);
		for (FileItem item : fileItems) {
			if (!item.isFormField()) {
				return item;
			}
		}
		return null;
	}

	public State check(FileItem fileItem) {
		BaseState state = new BaseState(false);
		String fileName = fileItem.getName();
		int fileTypeIndex = fileName.lastIndexOf(".");
		if (fileTypeIndex != -1) {
			fileType = fileName.substring(fileTypeIndex);
		}
		boolean isCheckFileType = ".doc".equals(fileType) || ".docx".equals(fileType);
		long fileSize = fileItem.getSize();
		Integer maxSize = (Integer) config.get("importwordMaxSize");
		if (isCheckFileType) {
			if (fileSize <= maxSize) {
				state.setState(true);
			} else {
				state.setInfo(AppInfo.MAX_SIZE);
			}
		} else {
			state.setInfo(AppInfo.NOT_ALLOW_FILE_TYPE);
		}
		return state;
	}

	public String parseHTML(String html) {
		html = html.replaceAll("(<|&lt;)", "#<#").replaceAll("(>|&gt;)", "#>#").replaceAll("(\"|&quot;)", "#@@#")
				.replaceAll("('|&acute;)", "#@#").replaceAll("(\r|\n|\t)", "");
		return html.toString();
	}
	private FileItem createFileItem(File file, String fieldName) {
		FileItemFactory factory = new DiskFileItemFactory(16, null);
		FileItem item = factory.createItem(fieldName, "text/plain", true, file.getName());
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		try {
			FileInputStream fis = new FileInputStream(file);
			OutputStream os = item.getOutputStream();
			while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return item;
	}
}
