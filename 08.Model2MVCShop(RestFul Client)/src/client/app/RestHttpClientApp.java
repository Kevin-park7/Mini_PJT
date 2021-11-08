package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;



public class RestHttpClientApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// 주석을 하나씩 처리해가며 실습
		////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n====================================\n");
//		RestHttpClientApp.getUserTest_JsonSimple();
		System.out.println("\n====================================\n");
//		RestHttpClientApp.getUserTest_Codehaus();
		System.out.println("\n====================================\n");
//		RestHttpClientApp.LoginTest_JsonSimple();
		System.out.println("\n====================================\n");
//		RestHttpClientApp.LoginTest_Codehaus();	
		System.out.println("\n====================================\n");
		//RestHttpClientApp.AddUserTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.UpdateUserTest_Codehaus1();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.UpdateUserTest_Codehaus2();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.listUserTest_Codehaus();
		
		
		
		
		System.out.println("\n====================================\n");
		//RestHttpClientApp.getProductTest_JsonSimple();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.getProductTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.AddProductTest_JsonSimple();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.AddProductTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.UpdateProductTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.ListProductTest_Codehaus();
		
		
		
		
		System.out.println("\n====================================\n");
		//RestHttpClientApp.ListPurchaseTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.AddPurchaseTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.getPurchaseTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.UpdatePurchaseTest_Codehaus();
		System.out.println("\n====================================\n");
		//RestHttpClientApp.getPurchaseTest_JsonSimple();

	
	
	}



	


	private static void getPurchaseTest_JsonSimple()throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/purchase/json/getPurchase/10002";
				
		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}






	private static void UpdatePurchaseTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/purchase/json/updatePurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		Product product = new Product();
		product.setProdName("테스트123");
		product.setProdDetail("테스용");
		product.setManuDate("1");
		product.setPrice(9999);
		product.setFileName("1234");
		product.setProdNo(10010);
		JSONObject json = new JSONObject();
		json.put("paymentOption", 001);
		json.put("receiverName", "박성원");
		json.put("receiverPhone", 0102056);
		json.put("divyAddr", "서울");
		json.put("divyRequest", "빠른새");
		json.put("tranNo", 10001);
		String jsonValue = objectMapper01.writeValueAsString(json);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 //Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		// System.out.println(purchase);
	}






	private static void getPurchaseTest_Codehaus() {
		// TODO Auto-generated method stub
		
	}






	private static void AddPurchaseTest_Codehaus() {
		// TODO Auto-generated method stub
		
	}






	private static void ListPurchaseTest_Codehaus() {
		// TODO Auto-generated method stub
		
	}




//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	private static void ListProductTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/listProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		JSONObject json = new JSONObject();
		json.put("currentPage", 1);
		json.put("pageSize", 3);
		
		String jsonValue = objectMapper01.writeValueAsString(json);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	

	}






	private static void UpdateProductTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/updateProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		Product product = new Product();
		product.setProdName("테스트123");
		product.setProdDetail("테스용");
		product.setManuDate("1");
		product.setPrice(9999);
		product.setFileName("1234");
		product.setProdNo(10010);
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Product product01 = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product01);
	}
	private static void AddProductTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		Product product = new Product();
		product.setProdName("테스트123");
		product.setProdDetail("테스용");
		product.setManuDate("1");
		product.setPrice(Integer.parseInt("9999"));
		product.setFileName("1234");
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Product product01 = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product01);
	}	
	
	
	public static void AddProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//[ 방법 1 : String 사용]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		//json.put("prodNo", 10044);
		json.put("prodName", "테스트123");
		json.put("prodDetail", "테스용");
		json.put("manuDate", "1");
		json.put("price", "9999");
		json.put("fileName", "1234");
		//json.put("reg_date", "21/10/20");
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	
	}
	
	
