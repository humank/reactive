package solid.humank.actor;

import akka.actor.Props;
import org.junit.Test;

/**
 * Created by kim on 2017/4/19.
 */

public class PropsTest {

    @Test
    public void createActorWithProps(){
        Props prop1 = Props.create(MyActor.class);
        Props prop2 = Props.create(MyActor.class,() -> new MyActor("actorName"));

    }
}
