<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.maxis.db.MaxisEbdPortal"%>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
<%@ page import="com.maxis.constant.Constant" %>
<%@ page import="org.apache.commons.httpclient.util.DateUtil" %>
<%@ page import="java.util.*" %>
<%@ page import="com.maxis.constant.CommonUtil" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="com.maxis.config.ContractExtSqlConfig" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="REFRESH" content="12" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/maxis.css" />
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/ajax1.js"></script>
<title>ExtContract</title>

<script type="text/javascript">

    function xmlServletHttpPostTest(params, regId, transMsid) {

        var f = document.sform;
        var xmlHttpReq = newXMLHttpRequest();

        var responseStatus = '';
        var mimsStatus = '';

        var url = "http://10.201.110.195/DominateWeb/InsertContractExt.aspx?";

        alert(url);

        xmlHttpReq.open('POST', url, true);
        xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xmlHttpReq.onreadystatechange = function(){

        if(xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
		    alert(xmlHttpReq.responseText);
            responseStatus = xmlHttpReq.responseText;
            alert(xmlHttpReq.responseText);
            if(responseStatus == '1|Successful'){
                alert('1');
                
                    mimsStatus = 'S';
                    updatepage(responseStatus, regId, mimsStatus, transMsid);

            }else{
                alert('Failed ' + responseStatus);
                document.getElementById("contents").innerHTML = params;
		        document.getElementById("respondTxt").innerHTML = xmlHttpReq.responseText;
            }
            
         }
        }
        xmlHttpReq.send(params);
    }

    function updatepage(resXML, regId, status, transMsid) {
        var f = document.sform;
        if(resXML == '1|Successful'){
            f.action= "<%=request.getContextPath()%>/servlet/ContractExtServlet?regId="+regId+"&status="+status+"&transMsid="+transMsid;
            f.submit();
        }else{
            alert('Response Status is not - 1|OK - Failed');
        }
    }

</script>
</head>

<body>
<form action="/servlet/ClientPost" method="post" id="sform" name="sform">
<%
    int recCtr = 0;
    SqlMapClient mapClient = null;

    mapClient = ContractExtSqlConfig.getSqlMapInstance();

    Log log = LogFactory.getLog(this.getClass());

%>

    <table>

        <tr style="font-family:Verdana;font-size:14px;font-weight:bold;" height="18">
            <td colspan="14">Maxis Inventory Management System - MIMS</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">&nbsp;</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">InsertContractExt [DealerNet > ASPX]</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td colspan="14">&nbsp;</td>
        </tr>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td bgcolor="#4169e1"><font color="#FFFFFF">Reg Id</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Trans Msid</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Msisdn</font></td>
            <td bgcolor="#4169e1"><font color="#FFFFFF">Contract Ext</font></td>
        </tr>

    <%
        List aList = null;

        aList = mapClient.queryForList(Constant.SELECT_EBDPORTAL_MIMS, null);
        int i = 0;
        log.info("==== Total no of Records fetched from DB  " + aList.size());

        String todayDate = DateUtil.formatDate(new java.util.Date(), "dd/MM/yyyy HH:mm:ss");

        String paramOrder = "";

        if (aList != null && aList.size() > 0) {
            MaxisEbdPortal maxisData = new MaxisEbdPortal();
            for (Iterator<MaxisEbdPortal> j = aList.iterator(); j.hasNext();) {
                maxisData = (MaxisEbdPortal) j.next();
                try {

                    /*
                       Template Data
                       ============================================================================================================================
                        Data Set Example - Sent to MIMS
                        Test url :  http://10.201.110.195/DominateWeb/InsertContractExt.aspx

                        InsertContractExt

                        Request :
                        MSISDN
                        ContractType
                        SourceFrom (MIMS, ECBD, DNET, MOS)

                        Sample Request:
                        60177552100|401020|DNET

                        Response :
                        ResultCode  1= Success | -1= Fail
                        ResultDesc

                        Sample Response:
                        1|Success

                      ============================================================================================================================

                    */

                    log.info("====== regId =======" + CommonUtil.getObjectParam(maxisData.getRegId()));

                    log.info("====== transMsid =======" + CommonUtil.getObjectParam(maxisData.getTransMsid()));

                    log.info("====== msisdn =======" + CommonUtil.getObjectParam(maxisData.getMsisdn()));
                    String msisdn = CommonUtil.getObjectParam(maxisData.getMsisdn());

                    log.info("====== extContract =======" + CommonUtil.getObjectParam(maxisData.getExtContract()));
                    String extContract = CommonUtil.getObjectParam(maxisData.getExtContract());

                    log.info("====== sourceFrom =======" + CommonUtil.getObjectParam("ECBD"));
                    String sourceFrom = CommonUtil.getObjectParam("ECBD");

                    paramOrder = msisdn + "|" + extContract + "|" + sourceFrom;

                    log.info("paramOrder = " + paramOrder);

                    i++;

                } catch (Exception ex) {
                    log.info("Iam in Exception " + ex.getMessage());
                }

    %>

        <tr style="font-family:Verdana;font-size:10px;font-weight:bold;" height="18">
            <td><%=maxisData.getRegId()%></td>
            <td><%=maxisData.getTransMsid()%></td>
            <td><%=maxisData.getMsisdn()%></td>
            <td><%=maxisData.getExtContract()%></td>
            <td><a href="javascript:xmlServletHttpPostTest('<%=paramOrder%>', '<%=maxisData.getRegId()%>', '<%=maxisData.getTransMsid()%>');">Contract Ext</a></td>
        </tr>

        <input type="hidden" name="paramOrder" value="<%=paramOrder%>" id="paramOrder" />
        <input type="hidden" name="regId" value="<%=maxisData.getRegId()%>" id="regId" />
        <input type="hidden" name="transMsid" value="<%=maxisData.getTransMsid()%>" id="transMsid" />

    <%
             if(i == 1){
    %>

            <script type="text/javascript">
                //alert(document.getElementById("paramOrder").value);
                //alert(document.getElementById("regId").value);
                //alert(document.getElementById("orderNo").value);
                xmlServletHttpPostTest(document.getElementById("paramOrder").value, document.getElementById("regId").value, document.getElementById("transMsid").value);
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