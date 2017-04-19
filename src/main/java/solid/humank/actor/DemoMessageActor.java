package solid.humank.actor;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;

/**
 * Created by kim on 2017/4/19.
 */
public class DemoMessageActor extends AbstractLoggingActor {

    static public class Greeting {
        private final String from;

        public Greeting(String from) {
            this.from = from;
        }

        public String getGreeter(){
            return from;
        }
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, g -> {
                    log().info("I was greeted by {}", g.getGreeter());
                })
                .build();
    }
}
