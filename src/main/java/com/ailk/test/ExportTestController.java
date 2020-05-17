package com.ailk.test;

import com.ailk.entity.PageData;
import com.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ExportTestController implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("123");
        //设置模型数据
        /*request.setAttribute("12",12);
        request.getRequestDispatcher("").forward(request,response);

        //使用此方法可以设置response的响应模式，比如响应json数据
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json串");*/
        try {
            this.export(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取数据
        List<PageData> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            PageData pageData = new PageData();
            pageData.setId(i+1L);
            pageData.setCreateTime(new Date());
            pageData.setPassword("password");
            pageData.setPhone(i+"phone");
            pageData.setUsername(i+"name");
            list.add(pageData);
        }

        //设置Excel标题
        String[] title = {"用户名id","用户名称","用户密码","用户手机","创建时间"};
        //Excel文件名
        String fileName = "用户信息表"+System.currentTimeMillis()+".xls";
        //sheet名
        String sheetName = "用户信息表";

        String[][] content = new String[list.size()][5];
        for(int i =0;i<list.size();i++){
            content[i] = new String[title.length];
            PageData obj = list.get(i);
            content[i][0] = obj.getId().toString();
            content[i][1] = obj.getUsername();
            content[i][2] = obj.getPassword();
            content[i][3] = obj.getPhone();
            content[i][4] = obj.getCreateTime().toString();
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName,title,content,null);
        //响应到客户端
        try{
            this.setResponseHeader(response,fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response,String fileName){
        try{
            try{
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        }catch (Exception ex){
            ex.printStackTrace();;
        }
    }
}
