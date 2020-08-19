/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KRA;

import com.nsdl.common.OkraServiceImpl;
import com.nsdl.common.OkraServiceImplService;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.xml.ws.BindingProvider;
import org.apache.commons.lang3.ArrayUtils;
import org.json.simple.JSONObject;

/**
 *
 * @author Goutam
 */
public class Registration {
    public static void main(String[] args) {
        try {
            Connection con = DBPool.get();
        JSONObject jsnobj = new  JSONObject();           
        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
        ctx.init(null, null, null);
        SSLContext.setDefault(ctx);
        String PAN = "DDJPS9630D";        

            String request_xml = "<APP_REQ_ROOT> \n" +
"<APP_PAN_INQ> \n" +
"<APP_IOP_FLG>IE</APP_IOP_FLG> \n" +
"<APP_POS_CODE>A1067</APP_POS_CODE> \n" +
"<APP_TYPE>I</APP_TYPE>\n" +
" <APP_NO>"+PAN+"</APP_NO>\n" +
" <APP_DATE>09-05-2012 00:00:00</APP_DATE> \n" +
" <APP_PAN_NO>"+PAN+"</APP_PAN_NO> \n" +
" <APP_PANEX_NO></APP_PANEX_NO> \n" +
" <APP_PAN_COPY>N</APP_PAN_COPY>\n" +
" <APP_EXMT>M</APP_EXMT> \n" +
" <APP_EXMT_CAT/> \n" +
" <APP_KYC_MODE></APP_KYC_MODE>\n" +
" <APP_EXMT_ID_PROOF>06</APP_EXMT_ID_PROOF>\n" +
" <APP_IPV_FLAG></APP_IPV_FLAG>\n" +
" <APP_IPV_DATE>15-05-2015 12:03:02</APP_IPV_DATE>\n" +
" <APP_GEN>M</APP_GEN> \n" +
" <APP_NAME>APP_NAME</APP_NAME>\n" +
" <APP_F_NAME>FATHER</APP_F_NAME> \n" +
" <APP_REGNO></APP_REGNO> \n" +
" <APP_DOB_DT>09-12-2015 00:00:00</APP_DOB_DT> \n" +
" <APP_DOI_DT></APP_DOI_DT>\n" +
" <APP_COMMENCE_DT></APP_COMMENCE_DT> \n" +
" <APP_NATIONALITY>02</APP_NATIONALITY>\n" +
" <APP_OTH_NATIONALITY>UNITED KINGDOM OF G</APP_OTH_NATIONALITY>\n" +
" <APP_COMP_STATUS></APP_COMP_STATUS>\n" +
" <APP_OTH_COMP_STATUS/>\n" +
" <APP_RES_STATUS>R</APP_RES_STATUS> \n" +
" <APP_RES_STATUS_PROOF></APP_RES_STATUS_PROOF>\n" +
" <APP_UID_NO>9632145789632587</APP_UID_NO> \n" +
" <APP_COR_ADD1>B304 ASX</APP_COR_ADD1>\n" +
" <APP_COR_ADD2>KAMGAR NAGAR</APP_COR_ADD2>\n" +
" <APP_COR_ADD3>address 3</APP_COR_ADD3> \n" +
" <APP_COR_CITY>GOA </APP_COR_CITY>\n" +
" <APP_COR_PINCD>400615</APP_COR_PINCD>\n" +
" <APP_COR_STATE>006</APP_COR_STATE>\n" +
" <APP_COR_CTRY>011</APP_COR_CTRY>\n" +
" <APP_OFF_NO>0123456789</APP_OFF_NO> \n" +
" <APP_RES_NO>0227578989</APP_RES_NO>\n" +
" <APP_MOB_NO>0123456789</APP_MOB_NO>\n" +
" <APP_FAX_NO>0227572244</APP_FAX_NO>\n" +
" <APP_EMAIL>testingMODIFIED@gmail.com</APP_EMAIL>\n" +
" <APP_COR_ADD_PROOF>06</APP_COR_ADD_PROOF>\n" +
" <APP_COR_ADD_REF>NA</APP_COR_ADD_REF>\n" +
" <APP_COR_ADD_DT>00/00/0000</APP_COR_ADD_DT>\n" +
" <APP_PER_ADD1>address 1</APP_PER_ADD1>\n" +
" <APP_PER_ADD2>KAMGAR NAGAR</APP_PER_ADD2>\n" +
" <APP_PER_ADD3></APP_PER_ADD3> \n" +
" <APP_PER_CITY></APP_PER_CITY> \n" +
" <APP_PER_PINCD>500502</APP_PER_PINCD>\n" +
" <APP_PER_STATE>006</APP_PER_STATE>\n" +
" <APP_PER_CTRY>014</APP_PER_CTRY>\n" +
" <APP_PER_ADD_PROOF>06</APP_PER_ADD_PROOF>\n" +
" <APP_PER_ADD_REF>NA</APP_PER_ADD_REF>\n" +
" <APP_PER_ADD_DT>00/00/0000</APP_PER_ADD_DT> \n" +
" <APP_INCOME>05</APP_INCOME> \n" +
" <APP_OCC>08</APP_OCC> \n" +
" <APP_OTH_OCC></APP_OTH_OCC>\n" +
" <APP_POL_CONN></APP_POL_CONN>\n" +
" <APP_DOC_PROOF>T</APP_DOC_PROOF>\n" +
" <APP_INTERNAL_REF/> \n" +
" <APP_BRANCH_CODE></APP_BRANCH_CODE>\n" +
" <APP_MAR_STATUS>01</APP_MAR_STATUS> \n" +
" <APP_NETWRTH>01234534.225</APP_NETWRTH>\n" +
" <APP_NETWORTH_DT>13-10-2014 00:00:00</APP_NETWORTH_DT>\n" +
" <APP_INCORP_PLC></APP_INCORP_PLC> \n" +
" <APP_OTHERINFO>WITHOUT KYC DOCUMENT ONLY EMAIL ID AND MOBILE NUMBER UPDATED</APP_OTHERINFO>\n" +
" <APP_FILLER1/> \n" +
" <APP_FILLER2>\n" +
" </APP_FILLER2>\n" +
" <APP_FILLER3>\n" +
" </APP_FILLER3>\n" +
" <APP_STATUS></APP_STATUS>\n" +
" <APP_STATUSDT></APP_STATUSDT>\n" +
" <APP_ERROR_DESC/> \n" +
" <APP_DUMP_TYPE>T</APP_DUMP_TYPE> \n" +
" <APP_DNLDDT>78945</APP_DNLDDT> \n" +
" <APP_KRA_INFO>NDML</APP_KRA_INFO>\n" +
" <APP_SIGNATURE/>\n" +
" </APP_PAN_INQ> \n" +
" <APP_SUMM_REC>  \n" +
" <APP_REQ_DATE>10-06-2013</APP_REQ_DATE>\n" +
" <APP_OTHKRA_BATCH></APP_OTHKRA_BATCH>\n" +
" <APP_OTHKRA_CODE>A1067</APP_OTHKRA_CODE>\n" +
" <APP_RESPONSE_DATE></APP_RESPONSE_DATE>   \n" +
" <APP_TOTAL_REC>5</APP_TOTAL_REC> \n" +
" </APP_SUMM_REC> \n" +
" </APP_REQ_ROOT>";
            
            OkraServiceImplService service = new OkraServiceImplService();
            OkraServiceImpl okraServiceImpl = service.getOkraServiceImpl();           
             String password = okraServiceImpl.getPassword("NDML@123", "test123");
            System.out.println("password:" + password);
            byte[] reg_request = request_xml.getBytes();
            Byte[] rr = ArrayUtils.toObject(reg_request);
            List<Byte> list = Arrays.asList(rr);
            List<Byte> resp = okraServiceImpl.registration(list , "TEST28", password, "test123", "A1067");
            Byte[] bytes = resp.toArray(new Byte[resp.size()]);
            String response = new String(ArrayUtils.toPrimitive(bytes));
            System.out.println(response);
            jsnobj = processResponse(response,""); 
            System.out.println("Response :" +jsnobj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
     public static JSONObject processResponse(String kraResponseDownload,String tag) {
        JSONObject jsono = new JSONObject();
        XMLParser xmlParser = new XMLParser(kraResponseDownload, "APP_PAN_INQ");
        try {
            String APP_ENTRYDT = xmlParser.getValue("APP_ENTRYDT");
            String APP_IOP_FLG = xmlParser.getValue("APP_IOP_FLG");
            String APP_PAN_DOB = xmlParser.getValue("APP_PAN_DOB");
            String APP_PAN_NO = xmlParser.getValue("APP_PAN_NO");
            String APP_POS_CODE = xmlParser.getValue("APP_POS_CODE");
            String APP_REG_ACK = xmlParser.getValue("APP_ENTRYDT");
            String APP_STATUS = xmlParser.getValue("APP_STATUS");
            String APP_STATUSDT = xmlParser.getValue("APP_STATUSDT");
            jsono.put("APP_ENTRYDT", APP_ENTRYDT);
            jsono.put("APP_IOP_FLG", APP_IOP_FLG);
            jsono.put("APP_PAN_DOB", APP_PAN_DOB);
            jsono.put("APP_PAN_NO", APP_PAN_NO);
            jsono.put("APP_POS_CODE", APP_POS_CODE);
            jsono.put("APP_REG_ACK", APP_REG_ACK);
            jsono.put("APP_STATUS", APP_STATUS);
            jsono.put("APP_STATUSDT", APP_STATUSDT);
            
            
           } catch (Exception e) {
            String error = xmlParser.getValue("ERROR");
            jsono.put("status", 0);
            jsono.put("msg", error);
            jsono.put("kradata","");
//GlobalClass.onError("", e);
        }
        return jsono;
    }
    
}
