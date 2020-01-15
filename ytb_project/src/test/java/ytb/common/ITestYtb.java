package ytb.common;

import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.NodesFactroy.Node.JDbNode;
import com.jtest.annotation.JTestInject;
import com.jtest.testframe.ITestImpl;
import ytb.common.test.BuildAppCtxt;

public class ITestYtb extends ITestImpl {
    @JTestInject(filename = "node.xml", value = "httpclient")
    protected HttpClientNode httpclient;
    @JTestInject("ytb_user")
    protected JDbNode dbUser;

    @JTestInject("ytb_project")
    protected JDbNode dbProject;
    @JTestInject("ytb_manager")
    protected JDbNode dbManager;
    @JTestInject("ytb_account")
    protected JDbNode dbAccount;

    protected UserLogin userLogin = new UserLogin();

    public void suiteSetUp() throws Exception {
        BuildAppCtxt.buildAppContext();

    }

    public void suiteTearDown() throws Exception {
        BuildAppCtxt.exitAppContext();

    }
}
