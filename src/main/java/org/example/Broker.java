package org.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Broker {
    //private List<Channel> channels = new ArrayList<>();
    private Map<Channel, List<User>> subscribers;
    private static volatile Broker instance;

    private Broker() {
        subscribers = new ConcurrentHashMap<>();
    }

    public static Broker getInstance() {
        if (instance == null) {
            synchronized (Broker.class) {
                if(instance == null) {
                    instance = new Broker();
                }
            }
        }
        return instance;
    }

    public void subscribe(Channel channel, User user) {
        List<User> channelSubscribers = subscribers.computeIfAbsent(channel, k -> new CopyOnWriteArrayList<>());
        channelSubscribers.add(user);
    }

    public void unsubscribe(Channel channel, User user) {
        List<User> channelSubscribers = subscribers.get(channel);
        if (channelSubscribers != null) {
            channelSubscribers.remove(user);
        }
    }

    public void notifySubscribers(Channel channel, String newVideoTitle) {
        List<User> channelSubscribers = subscribers.get(channel);
        channelSubscribers.forEach(channelSubscriber -> channelSubscriber.notifiedNewVideo(newVideoTitle));
    }

}
