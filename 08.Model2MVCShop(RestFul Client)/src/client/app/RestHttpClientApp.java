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
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
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
				
		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
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
		//Object ==> JSON Value �� ��ȯ
		Product product = new Product();
		product.setProdName("�׽�Ʈ123");
		product.setProdDetail("�׽���");
		product.setManuDate("1");
		product.setPrice(9999);
		product.setFileName("1234");
		product.setProdNo(10010);
		JSONObject json = new JSONObject();
		json.put("paymentOption", 001);
		json.put("receiverName", "�ڼ���");
		json.put("receiverPhone", 0102056);
		json.put("divyAddr", "����");
		json.put("divyRequest", "������");
		json.put("tranNo", 10001);
		String jsonValue = objectMapper01.writeValueAsString(json);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
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
		//Object ==> JSON Value �� ��ȯ
		JSONObject json = new JSONObject();
		json.put("currentPage", 1);
		json.put("pageSize", 3);
		
		String jsonValue = objectMapper01.writeValueAsString(json);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
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
		//Object ==> JSON Value �� ��ȯ
		Product product = new Product();
		product.setProdName("�׽�Ʈ123");
		product.setProdDetail("�׽���");
		product.setManuDate("1");
		product.setPrice(9999);
		product.setFileName("1234");
		product.setProdNo(10010);
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
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
		//Object ==> JSON Value �� ��ȯ
		Product product = new Product();
		product.setProdName("�׽�Ʈ123");
		product.setProdDetail("�׽���");
		product.setManuDate("1");
		product.setPrice(Integer.parseInt("9999"));
		product.setFileName("1234");
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 Product product01 = objectMapper.readValue(jsonobj.toString(), Product.class);
		 System.out.println(product01);
	}	
	
	
	public static void AddProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		//json.put("prodNo", 10044);
		json.put("prodName", "�׽�Ʈ123");
		json.put("prodDetail", "�׽���");
		json.put("manuDate", "1");
		json.put("price", "9999");
		json.put("fileName", "1234");
		//json.put("reg_date", "21/10/20");
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	
	}
	
	
private static void getProductTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
	// HttpClient : Http Protocol �� client �߻�ȭ 
	HttpClient httpClient = new DefaultHttpClient();
	
	String url= 	"http://127.0.0.1:8080/product/json/getProduct/10002";
			
	// HttpGet : Http Protocol �� GET ��� Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");
	
	// HttpResponse : Http Protocol ���� Message �߻�ȭ
	HttpResponse httpResponse = httpClient.execute(httpGet);
	
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();
	
	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	
	System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	String serverData = br.readLine();
	System.out.println(serverData);
	
	//==> �����б�(JSON Value Ȯ��)
	JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
	System.out.println(jsonobj);
}

	private static void getProductTest_JsonSimple() throws Exception {
		// TODO Auto-generated method stub
	
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";
				
		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
				
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
				
		//==> �����б�(JSON Value Ȯ��)
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
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getUserTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";
				
		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	
	private static void UpdateUserTest_Codehaus1()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol �� client �߻�ȭ 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url= 	"http://127.0.0.1:8080/user/json/updateUser/admin";

				// HttpGet : Http Protocol �� GET ��� Request
				HttpGet httpGet = new HttpGet(url);
				httpGet.setHeader("Accept", "application/json");
				httpGet.setHeader("Content-Type", "application/json");
				
				// HttpResponse : Http Protocol ���� Message �߻�ȭ
				HttpResponse httpResponse = httpClient.execute(httpGet);
				
				//==> Response Ȯ��
				System.out.println(httpResponse);
				System.out.println();

				//==> Response �� entity(DATA) Ȯ��
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream ����
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> �ٸ� ������� serverData ó�� 
				//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API Ȯ�� : Stream ��ü�� ���� ���� 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
				ObjectMapper objectMapper = new ObjectMapper();
				 User user = objectMapper.readValue(jsonobj.toString(), User.class);
				 System.out.println(user);
		
	}
	private static void UpdateUserTest_Codehaus2()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol �� client �߻�ȭ 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url = "http://127.0.0.1:8080/user/json/updateUser";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
				
//				//[ ��� 1 : String ���]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
//				//[ ��� 2 : JSONObject ���]
//				JSONObject json = new JSONObject();
//				json.put("userId", "admin");
//				json.put("password", "1234");
//				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
				
				//[ ��� 3 : codehaus ���]
				User user01 =  new User();
				user01.setUserId("user13");
				user01.setAddr("��Ʈ");
				user01.setPhone("010-2056-1658");
				user01.setEmail("tjddnjs888");
				user01.setUserName("�ڼ���");
				ObjectMapper objectMapper01 = new ObjectMapper();
				//Object ==> JSON Value �� ��ȯ
				String jsonValue = objectMapper01.writeValueAsString(user01);
				HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
				
				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response Ȯ��
				System.out.println(httpResponse);
				System.out.println();

				//==> Response �� entity(DATA) Ȯ��
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream ����
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> �ٸ� ������� serverData ó�� 
				//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API Ȯ�� : Stream ��ü�� ���� ���� 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
				ObjectMapper objectMapper = new ObjectMapper();
				 User user = objectMapper.readValue(jsonobj.toString(), User.class);
				 System.out.println(user);
	}
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getUserTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 User user = objectMapper.readValue(jsonobj.toString(), User.class);
		 System.out.println(user);
	}
//================================================================//	
	
//================================================================//
	//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void LoginTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("userId", "admin");
		json.put("password", "1234");
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	
	}
	
	
	//2.2 Http Protocol POST ��� Request : FromData���� 
	//==> JsonSimple + codehaus 3rd party lib ���
	public static void LoginTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();
		
		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
//		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ ��� 3 : codehaus ���]
		User user01 =  new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(user01);
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		
		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);
	
		ObjectMapper objectMapper = new ObjectMapper();
		 User user = objectMapper.readValue(jsonobj.toString(), User.class);
		 System.out.println(user);
	}	
	
	private static void listUserTest_Codehaus()throws Exception {
		// TODO Auto-generated method stub
		// HttpClient : Http Protocol �� client �߻�ȭ 
				HttpClient httpClient = new DefaultHttpClient();
				
				String url = "http://127.0.0.1:8080/user/json/listUser";
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json");
				
//				//[ ��� 1 : String ���]
//				String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//				HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
			
//				//[ ��� 2 : JSONObject ���]
//				JSONObject json = new JSONObject();
//				json.put("userId", "admin");
//				json.put("password", "1234");
//				HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
				
				//[ ��� 3 : codehaus ���]
				//Search search = new Search();
				//search.setCurrentPage(1);
				//search.setPageSize(3);
				//search.setSearchCondition("0");
				//search.setSearchKeyword("");
				JSONObject json = new JSONObject();
				json.put("currentPage", 1);
				json.put("pageSize", 3);
				ObjectMapper objectMapper01 = new ObjectMapper();
				//Object ==> JSON Value �� ��ȯ
				String jsonValue = objectMapper01.writeValueAsString(json);
				HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
				
				httpPost.setEntity(httpEntity01);
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				//==> Response Ȯ��
				System.out.println(httpResponse);
				System.out.println();

				//==> Response �� entity(DATA) Ȯ��
				HttpEntity httpEntity = httpResponse.getEntity();
				
				//==> InputStream ����
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
				//==> �ٸ� ������� serverData ó�� 
				//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
				//String serverData = br.readLine();
				//System.out.println(serverData);
				
				//==> API Ȯ�� : Stream ��ü�� ���� ���� 
				JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
				System.out.println(jsonobj);
			
			
	}

	
}