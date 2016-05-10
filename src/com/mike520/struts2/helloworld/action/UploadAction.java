package com.mike520.struts2.helloworld.action;

/**
 * Created by liwenxiang on 2016/5/5.
 */

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

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
            if (file == null || fileFileName == null) {
                return INPUT;
            }
            String path = "/test/";
            String realPath = ServletActionContext.getServletContext().getRealPath(path);
            String fileName = realPath + fileFileName;
            destFileName = path + fileFileName;
            FileUtils.copyFile(file,new File(fileName));
            return SUCCESS;
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
