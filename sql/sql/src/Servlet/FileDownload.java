package Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// 获取项目部署绝对路径下的upload文件夹路径,我们下载upload目录下面的文件
		String root = request.getServletContext().getRealPath("/upload");
		// 获取文件名
		String filename = request.getParameter("filename");
		
		File file = new File(root + "/" + filename);
		
		// 根据文件路径创建输入流
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			byte[] b = new byte[fis.available()];
			fis.read(b);
			response.getOutputStream().write(b);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer  = null;
			try {
				writer = response.getWriter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			writer.write("<script>alert('文件不存在');window.location='"+request.getContextPath()+"/index.jsp';</script>");
		}
		// 设置响应头,弹出下载框
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
