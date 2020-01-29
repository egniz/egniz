package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
	      String uploadPath = request.getServletContext().getRealPath("img");
	      File filePath = new File(uploadPath+File.separator+filename);
	      InputStream in = new FileInputStream(filePath);
	      
	      String sMimeType = getServletContext().getMimeType(uploadPath+File.separator+filename);
	      if(sMimeType == null) {
	         sMimeType = "application/octet-stream";//그냥 어떤 타입이든 다운로드하세요
	      }
	      response.setContentType(sMimeType);
	      String encoding = new String(filename.getBytes("euc-kr"), "8859_1");
	         response.setHeader("Content-Disposition", "attachment;filename="+encoding);
	         
	         ServletOutputStream out = response.getOutputStream();
	         byte[] arr = new byte[1024];
	         int length= -1;
	         while(true) {
	            length = in.read(arr, 0, arr.length);
	            if(length == -1) {
	               break;
	            }
	            out.write(arr, 0, length);
	         }
	         out.flush();
	         in.close();
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
