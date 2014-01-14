package cn.com.chinabank.shared.protocol.learn;

import com.alibaba.dubbo.remoting.Codec;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboCodec;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/14/14
 * Time: 8:35 PM
 */
public class LearnCodec extends DubboCodec implements Codec {

    public static final String NAME = "learn";
}
