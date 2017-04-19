package solid.humank.actor;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * Created by kim on 2017/4/19.
 */
public class DemoActor extends AbstractActor {

    private final Integer magicNumber;

    public DemoActor(Integer magicNumber) {
        this.magicNumber = magicNumber;
    }

    static Props props(Integer magicNumber) {

        return Props.create(DemoActor.class, () -> new DemoActor(magicNumber));

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Integer.class, i -> {
                    getSender().tell(i + magicNumber, getSelf());
                })
                .build();
    }
}
