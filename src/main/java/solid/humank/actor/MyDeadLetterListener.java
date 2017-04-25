package solid.humank.actor;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.Actor;
import akka.actor.DeadLetter;

/**
 * Created by kim on 2017/4/25.
 */
public class MyDeadLetterListener extends AbstractLoggingActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(DeadLetter.class, deadLetter -> {
                    log().info("received something: {}", deadLetter.message().toString());
                })
                .build();
    }

}
