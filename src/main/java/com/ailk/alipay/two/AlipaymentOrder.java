package com.ailk.alipay.two;

public class AlipaymentOrder {
    private String clubOrderId;
    private String outTradeNo;
    private byte tradeStatus;
    private Double totalAmount;
    private Double receiptAmount;
    private Double invoiceAmount;
    private Double buyerPayAmount;
    private Double refundFee;
    private String notifyUrl;

    public String getClubOrderId() {
        return clubOrderId;
    }

    public void setClubOrderId(String clubOrderId) {
        this.clubOrderId = clubOrderId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Double receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(Double buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public Double getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Double refundFee) {
        this.refundFee = refundFee;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
