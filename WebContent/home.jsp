<%@ page import="com.maxis.constant.ConfigurationManager"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.maxis.db.MaxisEbdPortal"%>
<%@ page import="com.maxis.db.DeviceData"%>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page import="com.maxis.config.BrightstarSqlConfig"%>
<%@ page import="com.maxis.constant.Constant"%>
<%@ page import="org.apache.commons.httpclient.util.DateUtil"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maxis.constant.CommonUtil"%>
<%@ page import="org.apache.commons.logging.Log"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="REFRESH" content="20" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/maxis.css" />
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/js/ajax1.js"></script>
<title>MIMSPostTestEnv</title>
<script type="text/javascript">

    function xmlServletHttpPostTest(params, regId, orderNo,deviceOrderNo) {

        var f = document.sform;
        var xmlHttpReq = newXMLHttpRequest();

        var responseStatus = '';
        var mimsStatus = '';
        //UAT URL
        var url="http://172.21.3.158:8080/EBDConnectorWS/Web/SalesOrderCreate.aspx";
        
        //var url="http://retail.men.maxis.com.my:8080/EBDConnectorWS/Web/SalesOrderCreate.aspx?";
        
        //below is prod url
    	//var url="http://retail.men.maxis.com.my:8080/EBDConnectorWS/Web/SalesOrderCreate.aspx?";
		alert('params: '+params);
      	xmlHttpReq.open('POST', url, true);
        xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xmlHttpReq.onreadystatechange = function(){
		if(xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
            responseStatus = xmlHttpReq.responseText;
            if(responseStatus.indexOf("1|OK")!=-1){
            	
                    document.getElementById("contents").innerHTML = params;
                    document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
                    mimsStatus = 'S';
                    updatepage(responseStatus, regId, mimsStatus, orderNo,deviceOrderNo);
                    
            }else{
                if (responseStatus.indexOf("Duplicate order")!=-1){
                	alert('Duplicate Order');
                    document.getElementById("contents").innerHTML = params;
		            document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
                    mimsStatus = 'M';
                    updateStatusToM(responseStatus, regId, mimsStatus, orderNo,deviceOrderNo);
                } else {
                    alert('Response Failed ' + responseStatus);
                    document.getElementById("contents").innerHTML = params;
		            document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
                }
            }
         }
            
        }
        xmlHttpReq.send(params);
    }

    function updatepage(resXML, id, status, orderNo,deviceOrderNo) {
        var f = document.sform;
        f.action= "<%=request.getContextPath()%>/servlet/ClientPost?id="+id+"&status="+status+"&orderNo="+orderNo+"&deviceOrderNo="+deviceOrderNo;
        f.submit();
    }

    function updateStatusToM(resXML, id, status, orderNo,deviceOrderNo) {
        var f = document.sform;
        f.action= "<%=request.getContextPath()%>/servlet/ClientPost?id="+id+"&status="+status+"&orderNo="+orderNo+"&deviceOrderNo="+deviceOrderNo;
        f.submit();
    }

    function delayer2(){
        window.location = "http://10.200.52.223:8080/EbdPortalConsumerOrdering/";
    }


</script>
</head>

<body>
	<%
    Calendar cal = Calendar.getInstance();
    System.out.println("Hour of the Day : " + cal.get(Calendar.HOUR_OF_DAY));
    int hoday = cal.get(Calendar.HOUR_OF_DAY);   
%>
	<form action="/servlet/ClientPost" method="post" id="sform"
		name="sform">
		<%
    int recCtr = 0;
    SqlMapClient brightStarMapClient = null;

    brightStarMapClient = BrightstarSqlConfig.getSqlMapInstance();

    Log log = LogFactory.getLog(this.getClass());

