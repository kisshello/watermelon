package com.ailk.upload;

import com.utils.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //判断enctype的属性
            boolean flag = ServletFileUpload.isMultipartContent(request);
            if(!flag){
                //enctype属性不是multipart/form-data
                request.setAttribute("msg","表单的格式不正确！");
                request.getRequestDispatcher("/newpages/upload/upload.jsp").forward(request,response);
                return;
            }
            //1、创建磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //1.1 设置缓冲区的大小
            diskFileItemFactory.setSizeThreshold(3*1024*1024);
            //1.2 设置临时文件的存放路径
            String tempPath = getServletContext().getRealPath("/temp");
            diskFileItemFactory.setRepository(new File(tempPath));
            //2、创建一个核心的解析类
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //设置文件上传的文件的大小
            //fileUpload.setSizeMax(5*1024*1024);
            //3、利用核心类来解析request，解析后会得到多个部分。会返回一个List集合。List集合装的是每个部分的内容（FileItem文件项）
            List<FileItem> list = fileUpload.parseRequest(request);
            //4、遍历List集合，会得到代表每个部分的文件项的对象。根据文件项判断是不是文件上传项。
            for(FileItem fileItem:list){
                //判断这个文件项是普通项还是文件上传项
                if(fileItem.isFormField()){
                    //普通项
                    String name = fileItem.getFieldName();//获得普通项的名称
                    //获得普通项的值
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name+"==="+value);
                }else {
                    //文件上传项
                    //获得文件上传项的名称
                    String filename = fileItem.getName();
                    int idx = filename.lastIndexOf("\\");
                    if(idx!= -1){
                        //使用的是老版本浏览器
                        filename.substring(idx+1);
                    }
                    System.out.println(filename);
                    //得到唯一文件名
                    String uuidFileName = UploadUtils.getUuidFileName(filename);
                    //获得文件上传的数据
                    InputStream is = fileItem.getInputStream();
                    //获得文件上传的路径
                    String realPath = getServletContext().getRealPath("/upload");
                    //创建一个输出流，写入到设置的路径中
                    OutputStream os = new FileOutputStream(realPath+"/"+uuidFileName);
                    //两个流对接
                    int len = 0;
                    byte [] b = new byte[1024];
                    while ((len=is.read(b))!= -1){
                        os.write(b,0,len);
                    }
                    is.close();
                    os.close();
                }
                //删除临时文件
                fileItem.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
