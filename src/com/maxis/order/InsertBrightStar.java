package com.maxis.order;

import com.maxis.constant.EmailConstant;
import com.maxis.constant.InsertionFaildException;
import com.maxis.db.AuditTrail;
import com.maxis.db.BrightStarForm;
import com.maxis.db.CustomerInfo;
import com.maxis.db.DBConnectionSQL;
import com.maxis.db.Device;
import com.maxis.db.PhoneOrder;
import com.maxis.db.PortalRegistrationMaster;
import com.maxis.db.RoadShow;
import com.maxis.db.TransMsisdn;
import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class InsertBrightStar
{
  Date dateCreated = new Date(System.currentTimeMillis());

  public static void main(String[] args)
  {
    InsertBrightStar brightStarPhoneOrder = new InsertBrightStar();



























    Date dateCreated = new Date(System.currentTimeMillis());

    BrightStarForm bForm = new BrightStarForm();
    bForm.setCreatedBy("WebService");
    bForm.setCustName("testbrightStar");
    bForm.setCompanyName("Company Name");
    bForm.setIc("ICNUMBER");
    bForm.setMsisdn("601212321");
    bForm.setContactNo("1234567895");
    bForm.setContactNumberFixed("1234567895");
    bForm.setTopup("10");
    bForm.setRoadshowName("BIP Roadshow");
    bForm.setProductId("84");
    bForm.setColorId("229");
    bForm.setDelAddress1("address1");
    bForm.setDelAddress2("address2");
    bForm.setCity("KUALA PERLIS");
    bForm.setPostCode("02000");
    bForm.setState("PERLIS");
    bForm.setCountry("131");
    bForm.setQuery("URL?CREATEDBY=WebService&custName=testbrightStar");


    DBConnectionSQL dbConnection = new DBConnectionSQL();
    dbConnection.setDB();
    try
    {
      brightStarPhoneOrder.insertIntoPhoneOrder(bForm, dbConnection);
    }
    catch (InsertionFaildException e)
    {
      e.printStackTrace();
      System.out.println("Inside the missing data...");
      AuditTrail auditTrail = dbConnection.getAuditSequence();
      auditTrail.setRegId(Integer.valueOf(100));
      auditTrail.setAccessBy("Webservice");
      auditTrail.setActivity("MISSING DATA/EXCEPTION");
      auditTrail.setRemarks("Query is :" + bForm.getQuery());
      auditTrail.setAuditDate(dateCreated);
      dbConnection.insertToAuditTrail(auditTrail);
    }
  }

  public void insertIntoPhoneOrder(BrightStarForm bForm, DBConnectionSQL dbConnection)
    throws InsertionFaildException
  {
    if ((bForm.getCreatedBy() != null) && (!bForm.getCreatedBy().equals("")) && (bForm.getCustName() != null) && (!bForm.getCustName().equals("")) && (bForm.getCompanyName() != null) && (!bForm.getCompanyName().equals("")) && (bForm.getIc() != null) && (!bForm.getIc().equals("")) && (bForm.getMsisdn() != null) && (!bForm.getMsisdn().equals("")) && (bForm.getContactNo() != null) && (!bForm.getContactNo().equals("")) && (bForm.getContactNumberFixed() != null) && (!bForm.getContactNumberFixed().equals("")) && (bForm.getTopup() != null) && (!bForm.getTopup().equals("")) && (bForm.getRoadshowName() != null) && (!bForm.getRoadshowName().equals("")) && (bForm.getProductId() != null) && (!bForm.getProductId().equals("")) && (bForm.getColorId() != null) && (!bForm.getColorId().equals("")) && (bForm.getDelAddress1() != null) && (!bForm.getDelAddress1().equals("")) && (bForm.getDelAddress2() != null) && (!bForm.getDelAddress2().equals("")) && (bForm.getCity() != null) && (!bForm.getCity().equals("")) && (bForm.getPostCode() != null) && (!bForm.getPostCode().equals("")) && (bForm.getState() != null) && (!bForm.getState().equals("")) && (bForm.getCountry() != null) && (!bForm.getCountry().equals(""))) {
      try
      {
        RoadShow roadShow = new RoadShow();
        roadShow.setRoadShowName(bForm.getRoadshowName());
        roadShow = dbConnection.getRoadShowDetails(roadShow);


        CustomerInfo customerInfo = dbConnection.getCustIdSequence();
        customerInfo.setCustBrnNo(roadShow.getBrn());
        customerInfo.setCompanyName(bForm.getCompanyName());
        customerInfo.setDelContactPhoneNo(bForm.getContactNo());
        customerInfo.setBillAddr1(bForm.getDelAddress1());
        customerInfo.setBillAddr2(bForm.getDelAddress2());
        customerInfo.setBillAddr3(bForm.getCity());
        customerInfo.setBillState(bForm.getState());
        customerInfo.setBillPostcode(bForm.getPostCode());
        customerInfo.setBillCountry(bForm.getCountry());
        customerInfo.setDealerCode(roadShow.getDealerCode());
        customerInfo.setDateCreated(this.dateCreated);
        customerInfo.setCustName(bForm.getCustName());
        customerInfo.setNewIc(bForm.getIc());
        dbConnection.insertCustInfo(customerInfo);


        PortalRegistrationMaster regMaster = dbConnection.getRegMasterSequence();

        System.out.println("regMaster sequence id --->" + regMaster.getRegId());
        regMaster.setCustId(customerInfo.getCustId());
        regMaster.setCustBrnNo(roadShow.getBrn());
        regMaster.setRegType("PhoneOrder");
        regMaster.setRegStatus("P");
        regMaster.setDealerCode(roadShow.getDealerCode());
        regMaster.setDateCreated(this.dateCreated);
        regMaster.setMarketCode(roadShow.getMarketCode());
        regMaster.setCollectCode(roadShow.getCollectionCode());
        regMaster.setAccountNo("11111");
        regMaster.setWsStatus("S");
        regMaster.setPhoneMarker("y");
        regMaster.setRollupId(Integer.valueOf("9"));
        regMaster.setCreatedBy(bForm.getCreatedBy());
        dbConnection.insertRegMaster(regMaster);



        TransMsisdn transMsisdn = dbConnection.getTransMsisdnSequence();
        transMsisdn.setMobileNo(bForm.getMsisdn());

        transMsisdn.setRateplanId(Integer.valueOf("10"));
        transMsisdn.setPrefMsisdn("PREFMSISDN");
        transMsisdn.setDateCreated(this.dateCreated);
        transMsisdn.setCreatedBy(bForm.getCreatedBy());
        transMsisdn.setPromotionId(Integer.valueOf("20"));
        transMsisdn.setCollectionId(Integer.valueOf(roadShow.getCollectionCode()));
        transMsisdn.setAccountNo("11111");
        transMsisdn.setWsStatus("S");
        transMsisdn.setOnsiteFullfillment("Y");
        transMsisdn.setRegId(regMaster.getRegId());
        transMsisdn.setMarketId(Integer.valueOf(roadShow.getMarketCode()));
        transMsisdn.setRegType("PhoneOrder");
        setTransMsisdn(transMsisdn, customerInfo);
        dbConnection.insertTransMsisdn(transMsisdn);


        Device device = new Device();
        device.setProductId(Integer.valueOf(bForm.getProductId()));
        device.setColorId(Integer.valueOf(bForm.getColorId()));
        device = dbConnection.getDeviceDetails(device);

        System.out.println(device.getPhoneUnitPrice() + "Phone Unit Price");

        PhoneOrder po = dbConnection.getPhoneOrderSequence();
        po.setRegId(regMaster.getRegId());
        po.setDateCreated(this.dateCreated);
        po.setCreatedBy(bForm.getCreatedBy());
        po.setPhoneTopupAmount(Integer.valueOf(bForm.getTopup()));

        po.setOrderDateTime(this.dateCreated);
        po.setDeliverStatusId(Integer.valueOf("3"));
        po.setCloseStatusId(Integer.valueOf("3"));
        po.setTransMsid(transMsisdn.getTransMsid());
        po.setCreateRemarks("Web Service creation");
        po.setVendorId(device.getVendorId());
        po.setPhoneUnitPrice(device.getPhoneUnitPrice());
        po.setDeviceId(device.getDeviceId());
        po.setSubsidyPrice(Integer.valueOf(device.getPhoneUnitPrice().intValue() - Integer.valueOf(bForm.getTopup()).intValue()));

        setPhoneOrder(po, customerInfo);

        dbConnection.insertPhoneOrder(po);

        dbConnection.insertPhoneOrderReg(po);


        AuditTrail auditTrail = dbConnection.getAuditSequence();

        auditTrail.setRegId(regMaster.getRegId());
        auditTrail.setAccessBy("Webservice");
        auditTrail.setActivity("Pending");

        auditTrail.setRemarks("Creating from the web service");
        auditTrail.setAuditDate(this.dateCreated);

        dbConnection.insertToAuditTrail(auditTrail);
      }
      catch (Exception e)
      {
        throw new InsertionFaildException(e.getMessage());
      }
    } else {
      throw new InsertionFaildException("Missing data");
    }
  }

  public static void setTransMsisdn(TransMsisdn transMsisdn, CustomerInfo customerInfo)
  {
    transMsisdn.setBillAddr1(customerInfo.getBillAddr1());
    transMsisdn.setBillAddr2(customerInfo.getBillAddr2());
    transMsisdn.setBillAddr3(customerInfo.getBillAddr3());
    transMsisdn.setBillPostcode(customerInfo.getBillPostcode());
    transMsisdn.setBillState(customerInfo.getBillState());
    transMsisdn.setBillCountry(customerInfo.getBillCountry());
  }

  public static void setPhoneOrder(PhoneOrder phoneOrder, CustomerInfo customerInfo)
  {
    phoneOrder.setDelAddr1(customerInfo.getBillAddr1());
    phoneOrder.setDelAddr2(customerInfo.getBillAddr2());
    phoneOrder.setDelAddr3(customerInfo.getBillAddr3());
    phoneOrder.setDelPostcode(customerInfo.getBillPostcode());
    phoneOrder.setDelState(customerInfo.getBillState());
    phoneOrder.setDelCountry(customerInfo.getBillCountry());
  }

  public void sendEmail(String query)
  {
    try
    {
      Date aDate = new Date();
      String subject = "Bright Star Phone Order Creation Missing Data ";
      String body = "Dear All\n\n\n While creating the phone order we found some missing data please ensure that you will send proper data. the query from bright star is  \n" + query;


      body = body + "\n\n\n\n";

      body = body + "This is a computer generated email \n\n\n\n\n\n";

      System.out.println(body);


      sendAllMail(subject, body);
    }
    catch (Exception ex)
    {
      System.out.println("Error " + ex.getMessage());
    }
  }

  public void sendAllMail(String subject, String messageBody)
    throws MessagingException, AddressException
  {
    System.out.println("inside sendMail  now");

    Properties props = System.getProperties();
    props.put("mail.smtp.host", EmailConstant.HOST);


    Session session = Session.getDefaultInstance(props, null);


    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("Portal@maxis.com.my"));

    message.addRecipient(Message.RecipientType.TO, new InternetAddress("SPANNIR@maxis.com.my"));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress("MVINAYK@maxis.com.my"));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress("czaifa@maxis.com.my"));
    message.setSubject(subject);
    System.out.println("Address set and sending the email now ");

    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText(messageBody);




    message.setHeader("Content-Type", "multipart/mixed");
    message.addHeader("X-Priority", "1");


    Multipart mp = new MimeMultipart();
    MimeBodyPart mbp1 = new MimeBodyPart();
    mbp1.setHeader("content-Type", "text/html");
    mp.addBodyPart(messageBodyPart);


    MimeBodyPart mbp2 = new MimeBodyPart();
    mbp2.setHeader("content-Type", "text/html");



    mp.addBodyPart(mbp2);


    message.setContent(mp);
    message.setSentDate(new Date());


    message.setContent(mp);

    Transport.send(message);
  }
}