%>

		<table>

			<tr style="font-family: Verdana; font-size: 14px; font-weight: bold;"
				height="18">
				<td colspan="14">Maxis Inventory Management System - MIMS</td>
			</tr>

			<tr style="font-family: Verdana; font-size: 10px; font-weight: bold;"
				height="18">
				<td colspan="14">&nbsp;</td>
			</tr>

			<tr style="font-family: Verdana; font-size: 10px; font-weight: bold;"
				height="18">
				<td colspan="14">EBDPortal Consumer Order [Maxis > B*]</td>
			</tr>

			<tr style="font-family: Verdana; font-size: 10px; font-weight: bold;"
				height="18">
				<td colspan="14">&nbsp;</td>
			</tr>

			<tr style="font-family: Verdana; font-size: 10px; font-weight: bold;"
				height="18">
				<td bgcolor="#4169e1"><font color="#FFFFFF">Reg Id</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Brn</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Company Name</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Customer
					Name</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Bill
					Address1</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">L1</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Bill
					Address2</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">L2</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Bill
					Address3</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Order No</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">IC No</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Msisdn</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Phone Order
					Status</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Device Name</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Topup Amount</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Subsidy
					Amount</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Market Type</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Reg Type</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">Reg Date
					Approved</font></td>
				<td bgcolor="#4169e1"><font color="#FFFFFF">MIMS Post</font></td>
			</tr>

			<%
        List aList = null;

        aList = brightStarMapClient.queryForList(Constant.SELECT_EBDPORTAL_MIMS, null);
        int i = 0;
        log.info("==== Total no of Records fetched from DB  " + aList.size());

        String todayDate = DateUtil.formatDate(new java.util.Date(), "dd/MM/yyyy HH:mm:ss");

        String paramOrder = "";
        String deviceOrderNo="";
        String strTT = "|TT|MW|";
        String strFF = "|FF|MW|";

        if (aList != null && aList.size() > 0) {
            MaxisEbdPortal maxisData = new MaxisEbdPortal();
            for (Iterator<MaxisEbdPortal> j = aList.iterator(); j.hasNext();) {
                maxisData = (MaxisEbdPortal) j.next();
                try {

                    /*
                       Template Data
                       ============================================================================================================================
                           Data Set Example - Sent to MIMS Upload.
                           urlParam1 :

                               < strOrderPrefix - RR RRT RRF>   RR + <OrderId>                                                                                   |               |
                               RR - on-site but customers havent get the phone
                               RRT - RR with top up amount
                               RRF - free phone

                              < OrderID >
                              20537

                              <Name>
                              GOH CHOO KWOK

                              <MSISDN>
                              125043269

                              <Addr1><Addr2><Addr3>
                              NO 8 FIRST AVENUE PLAZA IBM
                              <city>
                              KL
                              <State>
                              WP Kuala Lumpur
                              <Postcode>
                              48700
                              <Country>
                              MY

                              <DealerConsumerOrderProduct> Object[]
                              <ProductID>
                              45
                              <ColorId>
                              13
                              <Quantity>
                              1 or 2
                              <DeliveryDT = PreffereDateDelivery>
                              11/13/2009 12:00:00
                              <Remarks>
                              ||
                              <RatePlan>
                              Mobile Value Plus 50
                              <AccountNo>
                              ||
                              <NRIC_no>
                              780703-10-5184
                              <TotalAmt = TotalTopupAmount>
                              200
                              <PenaltyDetails><OfferOption><ReceiptNo><CenterDesc>
                              |||||
                              <OfferName = BrandName <space> ModelName>
                              Nokia	3120
                              Sony Ericsson	K320i
                              <HLR>
                              14 = Business Value Plus (Brightstar)
                              16 = Citibank Upgrade n' Save
                              if {14} - VP - Upgrade n' Save
                              if {16} - CB - Upgrade n' Save
                              <ContactNo = MSISDN>
                              125043269
                              <Fullfilment>
                              D - Courier
                              0 - B* HQ

                              <CompanyName>
                              <FixLineNo>
                              <BizUnitId>

                    */

					maxisData.setTopupAmount(0);


                    if(CommonUtil.getObjectParam(maxisData.getPhoneSubsidyAmount())==null || CommonUtil.getObjectParam(maxisData.getPhoneSubsidyAmount()).trim().equalsIgnoreCase("") ){
                    	maxisData.setPhoneSubsidyAmount(maxisData.getPhoneSubsidyAmount());
                    }
                    
                    String topup = CommonUtil.getObjectParam(maxisData.getTopupAmount());
                    String tt = "";

                    /* if(new Integer(topup).intValue() > 0){
                         tt = strTT;
                    } else */ 
                    if(new Integer(topup).intValue() == 0){
                         tt = strFF;
                    } else{
                         tt = "||||";
                    }

                    String strOrderPrefix = CommonUtil.getOrderPrefixStr(CommonUtil.getObjectParam(maxisData.getOrderNo()), CommonUtil.getObjectParam(maxisData.getMarketType()), CommonUtil.getObjectParam(maxisData.getTopupAmount()));


                    String delContactName = CommonUtil.getObjectParam(maxisData.getDelContactName());


                    String msisdn = null;

                    if(maxisData.getMsisdn()!=null){

                     msisdn = CommonUtil.getObjectParam(maxisData.getMsisdn().substring(0, maxisData.getMsisdn().length()));
                    }
  

                     DeviceData deviceData=new DeviceData();

                     String brandModelName=null;

                     String deviceId =null;

                     String colorId=null;
                     if(msisdn!=null){
                     if(msisdn.contains("FLEXI_FUND_DEVICE_")){

                         if(maxisData.getVirtualServiceNumber() != null){

                              maxisData.setMsisdn(CommonUtil.getObjectParam(maxisData.getVirtualServiceNumber()));

                               msisdn=CommonUtil.getObjectParam(maxisData.getVirtualServiceNumber());

                               System.out.println("order no"+maxisData.getOrderNo());

                             deviceData=(DeviceData)brightStarMapClient.queryForObject(Constant.SELECT_EBDPORTALFLEXIFUNDDEVICE, maxisData);

                              brandModelName = CommonUtil.getObjectParam(deviceData.getDeviceName()).replaceAll(",", " ");

                             deviceId = CommonUtil.getObjectParam(deviceData.getMimsDeviceId());

                             colorId = CommonUtil.getObjectParam(deviceData.getMimsColorId());

                             maxisData.setDeviceName(deviceData.getDeviceName());

                                       maxisData.setMimsDeviceId(deviceData.getMimsDeviceId());

                                       maxisData.setMimsColorId(deviceData.getMimsColorId());

                         }

                     }
                     else{

                         deviceData=(DeviceData)brightStarMapClient.queryForObject(Constant.SELECT_EBDPORTALDEVICE, maxisData);

                         brandModelName = CommonUtil.getObjectParam(deviceData.getDeviceName()).replaceAll(",", " ");

                         deviceId = CommonUtil.getObjectParam(deviceData.getMimsDeviceId());

                         colorId = CommonUtil.getObjectParam(deviceData.getMimsColorId());

                         maxisData.setDeviceName(deviceData.getDeviceName());

                         maxisData.setMimsDeviceId(deviceData.getMimsDeviceId());

                         maxisData.setMimsColorId(deviceData.getMimsColorId());

                   }
                     }

                     else{

                           deviceData=(DeviceData)brightStarMapClient.queryForObject(Constant.SELECT_EBDPORTALDEVICE, maxisData);

                           brandModelName = CommonUtil.getObjectParam(deviceData.getDeviceName()).replaceAll(",", " ");

                           deviceId = CommonUtil.getObjectParam(deviceData.getMimsDeviceId());
                           colorId = CommonUtil.getObjectParam(deviceData.getMimsColorId()); 
                           maxisData.setDeviceName(deviceData.getDeviceName());
                 		  maxisData.setMimsDeviceId(deviceData.getMimsDeviceId());
                 		  maxisData.setMimsColorId(deviceData.getMimsColorId());
                    }

                    String delAdd1 = CommonUtil.getObjectParam(maxisData.getDelAdd1());


                    String delAdd2 = CommonUtil.getObjectParam(maxisData.getDelAdd2());


                    String delAdd3 = CommonUtil.getObjectParam(maxisData.getDelAdd3());


                    String city = CommonUtil.getObjectParam(maxisData.getDelAdd3());


                    String billState = CommonUtil.getObjectParam(CommonUtil.getState(maxisData.getDelState()));


                    String billPostcode = CommonUtil.getObjectParam(maxisData.getDelPostcode());


                    String billCountry = CommonUtil.getObjectParam("MY");


                    String quantity = CommonUtil.getObjectParam("1");


                    String preffereDateDelivery = CommonUtil.getDateTime();
                    
                    
                    String ebdMasterId = !CommonUtil.getObjectParam(maxisData.getEasMasterRegId()).equals("")?CommonUtil.getObjectParam(maxisData.getEasMasterRegId()):CommonUtil.getObjectParam(maxisData.getRegId());
                    
                    String primaryContactEmail= CommonUtil.getObjectParam(maxisData.getPrimaryContactEmail());
                    
                    String secondaryPicName= CommonUtil.getObjectParam(maxisData.getSecondaryPicName());

                    String secondaryPicContactNo= CommonUtil.getObjectParam(maxisData.getSecondaryContactMobileNo());
                    
                    String secondaryContactFixedNo= CommonUtil.getObjectParam(maxisData.getSecondaryContactFixedNo());
                    
                    String secondaryPicEmail= CommonUtil.getObjectParam(maxisData.getSecondaryPicEmail());
                    
                    String secondaryPicIc= CommonUtil.getObjectParam(maxisData.getSecondaryPicIc());
                    

                    
                    //String remarks = "Order From EBD Portal";
                    String remarks = null;          

                    if (maxisData.getVerifiedRemark() != null)
                    	remarks = CommonUtil.getObjectParam(maxisData.getVerifiedRemark().substring(0, maxisData.getVerifiedRemark().length()));
                    else 
                    	remarks = "Order From EBD Portal";        

                    //String remarks = CommonUtil.getObjectParam(maxisData.getVerifiedRemark().substring(0, maxisData.getVerifiedRemark().length()));


                    String rateplan = CommonUtil.getObjectParam(maxisData.getRateplan());


                    String accountNo = CommonUtil.getObjectParam(maxisData.getAccountNo());


                    String nricNo = CommonUtil.getObjectParam(maxisData.getDelContactIc());


                    String topupAmount = CommonUtil.getObjectParam(maxisData.getTopupAmount());


                    //String penaltyOptions = "|Test|Offer||EBD Centre|";

                    String penaltyOptions = "";
                    if(maxisData.getImeiCompt()!=null)
                        penaltyOptions = CommonUtil.getObjectParam(maxisData.getImeiCompt());
                    else
                        penaltyOptions = "Test";
                    

                  


                    String offerName = CommonUtil.getOfferName(CommonUtil.getObjectParam(maxisData.getPromoId()));


                    String contactNo = CommonUtil.getObjectParam(maxisData.getDelContactPhoneNo());


                    String fullfillment = CommonUtil.getObjectParam("D");

                    String companyName =  CommonUtil.getObjectParam(maxisData.getCompanyName());

                    String contactNoFix = "";

                    if(maxisData.getContactNoFix() != null){
                        contactNoFix = CommonUtil.getObjectParam(maxisData.getContactNoFix().trim());
                    }else{
                        contactNoFix = "0";
                    }

                    String bizUnitId =  CommonUtil.getBizUnitID(CommonUtil.getObjectParam(maxisData.getMarketType()));


                    paramOrder = tt + strOrderPrefix + "|" + delContactName + "|" + msisdn + "|" + delAdd1 + "|" + delAdd2 + "|" + delAdd3 + "|" + city + "|" + billState + "|" + billPostcode + "|" + billCountry + "|" + deviceId + "|" + colorId + "|" + quantity + "|" + preffereDateDelivery + "|" + remarks + "|" + rateplan + "|" + accountNo + "|" + nricNo + "|" + topupAmount + "|" + penaltyOptions + "|Offer|" + strOrderPrefix + "|EBD Center|" + brandModelName + "|" + "1" + "|0|" + contactNo + "|" + fullfillment + "|1|"+ companyName + "|" + contactNoFix + "|" + bizUnitId+ "|" + ebdMasterId + "|" +primaryContactEmail+ "|" +secondaryPicName+ "|" + secondaryPicIc+ "|" + secondaryPicEmail+ "|" + secondaryPicContactNo+ "|" + secondaryContactFixedNo;
                    deviceOrderNo=strOrderPrefix;
                    //paramOrder = "|TT|MW|RRTS400001|NG CHIN HONG|0124780268|Test Address 1 Jalan 2/567H, Ampang park|Test Address 2 Jalan Ampang, Near KLCC|SIMPANG AMPAT|SIMPANG AMPAT|PG|14100|MY|651|430|1|05/04/2011 14:26:23|Test Remarks Phone Order| Value Plus 150(BB)|832364400|741214075779|190|Test|Offer|RRTS400001|EBD Center|B* iPhone4 (16GB) Black|1|0|60124780268/6045023488|D|1|EE JIA HOUSEWARES (M) SDN BH|60327814100|2";

                    i++;

                } catch (Exception ex) {
                    log.info("Iam in Exception " + ex.getMessage());
                }

    %>

			<tr style="font-family: Verdana; font-size: 10px; font-weight: bold;"
				height="18">
				<td><%=maxisData.getRegId()%></td>
				<td><%=maxisData.getCustBrn()%></td>
				<td><%=maxisData.getCompanyName()%></td>
				<td><%=maxisData.getDelContactName()%></td>
				<td><%=maxisData.getDelAdd1()%></td>
				<td><%=maxisData.getDel1Length()%></td>
				<td><%=maxisData.getDelAdd2()%></td>
				<td><%=maxisData.getDel2Length()%></td>
				<td><%=maxisData.getDelAdd3()%></td>
				<td><%=maxisData.getOrderNo()%></td>
				<td><%=maxisData.getNewIc()%></td>
				<td><%=maxisData.getMsisdn()%></td>
				<td><%=maxisData.getPhoneOrderStatus()%></td>
				<td><%=maxisData.getDeviceName()%></td>
				<td><%=maxisData.getTopupAmount()%></td>
				<td><%=maxisData.getPhoneSubsidyAmount()%></td>
				<td><%=maxisData.getMarketType()%></td>
				<td><%=maxisData.getRegType()%></td>
				<td><%=DateUtil.formatDate(maxisData.getRegDateApproved(), "dd/MM/yyyy")%></td>

				<td><a
					href="javascript:xmlServletHttpPostTest('<%=paramOrder%>', '<%=maxisData.getRegId()%>', '<%=maxisData.getOrderNo()%>', '<%=deviceOrderNo%>');">BrightStar</a></td>
			</tr>

			<input type="hidden" name="paramOrder" value="<%=paramOrder%>"
				id="paramOrder" />
			<input type="hidden" name="regId" value="<%=maxisData.getRegId()%>"
				id="regId" />
			<input type="hidden" name="orderNo"
				value="<%=maxisData.getOrderNo()%>" id="orderNo" />

			<%
             if(i == 1){

                 log.info("====== regId =======" + CommonUtil.getObjectParam(maxisData.getRegId()));
                 log.info("====== orderNo =======" + CommonUtil.getObjectParam(maxisData.getOrderNo()));
                 log.info("====== strOrderPrefix =======" + CommonUtil.getOrderPrefixStr(CommonUtil.getObjectParam(maxisData.getOrderNo()), CommonUtil.getObjectParam(maxisData.getMarketType()), CommonUtil.getObjectParam(maxisData.getTopupAmount())));
                 log.info("====== custName == delContactName=======" + CommonUtil.getObjectParam(maxisData.getDelContactName()));
                 if(maxisData.getMsisdn()!= null){
                     log.info("====== msisdn =======" + CommonUtil.getObjectParam(maxisData.getMsisdn().substring(1, maxisData.getMsisdn().length())));
                 }
                 else{
                     log.info("====== msisdn =======" + maxisData.getMsisdn());

                 }
                 log.info("====== delAdd1 =======" + CommonUtil.getObjectParam(maxisData.getDelAdd1()));
                 log.info("====== delAdd2 =======" + CommonUtil.getObjectParam(maxisData.getDelAdd2()));
                 log.info("====== delAdd3 =======" + CommonUtil.getObjectParam(maxisData.getDelAdd3()));
                 log.info("====== city =======" + maxisData.getDelAdd3());
                 log.info("====== delState =======" + CommonUtil.getObjectParam(CommonUtil.getState(maxisData.getDelState())));
                 log.info("====== delPostcode =======" + CommonUtil.getObjectParam(maxisData.getDelPostcode()));
                 log.info("====== delCountry =======" + CommonUtil.getObjectParam("MY"));
                 log.info("====== deviceId =======" + CommonUtil.getObjectParam(maxisData.getMimsDeviceId()));
                 log.info("====== colorId =======" + CommonUtil.getObjectParam(maxisData.getMimsColorId()));
                 log.info("====== quantity =======" + CommonUtil.getObjectParam("1"));
                 log.info("====== getDateTime =======" + CommonUtil.getDateTime());
                 log.info("====== remarks =======" + "Order From EBD Portal");
                 log.info("====== rateplan =======" + CommonUtil.getObjectParam(maxisData.getRateplan()));
                 log.info("====== accountNo =======" + maxisData.getAccountNo());
                 log.info("====== NRIC_no == delContactIC =======" + CommonUtil.getObjectParam(maxisData.getDelContactIc()));
                 log.info("====== topupAmount =======" + CommonUtil.getObjectParam(maxisData.getTopupAmount()));
                 log.info("====== <PenaltyDetails><OfferOption><ReceiptNo><CenterDesc> =======" + "|||||");
                 log.info("====== BrandModelName =======" + CommonUtil.getObjectParam(maxisData.getDeviceName()).replaceAll(",", " "));
                 log.info("====== offerName =======" + CommonUtil.getOfferName(CommonUtil.getObjectParam(maxisData.getPromoId())));
                 log.info("====== contactNo =======" + CommonUtil.getObjectParam(maxisData.getDelContactPhoneNo()));
                 log.info("====== Fullfilment =======" + CommonUtil.getObjectParam("D"));
                 log.info("====== companyName =======" + CommonUtil.getObjectParam(maxisData.getCompanyName()));
                 log.info("====== contactNoFix =======" + CommonUtil.getObjectParam(maxisData.getContactNoFix()));
                 log.info("====== bizUnitId =======" + CommonUtil.getBizUnitID(CommonUtil.getObjectParam(maxisData.getMarketType())));

                 log.info("paramOrder = " + paramOrder);
                 log.info("deviceOrderNo=" + deviceOrderNo);

    %>

			<script type="text/javascript">
                //alert(document.getElementById("paramOrder").value);
                //alert(document.getElementById("regId").value);
                //alert(document.getElementById("orderNo").value);
                 xmlServletHttpPostTest(document.getElementById("paramOrder").value, document.getElementById("regId").value, document.getElementById("orderNo").value,"<%=deviceOrderNo%>");
            </script>


			<%
              }
            } // end of FOR Loop
        } //end of IF
    %>

		</table>

		<table>
			<tr height="50">
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
					<h4>
						No Of Records :
						<%=i%></h4>
				</td>
			</tr>

			<tr height="50">
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
					<h4>Parameters</h4>
					<ul id="contents">
					</ul>
				</td>
			</tr>

			<tr height="50">
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
					<h4>Response Text</h4>
					<ul id="respondTxt">
					</ul>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>
