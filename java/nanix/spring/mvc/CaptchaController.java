package nanix.spring.mvc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaptchaController {
	
	@RequestMapping("/captcha1")
	public String captcha1() {
		return "captcha1";
	}
	
	@RequestMapping("/captcha2")
	public String captcha2() {
		return "captcha2";
	}
	
	@RequestMapping(value="/captcha2", method=RequestMethod.POST)
	public String captcha2ok(HttpServletRequest req) {
		
		String gCapRes = req.getParameter("g-recaptcha");
		System.out.println(gCapRes);
		
		
		// 클라이언트에서 넘겨준 코드를 
		// 검증용주소를 통해 올바른 값인지 확인함
		
		String scretKey ="---";
		String verifyURL = "https://www.google.com/recaptcha/api/siteverify";
        String params = "secret=" + scretKey + "&response=" + gCapRes;

        try {
        	
    		String jsonData = "";
    	
        	URL url = new URL(verifyURL);
        	HttpURLConnection huconn = (HttpURLConnection) url.openConnection();
			huconn.setRequestMethod("POST");
			huconn.setDoInput(true);
			huconn.setDoOutput(true);
			
			DataOutputStream os = new DataOutputStream(huconn.getOutputStream());
		    os.writeBytes(params);
			os.flush();
			os.close();
			
			InputStream is = huconn.getInputStream();
			BufferedReader br = new BufferedReader(
							new InputStreamReader(is, "UTF-8"));
			StringBuffer sb = new StringBuffer();
			
			while ((jsonData = br.readLine()) != null) {
				sb.append(jsonData);
			}
			
			JSONParser parser = new JSONParser();
			Object resvObj = parser.parse(sb.toString());
			JSONObject jsonObj = (JSONObject) resvObj;

			System.out.println( jsonObj.get("success") ); // v2용
			//System.out.println( jsonObj.get("score") ); // v3용
			//System.out.println( jsonObj.get("action") );// v3용

	    	} catch (Exception e) {
			
	    		e.printStackTrace();
	    	}

        return "captcha2";
	}
	
}
