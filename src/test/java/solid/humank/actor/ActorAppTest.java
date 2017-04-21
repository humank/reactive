package solid.humank.actor;

import akka.actor.Actor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.Test;

/**
 * Created by kim on 2017/4/21.
 */
public class ActorAppTest {

    @Test
    public void explainActorLifeCycle(){

        //take a reference to this web site to explain actor lifecycle in java syntax.
        //http://www.cnblogs.com/zhukunrong/p/5596611.html

        ActorSystem actorSystem = ActorSystem.create("LifecycleActorSystem");
        ExplainActorLifeCycle actor = actorSystem.actorOf(Props.create(ExplainActorLifeCycle.class),"lifecycleActor");
    }
}
