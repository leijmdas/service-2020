package ytb.common.testcase;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ytb.common.ManagerCommon.ITestYtb;
import ytb.common.RestMessage.MsgRequest;
import ytb.common.context.service.impl.AppCtxtUtil;
import ytb.common.utils.YtbUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@JTestClass.author("leijm")
public class TestRest extends ITestYtb {
	String url_base="http://localhost/rest";
	String url ="http://localhost/rest/service/demoModel";

	@Inject(filename = "node.xml", value = "httpclient")
	HttpClientNode httpclient;
	//private MongoTemplate mongoTemplate;

	MsgRequest req = new MsgRequest();
	String data;
//	public void suiteSetUp() {
//
//	}
//
//	public void suiteTearDown() throws IOException {
//	}
	
	@Override
	public void setUp() {
		req.token = UUID.randomUUID().toString();
		req.reqtime = System.currentTimeMillis();// DateFormat(new Date())
		
		req.seqno = System.currentTimeMillis();
		req.cmdtype = "projectType";
		req.cmd = "getProjectTypeList";
		req.msgBody = JSONObject.parseObject("{\"x\":1}");

	}
	
	@Override
	public void tearDown() {
	}
	
	
	@JTest
	@JTestClass.title("test0001_httprest1")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1:8080/rest/test")
	@JTestClass.exp("ok")
	public void test0001_httprest1() {
		
		String ret = httpclient.post(url_base+"/mngr",req.toJSONString() , "application/json");
		httpclient.checkStatusCode(200);
		JSONObject json=JSONObject.parseObject(ret);
		checkEQ(0,json.getInteger("retcode"));
	}
	
	
	@JTest
	@JTestClass.title("test0002_httprest2")
	@JTestClass.pre("")
	@JTestClass.step("post http://localhost:8080/rest/common")
	@JTestClass.exp("ok")
	public void test0002_httprest2() {
 
		String ret = httpclient.post(url_base+ "/mngr", data, "application/json");
		httpclient.checkStatusCode(200);
		JSONObject json=JSONObject.parseObject(ret);
		checkEQ(0,json.getInteger("retcode"));
		
	}
	
	@JTest
	@JTestClass.title("test0003_rest_template")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1:8080/WebMngr/rest/template")
	@JTestClass.exp("ok")
	public void test0003_rest_template() {
		
		String ret = httpclient.post("http://localhost:8080/WebMngr/rest/mngr",data , "application/json");
		httpclient.checkStatusCode(200);
		JSONObject json=JSONObject.parseObject(ret);
		checkEQ(0,json.getInteger("retcode"));
		System.out.println(data);
		System.out.println(json.get("msgBody"));
		System.out.println(json);
	}
	
	@JTest
	@JTestClass.title("test0004_rest_mngr")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1:8080/WebMngr/rest/common")
	@JTestClass.exp("ok")
	public void test0004_rest_mngr() {

		String ret = httpclient.post("http://localhost:80/WebMngr/rest/mngr", data, "application/json");
		httpclient.checkStatusCode(200);
		JSONObject json = JSONObject.parseObject(ret);
		checkEQ(0, json.getInteger("retcode"));
		System.out.println(data);
		System.out.println(json.get("msgBody"));
		System.out.println(json);
	}

	public int addGroupUser(int userId, int groupId, JSONArray groupUserIdArr){
		System.out.println(userId);
		System.out.println(groupId);
		System.out.println(JSONArray.toJSONString(groupUserIdArr));

		return groupId;
	}

	@JTest
	@JTestClass.title("e")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1/rest/service")
	@JTestClass.exp("ok")
	public void test0005_restDemo() {
		String url ="http://localhost/rest/service/demoModel";
		req.cmdtype = "student";
		req.cmd = "select";

		String ret = httpclient.post(url, req.toJSONString(), "application/json");
		httpclient.checkStatusCode(200);
		JSONObject json = JSONObject.parseObject(ret);
		checkEQ(0, json.getInteger("retcode"));
		System.out.println(req.toJSONString());
		System.out.println(json.get("msgBody"));
	}
	@JTest
	@JTestClass.title("e")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1/rest/service")
	@JTestClass.exp("ok")
	public void test0006_uid() {

//		 ApplicationContext ctxt = new ClassPathXmlApplicationContext
//				("classpath:/uid/default-uid-spring.xml");
//		ctxt = AppCtxtUtil.getApplicationContext();
//		DefaultUidGenerator uidGenerator=ctxt.getBean("defaultUidGenerator",DefaultUidGenerator.class);
//		System.out.println(uidGenerator.getUID());
//		System.out.println(uidGenerator.getUID());
//		System.out.println(uidGenerator.getUID());

	}
	@JTest
	@JTestClass.title("e")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1/rest/service")
	@JTestClass.exp("ok")
	public void test0007_uid() {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext
				("classpath:/uid/cached-uid-spring.xml");
		ctxt = AppCtxtUtil.getApplicationContext();
//
//		DefaultUidGenerator uidGenerator = ctxt.getBean("defaultUidGenerator",
//				DefaultUidGenerator.class);
//		System.out.println(uidGenerator.getUID());
//		System.out.println(uidGenerator.getUID());
//		System.out.println(uidGenerator.getUID());
//		uidGenerator = ctxt.getBean("defaultUidGenerator",
//				DefaultUidGenerator.class);
//		System.out.println(uidGenerator.getUID());
//		System.out.println(uidGenerator.getUID());

	}
	@JTest
	@JTestClass.title("e")
	@JTestClass.pre("")
	@JTestClass.step("post http://127.0.0.1/rest/service")
	@JTestClass.exp("ok")
	public void test0008_uid_utils() {


		System.out.println( YtbUtils.fsGetUID());
		System.out.println( YtbUtils.fsGetUID());
		System.out.println( YtbUtils.fsGetUID());
		System.out.println( YtbUtils.getObjectId());

	}
	//create table user_hp2(id bigint,name varchar(64)) partition by hash(id)
	//partitions 3;

	//https://blog.csdn.net/forezp
	//https://www.cnblogs.com/yeyang/p/10226284.html
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IOException {

		run(TestRest.class,1);
		//ModelFactory.build("work_group_member");

	}

}
		
		