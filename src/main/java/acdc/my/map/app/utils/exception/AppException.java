
package acdc.my.map.app.utils.exception;

/**
 *
 * @author developer
 */
public class AppException extends Exception{
    
    private String errMsg;
    
    public AppException(String errMsg){
        this.errMsg = errMsg;
    }
    
    public String getErrMsg(){
        return this.errMsg;
    }
    
    public String toString(){
        return this.errMsg;
    }
}
