package cn.whl.commonutils;

/**
 * 结果返回
 * @author wuhailong
 */
public class Result {
    
    private boolean success;
    
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
