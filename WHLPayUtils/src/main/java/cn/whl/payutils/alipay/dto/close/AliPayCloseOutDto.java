package cn.whl.payutils.alipay.dto.close;

import cn.whl.payutils.alipay.dto.AliPayOut;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.close.CloseOut;

/**
 * 阿里支付订单关闭返回参数封装
 * @author wuhailong
 */
public class AliPayCloseOutDto extends AliPayOut implements CloseOut{
    //通用部分 
    private String outTradeNo;   //商户网站唯一订单号                    
     
    private String tradeNo;      //支付宝系统交易流水号
    
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

}