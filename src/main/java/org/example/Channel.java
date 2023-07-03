package org.example;

import java.util.ArrayList;
import java.util.*;

public class Channel {
    private String channelName;
    //private User publisher;
    private Broker broker;
    List<User> users = new ArrayList<>();

    public Channel(String channelName,Broker broker){
        this.channelName = channelName;
        //this.publisher = publisher;
        this.broker = broker;
    }

    public void newVideoNotice(Channel channel, String newVideoTitle){
        System.out.println("Channel class : " + channelName +"'s new video : " + newVideoTitle);
        broker.notifySubscribers(channel, newVideoTitle);
    }
}
