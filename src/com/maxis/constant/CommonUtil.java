package com.maxis.constant;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.maxis.config.BrightstarSqlConfig;
import com.maxis.config.ThreeGplSqlConfig;
import com.maxis.db.AcctMgrRef;
import com.maxis.db.AuditTrail;
import com.maxis.db.CustInfo;
import com.maxis.db.CustomerInfo;
import com.maxis.db.Dealer;
import com.maxis.db.EasRefDevice;
import com.maxis.db.GlobalConfig;
import com.maxis.db.IccidMsisdnImeiMap;
import com.maxis.db.PhoneOrder;
import com.maxis.db.PortalRefChargeType;
import com.maxis.db.PortalRefIddCountry;
import com.maxis.db.PortalRefRatePlan;
import com.maxis.db.PortalRefRatePlanMap;
import com.maxis.db.PortalRefVasChargeDetails;
import com.maxis.db.PortalRegistrationMaster;
import com.maxis.db.PortalRegistrationStatus;
import com.maxis.db.PortalTransWMAction;
import com.maxis.db.Task;
import com.maxis.db.TaskMaster;
import com.maxis.db.TransMsisdn;
import com.maxis.db.TransPhoneOrderReg;
import com.maxis.db.TransServiceAttribute;
import com.maxis.db.TransServiceAttributeMap;
import com.maxis.db.TransVas;
import com.maxis.db.VasRef;
import com.maxis.log.DeliveredLogUtil;
import com.maxis.order.UpdateDeliveryConfirmation;
import com.maxis.service.webmethod.services.WebMethodInvocationService;

import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.AccountRequired;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ComponentListConnect;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeader;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.EaiHeaderE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ExternalIdList;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationRequestE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationResponseE;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ServiceRequired;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeCustomer;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeIddConnect;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeInArrDoc;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeNewLineRegistrationRequest;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypePackageCreation;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeServiceCreation;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeSpecialComponentListConnect;
import my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TypeSpecialPackageListConnect;

