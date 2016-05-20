package acdc.my.map.app.utils.exception;

/**
 *
 * @author Administrator
 */
public class AppSessionException extends Exception{
    
     private String errorText;

    public AppSessionException(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return this.errorText;
    }
    
}
