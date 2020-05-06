package com.ailk.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/5/5 13:29
 */
public class UploadTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1、创建磁盘文件项工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //1.1  设置缓冲区大小
            diskFileItemFactory.setSizeThreshold(2*1024*1024);//设置缓冲区的大小为3M
            //1.2  设置临时文件存放的路径
            String tempPath = getServletContext().getRealPath("/temp");
            diskFileItemFactory.setRepository(new File(tempPath));
            //2、创建核心的解析累
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //3、利用核心类解析request，解析后会得到多个部分。返回一个list集合，list集合装的是每个部分的内容(FileItem项)
            List<FileItem> list = fileUpload.parseRequest(req);
            //4、遍历list集合，会得到代表每个部分的文件项的对象，根据文件项判断是否是文件上传项
            for(FileItem fileItem:list){
                //判断这个文件是普通项还是文件上传项
                if(fileItem.isFormField()){
                    //普通项
                    // 接收普通项的值（接收值不能再使用request.getParameter()）
                    String name = fileItem.getFieldName();
                    //获得普通项的值
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name+"==="+value);
                }else{
                    //文件上传项
                    //获得文件上传项的名称
                    String name = fileItem.getName();
                    //获得文件上传的内容
                    InputStream is  = fileItem.getInputStream();
                    //获得文件上传的路径
                    String realPath = getServletContext().getRealPath("/upload");
                    //创建一个输出流，写入到设置的路径中
                    OutputStream os = new FileOutputStream(realPath+"/"+name);
                    //两个流对接
                    int len = 0;
                    byte[] b = new byte[1024];
                    while((len=is.read(b))!=-1){
                        os.write(b,0,len);
                    }
                    is.close();
                    os.close();

                }
            }
        }catch (FileUploadException e){
            e.printStackTrace();
        }
    }
}