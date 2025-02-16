import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;


public class LinkList {
    public static void main(String[] args) {

    	ConcurrentHashMap<String,Integer> list=new ConcurrentHashMap<>();
    	list.put("Success",0);
    	list.put("Error",0);
    	
        	for(int i=0;i<5000;i++) {
        		int threadNo=i;
        	    Thread test=new Thread(()->{
        	    	URL url;
					try {
						url = new URL("https://paperpalprod.onrender.com/login");
						  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		                    conn.setRequestMethod("GET"); // or "POST", "PUT", "DELETE", etc.

		                    int responseCode = conn.getResponseCode();
		                    System.out.println(threadNo+". Response Code: " + responseCode);
		                    list.put("Success", list.get("Success")+1);
					} catch (Exception e) {
						System.out.println(threadNo+"------------------------Error--------------------------");
						list.put("Error", list.get("Error")+1);
					} 
                  
        	    });
        	    try {
        	        test.start();
        	    }catch(Exception e) {
        	    	System.out.println(threadNo+"------------------------Error--------------------------");
					list.put("Error", list.get("Error")+1);
        	    }
        	
        	
        	}
        	
      Thread.sleep(20000);
    }
}

