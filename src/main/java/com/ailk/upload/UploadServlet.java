package com.ailk.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1、创建磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //2、创建一个核心的解析类
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
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
                    //获得文件上传的数据
                    InputStream is = fileItem.getInputStream();
                    //获得文件上传的路径
                    String realPath = getServletContext().getRealPath("/upload");
                    //创建一个输出流，写入到设置的路径中
                    OutputStream os = new FileOutputStream(realPath+"/"+filename);
                    //两个流对接
                    int len = 0;
                    byte [] b = new byte[1024];
                    while ((len=is.read(b))!= -1){
                        os.write(b,0,len);
                    }
                    is.close();
                    os.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
