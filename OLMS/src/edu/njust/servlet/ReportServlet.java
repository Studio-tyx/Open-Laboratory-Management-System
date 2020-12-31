package edu.njust.servlet;

import edu.njust.entity.StudentExperiment;
import edu.njust.entity.User;
import edu.njust.service.ExperimentService;
import edu.njust.service.ReportService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author TYX
 * @name ReportServlet
 * @description
 * @time
 **/
public class ReportServlet extends HttpServlet {
    /**
     * doGet
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 老师获取报告
     * 将学生信息封装成StudentExperiment
     * 调用ReportService().getReport()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    /**
     * doPost
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * 学生上传报告
     * 将信息封装成StudentExperiment
     * 调用ReportService().addReport()
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ExperimentService experimentService=new ExperimentService();
        User user=new User();
        user= (User) request.getSession().getAttribute("user");
        String stuId=user.getUserId();
        String expName= (String) request.getSession().getAttribute("expName");
        String expTeacherName= (String) request.getSession().getAttribute("expTeacherName");
        String expTerm= (String) request.getSession().getAttribute("expTerm");
        StudentExperiment studentExperiment=new StudentExperiment();
        studentExperiment=experimentService.getStudentExperiment(stuId,expName,expTeacherName,expTerm);
        //1、判断表单是否支持文件上传。 即：  enctype = "multipart/form-data"
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if(!isMultipartContent) {
            throw new RuntimeException("该请求不能完成文件上传");
        }
        //2、创建一个 DiskFileItemfactory对象
        DiskFileItemFactory factory = new DiskFileItemFactory();  //factory
        //3、创建一个ServletFileUpload对象，该对象是上传的核心组件
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //设置编码
        sfu.setHeaderEncoding("UTF-8");
        //4、解析request对象，并得到 一个表单项的 集合
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            //5、遍历该集合，集合中的每一项 即为 每一个表单项
            for(FileItem item:fileItems) {
                if(item.isFormField()) {
                    //普通表单项，不是文件项
                    //等价于以前的  request.getParameter()
                    String fieldname = item.getFieldName(); //字段名
                    String fieldvalue = item.getString("UTF-8"); //字段值
                    System.out.println(fieldname+"="+fieldvalue);
                }else {
                    //上传表单项
                    //获取文件名
                    String fileName = item.getName();
                    //获取输入流

                    InputStream is = item.getInputStream();
                    //创建输出流
                    String path = this.getServletContext().getRealPath("/Report");
                    System.out.println(path);
                    String relativePath="Report "+fileName;
                    System.out.println(relativePath);
                    //获得文件在服务器上上传的路径
                    File file = new File(path,fileName);
                    FileOutputStream fos = new FileOutputStream(file);
                    //完成文件的复制
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    //从客户端读取数据并将其写到服务器端的硬盘上
                    while((len=is.read(bytes))!=-1) {
                        fos.write(bytes, 0, len);
                    }

                }
                if(!item.isFormField()){
                    //1.获取真实地址,这里保存在Tomcat运行的项目upload目录中,这要在src/main/webapp下新建upload文件夹
//                    ServletContext sctx = getServletContext();
//                    String path=sctx.getRealPath("/upload");
//                    String fileName = item.getName();
//                    System.out.println(fileName);
//                    File uploadedFile=new File(path+"\\"+fileName);
//                    item.write(uploadedFile);

                    //2.保存到指定盘符
//                    String fileName=item.getName();
//                    File uploadedFile=new File("d:/Projects/"+fileName);
//                    item.write(uploadedFile);
                }

            }

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
