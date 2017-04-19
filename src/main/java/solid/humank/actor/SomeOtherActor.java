package solid.humank.actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

/**
 * Created by kim on 2017/4/19.
 */
public class SomeOtherActor extends AbstractActor {

    ActorRef demoRef = getContext().actorOf(DemoActor.props(42),"demo");


    @Override
    public Receive createReceive() {
        return null;
    }
}
