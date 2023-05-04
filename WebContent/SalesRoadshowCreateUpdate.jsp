<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.maxis.db.MaxisEbdPortal"%>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
<%@ page import="com.maxis.constant.Constant" %>
<%@ page import="java.util.*" %>
<%@ page import="com.maxis.constant.CommonUtil" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="com.maxis.config.BrightstarRoadShowConfig" %>
<%@ page import="com.maxis.log.RoadShowLogUtil" %>
<%@ page import="org.apache.commons.httpclient.util.DateUtil" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="REFRESH" content="12" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/maxis.css" />
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/ajax1.js"></script>
<title>MIMSPostTestEnv</title>

<script type="text/javascript">

    function xmlServletHttpPostTest(params, regId, orderNo) {

        var f = document.sform;
        var xmlHttpReq = newXMLHttpRequest();

        var responseStatus = '';
        var mimsStatus = '';

        // var url = "https://retail.maxis.net.my:8443/test/EBDConnectorWS/Web/SalesOrderCreate.aspx?";
        
        //var url = "https://retail.maxis.net.my:8443/EBDConnectorWS/Web/SalesOrderCreate.aspx?";

        //var url ="https://retailuat.maxis.net.my:8443/test/EBDConnectorWS/Web/RoadshowSalesCreateConfirm.aspx?";

        //Testing URL Working
        //var url = "http://172.21.3.98:8080/test/EBDConnectorWS/Web/RoadshowSalesCreateConfirm.aspx?";

        //Production URL for Tomorrow
        //var url = "http://retail.maxis.net.my:8080/EBDConnectorWS/Web/RoadshowSalesCreateConfirm.aspx?";

	  var url = "http://retail.men.maxis.com.my:8080/EBDConnectorWS/Web/RoadshowSalesCreateConfirm.aspx?";

        xmlHttpReq.open('POST', url, true);
        xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		
	  //alert(xmlHttpReq.readyState);
		
        xmlHttpReq.onreadystatechange = function()
        {
		if(xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
		    //alert(xmlHttpReq.responseText);
            responseStatus = xmlHttpReq.responseText;
            if(responseStatus == '1|OK'){
                //var reqConfirm = confirm('Do you want to submit ?');
                //if(reqConfirm){
                    document.getElementById("contents").innerHTML = params;
                    document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
                    mimsStatus = 'M';
                    updatepage(responseStatus, regId, mimsStatus, orderNo);
                //}else{
                    //alert('I dont want to submit Order No now --> ' + orderNo);
                //}
            }
			else{
                if (responseStatus.indexOf("already exist")!=-1){
                    //alert('Response Failed ' + responseStatus);
                    document.getElementById("contents").innerHTML = params;
		            document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
                    mimsStatus = 'M';
                    updateStatusToM(responseStatus, regId, mimsStatus, orderNo);
                }
				else if (responseStatus.indexOf("Item not in")!=-1){
						document.getElementById("contents").innerHTML = params;
						document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
						mimsStatus = 'H';
						updateStatusToM(responseStatus, regId, mimsStatus, orderNo);
				}else{
						alert('Response Failed ' + responseStatus);
						document.getElementById("contents").innerHTML = params;
						document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
				}
            }
         }
        }
	  //alert(params);
        xmlHttpReq.send(params);
    }

    function updatepage(resXML, id, status, orderNo) {
        var f = document.sform;
        f.action= "<%=request.getContextPath()%>/servlet/RoadShowSalesCreateConfirmServlet?id="+id+"&status="+status+"&orderNo="+orderNo;
        f.submit();
    }

    function updateStatusToM(resXML, id, status, orderNo) {
        var f = document.sform;
        f.action= "<%=request.getContextPath()%>/servlet/RoadShowSalesCreateConfirmServlet?id="+id+"&status="+status+"&orderNo="+orderNo;
        f.submit();
    }

    function delayer2(){
        window.location = "http://10.200.52.223:8080/EbdPortalConsumerOrdering/SalesRoadshowCreateUpdate.jsp";
    }


