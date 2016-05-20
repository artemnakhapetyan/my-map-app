package acdc.my.map.app.utils.exception;

import java.sql.SQLException;

/**
 *
 * @author acdc
 */
public class ExceptionUtils {

    public static String getUserDbErrMsg(SQLException sqlExp) {
        String result = null;
        if (sqlExp.getErrorCode() > 20099 && sqlExp.getErrorCode() < 22000) {
            result = String.valueOf(sqlExp.getErrorCode());
            int fromIndex = sqlExp.getMessage().indexOf(result) + (result).length() + 1;
            result = sqlExp.getMessage().substring(
                    fromIndex,
                    sqlExp.getMessage().indexOf("ORA-", fromIndex));
        } else {
            result = sqlExp.toString();
        }
        return result;

    }
    
    public static String stackTraceToString(Exception exp) {

        StringBuilder sb = new StringBuilder();

        if (exp.getMessage() != null) {
            sb.append(exp.getMessage());
            sb.append("\n");
        }

        if (exp.toString() != null) {
            sb.append(exp.toString());
            sb.append("\n");
        }

        for (StackTraceElement element : exp.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String getExceptionUserText(Exception exp) {

        String errMsg;

        if (exp instanceof SQLException) {
            //errMsg = ((SQLException) exp).getMessage();
            errMsg = ExceptionUtils.getUserDbErrMsg(((SQLException) exp));
        } else {
            if (exp instanceof AppException) {
                errMsg = ((AppException) exp).getErrMsg();
            } else {
                if (exp instanceof AppSessionException) {
                    errMsg = "ავტორიზაციის შეცდომა";
                } else {
                    errMsg = exp.toString();
                }
            }
        }

        return errMsg;

    }

}
