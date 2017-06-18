package com.citybus.web.servlet.front;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class Upload1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//����һ��ServletFileUpload����
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");//����ϴ��ļ�������
		//����request���󣬷������б���
		List<FileItem> fileItems = new ArrayList<FileItem>(0);
		//���ڷ�װ��ͨ���������
		Map<String, String[]> map = new HashMap<String, String[]>();
		String filename="";
		try {
			fileItems = sfu.parseRequest(request);
			
			//����fileItems����
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					//��ͨ����
					String name = fileItem.getFieldName();//�õ��ֶε���
					String value = fileItem.getString("UTF-8");//�õ��ֶ�ֵ
					map.put(name, new String[]{value});//��map�и�ֵ
					
				}else{
					//�ļ�����
					InputStream inputStream = fileItem.getInputStream();
					filename = fileItem.getName();//�õ��ϴ����ļ���
					//System.out.println("filename="+filename);
					String extension = FilenameUtils.getExtension(filename);
					if(!("jsp".equals(extension)||"exe".equals(extension))){//�ϴ����ļ�������jsp��exe
						//����Ŀ¼ 
						File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
						if(!storeDirectory.exists()){
							storeDirectory.mkdirs();//���Ŀ¼�����ڣ��ʹ���
							
						}
					//�����ļ���
					if(filename!=null){
						filename=System.currentTimeMillis()+"_" + (int)(Math.random()*10000)+
						 filename.substring(filename.lastIndexOf("."),filename.length());
					}
					//System.out.println(filename);
					// Ŀ¼��ɢ
					String childDirectory = makeChildDirectory(storeDirectory, filename); // a/b
					
					filename = childDirectory+"/"+filename;
					request.getSession().setAttribute("user_img", filename);
					//�ļ��ϴ� 
					fileItem.write(new File(storeDirectory,filename));
					//fileItem.delete();	//ɾ����ʱ�ļ�
					
					}
					
				}
			}
			System.out.println(filename);
			//�ַ�ת��
			response.getWriter().print(filename);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Ŀ¼��ɢ
		private String makeChildDirectory(File storeDirectory, String filename) {
			int hashcode = filename.hashCode();// �����ַ�ת����32λhashcode��
			//System.out.println(hashcode);
			String code = Integer.toHexString(hashcode); // ��hashcodeת��Ϊ16���Ƶ��ַ�
															// abdsaf2131safsd
			//System.out.println(code);
			String childDirectory = code.charAt(0) + "/"
					+ code.charAt(1); // a/b
			// ����ָ��Ŀ¼
			File file = new File(storeDirectory, childDirectory);
			if (!file.exists()) {
				file.mkdirs();
			}
			return childDirectory;
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
