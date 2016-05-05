package com.mike520.struts2.helloworld.action;

/**
 * Created by liwenxiang on 2016/5/5.
 */

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.bind.annotation.RequestParam;

@Namespace("")
public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private File file;// input from jsp.
    private String fileContentType;// input from FileUploadInterceptor
    private String fileFileName;// input from FileUploadInterceptor
    private String destFileName;// output for jsp

    @Action(value = "upload", interceptorRefs = {
            @InterceptorRef(value = "fileUpload", params = {"maximumSize", "2048000", "allowedTypes", "image/x-ms-bmp,image/jpeg,image/gif,image/png,image/x-png,application/excel,application/vnd.ms-excel"}),
            @InterceptorRef(value = "defaultStack")
    }, results = {
            @Result(name = SUCCESS, location = "/fileUpload/display.jsp"),
            @Result(name = INPUT, location = "/fileUpload/input.jsp")
    })
    public String upload() {
        try {
            if (file != null) {
                String savePath = "/test";
                InputStream is = new FileInputStream(file);
                String realDestPath = ServletActionContext.getServletContext().getRealPath(savePath);
                destFileName = realDestPath + "//" + fileFileName;
                if(StringUtils.isEmpty(destFileName)) {
                    return ERROR;
                }
                File destDir = new File(realDestPath);
                if(!destDir.exists()) destDir.mkdirs();
                OutputStream os = new FileOutputStream(destFileName);

                IOUtils.copy(is, os);
                os.flush();
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);
                destFileName = savePath+"/"+getFileFileName();
                return SUCCESS;
            }
            return INPUT;
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getDestFileName() {
        return destFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }
}
