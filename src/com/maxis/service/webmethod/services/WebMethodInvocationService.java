package com.maxis.service.webmethod.services;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.axis2.client.Options;
import org.apache.axis2.AxisFault;

/*import javax.xml.rpc.ServiceException;*/

import org.apache.axis2.transport.http.HttpTransportProperties;

import com.maxis.constant.CallBackInternalException;
import com.maxis.constant.CommonUtil;
import com.maxis.constant.Constant;
import com.maxis.constant.MessageCode;
import com.maxis.db.CustInfo;
import com.maxis.log.DeliveredLogUtil;

import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.AccountRequired;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ChangeEbdPackageRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ChangeEbdPackageResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.CreateSOnAdvPaymntRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.CreateSOnAdvPaymntResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewInventoryInfo;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.OldInventoryInfo;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ReserveEbdInventoryRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ReserveEbdInventoryRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ReserveEbdInventoryResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ServiceRequired;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SwapEbdInventoryRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SwapEbdInventoryRequestDetails;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SwapEbdInventoryRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SwapEbdInventoryResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TransferEbdServiceRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TransferEbdServiceResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeAccountCreation;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeCustomer;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeNewLineRegistrationRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeReserveEbdInventoryRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeReserveEbdInventoryResponse;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeSwapEbdInventoryRequest;

public class WebMethodInvocationService {
	
