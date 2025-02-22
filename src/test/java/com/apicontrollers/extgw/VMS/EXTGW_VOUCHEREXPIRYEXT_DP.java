package com.apicontrollers.extgw.VMS;

import java.util.HashMap;

import com.commons.MasterI;
import com.utils.RandomGeneration;
import com.utils._masterVO;

public class EXTGW_VOUCHEREXPIRYEXT_DP {

	public static String CUCategory = null;
	public static String TCPName = null;
	public static String Domain = null;
	public static String ProductCode = null;
	public static String LoginID = null;
	public static String LangCode = _masterVO.getMasterValue(MasterI.LANGUAGE);
	
	public static HashMap<String, String> getAPIdata() {
		
		/*
		 * Variable Declaration
		 */
		HashMap<String, String> apiData = new HashMap<String, String>();
		EXTGW_VOUCHEREXPIRYEXTENSION voucherExpiryExtAPI = new EXTGW_VOUCHEREXPIRYEXTENSION();
		
		/*
		 * Object Declaration
		 */
		RandomGeneration randomGeneration = new RandomGeneration();

		/*
		 * Variable initializations
		 */

		apiData.put(voucherExpiryExtAPI.EXTNWCODE,  _masterVO.getMasterValue(MasterI.NETWORK_CODE));
		apiData.put(voucherExpiryExtAPI.EXTREFNUM,  randomGeneration.randomNumeric(6));
		apiData.put(voucherExpiryExtAPI.EXPIRY_CHANGE_REASON,  "Automation Testing");
		apiData.put(voucherExpiryExtAPI.LOGINID,  "superadmin");
		apiData.put(voucherExpiryExtAPI.PASSWORD,  "1357");
		
		return apiData;
	}


}
