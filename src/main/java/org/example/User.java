package org.example;

public class User {
    private String userName;
    private Broker broker;

    public User(String userName, Broker broker){
        this.userName = userName;
        this.broker = broker;
    }

    public void notifiedNewVideo(String newVideoTitle){
        String receivedMessage = userName + " : " + newVideoTitle + "is uploaded";
        System.out.println(receivedMessage);
    }

    public void subscribeToChannel(Channel channel) {
        System.out.println();
        broker.subscribe(channel,this);
    }

    public void unsubscribeFromChannel(Channel channel) {
        System.out.println();
        broker.unsubscribe(channel,this);
    }

    public String getUserName(){
        return this.userName;
    }
}
