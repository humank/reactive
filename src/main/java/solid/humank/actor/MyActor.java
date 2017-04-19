package solid.humank.actor;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by kim on 2017/4/18.
 */
public class MyActor extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    private String actorName;
    public MyActor(String actorName){
        this.actorName = actorName;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s->{
                    log.info("received something: {}" ,s);
                })
                .matchAny(x-> log.info("received unknown message"))
                .build();
    }
}
