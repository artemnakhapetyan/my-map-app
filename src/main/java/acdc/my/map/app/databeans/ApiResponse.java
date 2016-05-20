
package acdc.my.map.app.databeans;

import acdc.my.map.app.utils.exception.AppSessionException;
import acdc.my.map.app.utils.exception.ExceptionUtils;

public class ApiResponse {
    
     private boolean success;
    private boolean sessionValid;
    private String errorText;
    private Integer errorCode;
    private Object data;
    private long totalCnt;

    public ApiResponse(){
        this.success = true;
        this.sessionValid = true;
    }
    
    public ApiResponse(Exception exp){
        
        if(exp instanceof AppSessionException){
            this.success = true;
            this.sessionValid = false;
        }else{
            this.success = false;
            this.sessionValid = true;
        }
        this.errorText = ExceptionUtils.getExceptionUserText(exp);
        
    }
    
    public boolean isSessionValid() {
        return sessionValid;
    }

    public void setSessionValid(boolean sessionValid) {
        this.sessionValid = sessionValid;
    }
    
    public Object getData() {
        return data;
    }

    public ApiResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTotalCnt() {
        return totalCnt;
    }

    public ApiResponse setTotalCnt(long totalCnt) {
        this.totalCnt = totalCnt;
        return this;
    }
    
}
