package solid.humank.actor;

import akka.actor.AbstractLoggingActor;

/**
 * Created by kim on 2017/4/21.
 */
public class ExplainActorLifeCycle extends AbstractLoggingActor {


    @Override
    public void preStart(){

        log().info("actor prestart is invoked.");
    }

    @Override
    public void postStop(){

        log().info("actor postStop is invoked.");
    }

    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .match(String.class, s->{
                    log().info("received something: {}" ,s);
                })
                .matchAny(x-> log().info("received unknown message"))
                .build();
    }

}
