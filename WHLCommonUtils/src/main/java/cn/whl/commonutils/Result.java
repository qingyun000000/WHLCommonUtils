package cn.whl.commonutils;

/**
 * 结果返回
 * @author wuhailong
 */
public class Result {
    
    private boolean success;
    
    private String message;
    
    //返回对象数据
    private Object data;

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
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