	public NewLineRegistrationResponseE createAccount(CustInfo f,Map<String, String> globalMap, String wmOrderId) throws Exception{
		NewLineRegistrationResponseE lineResponse = null; 
		try {
			//counter i to be used for next attempt. TODO
			DeliveredLogUtil.info("----Inside createAccount---");
			MaxisEaiProcessEbdOrderWsOrderEbdServiceStub stub = new MaxisEaiProcessEbdOrderWsOrderEbdServiceStub();
			lineResponse = new NewLineRegistrationResponseE();
			NewLineRegistrationRequestE lineRequest = new NewLineRegistrationRequestE();
			my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeaderE header = new my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeaderE();

			NewLineRegistrationRequest registrationRequest  = new NewLineRegistrationRequest();
			my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeader eaiHeader = new my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeader();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
			String timeReq=dateFormat.format(new Date());
			eaiHeader.setFrom("EBDONLINE");
			eaiHeader.setTo("ESB");
			eaiHeader.setAppId("OPF");
			eaiHeader.setMsgId(timeReq);
			eaiHeader.setMsgType("Request");
			eaiHeader.setTimestamp(timeReq);
			header.setEaiHeader(eaiHeader);
			
			TypeNewLineRegistrationRequest newLineRegistrationRequestDetails = prepareRequestDataBeforeCall(f,globalMap,wmOrderId);
			registrationRequest.setNewLineRegistrationRequestDetails(newLineRegistrationRequestDetails);

			
			lineRequest.setNewLineRegistrationRequest(registrationRequest);
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			String username = MessageCode.get(Constant.WEBMETHOD_USERNAME);
			String password = MessageCode.get(Constant.WEBMETHOD_PASSWORD);
			auth.setUsername(username);
			auth.setPassword(password);
			DeliveredLogUtil.info("----Calling stub for createAccount---");
			final Options clientOptions = stub._getServiceClient().getOptions();
			clientOptions.setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE,auth);
			stub._getServiceClient().setOptions(clientOptions);
			
			lineResponse = stub.newLineRegistration(lineRequest, header);
		}catch (AxisFault e1) {
			// TODO Auto-generated catch block
			DeliveredLogUtil.info("AxisException while placing account creation call to WM "+e1.getMessage());
			e1.printStackTrace();
			throw e1;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			DeliveredLogUtil.info("RemoteException while placing account creation call to WM "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return lineResponse;
	}
	
	private TypeNewLineRegistrationRequest prepareRequestDataBeforeCall(CustInfo f,Map<String, String> globalMap,String wmOrderId) {
		
		TypeNewLineRegistrationRequest request = new TypeNewLineRegistrationRequest();
		
		request.setOrderId(wmOrderId); 
		request.setOrderType("1"); 
		TypeCustomer typeCustomer = new TypeCustomer();
		typeCustomer.setIcType(globalMap.get("EAS_IcType")); 
		typeCustomer.setIcNo(f.getCustBrnNo());  //brn no
		typeCustomer.setBillLname(f.getDelContactName()); 
		typeCustomer.setBillCompany(f.getCompanyName()); 
		typeCustomer.setBillAddress1(f.getBillAddr1());
		typeCustomer.setBillAddress2(f.getBillAddr2());
		typeCustomer.setBillAddress3(f.getBillAddr3());
		typeCustomer.setBillState(f.getBillState());
		typeCustomer.setBillCity(f.getBillAddr3());
		typeCustomer.setBillZip(f.getBillPostcode());
		typeCustomer.setBillCountryCode(globalMap.get("EAS_BillCountryCode"));

		request.setCustomer(typeCustomer);
		
		AccountRequired accountRequired = new AccountRequired();
			accountRequired.setAccountRequired("Y");
		request.setAccountRequired(accountRequired);
		ServiceRequired serviceRequired = new ServiceRequired();
			serviceRequired.setServiceRequired("N");
		request.setServiceRequired(serviceRequired);
		
		TypeAccountCreation typeAccountCreation = new TypeAccountCreation();
		typeAccountCreation.setAccountStatus("-1");
		typeAccountCreation.setMktCode(f.getMarketCodeId());
		typeAccountCreation.setAcctCategory(globalMap.get("EAS_AcctCategory"));
		typeAccountCreation.setBillFmtOpt(globalMap.get("EAS_BillFmtOpt"));
			if(f.getBillInd() !=null && f.getBillInd()==1)
				typeAccountCreation.setAccountType("1");
			else
				typeAccountCreation.setAccountType("0");
		    /*typeAccountCreation.setAccountType("1");*/
			typeAccountCreation.setAccountSegId(globalMap.get("EAS_AccountSegId"));
			typeAccountCreation.setBillFranchiseTaxCode(globalMap.get("EAS_BillFranchiseTaxCode"));
			typeAccountCreation.setBillingFrequency(globalMap.get("EAS_BillingFrequency"));
			typeAccountCreation.setMsgGrpId(globalMap.get("EAS_MsgGrpId"));
			typeAccountCreation.setNoBill(globalMap.get("EAS_NoBill"));
			typeAccountCreation.setOwningCostCtr(globalMap.get("EAS_OwningCostCtr"));
			typeAccountCreation.setPayMethod(globalMap.get("EAS_PayMethod"));
			typeAccountCreation.setRateClassDefault(globalMap.get("EAS_RateClassDefault"));
			typeAccountCreation.setRevRcvCostCtr(globalMap.get("EAS_RevRcvCostCtr"));
			typeAccountCreation.setParentId(f.getParentId().substring(0, f.getParentId().length()-1));
			typeAccountCreation.setHierarchyId(f.getHireId().substring(0,f.getHireId().length()-1));
			typeAccountCreation.setBillDispMeth(globalMap.get("EAS_BillDispMeth"));
			typeAccountCreation.setChargeThreshold(globalMap.get("EAS_ChargeThreshold"));
			typeAccountCreation.setCurrencyCode(globalMap.get("EAS_CurrencyCode"));
			typeAccountCreation.setExrateClass(globalMap.get("EAS_ExrateClass"));
			typeAccountCreation.setVipCode(f.getCollectCode());
			typeAccountCreation.setRegulatoryId(globalMap.get("EAS_RegulatoryId"));
			typeAccountCreation.setCustFranchiseTaxCode(globalMap.get("EAS_CustFranchiseTaxCode"));
			typeAccountCreation.setLanguageCode(globalMap.get("EAS_LanguageCode"));
			//typeAccountCreation.setContact1Name(f.getEasCustInfo().getPicName());
			//typeAccountCreation.setContact1Phone(f.getEasCustInfo().getPicPhoneNo());
			if(f.getDelContactPhoneNo()!=null && f.getDelContactPhoneNo().length()>0){
			typeAccountCreation.setCustPhone1(f.getDelContactPhoneNo());}
		request.setAccount(typeAccountCreation);
		request.setChgWho(f.getDealerCode());
		request.setDealerCode(f.getDealerCode());
		if(CommonUtil.isNotEmptyAndNotNull(f.getAcctManagerDealerCode())) {
			//request.setDealerCode(f.getAcctManagerDealerCode());
			request.setInpF01(f.getAcctManagerDealerCode()); 
		}/* else {
			request.setDealerCode(f.getDealerCode());
		}*/
		return request;
	}
	public NewLineRegistrationResponseE callNewLineRegistrationForBulk(NewLineRegistrationRequestE registrationRequestE,CommonUtil commonUtil) throws CallBackInternalException{
	    MaxisEaiProcessEbdOrderWsOrderEbdServiceStub stub;
		NewLineRegistrationResponseE registrationResponseE = null;
		try {
			stub = new MaxisEaiProcessEbdOrderWsOrderEbdServiceStub();			
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		//TODO check username & password
		auth.setUsername(MessageCode.get(Constant.WEBMETHOD_USERNAME));
		auth.setPassword(MessageCode.get(Constant.WEBMETHOD_PASSWORD));
		options.setProperty(Constant.AUTHENTICATE, auth);
		stub._getServiceClient().setOptions(options);
		registrationResponseE = stub.newLineRegistration(registrationRequestE, commonUtil.getEaiHeaderForIOT());
		
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CallBackInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return registrationResponseE;
	}


}
