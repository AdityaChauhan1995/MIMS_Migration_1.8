
/**
 * MaxisEaiProcessEbdOrderWsOrderEbdServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package my.com.maxis.services.eai.ebd.orderebdservice.v1;

    /**
     *  MaxisEaiProcessEbdOrderWsOrderEbdServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MaxisEaiProcessEbdOrderWsOrderEbdServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MaxisEaiProcessEbdOrderWsOrderEbdServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MaxisEaiProcessEbdOrderWsOrderEbdServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for resumeEbdService method
            * override this method for handling normal response from resumeEbdService operation
            */
           public void receiveResultresumeEbdService(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ResumeEbdServiceResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeEbdService operation
           */
            public void receiveErrorresumeEbdService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for suspendEbdService method
            * override this method for handling normal response from suspendEbdService operation
            */
           public void receiveResultsuspendEbdService(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SuspendEbdServiceResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from suspendEbdService operation
           */
            public void receiveErrorsuspendEbdService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changeEbdPackage method
            * override this method for handling normal response from changeEbdPackage operation
            */
           public void receiveResultchangeEbdPackage(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ChangeEbdPackageResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeEbdPackage operation
           */
            public void receiveErrorchangeEbdPackage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for transferEbdService method
            * override this method for handling normal response from transferEbdService operation
            */
           public void receiveResulttransferEbdService(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.TransferEbdServiceResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from transferEbdService operation
           */
            public void receiveErrortransferEbdService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reserveEbdInventory method
            * override this method for handling normal response from reserveEbdInventory operation
            */
           public void receiveResultreserveEbdInventory(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.ReserveEbdInventoryResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reserveEbdInventory operation
           */
            public void receiveErrorreserveEbdInventory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for swapEbdInventory method
            * override this method for handling normal response from swapEbdInventory operation
            */
           public void receiveResultswapEbdInventory(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.SwapEbdInventoryResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from swapEbdInventory operation
           */
            public void receiveErrorswapEbdInventory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for newLineRegistration method
            * override this method for handling normal response from newLineRegistration operation
            */
           public void receiveResultnewLineRegistration(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.NewLineRegistrationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from newLineRegistration operation
           */
            public void receiveErrornewLineRegistration(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUnbillToBill method
            * override this method for handling normal response from updateUnbillToBill operation
            */
           public void receiveResultupdateUnbillToBill(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.UpdateUnbillToBillResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUnbillToBill operation
           */
            public void receiveErrorupdateUnbillToBill(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for redirectEbdChargeRule method
            * override this method for handling normal response from redirectEbdChargeRule operation
            */
           public void receiveResultredirectEbdChargeRule(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.RedirectEbdChargeRuleResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from redirectEbdChargeRule operation
           */
            public void receiveErrorredirectEbdChargeRule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createSOnAdvPaymnt method
            * override this method for handling normal response from createSOnAdvPaymnt operation
            */
           public void receiveResultcreateSOnAdvPaymnt(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.CreateSOnAdvPaymntResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createSOnAdvPaymnt operation
           */
            public void receiveErrorcreateSOnAdvPaymnt(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateBillToUnbill method
            * override this method for handling normal response from updateBillToUnbill operation
            */
           public void receiveResultupdateBillToUnbill(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.UpdateBillToUnbillResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateBillToUnbill operation
           */
            public void receiveErrorupdateBillToUnbill(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disconnectEbdService method
            * override this method for handling normal response from disconnectEbdService operation
            */
           public void receiveResultdisconnectEbdService(
                    my.com.maxis.services.eai.ebd.orderebdservice.v1.MaxisEaiProcessEbdOrderWsOrderEbdServiceStub.DisconnectEbdServiceResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disconnectEbdService operation
           */
            public void receiveErrordisconnectEbdService(java.lang.Exception e) {
            }
                


    }
    