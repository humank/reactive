package solid.humank.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by kim on 2017/4/21.
 */
public class ActorAppTest {

    @Test
    public void explainActorLifeCycle(){

        //take a reference to this web site to explain actor lifecycle in java syntax.
        //http://www.cnblogs.com/zhukunrong/p/5596611.html

        ActorSystem system = ActorSystem.create("sample");
        ActorRef ref = system.actorOf(Props.create(ExplainActorLifeCycle.class),"test");

        ref.tell(new String("Hello , I'm Kim :D "), ref);

    }

    public static void main(String[] args){

        ActorSystem system = ActorSystem.create("sample");
        ActorRef ref = system.actorOf(Props.create(ExplainActorLifeCycle.class),"test");

        ref.tell(new String("Hello , I'm Kim :D "), ref);

    }

    @Test
    public void demonstrateTestActorRef(){

        final ActorSystem system = ActorSystem.create("sample");
        final Props props = Props.create(ExplainActorLifeCycle.class);
        final TestActorRef<ExplainActorLifeCycle> ref = TestActorRef.create(system,props,"test");

        ref.tell(new String("Hello , I'm Kim :D "), ref);

        final ExplainActorLifeCycle actor = ref.underlyingActor();

        assertNotNull(actor);

    }
}

