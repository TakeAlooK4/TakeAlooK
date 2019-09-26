package com.bit.tak.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageUploadUtils {

	public static String imageUpload(String uploadPath, String originalName, byte[] fileData) throws Exception{
		//public static String imageUpload(String uploadPath, String originalName, byte[] fileData, MultipartFile file) throws Exception{
		//System.out.println(""+file);
		//UUID발급
		UUID uuid = UUID.randomUUID();

		//저장한 파일명 
		String savedName = uuid.toString() + "_"+ originalName;

		//업로드할 디렉토리(날짜별로 폴더 생성)
		String savedPath = calcPath(uploadPath);

		System.out.println("afwlefiwenwnf:  "+savedPath+savedName);
		//파일 경로(기존의 업로드경로 + 날짜별 경로), 파일명을 받아 파일 객체 생성
		File target = new File(uploadPath + savedPath,savedName);
		/* File targ = new File(uploadPath + savedPath); */
		
		  System.out.println("savePath "+savedPath);
		  System.out.println("uploadPath "+uploadPath);
		 // System.out.println("targ.  "+target);
		//System.out.println("targ.getAbsolutePath()  "+targ.getAbsolutePath());
		 
		//file.transferTo(targ);

		//임시 디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(fileData, target);

		//썸네일을 생성하기 위한 파일의 확장자 검사
		//파일명이 aaa.bbb.xxx.jpg일경우 마지가 .을 찾기위해
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		//String uploadedFileName = uploadPath+savedPath+savedName;
		//이미지 파일은 썸네일 사용

		if(MediaUtils.getMediaType(formatName)!= null) { 
			//썸네일 생성
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName); 
			//나머지는 아이콘 
		}else {  
			uploadedFileName = makeIcon(uploadPath,savedPath,savedName); 
		}

		return uploadedFileName;
	}

	private static String calcPath(String uploadPath ) {
		Calendar cal = Calendar.getInstance();
		//File.separator:디렉토리 구분자(\\)
		//연도, ex) \\2017
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		System.out.println(yearPath);
		//월, ex) \\2017\\03
		String monthPath = yearPath+ File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		System.out.println(monthPath);

		//날짜
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println(datePath);

		//디렉토리 생성 메소드 호출
		makeDir(uploadPath,yearPath, monthPath, datePath);
		System.out.println("dddddssssdddd"+datePath);
		return datePath;
	}

	//디렉토리 생성
	private static void makeDir(String uploadPath, String...paths) {
		System.out.println("======>"+uploadPath);
		//디렉토리가 존재하면
		if( new File(paths[paths.length - 1]).exists()) {
			return;
		}
		//디렉토리가 존재하지 않으면
		for(String path: paths) {
			File dirPath = new File(uploadPath+path);
			// 디렉토리가 존재하지 않으면
			if(!dirPath.exists()) {
				//디렉토리 생성
				dirPath.mkdir();
			}
			System.out.println("사진경로 ImageUploadUtils:" + dirPath);
		}

	}

	//썸네일 생성

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{ 
		//이미지를 읽기 위한 버퍼 
		BufferedImage sourceImg =ImageIO.read(new File(uploadPath+path,fileName)); 
		//100픽셀 단위의 썸네일 생성
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100); 
		//썸네일의 이름을 생성(원본파일명에 's_'를 붙임)
		String thumbnailName = uploadPath + path + File.separator+ "s_" + fileName; 
		File newFile = new File(thumbnailName);
		String formatName =fileName.substring(fileName.lastIndexOf(".")+1); 
		//썸네일 생성
		ImageIO.write(destImg, formatName.toUpperCase(),newFile); //썸네일의 이름을 리턴함
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/'); 
	}

	//아이콘 생성

	private static String makeIcon(String uploadPath, String Path, String fileName) throws Exception { 
		//아이콘의 이름 
		String iconName = uploadPath + Path + File.separator + fileName; 
		//아이콘 이름을 리턴 
		//File.separatorChar:디렉토리 구분자
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '\\'); 
	}



}
