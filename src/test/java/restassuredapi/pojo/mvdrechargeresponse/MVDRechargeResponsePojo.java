package restassuredapi.pojo.mvdrechargeresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MVDRechargeResponsePojo {

    @JsonProperty("statusCode")
	private int statusCode;
    @JsonProperty("status")
	private String status;
    @JsonProperty("dataObject")
	private DataObject dataObject;
    
    
    
   
   
    
    @JsonProperty("statusCode")
    public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	

	@JsonProperty("dataObject")
	public DataObject getDataObject() {
		return dataObject;
	}

	public void setDataObject(DataObject dataObject) {
		this.dataObject = dataObject;
	}

	public static class DataObject
    {
		 @JsonProperty("fileName")
		 @JsonIgnoreProperties
			private String fileName;
		 
		 @JsonProperty("data")
		 @JsonIgnoreProperties
			private String data;
		
		 @JsonProperty("data")
		 @JsonIgnoreProperties
		public String getData() {
			return data;
		}
		 
		 @JsonProperty("data")
		 @JsonIgnoreProperties
		public void setData(String data) {
			this.data = data;
		}
		@JsonProperty("fileName")
		@JsonIgnoreProperties
		public String getFileName() {
			return fileName;
		}
		@JsonProperty("fileName")
		@JsonIgnoreProperties
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		@JsonProperty("txnIdFile")
		@JsonIgnoreProperties
	   	private String txnIdFile;
		
		@JsonProperty("txnIdFile")
		@JsonIgnoreProperties
		public String getTxnIdFile() {
			return txnIdFile;
		}
		@JsonProperty("txnIdFile")
		@JsonIgnoreProperties
		public void setTxnIdFile(String txnIdFile) {
			this.txnIdFile = txnIdFile;
		}
    	@JsonProperty("txnids")
    	@JsonIgnoreProperties
    	private TxnIdObject[] txnids;

 		@JsonProperty("date")
    	@JsonIgnoreProperties
    	private String date;
		
		@JsonProperty("txnstatus")
    	@JsonIgnoreProperties
    	private String txnstatus;
		
		
		@JsonProperty("message")
    	@JsonIgnoreProperties
    	private String message;
		
		@JsonProperty("errorcode")
    	@JsonIgnoreProperties
    	private String errorcode;
		
	   	@JsonProperty("type")
    	@JsonIgnoreProperties
    	private String type;
		
	   	@JsonProperty("type")
    	@JsonIgnoreProperties
		public String getType() {
			return type;
		}
	   	@JsonProperty("type")
    	@JsonIgnoreProperties
		public void setType(String type) {
			this.type = type;
		}
		
		@JsonProperty("txnids")
    	@JsonIgnoreProperties
		public TxnIdObject[] getTxnids() {
			return txnids;
		}
		@JsonProperty("txnids")
    	@JsonIgnoreProperties
		public void setTxnids(TxnIdObject[] txnids) {
			this.txnids = txnids;
		}

		@JsonProperty("date")
		@JsonIgnoreProperties
		public String getDate() {
			return date;
		}
		@JsonProperty("date")
		@JsonIgnoreProperties
		public void setDate(String date) {
			this.date = date;
		}
		@JsonProperty("txnstatus")
		@JsonIgnoreProperties
		public String getTxnstatus() {
			return txnstatus;
		}
		@JsonProperty("txnstatus")
		@JsonIgnoreProperties
		public void setTxnstatus(String txnstatus) {
			this.txnstatus = txnstatus;
		}
		
		@JsonProperty("message")
		@JsonIgnoreProperties
		public String getMessage() {
			return message;
		}
		@JsonProperty("message")
		@JsonIgnoreProperties
		public void setMessage(String message) {
			this.message = message;
		}

		@JsonProperty("errorcode")
    	@JsonIgnoreProperties
		public String getErrorcode() {
			return errorcode;
		}
		@JsonProperty("errorcode")
    	@JsonIgnoreProperties
		public void setErrorcode(String errorcode) {
			this.errorcode = errorcode;
		}
		@JsonProperty("TXNSTATUS")
    	@JsonIgnoreProperties
    	private String TXNSTATUS;
		
		@JsonProperty("TXNSTATUS")
    	@JsonIgnoreProperties
		public String getTXNSTATUS() {
			return TXNSTATUS;
		}
		@JsonProperty("TXNSTATUS")
    	@JsonIgnoreProperties
		public void setTXNSTATUS(String tXNSTATUS) {
			TXNSTATUS = tXNSTATUS;
		}
		@JsonProperty("DATE")
    	@JsonIgnoreProperties
		public String getDATE() {
			return DATE;
		}
		@JsonProperty("DATE")
    	@JsonIgnoreProperties
		public void setDATE(String dATE) {
			DATE = dATE;
		}
		@JsonProperty("MESSAGE")
    	@JsonIgnoreProperties
		public String getMESSAGE() {
			return MESSAGE;
		}
		@JsonProperty("MESSAGE")
    	@JsonIgnoreProperties
		public void setMESSAGE(String mESSAGE) {
			MESSAGE = mESSAGE;
		}
		@JsonProperty("DATE")
    	@JsonIgnoreProperties
    	private String DATE;
		@JsonProperty("MESSAGE")
    	@JsonIgnoreProperties
    	private String MESSAGE;	
		@JsonProperty("receivertrfvalue")
		@JsonIgnoreProperties
		private String receivertrfvalue;
		@JsonProperty("receivertrfvalue")
		@JsonIgnoreProperties
		public String getReceivertrfvalue() {
			return receivertrfvalue;
		}
		@JsonProperty("receivertrfvalue")
		@JsonIgnoreProperties
		public void setReceivertrfvalue(String receivertrfvalue) {
			this.receivertrfvalue = receivertrfvalue;
		}
		@JsonProperty("receiveraccessval")
		@JsonIgnoreProperties
		public String getReceiveraccessval() {
			return receiveraccessval;
		}
		@JsonProperty("receiveraccessval")
		@JsonIgnoreProperties
		public void setReceiveraccessval(String receiveraccessval) {
			this.receiveraccessval = receiveraccessval;
		}
		@JsonProperty("receiveraccessval")
		@JsonIgnoreProperties
		private String receiveraccessval;
    
    }

	public static class TxnIdObject{
		@JsonProperty("txnid")
    	@JsonIgnoreProperties
    	private String txnid;
		
		@JsonProperty("txnid")
    	@JsonIgnoreProperties
		public String getTxnid() {
			return txnid;
		}
		@JsonProperty("txnid")
    	@JsonIgnoreProperties
		public void setTxnid(String txnid) {
			this.txnid = txnid;
		}
		public TxnIdObject(String txnid) {
			 this.txnid=txnid;
		}
		public TxnIdObject() {
			 
		}
	}
	
    
}
