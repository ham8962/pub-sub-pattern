package org.example;

public class Main {
    public static void main(String[] args) {
        Broker broker = Broker.getInstance();
        User user = new User("dean", broker);
        Channel channel1 = new Channel("TED", broker);

        user.subscribeToChannel(channel1);
        user.getUserName();

        channel1.newVideoNotice(channel1,"javaPractice1");



    }
}