</script>
</head>

<body>
<form action="/servlet/RoadShowSalesCreateConfirmServlet" method="post" id="sform" name="sform">
<%
    int recCtr = 0;
    SqlMapClient roadshowConfirmMapClient = null;

    roadshowConfirmMapClient = BrightstarRoadShowConfig.getSqlMapInstance();

    Log log = LogFactory.getLog(this.getClass());

%>

    <table>

        <tr style="font-family:Verdana;font-size:14px;font-weight:bold;" height="18">
            <td colspan="14">EBDPortal Roadshow Confirmation - MIMS</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">&nbsp;</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">EBDPortal Roadshow Confirmation [EBD > MIMS]</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">&nbsp;</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td bgcolor="#4169e1"><font color="#FFFFFF">Reg Id</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Brn</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Company Name</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Customer Name</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Bill Address1</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">L1</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Bill Address2</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">L2</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Bill Address3</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Order No</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">IC No</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Msisdn</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Phone Order Status</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Device Name</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Topup Amount</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Subsidy Amount</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Market Type</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Reg Type</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Reg Date Approved</font></td>
		<td bgcolor="#4169e1"><font color="#FFFFFF">Sales id</font></td>

            <td bgcolor="#4169e1"><font color="#FFFFFF">MIMS Post</font></td>
        </tr>

    <%
        List aList = null;

        aList = roadshowConfirmMapClient.queryForList(Constant.select_RoadShow_details, null);
        int i = 0;
        RoadShowLogUtil.info("==== Total no of Records fetched from DB  " + aList.size());

        String todayDate = DateUtil.formatDate(new java.util.Date(), "dd/MM/yyyy HH:mm:ss");

        String paramOrder = "";

        if (aList != null && aList.size() > 0) {
            MaxisEbdPortal maxisData = new MaxisEbdPortal();
            for (Iterator<MaxisEbdPortal> j = aList.iterator(); j.hasNext();) {
                maxisData = (MaxisEbdPortal) j.next();
                try {

                    /*
                       Template Data
                       =======================================================
                           Data Set Example - Sent to MIMS Upload.
                           urlParam1 :
                               <SalesId>|<StatusCode>|<MessageCode>
                       =======================================================
                    */

                    paramOrder = maxisData.getSalesId() + "|1|OK";

                    i++;

                } catch (Exception ex) {
                    RoadShowLogUtil.info("Iam in JSP Exception " + ex.getMessage());
                }

    %>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
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
		<td><%=maxisData.getSalesId()%></td>
 
            <td><%=DateUtil.formatDate(maxisData.getRegDateApproved(), "dd/MM/yyyy")%></td>

            <td><a href="javascript:xmlServletHttpPostTest('<%=paramOrder%>', '<%=maxisData.getRegId()%>', '<%=maxisData.getOrderNo()%>');">BrightStar</a></td>
        </tr>

        <input type="hidden" name="paramOrder" value="<%=paramOrder%>" id="paramOrder" />
        <input type="hidden" name="regId" value="<%=maxisData.getRegId()%>" id="regId" />
        <input type="hidden" name="orderNo" value="<%=maxisData.getOrderNo()%>" id="orderNo" />

    <%
             if(i == 1){

                 RoadShowLogUtil.info("====== salesId =======" + CommonUtil.getObjectParam(maxisData.getSalesId()));
                 RoadShowLogUtil.info("paramOrder = " + paramOrder);

    %>

            <script type="text/javascript">
                //alert(document.getElementById("paramOrder").value);
                //alert(document.getElementById("regId").value);
                //alert(document.getElementById("orderNo").value);
                xmlServletHttpPostTest(document.getElementById("paramOrder").value, document.getElementById("regId").value, document.getElementById("orderNo").value);
                setTimeout("location.reload(true);", 15000);
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
              <h4>No Of Records : <%=i%></h4>
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