public class CommonUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	protected static Log log = LogFactory.getLog(CommonUtil.class);
	private static SqlMapClient brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();
	private static SqlMapClient portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

	public static String getDateTime() {
		return sdf.format(new Date());
	}

	public static String getObjectParam(Object obj) throws Exception {
		String str = "";
		try {
			if ((obj instanceof Integer)) {
				if (obj != null) {
					str = obj.toString();
				} else {
					str = "";
				}
			} else if ((obj instanceof String)) {
				if (obj != null) {
					str = obj.toString();
				} else {
					str = "";
				}
			} else {
				str = "";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return str;
	}

	public static String getColorCode(String obj) throws Exception {
		String str = "";
		String blackColorCode = "3";
		String whiteColorCode = "2";
		try {
			System.out.println("============= getColorCode ============ ");
			if (obj != null) {
				if (obj.equals("10")) {
					str = blackColorCode;
				} else if (obj.equals("11")) {
					str = whiteColorCode;
				} else if (obj.equals("12")) {
					str = blackColorCode;
				} else if (obj.equals("13")) {
					str = whiteColorCode;
				} else if (obj.equals("14")) {
					str = blackColorCode;
				} else if (obj.equals("15")) {
					str = whiteColorCode;
				} else {
					str = "";
				}
			} else {
				str = "";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return str;
	}

	public static String getOrderPrefixStr(String regId_, String marketType_, String topupAmount) throws Exception {
		String str = "";
		String regex = "[0-9]+";
		Integer orderId = null;
		if (regId_.matches(regex)) {
			orderId = Integer.valueOf(regId_);
		}

		String prefixStrCorpTA = "RRTE";
		String prefixStrCorpNTA = "RRFE";
		String prefixStrCorpNTA_NEW = "RRFEI";

		String prefixStrSmeTA = "RRTS";
		String prefixStrSmeNTA = "RRFS";
		String prefixStrSmeNTA_NEW = "RRFSI";
		String mdriveIOTSME = "MDRS";
		String mdriveIOTCorp = "MDRE";

		String strTT = "|TT|MW|";
		String strFF = "|FF|MW|";

		int totup = 0;
		if ((topupAmount.length() > 0) && (topupAmount != null)) {
			totup = new Integer(topupAmount).intValue();
		}
		try {

			Integer prodGrpId = null;

			PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
			try {
				if (orderId != null) {
					Integer regId = CommonUtil.getRegId(orderId);
					portalRegistrationMaster.setRegId(regId);
					portalRegistrationMaster = (PortalRegistrationMaster) brightStarMapClient
					    .queryForObject(Constant.select_prodRegGrpMapId, portalRegistrationMaster);
					prodGrpId = portalRegistrationMaster.getProdGrpId();
				}
			} catch (Exception e) {
				LogUtil.info("====== Exception Occured ========== " + e.getMessage());
			}

			if (prodGrpId == null || prodGrpId != 12) {
				if (marketType_ != null) {
					if ((marketType_.equals("Corporate Individual")) && (totup != 0)) {
						str = prefixStrCorpNTA_NEW + regId_;
						log.info(
						    "====== (marketType_.equals(Corporate Individual) || marketType_.equals(Corporate)) && (totup != 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrCorpNTA_NEW =======" + prefixStrCorpNTA_NEW);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("Corporate Individual")) && (totup == 0)) {
						str = prefixStrCorpNTA_NEW + regId_;
						log.info("====== (marketType_.equals(Corporate Individual) && (totup == 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrCorpNTA_NEW =======" + prefixStrCorpNTA_NEW);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("SME Individual")) && (totup != 0)) {
						str = prefixStrSmeNTA_NEW + regId_;
						log.info("====== (marketType_.equals(SME Individual)) && (totup != 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeNTA_NEW =======" + prefixStrSmeNTA_NEW);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("SME Individual")) && (totup == 0)) {
						str = prefixStrSmeNTA_NEW + regId_;
						log.info("======  marketType_.equals(SME Individual)) && (totup == 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeNTA_NEW =======" + prefixStrSmeNTA_NEW);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("Company/SME")) && (totup != 0)) {
						str = prefixStrSmeNTA + regId_;
						log.info("====== (marketType_.equals(Company/SME)) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeTA =======" + prefixStrSmeNTA);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("Company/SME")) && (totup == 0)) {
						str = prefixStrSmeNTA + regId_;
						log.info("====== (marketType_.equals(Company/SME)) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeNTA =======" + prefixStrSmeNTA);
						log.info("====== str =======" + str);
					} else if (marketType_.equals("Corporate")) {
						str = prefixStrCorpNTA + regId_;
						log.info("====== marketType_.equals(Corporate) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrCorpNTA =======" + prefixStrCorpNTA);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("Government Individual (Dealer)")) && (totup != 0)) {
						str = prefixStrCorpNTA_NEW + regId_;
						log.info("====== (marketType_.equals(Government Individual (Dealer))) && (totup != 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeTA =======" + prefixStrCorpNTA_NEW);
						log.info("====== str =======" + str);
					} else if ((marketType_.equals("Government Individual (Dealer)")) && (totup == 0)) {
						str = prefixStrCorpNTA_NEW + regId_;
						log.info("======  marketType_.equals(Government Individual (Dealer))) && (totup == 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrSmeNTA =======" + prefixStrCorpNTA_NEW);
						log.info("====== str =======" + str);
					}
					// Added later
					else if ((marketType_.equalsIgnoreCase("Public Sector Corporate"))) {
						str = prefixStrCorpNTA + regId_;
						log.info("====== (marketType_.equalsIgnoreCase(Public Sector Corporate)");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrCorpNTA =======" + prefixStrCorpNTA);
						log.info("====== str =======" + str);
					} else if ((marketType_.equalsIgnoreCase("Public Sector Individual"))) {
						str = prefixStrCorpNTA_NEW + regId_;
						log.info("====== (marketType_.equalsIgnoreCase(Public Sector Individual)");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== prefixStrCorpNTA_NEW =======" + prefixStrCorpNTA_NEW);
						log.info("====== str =======" + str);
					} else {
						str = "";
					}
				} else {
					str = "";
				}
			}

			else {
				if (prodGrpId != null && prodGrpId == 12) {
					if ((marketType_.equals("Corporate")) && (totup == 0)) {
						str = mdriveIOTCorp + regId_;
						log.info("====== (marketType_.equals(Corporate Individual) && (totup == 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== mdriveIOTCorp =======" + mdriveIOTCorp);
						log.info("====== str =======" + str);
					}
					if ((marketType_.equals("Company/SME")) && (totup == 0)) {
						str = mdriveIOTSME + regId_;
						log.info("====== (marketType_.equals(Corporate Individual) && (totup == 0) =======");
						log.info("====== marketType_ =======" + marketType_);
						log.info("====== mdriveIOTSME =======" + mdriveIOTSME);
						log.info("====== str =======" + str);
					}
					/*
					 * if((marketType_.equals("Public Sector Corporate")) && (totup == 0)){ str =
					 * mdriveIOTCorp + regId_;
					 * log.info("====== (marketType_.equals(Corporate) && (totup == 0) =======");
					 * log.info("====== marketType_ =======" + marketType_);
					 * log.info("====== prefixStrCorpNTA =======" + mdriveIOTCorp);
					 * log.info("====== str =======" + str); }
					 */
				}
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		// str= prefixStrCorpTA + regId_;
		return str;
	}

	public static String getOrderPrefixStrProd(String regId_, String marketType_, String topupAmount) throws Exception {
		String str = "";

		String prefixStrCorpTA = "RRTE";
		String prefixStrCorpNTA = "RRFE";

		String prefixStrSmeTA = "RRTS";
		String prefixStrSmeNTA = "RRFS";

		int totup = 0;
		if ((topupAmount.length() > 0) && (topupAmount != null)) {
			totup = new Integer(topupAmount).intValue();
		}
		try {
			if (marketType_ != null) {
				if (((marketType_.equals("Corporate Individual")) || (marketType_.equals("Corporate"))) && (totup != 0)) {
					str = prefixStrCorpTA + regId_;
					log.info(
					    "====== (marketType_.equals(Corporate Individual) || marketType_.equals(Corporate)) && (totup != 0) =======");
					log.info("====== marketType_ =======" + marketType_);
					log.info("====== prefixStrCorpTA =======" + prefixStrCorpTA);
					log.info("====== str =======" + str);
				} else if (((marketType_.equals("Corporate Individual")) || (marketType_.equals("Corporate")))
				    && (totup == 0)) {
					str = prefixStrCorpNTA + regId_;
					log.info(
					    "====== (marketType_.equals(Corporate Individual) || marketType_.equals(Corporate)) && (totup == 0) =======");
					log.info("====== marketType_ =======" + marketType_);
					log.info("====== prefixStrCorpNTA =======" + prefixStrCorpNTA);
					log.info("====== str =======" + str);
				} else if (((marketType_.equals("Company/SME")) || (marketType_.equals("SME Individual"))) && (totup != 0)) {
					str = prefixStrSmeTA + regId_;
					log.info(
					    "====== (marketType_.equals(Company/SME) || marketType_.equals(SME Individual)) && (totup != 0) =======");
					log.info("====== marketType_ =======" + marketType_);
					log.info("====== prefixStrSmeTA =======" + prefixStrSmeTA);
					log.info("====== str =======" + str);
				} else if (((marketType_.equals("Company/SME")) || (marketType_.equals("SME Individual"))) && (totup == 0)) {
					str = prefixStrSmeNTA + regId_;
					log.info(
					    "====== (marketType_.equals(Company/SME) || marketType_.equals(SME Individual)) && (totup == 0) =======");
					log.info("====== marketType_ =======" + marketType_);
					log.info("====== prefixStrSmeNTA =======" + prefixStrSmeNTA);
					log.info("====== str =======" + str);
				} else if (totup == 0) {
					str = prefixStrSmeNTA + regId_;
					log.info("====== unknown (totup == 0) =======");
					log.info("====== unknown marketType_ =======" + marketType_);
					log.info("====== unknown prefixStrSmeNTA =======" + prefixStrSmeNTA);
					log.info("====== unknown str =======" + str);
				} else if (totup != 0) {
					str = prefixStrSmeTA + regId_;
					log.info("====== unknown (totup != 0) =======");
					log.info("====== unknown marketType_ =======" + marketType_);
					log.info("====== unknown prefixStrSmeNTA =======" + prefixStrSmeNTA);
					log.info("====== unknown str =======" + str);
				} else {
					str = "";
				}
			} else {
				str = "";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return str;
	}

	public static String getOfferName(String promoId) throws Exception {
		String str = "";
		String strPromo1 = "VP - Upgrade n' Save";
		String strPromo2 = "CB - Upgrade n' Save";
		try {
			if (promoId != null) {
				if (promoId.equals("28")) {
					str = strPromo1;
				} else if (promoId.equals("29")) {
					str = strPromo2;
				} else {
					str = "1";
				}
			} else {
				str = "";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return str;
	}

	public static String getState(String state) throws Exception {
		String str = "";
		if (state.equalsIgnoreCase("PERLIS")) {
			str = "PL";
		} else if (state.equalsIgnoreCase("KEDAH")) {
			str = "KD";
		} else if (state.equalsIgnoreCase("PULAU PINANG")) {
			str = "PG";
		} else if (state.equalsIgnoreCase("PERAK")) {
			str = "PK";
		} else if (state.equalsIgnoreCase("SELANGOR")) {
			str = "SL";
		} else if (state.equalsIgnoreCase("WILAYAH PERSEKUTUAN")) {
			str = "KL";
		} else if (state.equalsIgnoreCase("KUALA LUMPUR")) {
			str = "KL";
		} else if (state.equalsIgnoreCase("NEGERI SEMBILAN")) {
			str = "NS";
		} else if (state.equalsIgnoreCase("MELAKA")) {
			str = "ME";
		} else if (state.equalsIgnoreCase("JOHOR")) {
			str = "JH";
		} else if (state.equalsIgnoreCase("KELANTAN")) {
			str = "KN";
		} else if (state.equalsIgnoreCase("TERENGGANU")) {
			str = "TG";
		} else if (state.equalsIgnoreCase("PAHANG")) {
			str = "PH";
		} else if (state.equalsIgnoreCase("SABAH")) {
			str = "SA";
		} else if (state.equalsIgnoreCase("SARAWAK")) {
			str = "SK";
		} else if (state.equalsIgnoreCase("WP LABUAN")) {
			str = "LB";
		} else {
			str = "";
		}
		return str;
	}

	public static String getBizUnitID(String marketType_) throws Exception {
		String bizUnitID = "";
		try {
			if (marketType_ != null) {
				if ((marketType_.equalsIgnoreCase("Corporate Individual")) || (marketType_.equalsIgnoreCase("Corporate")
				    || (marketType_.equalsIgnoreCase("Public Sector Corporate")))) {
					bizUnitID = "4";
				} else if ((marketType_.equalsIgnoreCase("Company/SME")) || (marketType_.equalsIgnoreCase("SME Individual"))) {
					bizUnitID = "2";
				} else {
					bizUnitID = "0";
				}
			} else {
				bizUnitID = "0";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return bizUnitID;
	}

	public static Map<String, String> getGlobalConfig() throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		try {

			List<GlobalConfig> list = (List<GlobalConfig>) brightStarMapClient.queryForList(Constant.select_GlobalConfig);
			if (list != null && list.size() > 0) {
				for (GlobalConfig globalConfig : list) {
					map.put(globalConfig.getStrParameterName(), globalConfig.getStrParameterValue());
				}
			}
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());

		}
		return map;
	}

	public static CustInfo getCustomerInformation(Integer orderNo) {
		CustInfo info = new CustInfo();
		try {
			CustomerInfo custInfo = new CustomerInfo();
			PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
			Integer regId = getRegId(orderNo);
			portalRegistrationMaster.setRegId(regId);
			portalRegistrationMaster = (PortalRegistrationMaster) brightStarMapClient
			    .queryForObject(Constant.select_prodRegGrpMapId, portalRegistrationMaster);
			custInfo.setCustId(portalRegistrationMaster.getCustId());
			if (portalRegistrationMaster.getBillInd() != null) {
				info.setBillInd(Integer.parseInt(portalRegistrationMaster.getBillInd()));
			}

			custInfo = (CustomerInfo) brightStarMapClient.queryForObject(Constant.select_CustInfo, custInfo);
			portalRegistrationMaster = (PortalRegistrationMaster) brightStarMapClient
			    .queryForObject(Constant.select_CustInfo1, portalRegistrationMaster);
			String regex = "[0-9]+";
			if (portalRegistrationMaster.getAccMgrCode() != null && portalRegistrationMaster.getAccMgrCode().length() > 0) {
				if (portalRegistrationMaster.getAccMgrCode().matches(regex)) {
					CustomerInfo custInfoAccMgrCode = new CustomerInfo();
					custInfoAccMgrCode = (CustomerInfo) brightStarMapClient.queryForObject(Constant.select_CustInfo1Acc,
					    portalRegistrationMaster);

					info.setAcctManagerDealerCode(custInfoAccMgrCode.getAcctManagerDealerCode());
				} else {
					info.setAcctManagerDealerCode(portalRegistrationMaster.getAccMgrCode());
				}
			}
			info.setCustBrnNo(portalRegistrationMaster.getCustBrnNo());
			info.setMarketCodeId(portalRegistrationMaster.getMarketCode());
			info.setCompanyName(custInfo.getCompanyName());
			info.setBillAddr1(custInfo.getBillAddr1());
			info.setBillAddr2(custInfo.getBillAddr2());
			info.setBillAddr3(custInfo.getBillAddr3());
			info.setBillPostcode(custInfo.getBillPostcode());
			info.setBillState(custInfo.getBillState());
			info.setDelContactName(portalRegistrationMaster.getAccountNo());
			info.setPicName(custInfo.getPicName());
			info.setPicPhoneNo(custInfo.getPicPhoneNo());
			info.setRegId(portalRegistrationMaster.getRegId());
			if (custInfo.getDelContactPhoneNo() != null) {
				info.setDelContactPhoneNo(custInfo.getDelContactPhoneNo());
			}
			info.setMarketCode(String.valueOf(portalRegistrationMaster.getMarketCode()));
			info.setHireId(portalRegistrationMaster.getHireId());
			info.setParentId(portalRegistrationMaster.getParentId());
			info.setCollectCode(portalRegistrationMaster.getCollectCode());
			info.setDealerCode(portalRegistrationMaster.getDealerCode());
			// Added for Secondary PIC
			info.setSecondaryPicName(custInfo.getSecondaryPicName());
			info.setSecondaryPicContactNo(custInfo.getSecondaryPicContactNo());
			info.setSecondaryPicEmail(custInfo.getSecondaryPicEmail());
			info.setSecondaryPicIc(custInfo.getSecondaryPicIc());

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());

		}

		return info;

	}

	public static boolean isNotEmptyAndNotNull(String val) {
		return (val != null && !"".equals(val));
	}

	public static boolean updateTransServiceAttributeDelivered(Integer orderNo, Integer seqNo) {

		try {
			TransServiceAttribute transServiceAttribute = new TransServiceAttribute();
			TaskMaster taskMaster = new TaskMaster();
			taskMaster = getTaskIdOwnerRoleId(orderNo, seqNo);
			transServiceAttribute.setTaskId(Integer.valueOf(taskMaster.getTaskId()));
			transServiceAttribute.setTransMsid(getTransMsid(orderNo));
			brightStarMapClient.update(Constant.update_PortalTransServiceAttribute, transServiceAttribute);
			LogUtil.info("Portal_Trans_service_attribute updated for orderId: " + orderNo);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return true;
	}

	public static boolean updateTransTask(Integer orderNo, Integer sequenceNo) {

		try {
			Task task = new Task();
			String uniqueTaskId = uniqueTaskId(getTransMsid(orderNo));
			if (uniqueTaskId == null || sequenceNo == 2) {
				task.setModifiedBy(Constant.dealerName);
				task.setModifiedDatetime(new Date(System.currentTimeMillis()));
				TaskMaster taskMaster = new TaskMaster();
				taskMaster = getTaskIdOwnerRoleId(new Integer(orderNo), sequenceNo);
				task.setOwnerRoleId(taskMaster.getOwnerRoleId());
				task.setTaskId(taskMaster.getTaskId());
				if (sequenceNo == 0) {
					task.setRemarks(Constant.deliveryConfirmation);
					task.setTaskIdCompare(taskMaster.getTaskId());
				}
				if (sequenceNo == 2) {
					task.setRemarks(Constant.deliveredConfirmation);
					task.setTaskIdCompare(taskMaster.getTaskId());

				}
				task.setStatus(Constant.STATUS);
				task.setTransMsid(getTransMsid(orderNo));

				brightStarMapClient.update(Constant.update_PortalTransTask, task);
				LogUtil.info("Portal_Trans_Task Updated successfully for order id: " + orderNo);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return true;
	}

	public static boolean insertTransTask(Integer orderNo, Integer sequenceNo) {

		try {
			Task task = new Task();
			String uniqueTaskId = uniqueTaskId(getTransMsid(orderNo));
			if (uniqueTaskId == null) {
				task = (Task) brightStarMapClient.queryForObject(Constant.select_MaxInstanceIsPortalTransTask);
				Integer regId = getRegId(orderNo);
				task.setRegId(regId);
				task.setTransMsid(getTransMsid(orderNo));
				TaskMaster taskMaster = new TaskMaster();
				taskMaster = getTaskIdOwnerRoleId(new Integer(orderNo), sequenceNo);
				task.setTaskId(taskMaster.getTaskId());
				task.setOwnerRoleId(taskMaster.getOwnerRoleId());
				task.setCreatedBy(Constant.dealerCode);
				task.setCreatedDate(new Date(System.currentTimeMillis()));
				task.setTaskInstanceId(task.getMaxInstanceIdSeq());
				task.setStatus(Constant.STATUS_INPROGRESS);
				brightStarMapClient.insert(Constant.insert_PortalTransTask, task);
				LogUtil.info("Portal_trans_task insertion successfully done for orderId: " + orderNo);
			}

		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return true;
	}

	public static Integer getRegId(Integer orderNo) {

		TransPhoneOrderReg transPhoneOrderReg = new TransPhoneOrderReg();
		try {
			transPhoneOrderReg.setOrderNo(orderNo);
			transPhoneOrderReg = (TransPhoneOrderReg) portalMapClient
			    .queryForObject(Constant.select_PORTAL_TRANS_PHONE_ORDER_REG, transPhoneOrderReg);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return transPhoneOrderReg.getRegId();

	}

	public static boolean updateTransServiceAttribute(Integer orderNo, String imei, Integer sequenceNo) {

		try {
			TransServiceAttribute transServiceAttribute = new TransServiceAttribute();
			String uniqueValue = uniqueValue(getTransMsid(orderNo));
			if (uniqueValue == null) {
				Integer regId = getRegId(orderNo);
				TaskMaster taskMaster = new TaskMaster();
				taskMaster = getTaskIdOwnerRoleId(new Integer(orderNo), sequenceNo);
				transServiceAttribute.setTaskId(Integer.valueOf(taskMaster.getTaskId()));
				transServiceAttribute.setTransMsid(getTransMsid(orderNo));
				brightStarMapClient.update(Constant.update_PortalTransServiceAttribute, transServiceAttribute);
				LogUtil.info("Portal_Trans_service_attribute updated successfully for orderId: " + orderNo);
				transServiceAttribute.setRegId(regId);
				/* Integer maxId = CommonUtil.getMaximumId(regId); */
				TransServiceAttributeMap transServiceAttributeMap = new TransServiceAttributeMap();

				String[] transServiceAttributeHeaderName = new String[3];
				transServiceAttributeHeaderName[0] = Constant.HEADER_NAME1;
				transServiceAttributeHeaderName[1] = Constant.HEADER_NAME2;
				transServiceAttributeHeaderName[2] = Constant.HEADER_NAME3;
				IccidMsisdnImeiMap iccidMsisdnImeiMap = new IccidMsisdnImeiMap();
				iccidMsisdnImeiMap.setImei(imei);
				iccidMsisdnImeiMap = (IccidMsisdnImeiMap) brightStarMapClient.queryForObject(Constant.select_IccidMsisdnImei,
				    iccidMsisdnImeiMap);
				String[] transServiceAttributeValue = new String[3];
				transServiceAttributeValue[0] = imei;
				transServiceAttributeValue[1] = iccidMsisdnImeiMap.getIccid();
				transServiceAttributeValue[2] = iccidMsisdnImeiMap.getMsisdn();
				for (int i = 0; i < 3; i++) {
					Integer maxId = CommonUtil.getMaximumId(regId);
					transServiceAttribute.setId(maxId);
					transServiceAttributeMap.setPrdRegGroupMapId(taskMaster.getProdRefGrpMapId());
					transServiceAttributeMap.setTaskId(taskMaster.getTaskId());
					transServiceAttribute.setHeaderValue(transServiceAttributeValue[i]);
					transServiceAttribute.setHeaderName(transServiceAttributeHeaderName[i]);
					transServiceAttributeMap.setHeaderName(transServiceAttributeHeaderName[i]);
					transServiceAttributeMap = (TransServiceAttributeMap) brightStarMapClient
					    .queryForObject(Constant.select_TransServiceAttributeMap, transServiceAttributeMap);
					transServiceAttribute.setMapId(transServiceAttributeMap.getMapId());
					brightStarMapClient.insert(Constant.insert_PortalTransServiceAttribute, transServiceAttribute);
					LogUtil.info("Portal_Trans_service_attribute insertion successfully done for orderId: " + orderNo);

				}
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return true;
	}

	public static TaskMaster getTaskIdOwnerRoleId(Integer orderNo, Integer sequenceNo) throws SQLException {

		TaskMaster taskMaster = new TaskMaster();
		try {

			taskMaster.setProdRefGrpMapId(CommonUtil.getProdRegGrpMapId(orderNo));
			if (sequenceNo == 0 || sequenceNo == 1) {
				taskMaster.setSequenceNo(sequenceNo);
				taskMaster.setIsTerminal(Constant.isTerminal);
			}
			if (sequenceNo == 2) {
				taskMaster.setSequenceNo(sequenceNo);
				taskMaster.setIsTerminal(Constant.isTerminalDeliv);
			}
			taskMaster = (TaskMaster) brightStarMapClient.queryForObject(Constant.select_TaskMaster, taskMaster);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return taskMaster;
	}

	public static boolean validateImeiIccidMsisdn(String imei) {

		IccidMsisdnImeiMap iccidMsisdnImeiMap = new IccidMsisdnImeiMap();
		boolean returnvalue = false;
		try {

			iccidMsisdnImeiMap.setImei(imei);
			iccidMsisdnImeiMap = (IccidMsisdnImeiMap) brightStarMapClient.queryForObject(Constant.select_IccidMsisdnImei,
			    iccidMsisdnImeiMap);

		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (iccidMsisdnImeiMap != null) {
			if (iccidMsisdnImeiMap.getIccid() != null && iccidMsisdnImeiMap.getMsisdn() != null) {
				LogUtil.info("ICCID IMEI MSISDN validation done successfully");
				returnvalue = true;
			} else {
				LogUtil.info("ICCID IMEI MSISDN validation failed");
				returnvalue = false;
			}
		}
		return returnvalue;
	}

	public static String getMsisdn(String imei) {

		IccidMsisdnImeiMap iccidMsisdnImeiMap = new IccidMsisdnImeiMap();
		try {
			iccidMsisdnImeiMap.setImei(imei);
			iccidMsisdnImeiMap = (IccidMsisdnImeiMap) brightStarMapClient.queryForObject(Constant.select_IccidMsisdnImei,
			    iccidMsisdnImeiMap);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return iccidMsisdnImeiMap.getMsisdn();
	}

	public static Integer getProdRegGrpMapId(Integer orderNo) {

		PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
		try {
			Integer regId = CommonUtil.getRegId(orderNo);
			portalRegistrationMaster.setRegId(regId);
			portalRegistrationMaster = (PortalRegistrationMaster) brightStarMapClient
			    .queryForObject(Constant.select_prodRegGrpMapId, portalRegistrationMaster);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return portalRegistrationMaster.getProdRegGrpMapId();
	}

	public static Integer getMaximumId(Integer regId) {

		TransServiceAttribute transServiceAttribute = new TransServiceAttribute();
		try {
			transServiceAttribute.setRegId(regId);
			transServiceAttribute = (TransServiceAttribute) brightStarMapClient
			    .queryForObject(Constant.select_MaxIDServiceAttribute, transServiceAttribute);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return transServiceAttribute.getIdSequence();
	}

	public static Integer getTransMsid(Integer orderNo) {

		PhoneOrder phoneOrder = new PhoneOrder();
		try {
			phoneOrder.setOrderNo(orderNo);
			phoneOrder = (PhoneOrder) brightStarMapClient.queryForObject(Constant.select_transMsid, phoneOrder);
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		return phoneOrder.getTransMsid();

	}

	public static String uniqueTaskId(Integer transMsid) {
		Task task = new Task();
		task.setTransMsid(transMsid);
		task.setOwnerRoleId(Constant.ownerRoleId);
		try {
			task = (Task) brightStarMapClient.queryForObject(Constant.select_taskIdUnique, task);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (task == null) {
			return null;
		} else
			return task.getTaskId();
	}

	public static String uniqueValue(Integer transMsid) {
		TransServiceAttribute transServiceAttribute = new TransServiceAttribute();
		transServiceAttribute.setTransMsid(transMsid);
		transServiceAttribute.setHeaderName("IMEI");
		try {
			transServiceAttribute = (TransServiceAttribute) brightStarMapClient
			    .queryForObject(Constant.select_uniqueIMEIICCIDMSIDN, transServiceAttribute);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (transServiceAttribute == null) {
			return null;
		} else
			return transServiceAttribute.getHeaderValue();
	}

	public static boolean updateTransMsisdnStatusIOTRegId(Integer orderNo, boolean senToWm) {
		try {
			Integer transMsisd = CommonUtil.getTransMsid(orderNo);
			Integer regId = CommonUtil.getRegId(orderNo);
			Date dateModified = new Date(System.currentTimeMillis());
			TransMsisdn transMsisdn = new TransMsisdn();
			transMsisdn.setTransMsid(transMsisd);
			transMsisdn.setRegId(regId);
			transMsisdn.setDateModified(dateModified);
			if (senToWm) {

				transMsisdn.setWsStatus(Constant.Pending_Service_Creation);
				transMsisdn.setErrMsg("Pending Service Creation");
			} else {
				transMsisdn.setWsStatus(Constant.Failed_Service_creation);
				transMsisdn.setErrMsg("Failed Service Creation");
			}
			brightStarMapClient.update(Constant.update_PortalTransMsisdn, transMsisdn);
		}

		catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		return true;
	}

	public static boolean updatePortalRegistrationMaster(Integer orderNo, boolean senToWm) {
		try {
			Integer regId = CommonUtil.getRegId(orderNo);
			Date dateModified = new Date(System.currentTimeMillis());
			PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
			portalRegistrationMaster.setRegId(regId);
			portalRegistrationMaster.setDateModified(dateModified);
			if (senToWm) {

				portalRegistrationMaster.setRegStatus(Constant.Pending_Service_Creation);
			} else {

				portalRegistrationMaster.setRegStatus(Constant.Failed_Service_creation);
			}
			brightStarMapClient.update(Constant.update_PortalRegistrationMaster, portalRegistrationMaster);
		}

		catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		return true;
	}

	public static String checkAccountNumberCreation(Integer regId) {
		PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
		portalRegistrationMaster.setRegId(regId);
		try {
			portalRegistrationMaster = (PortalRegistrationMaster) brightStarMapClient.queryForObject(Constant.select_accNo,
			    portalRegistrationMaster);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (portalRegistrationMaster.getAccountNo() != null
		    && !portalRegistrationMaster.getAccountNo().equalsIgnoreCase(null)) {
			return portalRegistrationMaster.getAccountNo();
		} else {
			return null;
		}
	}

	public static TransMsisdn fetchTransMsisdnDetails(Integer transMsisdn) {
		TransMsisdn transMsisdnSelect = new TransMsisdn();
		transMsisdnSelect.setTransMsid(transMsisdn);
		try {
			transMsisdnSelect = (TransMsisdn) brightStarMapClient.queryForObject(Constant.select_TransMsidnDetails,
			    transMsisdnSelect);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (transMsisdnSelect != null) {
			return transMsisdnSelect;
		} else {
			return null;
		}

	}

	public static boolean activateOrderServiceForIoT(TransMsisdn transMsisdn, Integer regId,
	    Map<String, String> globalMap) throws CallBackInternalException {
		boolean sentToWM = false;
		try {
			DeliveredLogUtil.info("activateOrderServiceForIoT function is called in CommonUtil");
			PortalRegistrationMaster registrationMaster = CommonUtil.findRegistrationDetailsByRegId(regId);
			String externalIdType = CommonUtil.fetchRatePlanExternalIdType(transMsisdn.getRateplanId());
			CustomerInfo customerInfo = CommonUtil.fetchCustomerInfo(registrationMaster.getCustId());
			/* boolean sentToWM = false; */
			CommonUtil commonUtil = new CommonUtil();
			registrationMaster.setPortalCustInfo(customerInfo);
			TypeNewLineRegistrationRequest typeNewLineRegistration = new TypeNewLineRegistrationRequest();
			String wmOrderId;
			wmOrderId = "EBD" + "_" + String.valueOf(registrationMaster.getRegId()) + "_" + transMsisdn.getTransMsid() + "_"
			    + Constant.Reg_type_New_id.toString() + "_" + "0";
			DeliveredLogUtil.info("wm Order Id formed : " + wmOrderId);
			PortalTransWMAction portalTransWmAction = CommonUtil.checkTransWMActionExists(wmOrderId);
			Integer retryCount = 0;
			if (portalTransWmAction != null) {
				retryCount = portalTransWmAction.getRetryCount() + 1;
				wmOrderId = "EBD" + "_" + String.valueOf(registrationMaster.getRegId()) + "_" + transMsisdn.getTransMsid() + "_"
				    + Constant.Reg_type_New_id.toString() + "_" + retryCount.toString();
				DeliveredLogUtil.info("wm Order Id formed : " + wmOrderId);

			}
			typeNewLineRegistration.setOrderId(wmOrderId);
			DeliveredLogUtil.info("externalIdType for wmOrderId: " + wmOrderId + " is: " + externalIdType);
			typeNewLineRegistration.setCustomer(
			    CommonUtil.setTypeCustomer(registrationMaster.getPortalCustInfo(), globalMap, registrationMaster));
			AccountRequired accountRequired = new AccountRequired();
			ServiceRequired serviceRequired = new ServiceRequired();
			typeNewLineRegistration.setOrderType(globalMap.get("EAS_OrderType"));
			DeliveredLogUtil.info("Order Type :" + typeNewLineRegistration.getOrderType());
			accountRequired.setAccountRequired(globalMap.get("EAS_PhoneOrderAcctReq"));
			DeliveredLogUtil.info("Acct Required " + accountRequired.getAccountRequired());
			serviceRequired.setServiceRequired(globalMap.get("EAS_VSNServiceReq"));
			DeliveredLogUtil.info("Acct Required " + accountRequired.getAccountRequired());
			typeNewLineRegistration.setServiceRequired(serviceRequired);
			typeNewLineRegistration.setAccountRequired(accountRequired);
			if (null != registrationMaster.getAccountType()
			    && registrationMaster.getAccountType().equalsIgnoreCase("Existing Account")) {
				String existingAccountNo;
				existingAccountNo = registrationMaster.getAccountNo().substring(0,
				    (registrationMaster.getAccountNo().length() - 1));
				typeNewLineRegistration.setFxAcctNo(existingAccountNo);
			} else {
				typeNewLineRegistration.setFxAcctNo(registrationMaster.getAccountNo());
			}
			DeliveredLogUtil.info("Fx Acct No  :" + typeNewLineRegistration.getFxAcctNo());
			typeNewLineRegistration.setService(
			    CommonUtil.setDummyServiceToGenVSNForIOT(transMsisdn, registrationMaster, globalMap, externalIdType));
			typeNewLineRegistration.setDealerCode(registrationMaster.getDealerCode());
			DeliveredLogUtil.info("Dealer Code   : " + typeNewLineRegistration.getDealerCode());
			typeNewLineRegistration.setChgWho(registrationMaster.getDealerCode());
			DeliveredLogUtil.info("Chg Who : " + typeNewLineRegistration.getChgWho());
			/*
			 * String accMgrDealerCode =
			 * CommonUtil.getAccMgrByMgrId(registrationMaster.getAccMgrCode());
			 * if(accMgrDealerCode!=""){
			 * typeNewLineRegistration.setInpF01(accMgrDealerCode);
			 * DeliveredLogUtil.info("Submit For : "+typeNewLineRegistration.getInpF01()); }
			 */
			String acctMgrCode = registrationMaster.getAccMgrCode();
			String regex = "[0-9]+";
			if (null != acctMgrCode && acctMgrCode.length() > 0) {
				if (acctMgrCode.matches(regex)) {
					String acctMgrRefName = CommonUtil.getAccMgrByMgrId(registrationMaster.getAccMgrCode());
					typeNewLineRegistration.setInpF01(acctMgrRefName);
				} else {
					typeNewLineRegistration.setInpF01(registrationMaster.getAccMgrCode());
				}
			}
			typeNewLineRegistration.setInpF02(externalIdType);
			WebMethodInvocationService invocationService = new WebMethodInvocationService();
			NewLineRegistrationRequest registrationRequest = new NewLineRegistrationRequest();
			registrationRequest.setNewLineRegistrationRequestDetails(typeNewLineRegistration);
			NewLineRegistrationRequestE registrationRequestE = new NewLineRegistrationRequestE();
			registrationRequestE.setNewLineRegistrationRequest(registrationRequest);
			NewLineRegistrationResponseE registrationResponseE = null;
			int j = 0;
			if (null != retryCount) {
				j = retryCount;
			}
			for (int i = j; i < j + 3; i++) {
				DeliveredLogUtil.info("invoke the service iteration :" + i);
				registrationResponseE = invocationService.callNewLineRegistrationForBulk(registrationRequestE, commonUtil);
				if (null == registrationResponseE || null == registrationResponseE.getNewLineRegistrationResponse()
				    || null == registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				    || null == registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				        .getMsgCode()
				    || !registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				        .getMsgCode().equalsIgnoreCase("0")) {
					DeliveredLogUtil.info("Response code is not 0,  so trying to invoke the service for one more time");
					wmOrderId = "EBD" + "_" + String.valueOf(registrationMaster.getRegId()) + "_" + transMsisdn.getTransMsid()
					    + "_" + Constant.Reg_type_New_id.toString() + "_" + i;
					DeliveredLogUtil.info("wmOrderId formed :" + wmOrderId);
					TypeNewLineRegistrationRequest lineRegistrationRequest = registrationRequestE.getNewLineRegistrationRequest()
					    .getNewLineRegistrationRequestDetails();
					lineRegistrationRequest.setOrderId(wmOrderId);
					registrationRequest.setNewLineRegistrationRequestDetails(lineRegistrationRequest);
					registrationRequestE.setNewLineRegistrationRequest(registrationRequest);
				} else {
					DeliveredLogUtil.info("Request object is sent successfully");
					PortalTransWMAction portalTransWmActionIn = new PortalTransWMAction();
					portalTransWmActionIn.setWmOrderId(wmOrderId);
					DeliveredLogUtil.info("insert in to trans wm action wm order id  :" + portalTransWmActionIn.getWmOrderId());
					portalTransWmActionIn.setRegId(regId);
					DeliveredLogUtil.info("insert in to trans wm action master reg id  :" + portalTransWmActionIn.getRegId());
					portalTransWmActionIn.setTransMsid(transMsisdn.getTransMsid());
					DeliveredLogUtil.info("insert in to trans wm action  :" + portalTransWmActionIn.getTransMsid());
					portalTransWmActionIn.setRetryCount(retryCount);
					DeliveredLogUtil.info("insert in to trans wm action retry count  :" + portalTransWmActionIn.getRetryCount());
					portalTransWmActionIn.setWmActionStatusCode(Constant.Reg_type_New_id);
					DeliveredLogUtil
					    .info("insert in to trans wm action wm action code :" + portalTransWmActionIn.getWmActionStatusCode());
					portalTransWmActionIn.setWmTriggerTime((new Date()));
					DeliveredLogUtil.info("insert in to trans wm action wm status msg:" + portalTransWmActionIn.getWmStatusMsg());
					portalTransWmActionIn.setChannelId(Constant.CHANNEL_IOT);
					portalTransWmActionIn.setDateCreated(new Date());
					portalTransWmActionIn.setDateModified(new Date());
					/* callBackManager.insertEasTransMsisdnIOT(easMsisdn, session); */

					DeliveredLogUtil.info("wmOrderId is formed successfully and inserted for orderid :" + wmOrderId);
					/*
					 * PortalTransWMAction
					 * easMsisdn=formServiceOrderActionRNSIOT(wmOrderId,transMsisdn,Constant.
					 * Reg_type_New_id,i,regId,callBackManager,session);
					 */
					DeliveredLogUtil.info("wmOrderId is formed successfully and inserted for orderid :" + wmOrderId);
					DeliveredLogUtil.info("transWmAction is updated with respective status");
					sentToWM = true;
					boolean transWMInsert = CommonUtil.insertTransWMActionIOT(portalTransWmActionIn);
					boolean transMsisdnUpdate = CommonUtil.updateTransMsisdnIOT(regId, transMsisdn.getTransMsid(), "",
					    Constant.Pending_Line_Prov);
					updateStatusForChildMaster(regId);

					/* mapForReturn.put(easMsisdn.getEasMasterRegId(), "completed"); */
					break;
				}
			}
			if (null == registrationResponseE || null == registrationResponseE.getNewLineRegistrationResponse()
			    || null == registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
			    || null == registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
			        .getMsgCode()
			    || !registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
			        .getMsgCode().equalsIgnoreCase("0")) {
				DeliveredLogUtil.info("Request object is sent successfully");
				PortalTransWMAction easMsisdn = null;
				if (null != registrationResponseE && null != registrationResponseE.getNewLineRegistrationResponse()
				    && null != registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				    && null != registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				        .getMsgCode()
				    && !registrationResponseE.getNewLineRegistrationResponse().getNewLineRegistrationResponseDetails()
				        .getMsgCode().equalsIgnoreCase("0")) {
					DeliveredLogUtil.info("Request body not sent successfully");
					sentToWM = false;
					PortalTransWMAction portalTransWMActionIoTFail = formServiceOrderActionRNSIOT(wmOrderId, transMsisdn,
					    Constant.Reg_type_New_id, retryCount + 3, regId);
					boolean transWMInsertFail = CommonUtil.insertTransWMActionIOT(portalTransWMActionIoTFail);
					boolean transMsisdnUpdate = CommonUtil.updateTransMsisdnIOT(regId, transMsisdn.getTransMsid(), "",
					    Constant.Failed_Line_Prov);

					updateStatusForChildMaster(regId);
				}
			}
		} catch (CallBackInternalException e) {
			// TODO Auto-generated catch block
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			throw e;

		} catch (Exception e) {
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			CallBackInternalException ce = new CallBackInternalException();
			ce.setExceptionIndicator("Y");
			ce.setExceptionMessage(e.getMessage());
			DeliveredLogUtil.info("Exception occurred :" + e.getMessage());

			throw ce;

		}

		return sentToWM;
	}

	public static PortalRegistrationMaster findRegistrationDetailsByRegId(Integer regId) {
		PortalRegistrationMaster registrationMaster = new PortalRegistrationMaster();
		registrationMaster.setRegId(regId);
		try {
			registrationMaster = (PortalRegistrationMaster) brightStarMapClient
			    .queryForObject(Constant.select_RegistrationDetails, registrationMaster);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (registrationMaster != null) {
			return registrationMaster;
		} else {
			return null;
		}
	}

	public static String fetchRatePlanExternalIdType(Integer ratePlanId) {
		TransMsisdn transMsisdn = new TransMsisdn();
		transMsisdn.setRateplanId(ratePlanId);
		try {
			transMsisdn = (TransMsisdn) brightStarMapClient.queryForObject(Constant.select_externalId, transMsisdn);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (transMsisdn.getExternalId() != null && transMsisdn.getExternalId() != "") {
			return transMsisdn.getExternalId();
		} else {
			return null;
		}
	}

	public static CustomerInfo fetchCustomerInfo(Integer custId) {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustId(custId);
		try {
			customerInfo = (CustomerInfo) brightStarMapClient.queryForObject(Constant.select_customerDetails, customerInfo);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (customerInfo != null) {
			return customerInfo;
		} else {
			return null;
		}
	}

	public static String getAccMgrByMgrId(String accMgrId) {
		AcctMgrRef accMgrRef = new AcctMgrRef();
		try {
			if (accMgrId != null && accMgrId != "") {
				accMgrRef.setAcctMgrId(Integer.valueOf(accMgrId));
				accMgrRef = (AcctMgrRef) brightStarMapClient.queryForObject(Constant.select_accMgrDealerCode, accMgrRef);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (accMgrRef != null) {
			return accMgrRef.getDealerCode();
		} else {
			return null;
		}
	}

	public static PortalTransWMAction checkTransWMActionExists(String wmOrderId) {
		PortalTransWMAction portalTransWMAction = new PortalTransWMAction();
		portalTransWMAction.setWmOrderId(wmOrderId);

		try {
			portalTransWMAction = (PortalTransWMAction) brightStarMapClient.queryForObject(Constant.select_transWMAction,
			    portalTransWMAction);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (portalTransWMAction != null) {
			return portalTransWMAction;
		} else {
			return null;
		}
	}

	public static Dealer getDealerDetails(String dealerCode) {
		Dealer dealer = new Dealer();
		dealer.setDealerCode(dealerCode);

		try {
			dealer = (Dealer) brightStarMapClient.queryForObject(Constant.select_dealerDetails, dealer);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (dealer != null) {
			return dealer;
		} else {
			return null;
		}
	}

	public static List<TransVas> fetchVasDetails(Integer transMsid) {

		TransVas transVas = new TransVas();
		transVas.setTransMsid(transMsid);
		List<TransVas> vasList = null;
		try {

			vasList = (List<TransVas>) brightStarMapClient.queryForList(Constant.select_vasDetails, transVas);

		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (vasList != null) {
			return vasList;
		} else {
			return null;
		}

	}

	public static List<PortalRefRatePlan> fetchRatePlanDetailsList(Integer ratePlanId) {
		PortalRefRatePlan portalRefRatePlan = new PortalRefRatePlan();
		portalRefRatePlan.setRatePlanId(ratePlanId);
		List<PortalRefRatePlan> ratePlanList = null;
		try {
			ratePlanList = (List<PortalRefRatePlan>) brightStarMapClient.queryForList(Constant.select_rateplanDetails,
			    portalRefRatePlan);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (ratePlanList != null) {
			return ratePlanList;
		} else {
			return null;
		}

	}

	public static List<PortalRefChargeType> fetchRefChargeType(Integer chargeTypeId) {
		PortalRefChargeType portalRefChargeType = new PortalRefChargeType();
		portalRefChargeType.setChargeTypeID(chargeTypeId);
		List<PortalRefChargeType> portalRefChargeTypeList = null;
		try {
			portalRefChargeTypeList = (List<PortalRefChargeType>) brightStarMapClient
			    .queryForList(Constant.select_portalrefchargeType, portalRefChargeType);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (portalRefChargeTypeList != null) {
			return portalRefChargeTypeList;
		} else {
			return null;
		}

	}

	public static List<PortalRefVasChargeDetails> fetchRefVasChargeDetails(Integer vasId) {
		PortalRefVasChargeDetails portalRefCharge = new PortalRefVasChargeDetails();
		portalRefCharge.setVasId(vasId);
		List<PortalRefVasChargeDetails> chargeTypeList = null;
		try {
			chargeTypeList = (List<PortalRefVasChargeDetails>) brightStarMapClient
			    .queryForList(Constant.select_ChargeTypeDetails, portalRefCharge);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (chargeTypeList != null) {
			return chargeTypeList;
		} else {
			return null;
		}

	}

	public static List<VasRef> fetchRefVasDetailsList(Integer ratePlanId) {
		VasRef vasRef = new VasRef();
		vasRef.setRateplanId(ratePlanId);
		List<VasRef> refVasList = null;
		try {
			refVasList = (List<VasRef>) brightStarMapClient.queryForList(Constant.select_VasRefDetails, vasRef);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (refVasList != null) {
			return refVasList;
		} else {
			return null;
		}

	}

	public static List<EasRefDevice> fetchRefEasDeviceDetails(String deliveryPartner, String deviceArticleId) {
		EasRefDevice deviceRef = new EasRefDevice();
		deviceRef.setDeviceArticleId(deviceArticleId);
		deviceRef.setDeliveryPartner(deliveryPartner);
		List<EasRefDevice> deviceRefList = null;
		try {
			deviceRefList = (List<EasRefDevice>) brightStarMapClient.queryForList(Constant.select_deviceDetails, deviceRef);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (deviceRefList != null) {
			return deviceRefList;
		} else {
			return null;
		}

	}

	public static List<TypeIddConnect> fetchIddListConnect(Integer transMsid) {
		PortalRefIddCountry portalRefIdCountry = new PortalRefIddCountry();
		portalRefIdCountry.setTransMsid(transMsid);
		List<TypeIddConnect> tyepIdList = null;
		List<PortalRefIddCountry> portalCountryList = null;
		try {
			portalCountryList = (List<PortalRefIddCountry>) brightStarMapClient
			    .queryForList(Constant.select_portalRefIdCountry, portalRefIdCountry);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (null != portalCountryList && portalCountryList.size() > 0) {
			for (Iterator iterator = portalCountryList.iterator(); iterator.hasNext();) {
				PortalRefIddCountry portalRefIddCountry = (PortalRefIddCountry) iterator.next();
				TypeIddConnect typeIddConnect = new TypeIddConnect();
				typeIddConnect.setCorridorPlanId(portalRefIddCountry.getCorridorPlanId().toString());
				typeIddConnect.setPoint(portalRefIddCountry.getPoint().toString());
				tyepIdList.add(typeIddConnect);
			}
		}
		return tyepIdList;

	}

	public static TypeServiceCreation setDummyServiceToGenVSNForIOT(TransMsisdn transMsisdn,
	    PortalRegistrationMaster registrationMaster, Map<String, String> globalConfig, String externalIdType)
	    throws CallBackInternalException {

		/* TypeServiceCreation typeServiceCreation = new TypeServiceCreation(); */
		try {
			/* TypeServiceCreation typeServiceCreation = new TypeServiceCreation(); */
			TypeServiceCreation typeServiceCreation = new TypeServiceCreation();
			CustomerInfo customerInfo = registrationMaster.getPortalCustInfo();
			typeServiceCreation.setExternalIdList(setExternalIdListIOT(transMsisdn));

			/*
			 * if(globalConfig.getStrParameterName().equals(CallBackConstants.
			 * MES_DisplayExternalIdType)){
			 * typeServiceCreation.setDisplayExternalIdType(globalConfig.
			 * getStrParameterValue());
			 * DeliveredLogUtil.info("Display External Id Type :"+typeServiceCreation.
			 * getDisplayExternalIdType()); }
			 */

			typeServiceCreation.setNoBill(globalConfig.get(Constant.EAS_NoBill));
			DeliveredLogUtil.info("No Bill :" + typeServiceCreation.getNoBill());

			typeServiceCreation.setPrivacyLevel(globalConfig.get(Constant.EAS_PrivacyLevel));
			DeliveredLogUtil.info("Privacy Level :" + typeServiceCreation.getPrivacyLevel());

			typeServiceCreation.setRateClass(globalConfig.get(Constant.EAS_RateClassDefault));
			DeliveredLogUtil.info("RateClassDefault :" + typeServiceCreation.getRateClass());

			typeServiceCreation.setRevRcvCostCtr(globalConfig.get(Constant.EAS_RevRcvCostCtr));
			DeliveredLogUtil.info("RevRcvCostCtr :" + typeServiceCreation.getRevRcvCostCtr());

			typeServiceCreation.setGenerateVSN(globalConfig.get(Constant.generateVSN));
			DeliveredLogUtil.info("generateVSN :" + typeServiceCreation.getGenerateVSN());

			typeServiceCreation.setServiceCountryCode(globalConfig.get(Constant.EAS_ServiceCountryCode));
			DeliveredLogUtil.info("ServiceCountryCode :" + typeServiceCreation.getServiceCountryCode());

			typeServiceCreation.setServiceFranchiseTaxCode(globalConfig.get(Constant.EAS_ServiceFranchiseTaxCode));
			DeliveredLogUtil.info("ServiceFranchiseTaxCode :" + typeServiceCreation.getServiceFranchiseTaxCode());

			typeServiceCreation.setBRevRcvCostCtr(globalConfig.get(Constant.EAS_brevCostCtr));
			DeliveredLogUtil.info("BRev Rcv Cost Ctr  :" + typeServiceCreation.getBRevRcvCostCtr());

			typeServiceCreation.setCurrencyCode(globalConfig.get(Constant.EAS_CurrencyCode));
			DeliveredLogUtil.info("Currency Code  :" + typeServiceCreation.getCurrencyCode());

			typeServiceCreation.setExrateClass(globalConfig.get(Constant.EAS_ExrateClass));
			DeliveredLogUtil.info("exrate class :" + typeServiceCreation.getExrateClass());

			typeServiceCreation.setIsPrepaid(globalConfig.get(Constant.EAS_isPrePaid));
			DeliveredLogUtil.info("Is prepaid :" + typeServiceCreation.getIsPrepaid());

			typeServiceCreation.setStatusId(globalConfig.get(Constant.EAS_statusId));
			DeliveredLogUtil.info("status id :" + typeServiceCreation.getStatusId());

			typeServiceCreation.setStatusReasonId(globalConfig.get(Constant.EAS_statusReasonId));
			DeliveredLogUtil.info("status reason id :" + typeServiceCreation.getStatusReasonId());

			typeServiceCreation.setTimezone(globalConfig.get(Constant.EAS_timeZone));
			DeliveredLogUtil.info("Time zone :" + typeServiceCreation.getTimezone());

			typeServiceCreation.setViewStatus(globalConfig.get(Constant.EAS_viewStatus));
			DeliveredLogUtil.info("view Status :" + typeServiceCreation.getViewStatus());

			typeServiceCreation.setIxcProviderId(globalConfig.get(Constant.EAS_ixcProviderId));
			DeliveredLogUtil.info("ixc provider id :" + typeServiceCreation.getIxcProviderId());
			typeServiceCreation.setDisplayExternalIdType(externalIdType);
			DeliveredLogUtil.info("Display External Id Type :" + typeServiceCreation.getDisplayExternalIdType());

			Dealer dealer = CommonUtil.getDealerDetails(registrationMaster.getDealerCode());
			if (null != dealer && null != dealer.getSalesChannelId()) {
				typeServiceCreation.setSalesChannelId(dealer.getSalesChannelId().toString());
				DeliveredLogUtil.info("Sales channel Id :" + typeServiceCreation.getSalesChannelId());
			}
			typeServiceCreation.setAccountExternalId(registrationMaster.getAccountNo());
			DeliveredLogUtil.info("Account External Id :" + registrationMaster.getAccountNo());
			typeServiceCreation.setServiceAddress1(customerInfo.getBillAddr1());
			DeliveredLogUtil.info("Bill Address1 :" + typeServiceCreation.getServiceAddress1());
			typeServiceCreation.setServiceAddress2(customerInfo.getBillAddr2());
			DeliveredLogUtil.info("Bill Address2 :" + typeServiceCreation.getServiceAddress2());
			typeServiceCreation.setServiceAddress3(customerInfo.getBillAddr3());
			DeliveredLogUtil.info("Bill Address3 :" + typeServiceCreation.getServiceAddress3());
			typeServiceCreation.setServiceLname(customerInfo.getCompanyName());
			DeliveredLogUtil.info("service L name :" + typeServiceCreation.getServiceLname());
			typeServiceCreation.setServiceState(customerInfo.getBillState());
			DeliveredLogUtil.info("Service status :" + typeServiceCreation.getServiceState());
			typeServiceCreation.setServiceZip(customerInfo.getBillPostcode());
			DeliveredLogUtil.info("service zip :" + typeServiceCreation.getServiceZip());
			List<TransVas> components = CommonUtil.fetchVasDetails(transMsisdn.getTransMsid());
			List<PortalRefRatePlan> componentsPortalRefRatePlan = CommonUtil
			    .fetchRatePlanDetailsList(transMsisdn.getRateplanId());
			for (Iterator iteratorcomponents = componentsPortalRefRatePlan.iterator(); iteratorcomponents.hasNext();) {
				PortalRefRatePlan portalRefRatePlan = (PortalRefRatePlan) iteratorcomponents.next();
				typeServiceCreation.setEmfConfigId(portalRefRatePlan.getEmfConfigId().toString());
			}
			Map<String, List<TransVas>> packageMap = new HashMap<String, List<TransVas>>();
			for (Iterator iteratorcomponents = components.iterator(); iteratorcomponents.hasNext();) {
				TransVas vasRef = (TransVas) iteratorcomponents.next();
				if ((null == vasRef.getContractType())
				    || (null != vasRef.getContractType() && vasRef.getContractType().length() > 0
				        && !vasRef.getContractType().equalsIgnoreCase(Constant.component_type_zerolution))) {
					if (null != packageMap.get(vasRef.getPackageId().toString())
					    && packageMap.get(vasRef.getPackageId().toString()).size() > 0) {
						List<TransVas> vasRefList = packageMap.get(vasRef.getPackageId().toString());
						vasRefList.add(vasRef);
						packageMap.put(vasRef.getPackageId().toString(), vasRefList);
					} else {
						List<TransVas> vasRefList = new ArrayList<TransVas>();
						vasRefList.add(vasRef);
						packageMap.put(vasRef.getPackageId().toString(), vasRefList);
					}
				}
			}
			TypePackageCreation[] typePackageCreation;
			typePackageCreation = new TypePackageCreation[packageMap.size()];
			Set<String> packageIdSet = packageMap.keySet();
			int i1 = 0;
			for (Iterator iteratorpackages = packageIdSet.iterator(); iteratorpackages.hasNext();) {
				String packageId = (String) iteratorpackages.next();
				typePackageCreation[i1] = new TypePackageCreation();
				List<TransVas> componentsList = packageMap.get(packageId.toString());
				ComponentListConnect[] componentList = new ComponentListConnect[componentsList.size()];
				int j = 0;
				typePackageCreation[i1].setPackageId(packageId);
				typePackageCreation[i1].setConnectReason(Constant.connectReason);
				DeliveredLogUtil.info("PackageId :" + typePackageCreation[i1].getPackageId());
				for (Iterator iterator2 = componentsList.iterator(); iterator2.hasNext();) {
					TransVas vasRef = (TransVas) iterator2.next();
					componentList[j] = new ComponentListConnect();
					componentList[j].setComponentId(vasRef.getComponentId().toString());
					componentList[j].setConnectReason(Constant.connectReason);

					DeliveredLogUtil.info("Component Id :" + vasRef.getComponentId());
					j++;
				}
				typePackageCreation[i1].setComponentListConnect(componentList);
				i1++;
			}
			typeServiceCreation.setPackageListConnect(typePackageCreation);
			List<VasRef> componentsRefVas = CommonUtil.fetchRefVasDetailsList(transMsisdn.getRateplanId());
			for (Iterator iterator = componentsRefVas.iterator(); iterator.hasNext();) {
				VasRef vasRef = (VasRef) iterator.next();
				Map<String, List<VasRef>> packageMapSpecial = new HashMap<String, List<VasRef>>();
				for (Iterator iteratorcomponents = componentsRefVas.iterator(); iteratorcomponents.hasNext();) {
					VasRef refVas = (VasRef) iteratorcomponents.next();
					if (null != packageMapSpecial.get(refVas.getPackageId().toString())
					    && packageMapSpecial.get(refVas.getPackageId().toString()).size() > 0) {
						List<VasRef> vasRefList = packageMapSpecial.get(refVas.getPackageId().toString());
						vasRefList.add(refVas);
						packageMapSpecial.put(refVas.getPackageId().toString(), vasRefList);
					} else {
						List<VasRef> vasRefList = new ArrayList<VasRef>();
						vasRefList.add(refVas);
						packageMapSpecial.put(refVas.getPackageId().toString(), vasRefList);
					}
				}
				TypeSpecialPackageListConnect[] typeSpecialPackageCreation = null;
				typeSpecialPackageCreation = new TypeSpecialPackageListConnect[packageMapSpecial.size()];
				Set<String> packageIdSetSpecial = packageMapSpecial.keySet();
				int i2 = 0;
				for (Iterator iteratorpackages = packageIdSetSpecial.iterator(); iteratorpackages.hasNext();) {
					String packageId = (String) iteratorpackages.next();
					typeSpecialPackageCreation[i2] = new TypeSpecialPackageListConnect();
					List<VasRef> componentsList = packageMapSpecial.get(packageId);
					TypeSpecialComponentListConnect[] componentList = new TypeSpecialComponentListConnect[componentsList.size()];
					int j = 0;
					typeSpecialPackageCreation[i2].setPackageId(packageId);
					typeSpecialPackageCreation[i2].setConnectReason(Constant.connectReason);
					typeSpecialPackageCreation[i2].setSpPackageType(Constant.sp_package_type);
					DeliveredLogUtil.info("PackageId :" + typeSpecialPackageCreation[i2].getPackageId());
					boolean addedComponent = false;
					for (Iterator iterator2 = componentsList.iterator(); iterator2.hasNext();) {
						VasRef vasRef1 = (VasRef) iterator2.next();
						List<PortalRefChargeType> componentsRefChargeType = CommonUtil
						    .fetchRefChargeType(vasRef1.getChargeTypeId());
						List<PortalRefVasChargeDetails> componentsRefVasChargeDetails = CommonUtil
						    .fetchRefVasChargeDetails(vasRef1.getVasId());

						for (Iterator iterator3 = componentsRefChargeType.iterator(); iterator3.hasNext();) {

							PortalRefChargeType portalRefChargeType = (PortalRefChargeType) iterator3.next();

							for (Iterator iterator4 = componentsRefVasChargeDetails.iterator(); iterator4.hasNext();) {
								PortalRefVasChargeDetails portalRefVasChargeDetails = (PortalRefVasChargeDetails) iterator4.next();
								if (Constant.sp_component_type_five.equalsIgnoreCase(portalRefChargeType.getSpComponent() + "")) {
									componentList[j] = new TypeSpecialComponentListConnect();
									componentList[j].setComponentId(vasRef1.getComponentId());
									componentList[j].setSpComponentType(Constant.sp_component_type_five);
									componentList[j].setConnectReason(Constant.connectReason);
									if (portalRefVasChargeDetails.getVasMonthlyAmount() != null) {
										componentList[j].setInpF01(String.valueOf(portalRefVasChargeDetails.getVasMonthlyAmount()));
									}
									DeliveredLogUtil.info("Component Id :" + vasRef1.getComponentId());
									addedComponent = true;
									j++;
								} else if (Constant.sp_component_type_three
								    .equalsIgnoreCase(portalRefChargeType.getSpComponent() + "")) {
									componentList[j] = new TypeSpecialComponentListConnect();
									componentList[j].setComponentId(vasRef1.getComponentId());
									componentList[j].setSpComponentType(Constant.sp_component_type_three);
									componentList[j].setConnectReason(Constant.connectReason);
									if (portalRefVasChargeDetails.getChargeTypeValue() != null
									    && portalRefVasChargeDetails.getInstallmentDuration() != null) {
										int upgradeValue = (int) (portalRefVasChargeDetails.getChargeTypeValue()
										    * portalRefVasChargeDetails.getInstallmentDuration());
										componentList[j].setInpF01(String.valueOf(upgradeValue));
									}

									if (portalRefVasChargeDetails.getChargeTypeValue() != null) {
										componentList[j].setInpF02(String.valueOf(portalRefVasChargeDetails.getChargeTypeValue()));
									}

									DeliveredLogUtil.info("Component Id :" + vasRef1.getComponentId());
									addedComponent = true;
									j++;
								} else if (Constant.sp_component_type_two.equalsIgnoreCase(portalRefChargeType.getSpComponent() + "")) {
									componentList[j] = new TypeSpecialComponentListConnect();
									componentList[j].setComponentId(vasRef1.getComponentId());
									componentList[j].setSpComponentType(Constant.sp_component_type_two);
									componentList[j].setConnectReason(Constant.connectReason);
									if (portalRefVasChargeDetails.getMonthlyInstallmentAmount() != null
									    && portalRefVasChargeDetails.getInstallmentDuration() != null) {
										int installmentAmt = (int) (portalRefVasChargeDetails.getMonthlyInstallmentAmount()
										    * portalRefVasChargeDetails.getInstallmentDuration());
										componentList[j].setInpF02(String.valueOf(installmentAmt));
									}
									if (portalRefVasChargeDetails.getMonthlyInstallmentAmount() != null) {
										componentList[j].setInpF01(String.valueOf(portalRefVasChargeDetails.getMonthlyInstallmentAmount()));
									}
									if (portalRefVasChargeDetails.getInstallmentDuration() != null) {
										componentList[j].setInpF03(String.valueOf(portalRefVasChargeDetails.getInstallmentDuration()));
									}
									if (portalRefVasChargeDetails.getAnnotation() != null) {
										componentList[j].setInpF04(portalRefVasChargeDetails.getAnnotation());
									}

									List<EasRefDevice> easRefDevice = CommonUtil.fetchRefEasDeviceDetails(
									    portalRefVasChargeDetails.getDeliveryPartner(), portalRefVasChargeDetails.getDeviceArticleId());
									if (easRefDevice != null && easRefDevice.size() > 0) {
										String extendedData = portalRefVasChargeDetails.getExtendedData();
										String[] parts = extendedData.split(":");
										String extendedDataValue1 = parts[0];
										String extendedDataValue2 = parts[1];
										String extendedDataValue3 = parts[2];
										TypeInArrDoc[] typeArrInDoc = new TypeInArrDoc[4];
										typeArrInDoc[0] = new TypeInArrDoc();
										typeArrInDoc[0].setInA01(extendedDataValue1 + "|" + easRefDevice.get(0).getDeviceName());
										typeArrInDoc[1] = new TypeInArrDoc();
										typeArrInDoc[1].setInA01(extendedDataValue2 + "|" + portalRefVasChargeDetails.getDeliveryPartner());
										typeArrInDoc[2] = new TypeInArrDoc();
										typeArrInDoc[2].setInA01(extendedDataValue3 + "|" + portalRefVasChargeDetails.getDeviceArticleId());
										componentList[j].setInArr01(typeArrInDoc);
										DeliveredLogUtil.info("Component Id :" + vasRef1.getComponentId());
									}
									addedComponent = true;
									j++;
								}

							}
						}
					}
					if (addedComponent) {
						typeSpecialPackageCreation[i2].setSpecialComponentListConnect(componentList);
					} else {
						typeSpecialPackageCreation[i2] = null;
					}
					i2++;
				}
				typeServiceCreation.setSpecialPackageListConnect(typeSpecialPackageCreation);

			}
			List<TypeIddConnect> iddConnectList = CommonUtil.fetchIddListConnect(transMsisdn.getTransMsid());
			if (null != iddConnectList && iddConnectList.size() > 0) {
				TypeIddConnect[] iddConnectArray = iddConnectList.toArray(new TypeIddConnect[iddConnectList.size()]);
				typeServiceCreation.setIddListConnect(iddConnectArray);
			}
			return typeServiceCreation;
		} catch (CallBackInternalException e) {
			// TODO Auto-generated catch block
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			throw e;

		} catch (Exception e) {
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			CallBackInternalException ce = new CallBackInternalException();
			ce.setExceptionIndicator("Y");
			ce.setExceptionMessage(e.getMessage());
			DeliveredLogUtil.info("Exception occurred :" + e.getMessage());
			throw ce;
		}

	}

	public static TypeCustomer setTypeCustomer(CustomerInfo customerInfo, Map<String, String> globalConfigs,
	    PortalRegistrationMaster registrationMaster) {

		TypeCustomer typeCustomer = new TypeCustomer();
		/*
		 * typeCustomer.setIcType(CallBackConstants.ictype_brn);
		 * DeliveredLogUtil.info("Ic Type :"+typeCustomer.getIcType());
		 */
		/* if(null!=registrationMaster && null!=registrationMaster.getCustBrnNo()) */

		/* DeliveredLogUtil.info("Ic No :"+typeCustomer.getIcNo()); */
		typeCustomer.setBillLname(customerInfo.getDelContactName());
		DeliveredLogUtil.info("Bill Lname :" + typeCustomer.getBillLname());
		// TODO city name is not stored in db how to send the city
		// typeCustomer.setBillCity(customerInfo.getCity());
		typeCustomer.setBillCompany(customerInfo.getCompanyName());
		DeliveredLogUtil.info("Bill Company :" + typeCustomer.getBillCompany());
		typeCustomer.setBillAddress1(customerInfo.getBillAddr1());
		DeliveredLogUtil.info("Bill Address1 :" + typeCustomer.getBillAddress1());
		typeCustomer.setBillAddress2(customerInfo.getBillAddr2());
		DeliveredLogUtil.info("Bill Address2 :" + typeCustomer.getBillAddress2());
		typeCustomer.setBillCity(customerInfo.getCitySiteA());
		DeliveredLogUtil.info("Bill Address3 :" + typeCustomer.getBillCity());
		typeCustomer.setBillState(customerInfo.getBillState());
		DeliveredLogUtil.info("Bill State :" + typeCustomer.getBillState());
		// customerInfo.getEmail();
		typeCustomer.setBillZip(customerInfo.getBillPostcode());
		DeliveredLogUtil.info("Bill Zip :" + typeCustomer.getBillZip());
		typeCustomer.setBillCity(customerInfo.getBillAddr3());
		DeliveredLogUtil.info("Bill City:" + typeCustomer.getBillCity());

		/*
		 * if(null!=registrationMaster.getMarketCode() &&
		 * registrationMaster.getMarketCode().length()>0){
		 * if(registrationMaster.getMarketCode().equalsIgnoreCase("Company/SME")){
		 * typeCustomer.setMktCode(CallBackConstants.market_code_companySME);
		 * DeliveredLogUtil.info("Market Code :"+typeCustomer.getMktCode()); }else{
		 * typeCustomer.setMktCode(CallBackConstants.market_code_corporate);
		 * DeliveredLogUtil.info("Market Code :"+typeCustomer.getMktCode()); } }else{
		 * typeCustomer.setMktCode(CallBackConstants.market_code_null);
		 * DeliveredLogUtil.info("Market Code :"+typeCustomer.getMktCode()); }
		 * //typeCustomer.setMktCode(param);
		 * typeCustomer.setAcctCategory(CallBackConstants.acct_category);
		 * DeliveredLogUtil.info("Acct Category :"+typeCustomer.getAcctCategory());
		 */

		typeCustomer.setBillCountryCode(globalConfigs.get("EAS_BillCountryCode"));
		DeliveredLogUtil.info("Bill Country Code :" + typeCustomer.getBillCountryCode());

		if (null != registrationMaster.getProdCatId() && registrationMaster.getProdCatId() == Constant.ZEROLUTION_BIZ_IND) {
			if (null != registrationMaster.getPortalCustInfo().getNewIc()
			    && registrationMaster.getPortalCustInfo().getNewIc().length() > 0) {

				typeCustomer.setIcNo(registrationMaster.getPortalCustInfo().getNewIc());
				typeCustomer.setIcType(globalConfigs.get("EAS_NewIcType"));

			} else {

				typeCustomer.setIcNo(registrationMaster.getPortalCustInfo().getPassportNo());
				typeCustomer.setIcType(globalConfigs.get("EAS_NewPassport"));

			}
			DeliveredLogUtil.info("Ic Type :" + typeCustomer.getIcType());
		} else {

			typeCustomer.setIcType(globalConfigs.get("EAS_IcType"));
			typeCustomer.setIcNo(registrationMaster.getCustBrnNo());
			DeliveredLogUtil.info("Ic Type :" + typeCustomer.getIcType());
		}

		return typeCustomer;
	}

	public EaiHeaderE getEaiHeaderForIOT() throws CallBackInternalException {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String timeReq = dateFormat.format(new Date());
			EaiHeader eaiHeader = new EaiHeader();
			eaiHeader.setFrom("EBDAPPDIRECT");
			DeliveredLogUtil.info("From  :" + eaiHeader.getFrom());
			eaiHeader.setTo("ESB");
			DeliveredLogUtil.info("To  :" + eaiHeader.getTo());
			eaiHeader.setAppId("OPF");
			DeliveredLogUtil.info("App Id  :" + eaiHeader.getAppId());
			eaiHeader.setMsgId(timeReq);
			DeliveredLogUtil.info("Msg Id :" + eaiHeader.getMsgId());
			eaiHeader.setMsgType("Request");
			DeliveredLogUtil.info("Msg Type  :" + eaiHeader.getMsgType());
			eaiHeader.setTimestamp(timeReq);
			DeliveredLogUtil.info("Time stamp :" + eaiHeader.getTimestamp());
			EaiHeaderE eaiHeaderE = new EaiHeaderE();
			eaiHeaderE.setEaiHeader(eaiHeader);
			return eaiHeaderE;
		} catch (Exception e) {
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			CallBackInternalException ce = new CallBackInternalException();
			ce.setExceptionIndicator("Y");
			ce.setExceptionMessage(e.getMessage());
			DeliveredLogUtil.info("Exception occurred :" + e.getMessage());
			throw ce;
		}
	}

	public static boolean insertTransWMActionIOT(PortalTransWMAction portalTransWmAction) {
		boolean insertSuccessCheck = false;
		if (portalTransWmAction != null) {
			try {
				brightStarMapClient.insert(Constant.insert_PortalTransWMActionIOT, portalTransWmAction);
				insertSuccessCheck = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				insertSuccessCheck = false;
				e.printStackTrace();

			}

		}
		return insertSuccessCheck;
	}

	public static boolean updateTransMsisdnIOT(Integer regId, Integer transMsid, String vsn, String status) {
		TransMsisdn transMsisdn = new TransMsisdn();
		transMsisdn.setWsStatus(status);
		transMsisdn.setRegId(regId);
		transMsisdn.setTransMsid(transMsid);
		transMsisdn.setPrefMsisdn(vsn);
		transMsisdn.setDateModified(new Date());
		boolean transUpdate = false;
		if (status.equalsIgnoreCase(Constant.Pending_Line_Prov)) {
			transMsisdn.setErrMsg("Successful");
		}
		if (status.equalsIgnoreCase(Constant.Failed_Line_Prov)) {
			transMsisdn.setErrMsg("Failed Service Creation");
		}

		if (regId != null) {
			try {
				brightStarMapClient.update(Constant.update_PortalTransMsisdnIOT, transMsisdn);
				transUpdate = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				transUpdate = false;
				e.printStackTrace();
			}
		}
		return transUpdate;

	}

	public static PortalTransWMAction formServiceOrderActionRNSIOT(String wmOrderId, TransMsisdn transMsisdn,
	    String wmActionCode, Integer retryCount, Integer regId) {
		if (regId != null) {
			PortalTransWMAction portalTrans = new PortalTransWMAction();
			portalTrans.setWmOrderId(wmOrderId);
			DeliveredLogUtil.info("insert in to trans wm action wm order id  :" + portalTrans.getWmOrderId());
			// easMsisdn.setEasMasterRegId(easMsisdnBackUp.getEasMasterRegId());
			// easMsisdn.setRegId(requestObjForSOType.getRegMasterList().get(0).getRegId());
			portalTrans.setRegId(regId);
			DeliveredLogUtil.info("insert in to trans wm action master reg id  :" + portalTrans.getRegId());
			portalTrans.setTransMsid(transMsisdn.getTransMsid());
			DeliveredLogUtil.info("insert in to trans wm action  :" + portalTrans.getTransMsid());
			portalTrans.setRetryCount(retryCount);
			DeliveredLogUtil.info("insert in to trans wm action retry count  :" + portalTrans.getRetryCount());
			portalTrans.setWmActionStatusCode(wmActionCode);
			DeliveredLogUtil.info("insert in to trans wm action wm action code :" + portalTrans.getWmActionStatusCode());
			portalTrans.setWmTriggerTime((new Date()));
			portalTrans.setWmStatus(Constant.request_not_sent);
			DeliveredLogUtil.info("insert in to trans wm action wm status :" + portalTrans.getWmStatus());
			portalTrans.setWmStatusMsg(Constant.request_not_sent_msg);
			DeliveredLogUtil.info("insert in to trans wm action wm status msg:" + portalTrans.getWmStatusMsg());
			portalTrans.setChannelId(Constant.CHANNEL_IOT);
			portalTrans.setDateCreated(new Date());
			portalTrans.setDateModified(new Date());
			return portalTrans;
		} else
			return null;
	}

	public static void updateStatusForChildMaster(Integer regId) throws CallBackInternalException {
		try {
			List<TransMsisdn> transMsisdnList = CommonUtil.fetchTransMsisdnList(regId);
			List<String> pendingStatusList = CommonUtil.formPendingStatus();
			List<String> failedStatusList = CommonUtil.formFailedStatus();
			Integer countPending = 0;
			Integer countSuccess = 0;
			Integer countFailed = 0;
			String statusChanged = "";
			for (Iterator iterator = transMsisdnList.iterator(); iterator.hasNext();) {
				TransMsisdn transMsisdn = (TransMsisdn) iterator.next();
				if (pendingStatusList.contains(transMsisdn.getWsStatus())) {
					countPending++;
				} else if (failedStatusList.contains(transMsisdn.getWsStatus())) {
					countFailed++;
				} else if (transMsisdn.getWsStatus().equalsIgnoreCase(Constant.Rejected)) {
					statusChanged = Constant.Rejected;
					break;
				} else if (transMsisdn.getWsStatus().equalsIgnoreCase(Constant.Failed_Service_creation)) {
					statusChanged = Constant.Failed_Service_creation;
					break;
				} else if (transMsisdn.getWsStatus().equalsIgnoreCase(Constant.Completed_Line_Prov)) {
					countSuccess++;
				}
			}
			PortalRegistrationMaster portalRegistrationMaster = new PortalRegistrationMaster();
			if (null != statusChanged && statusChanged.length() > 0) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(statusChanged);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countFailed.equals(transMsisdnList.size())) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Failed_System_Prov);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countSuccess.equals(transMsisdnList.size())) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Completed_System_Prov);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countPending.equals(transMsisdnList.size())) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Pending_System_Prov);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countSuccess > 0 && countPending > 0) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Partially_Completed);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countSuccess > 0 && countFailed > 0) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Partially_Completed);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countFailed > 0 && countPending > 0 && countSuccess == 0) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Pending_System_Prov);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countSuccess == 0 && countPending > 0 && (countFailed == 0 || countFailed > 0)) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Pending_System_Prov);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			} else if (countSuccess > 0) {
				portalRegistrationMaster.setRegId(regId);
				portalRegistrationMaster.setRegStatus(Constant.Partially_Completed);
				DeliveredLogUtil.info("updating the status for regid  :" + portalRegistrationMaster.getRegId()
				    + " with the status :" + portalRegistrationMaster.getRegStatus());
			}

			CommonUtil.updatePortalRegistrationMasterIOT(portalRegistrationMaster);
			PortalRegistrationMaster registrationMaster = CommonUtil.findRegistrationDetailsByRegId(regId);
			registrationMaster.setRegStatus(portalRegistrationMaster.getRegStatus());
			insertIntoPortalRegStatusFrTrackingIOT(registrationMaster);
			insertIntoAuditTrialFrTrackingIOT(registrationMaster);
		} catch (Exception e) {
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			CallBackInternalException ce = new CallBackInternalException();
			ce.setExceptionIndicator("Y");
			ce.setExceptionMessage(e.getMessage());
			DeliveredLogUtil.info("Exception occurred :" + e.getMessage());
			throw ce;
		}

	}

	public static boolean updatePortalRegistrationMasterIOT(PortalRegistrationMaster portalRegMaster) {
		boolean updateSuccess = false;
		if (portalRegMaster != null) {
			try {
				Date dateModified = new Date();
				portalRegMaster.setDateModified(dateModified);
				brightStarMapClient.update(Constant.update_PortalRegistrationMasterIOT, portalRegMaster);
				updateSuccess = true;
			} catch (SQLException e) {
				LogUtil.info("====== Exception Occured ========== " + e.getMessage());
				updateSuccess = false;
			}
		}
		return updateSuccess;
	}

	public static List<TransMsisdn> fetchTransMsisdnList(Integer regId) {
		List<TransMsisdn> transMsisdnList = null;
		TransMsisdn transMsisdn = new TransMsisdn();
		transMsisdn.setRegId(regId);
		try {
			transMsisdnList = (List<TransMsisdn>) brightStarMapClient.queryForList(Constant.select_TransMsisdnList,
			    transMsisdn);
		} catch (SQLException e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}
		if (transMsisdnList != null) {
			return transMsisdnList;
		} else {
			return null;
		}

	}

	public static List<String> formPendingStatus() {
		List<String> pendingStatusList = new ArrayList<String>();
		pendingStatusList.add(Constant.Pending_Line_Prov);
		pendingStatusList.add(Constant.Pending_System_Prov);
		pendingStatusList.add(Constant.Pending_Service_Creation);
		pendingStatusList.add(Constant.Pending_MNP);
		// pendingStatusList.add(CallBackConstants.Completed_Line_Prov);
		pendingStatusList.add(Constant.sent_for_device_fulfillment);
		pendingStatusList.add(Constant.Zerolution_Device_created);
		pendingStatusList.add(Constant.Zerolution_Device_pick_and_pack);
		pendingStatusList.add(Constant.Zerolution_Device_in_transit);
		pendingStatusList.add(Constant.Zerolution_Device_in_transit_attempt1);
		pendingStatusList.add(Constant.Zerolution_Device_in_transit_attempt_2);
		pendingStatusList.add(Constant.Zerolution_Device_in_transit_attempt_3);
		pendingStatusList.add(Constant.Zerolution_Device_fulfilled);
		pendingStatusList.add(Constant.Sent_for_Zerolution_Activation);
		pendingStatusList.add(Constant.pending_crr);
		pendingStatusList.add(Constant.Pending_Submission_BrightStar);
		pendingStatusList.add(Constant.Completed_Submission_BrightStar);
		pendingStatusList.add(Constant.Sent_For_Zerolution_SvcChange);
		pendingStatusList.add(Constant.Zerolution_Device_fulfilled);
		// pendingStatusList.add(CallBackConstants.Port_In_Committed);
		pendingStatusList.add(Constant.Processing);
		// pendingStatusList.add("ZDFA");
		return pendingStatusList;

	}

	public static List<String> formFailedStatus() {
		List<String> failedStatusList = new ArrayList<String>();
		failedStatusList.add(Constant.Zerolution_Device_failed);
		failedStatusList.add(Constant.Zerolution_Device_cancelled);
		failedStatusList.add(Constant.Failed_Line_Prov);
		failedStatusList.add(Constant.Failed_System_Prov);
		failedStatusList.add(Constant.Failed_Service_creation);
		failedStatusList.add(Constant.Zerolution_Activation_Failed);
		failedStatusList.add(Constant.Zerolution_SVC_Failed);
		failedStatusList.add(Constant.FAILED_STATUS);
		// failedStatusList.add(CallBackConstants.PortIn_Failed_Close_Order);

		return failedStatusList;

	}

	public static void insertIntoPortalRegStatusFrTrackingIOT(PortalRegistrationMaster registrationMaster) {

		PortalRegistrationStatus portalRegistrationStatus = new PortalRegistrationStatus();
		PortalRegistrationStatus regStatusId = CommonUtil.getRegStatusId_Delivered();
		portalRegistrationStatus.setRegStatusId(regStatusId.getRegStatusSequence());
		DeliveredLogUtil.info("insert into portal registration status :");
		portalRegistrationStatus.setRegId(registrationMaster.getRegId());
		DeliveredLogUtil.info("insert into portal registration status reg id :" + portalRegistrationStatus.getRegId());
		portalRegistrationStatus.setCreateUserId(registrationMaster.getCreatedBy());
		DeliveredLogUtil
		    .info("insert into portal registration status created by :" + portalRegistrationStatus.getCreateUserId());
		portalRegistrationStatus.setDateCreated(new Date(System.currentTimeMillis()));
		DeliveredLogUtil
		    .info("insert into portal registration status created date :" + portalRegistrationStatus.getDateCreated());
		portalRegistrationStatus.setRegStatus(registrationMaster.getRegStatus());
		DeliveredLogUtil
		    .info("insert into portal registration status reg status :" + portalRegistrationStatus.getRegStatus());
		portalRegistrationStatus.setRemarks(registrationMaster.getRemarks());
		DeliveredLogUtil.info("insert into portal registration status remarks :" + portalRegistrationStatus.getRemarks());
		if (portalRegistrationStatus != null) {
			try {
				brightStarMapClient.insert(Constant.insert_PortalRegStatusIOT, portalRegistrationStatus);

			} catch (SQLException e) {

				LogUtil.info("====== Exception Occured ========== " + e.getMessage());

			}
		}
	}

	public static void insertIntoAuditTrialFrTrackingIOT(PortalRegistrationMaster registrationMaster) {

		AuditTrail auditTrail = new AuditTrail();
		AuditTrail auditTrailId = new AuditTrail();
		auditTrailId = UpdateDeliveryConfirmation.getAuditSeqNo_Delivered();
		auditTrail.setAuditId(auditTrailId.getAuditSeqNo());
		auditTrail.setRegId(registrationMaster.getRegId());
		DeliveredLogUtil.info("insert into Audit trail status :");
		DeliveredLogUtil.info("insert into Audit trail reg id :" + auditTrail.getRegId());
		auditTrail.setAccessBy(registrationMaster.getCreatedBy());
		DeliveredLogUtil.info("insert into Audit trail created by:" + auditTrail.getAccessBy());
		auditTrail.setActivity("updating the status as :" + registrationMaster.getRegStatus());
		DeliveredLogUtil.info("insert into Audit trail Activity :" + auditTrail.getActivity());
		auditTrail.setRemarks(registrationMaster.getRemarks());
		DeliveredLogUtil.info("insert into Audit trail Remarks :" + auditTrail.getRemarks());
		auditTrail.setAuditDate(new Date());
		if (auditTrail != null) {
			try {
				brightStarMapClient.insert(Constant.insert_AuditTrailIOT, auditTrail);

			} catch (SQLException e) {

				LogUtil.info("====== Exception Occured ========== " + e.getMessage());

			}
		}
	}

	public static PortalRegistrationStatus getRegStatusId_Delivered() {
		PortalRegistrationStatus portalRegStatus = new PortalRegistrationStatus();
		try {
			portalMapClient = ThreeGplSqlConfig.getSqlMapInstance();

			portalRegStatus = (PortalRegistrationStatus) portalMapClient.queryForObject(Constant.select_reg_status_sequence);
			DeliveredLogUtil
			    .info("======== DeliveredServlet Audit Seq No  ======== " + portalRegStatus.getRegStatusSequence());
		} catch (Exception ex) {
			DeliveredLogUtil.info("======== DeliveredServlet get AM IN EXCEPTION ======== " + ex.getMessage());
		}
		return portalRegStatus;
	}

	public static ExternalIdList[] setExternalIdListIOT(TransMsisdn transMsisdn) throws CallBackInternalException {
		try {

			Integer ratePlanId = CommonUtil.getRatePlanId(transMsisdn.getTransMsid());
			String customerId = CommonUtil.getCutomerId(ratePlanId);
			String customerIdArray[] = customerId.split(",");
			String cspName = CommonUtil.getCSPName(ratePlanId);
			String cspNameArray[] = cspName.split(",");

			int externalIdListLength = 2;
			// size of externalId list is made from customerId length and cspName length
			if (cspNameArray.length > 0) {
				externalIdListLength += cspNameArray.length;
			} else {
				externalIdListLength++;
			}

			// size of externalId list is made from customerId length and cspName length
			if (customerIdArray.length > 0) {
				externalIdListLength += customerIdArray.length;
			} else {
				externalIdListLength++;
			}

			ExternalIdList[] externalIdList = new ExternalIdList[externalIdListLength];
			int i = 0;
			externalIdList[i] = new ExternalIdList();
			externalIdList[i].setExternalIdType(Constant.externalIdType_servicename);
			DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
			externalIdList[i].setExternalId(CommonUtil.getIMEI(transMsisdn.getTransMsid()));
			DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
			externalIdList[i].setActionType(Constant.vsn_action_type);
			DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
			i++;

			externalIdList[i] = new ExternalIdList();
			externalIdList[i].setExternalIdType(Constant.externalIdType_subsciptionkey);
			DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
			externalIdList[i].setExternalId(CommonUtil.getICCID(transMsisdn.getTransMsid()));
			DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
			externalIdList[i].setActionType(Constant.vsn_action_type);
			DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
			i++;

			if (cspNameArray.length > 0) {
				for (int counter = 0; counter < cspNameArray.length; counter++) {
					if (cspNameArray[counter] != null) {
						externalIdList[i] = new ExternalIdList();
						externalIdList[i].setExternalIdType(Constant.cspName);
						DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
						externalIdList[i].setExternalId(cspNameArray[counter]);
						DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
						externalIdList[i].setActionType(Constant.vsn_action_type);
						DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
						i++;
					}
				}
			} else {
				// change values of exteranlId
				externalIdList[i] = new ExternalIdList();
				externalIdList[i].setExternalIdType(Constant.cspName);
				DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
				externalIdList[i].setExternalId(cspName);
				DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
				externalIdList[i].setActionType(Constant.vsn_action_type);
				DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
				i++;
			}

			// size of externalId list is made from customerId length and cspName length
			if (customerIdArray.length > 0) {
				for (int counter = 0; counter < customerIdArray.length; counter++) {
					if (customerIdArray[counter] != null) {
						// change values of exteranlId
						externalIdList[i] = new ExternalIdList();
						externalIdList[i].setExternalIdType(Constant.customerId);
						DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
						externalIdList[i].setExternalId(customerIdArray[counter]);
						DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
						externalIdList[i].setActionType(Constant.vsn_action_type);
						DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
						i++;
					}
				}
			} else {
				// change values of exteranlId
				externalIdList[i] = new ExternalIdList();
				externalIdList[i].setExternalIdType(Constant.customerId);
				DeliveredLogUtil.info("External Id Type  :" + externalIdList[i].getExternalIdType());
				externalIdList[i].setExternalId(customerId);
				DeliveredLogUtil.info("External Id  :" + externalIdList[i].getExternalId());
				externalIdList[i].setActionType(Constant.vsn_action_type);
				DeliveredLogUtil.info("Action type  :" + externalIdList[i].getActionType());
			}

			return externalIdList;
		} catch (Exception e) {
			DeliveredLogUtil.info("********************************Exception occurred :" + e.getMessage());
			CallBackInternalException ce = new CallBackInternalException();
			ce.setExceptionIndicator("Y");
			ce.setExceptionMessage(e.getMessage());
			DeliveredLogUtil.info("Exception occurred :" + e.getMessage());
			throw ce;
		}
	}

	public static Integer getRatePlanId(Integer transMsid) {
		TransMsisdn transMsisdn = new TransMsisdn();

		try {
			if (transMsid != null) {
				transMsisdn.setTransMsid(transMsid);
				transMsisdn = (TransMsisdn) brightStarMapClient.queryForObject(Constant.select_ratePlanId, transMsisdn);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (transMsisdn != null) {
			return transMsisdn.getRateplanId();
		} else {
			return null;
		}
	}

	public static String getCutomerId(Integer ratePlanId) {
		PortalRefRatePlanMap portalRefRatePlanMap = new PortalRefRatePlanMap();

		try {
			if (ratePlanId != null) {
				portalRefRatePlanMap.setRatePlanId(ratePlanId);
				portalRefRatePlanMap.setKeyName(Constant.CUSTOMER_ID);
				portalRefRatePlanMap = (PortalRefRatePlanMap) brightStarMapClient.queryForObject(Constant.select_customerId,
				    portalRefRatePlanMap);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (portalRefRatePlanMap != null) {
			return portalRefRatePlanMap.getKeyValue();
		} else {
			return null;
		}
	}

	public static String getCSPName(Integer ratePlanId) {
		PortalRefRatePlanMap portalRefRatePlanMap = new PortalRefRatePlanMap();

		try {
			if (ratePlanId != null) {
				portalRefRatePlanMap.setRatePlanId(ratePlanId);
				portalRefRatePlanMap.setKeyName(Constant.CSP_NAME);
				portalRefRatePlanMap = (PortalRefRatePlanMap) brightStarMapClient.queryForObject(Constant.select_customerId,
				    portalRefRatePlanMap);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (portalRefRatePlanMap != null) {
			return portalRefRatePlanMap.getKeyValue();
		} else {
			return null;
		}
	}

	public static String getIMEI(Integer transMsid) {
		TransServiceAttribute transServiceAttribute = new TransServiceAttribute();

		try {
			if (transMsid != null) {
				transServiceAttribute.setTransMsid(transMsid);
				transServiceAttribute.setHeaderName(Constant.IMEI);
				transServiceAttribute = (TransServiceAttribute) brightStarMapClient.queryForObject(Constant.select_IMEIICCID,
				    transServiceAttribute);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (transServiceAttribute != null) {
			return transServiceAttribute.getValue();
		} else {
			return null;
		}
	}

	public static String getICCID(Integer transMsid) {
		TransServiceAttribute transServiceAttribute = new TransServiceAttribute();

		try {
			if (transMsid != null) {
				transServiceAttribute.setTransMsid(transMsid);
				transServiceAttribute.setHeaderName(Constant.ICCID);
				transServiceAttribute = (TransServiceAttribute) brightStarMapClient.queryForObject(Constant.select_IMEIICCID,
				    transServiceAttribute);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (transServiceAttribute != null) {
			return transServiceAttribute.getValue();
		} else {
			return null;
		}
	}

	public static String getStatusOfMegaFortrisTask(Integer transMsid) {
		Task task = new Task();

		try {
			if (transMsid != null) {
				task.setTransMsid(transMsid);
				task.setTaskId(Constant.MegaFortrisTask);
				task.setOwnerRoleId(Constant.megaFortris);
				task = (Task) brightStarMapClient.queryForObject(Constant.select_StatusOfMegafortrisTask, task);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (task != null) {
			return task.getStatus();
		} else {
			return null;
		}
	}

	public static String getStatusOfBrightStarTask(Integer transMsid) {
		Task task = new Task();

		try {
			if (transMsid != null) {
				task.setTransMsid(transMsid);
				task.setTaskId(Constant.brightStarTask);
				task.setOwnerRoleId(Constant.brightStarOwner);
				task = (Task) brightStarMapClient.queryForObject(Constant.select_StatusOfMegafortrisTask, task);
			}
		} catch (Exception e) {
			LogUtil.info("====== Exception Occured ========== " + e.getMessage());
		}

		if (task != null) {
			return task.getStatus();
		} else {
			return null;
		}
	}
}
