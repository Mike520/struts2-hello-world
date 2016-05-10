package com.mike520.struts2.helloworld.action;

/**
 * Created by liwenxiang on 2016/5/5.
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Namespace("")
public class MultiUploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<File> file;// input from jsp.
    private List<String> fileContentType;// input from FileUploadInterceptor
    private List<String> fileFileName;// input from FileUploadInterceptor
    private List<String> destFileName;// output for jsp

    @Action(value = "multiUpload", interceptorRefs = {
            @InterceptorRef(value = "fileUpload", params = {"maximumSize", "2048000", "allowedTypes", "image/x-ms-bmp,image/jpeg,image/gif,image/png,image/x-png,application/excel,application/vnd.ms-excel"}),
            @InterceptorRef(value = "defaultStack")
    }, results = {
            @Result(name = SUCCESS, location = "/fileUpload/multiDisplay.jsp"),
            @Result(name = INPUT, location = "/fileUpload/multiInput.jsp")
    })
    public String multiUpload() {
        try {
            if (file == null
                    || fileFileName == null
                    || fileFileName.size() <= 0
                    || file.size() <= 0) {
                return INPUT;
            }
            if (destFileName == null) {
                destFileName = new ArrayList();
            }
            String path = "/test/";
            String realPath = ServletActionContext.getServletContext().getRealPath(path);
            for (int i = 0; i < file.size(); i++) {
                String fileName = realPath + fileFileName.get(i);
                destFileName.add(path + fileFileName.get(i));
                FileUtils.copyFile(file.get(i),new File(fileName));
            }
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public List<String> getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(List<String> fileContentType) {
        this.fileContentType = fileContentType;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public List<String> getDestFileName() {
        return destFileName;
    }

    public void setDestFileName(List<String> destFileName) {
        this.destFileName = destFileName;
    }
}
