package cn.intellif.springnettyclient.utils;

import io.netty.channel.Channel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChannelUtils {
    private Channel channel;
    private volatile  boolean init =false;

    private static ChannelUtils instance = new ChannelUtils();

    private ChannelUtils(){

    }

    public static ChannelUtils getInstance(){
        return instance;
    }

    public synchronized void  addChannel(Channel channel){
        this.channel = channel;
        init = true;
    }

    public Channel getChannel() {
        if(init) {
            return channel;
        }else{
            return null;
        }

    }


    public void batchSendMsg(){
        Executor executor = Executors.newFixedThreadPool(50);
        for(int i=0;i<50;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        channel.writeAndFlush("你好哈哈哈哈哈哈哈......................你好");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