private static void getProductTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
	// HttpClient : Http Protocol 의 client 추상화 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url= 	"http://127.0.0.1:8080/product/json/getProduct/10002";
			
	// HttpGet : Http Protocol 의 GET 방식 Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");
	
	// HttpResponse : Http Protocol 응답 Message 추상화
	HttpResponse httpResponse = httpClient.execute(httpGet);
	
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	System.out.println("[ Server 에서 받은 Data 확인 ] ");
	String serverData = br.readLine();
	System.out.println(serverData);
	
	//==> 내용읽기(JSON Value 확인)
	JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
	System.out.println(jsonobj);
}

	private static void getProductTest_JsonSimple() throws Exception {
		// TODO Auto-generated method stub
	
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";
				
		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();
		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
				
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
				
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
			
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
		private static void AddUserTest_Codehaus()throws Exception {
			// TODO Auto-generated method stub
			HttpClient httpClient = new DefaultHttpClient();
			
			String url = "http://127.0.0.1:8080/user/json/addUser";
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			
			User user01 =  new User();
			user01.setUserId("testUser");
			user01.setPassword("1234");
			user01.setUserName("scott");
			user01.setRole("user");
			ObjectMapper objectMapper01 = new ObjectMapper();

			String jsonValue = objectMapper01.writeValueAsString(user01);
			HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
			
			httpPost.setEntity(httpEntity01);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			System.out.println(httpResponse);
			System.out.println();

			HttpEntity httpEntity = httpResponse.getEntity();
			
			InputStream is = httpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

			JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
			System.out.println(jsonobj);
		
			ObjectMapper objectMapper = new ObjectMapper();
			 User user = objectMapper.readValue(jsonobj.toString(), User.class);
			 System.out.println(user);
			;
			
		}

//================================================================//
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void getUserTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";
				
		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	
	private static void UpdateUserTest_Codehaus1()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol 의 client 추상화 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url= 	"http://127.0.0.1:8080/user/json/updateUser/admin";

				// HttpGet : Http Protocol 의 GET 방식 Request
				HttpGet httpGet = new HttpGet(url);
				httpGet.setHeader("Accept", "application/json");
				httpGet.setHeader("Content-Type", "application/json");
				
				// HttpResponse : Http Protocol 응답 Message 추상화
				HttpResponse httpResponse = httpClient.execute(httpGet);
				
				//==> Response 확인
				System.out.println(httpResponse);
				System.out.println();

				//==> Response 중 entity(DATA) 확인
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream 생성
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> 다른 방법으로 serverData 처리 
				//System.out.println("[ Server 에서 받은 Data 확인 ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API 확인 : Stream 객체를 직접 전달 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
				ObjectMapper objectMapper = new ObjectMapper();
				 User user = objectMapper.readValue(jsonobj.toString(), User.class);
				 System.out.println(user);
		
	}
	private static void UpdateUserTest_Codehaus2()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol 의 client 추상화 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url = "http://127.0.0.1:8080/user/json/updateUser";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
				
//				//[ 방법 1 : String 사용]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
//				//[ 방법 2 : JSONObject 사용]
//				JSONObject json = new JSONObject();
//				json.put("userId", "admin");
//				json.put("password", "1234");
//				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
				
				//[ 방법 3 : codehaus 사용]
				User user01 =  new User();
				user01.setUserId("user13");
				user01.setAddr("비트");
				user01.setPhone("010-2056-1658");
				user01.setEmail("tjddnjs888");
				user01.setUserName("박성원");
				ObjectMapper objectMapper01 = new ObjectMapper();
				//Object ==> JSON Value 로 변환
				String jsonValue = objectMapper01.writeValueAsString(user01);
				HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
				
				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response 확인
				System.out.println(httpResponse);
				System.out.println();

				//==> Response 중 entity(DATA) 확인
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream 생성
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> 다른 방법으로 serverData 처리 
				//System.out.println("[ Server 에서 받은 Data 확인 ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API 확인 : Stream 객체를 직접 전달 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
				ObjectMapper objectMapper = new ObjectMapper();
				 User user = objectMapper.readValue(jsonobj.toString(), User.class);
				 System.out.println(user);
	}
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void getUserTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 User user = objectMapper.readValue(jsonobj.toString(), User.class);
		 System.out.println(user);
	}
//================================================================//	
	
//================================================================//
	//2.1 Http Protocol POST Request : FromData 전달 / JsonSimple 3rd party lib 사용
	public static void LoginTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//[ 방법 1 : String 사용]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("userId", "admin");
		json.put("password", "1234");
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	
	}
	
	
	//2.2 Http Protocol POST 방식 Request : FromData전달 
	//==> JsonSimple + codehaus 3rd party lib 사용
	public static void LoginTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
//		//[ 방법 1 : String 사용]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ 방법 2 : JSONObject 사용]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ 방법 3 : codehaus 사용]
		User user01 =  new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(user01);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 User user = objectMapper.readValue(jsonobj.toString(), User.class);
		 System.out.println(user);
	}	
	
	private static void listUserTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol 의 client 추상화 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url = "http://127.0.0.1:8080/user/json/listUser";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
				
//				//[ 방법 1 : String 사용]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
//				//[ 방법 2 : JSONObject 사용]
//				JSONObject json = new JSONObject();
//				json.put("userId", "admin");
//				json.put("password", "1234");
//				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
				
				//[ 방법 3 : codehaus 사용]
				//Search search = new Search();
				//search.setCurrentPage(1);
				//search.setPageSize(3);
				//search.setSearchCondition("0");
				//search.setSearchKeyword("");
				JSONObject json = new JSONObject();
				json.put("currentPage", 1);
				json.put("pageSize", 3);
				ObjectMapper objectMapper01 = new ObjectMapper();
				//Object ==> JSON Value 로 변환
				String jsonValue = objectMapper01.writeValueAsString(json);
				HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
				
				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response 확인
				System.out.println(httpResponse);
				System.out.println();

				//==> Response 중 entity(DATA) 확인
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream 생성
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> 다른 방법으로 serverData 처리 
				//System.out.println("[ Server 에서 받은 Data 확인 ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API 확인 : Stream 객체를 직접 전달 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
			
	}

	
}