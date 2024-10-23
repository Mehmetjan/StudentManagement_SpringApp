package net.studentInfo.studentManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fileName;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String fileName, int fileValue){
        super(String.format("% not found with %:'%'", resourceName, fileName,fileValue));
        this.resourceName=resourceName;
        this.fileName=fileName;
        this.fieldValue=fileValue;
    }
}
