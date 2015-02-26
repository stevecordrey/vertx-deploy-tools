package nl.jpoint.vertx.mod.cluster.aws;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class AwsAutoScalingUtilTest {

    private final static String ACCESS_KEY = "";
    private final static String SECRET_ACCESS_KEY = "";
    private final static String AS_GROUP_ID = "";
    private final static String INSTANCE_ID = "";
    private final static String ELB = "";

    AwsAutoScalingUtil util = new AwsAutoScalingUtil(ACCESS_KEY, SECRET_ACCESS_KEY);
    AwsElbUtil elbUtil = new AwsElbUtil(ACCESS_KEY, SECRET_ACCESS_KEY, "eu-west-1", ELB, INSTANCE_ID);


    @Test
    @Ignore
    public void testElbInstanceState() throws AwsException {
        AwsState state = elbUtil.getInstanceState();
        Assert.assertEquals(AwsState.INSERVICE, state);
    }

    @Test
    @Ignore
    public void testListInstancesInGroup() throws AwsException {
        List<String> result = util.listInstancesInGroup("");
        Assert.assertEquals(1, result.size());
    }

    @Test
    @Ignore
    public void testListLoadBalancersInGroup() throws AwsException {
        List<String> result = util.listLoadBalancers(AS_GROUP_ID);
        Assert.assertEquals(1, result.size());

    }

    @Test
    @Ignore
    public void testFetchInstanceState() throws AwsException {
        AwsState result = util.getInstanceState(INSTANCE_ID,AS_GROUP_ID);
        Assert.assertEquals(AwsState.INSERVICE, result);
    }

    @Test
    @Ignore
    public void testEnterStandby() throws  AwsException {
        util.enterStandby(INSTANCE_ID,AS_GROUP_ID);
    }

    @Test
    @Ignore
    public void testExitStandby() throws  AwsException {
        util.exitStandby(INSTANCE_ID,AS_GROUP_ID);
    }


}