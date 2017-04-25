package solid.humank.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.event.Logging;
import akka.testkit.TestActorRef;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by kim on 2017/4/21.
 */
public class ActorAppTest {

    @Test
    public void tryInitWithNewStatement() {
        ExplainActorLifeCycle actor = new ExplainActorLifeCycle();
    }

    @Test
    public void explainActorLifeCycle() {

        ActorSystem system = ActorSystem.create("sample");
        ActorRef ref = system.actorOf(Props.create(ExplainActorLifeCycle.class), "test");

        ref.tell(new String("Hello , I'm Kim :D "), ref);
    }

    //take a reference to this web site to explain actor lifecycle in java syntax.
    //http://www.cnblogs.com/zhukunrong/p/5596611.html


    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("sample");
        ActorRef ref = system.actorOf(Props.create(ExplainActorLifeCycle.class), "test");

        ref.tell(new String("Hello , I'm Kim :D "), ref);

    }

    @Test
    public void demonstrateTestActorRef() {

        final ActorSystem system = ActorSystem.create("sample");
        final Props props = Props.create(ExplainActorLifeCycle.class);
        final TestActorRef<ExplainActorLifeCycle> ref = TestActorRef.create(system, props, "test");

        ref.tell(new String("Hello"), ActorRef.noSender());

        final ExplainActorLifeCycle actor = ref.underlyingActor();

        assertNotNull(actor);

    }

    @Test
    public void demoStopActor() {

        final ActorSystem system = ActorSystem.create("sample");
        final Props props = Props.create(ExplainActorLifeCycle.class);
        final TestActorRef<ExplainActorLifeCycle> ref = TestActorRef.create(system, props, "test");

        ref.tell(new String("Stop"), ActorRef.noSender());

        final ExplainActorLifeCycle actor = ref.underlyingActor();

        assertNotNull(actor);

    }


    @Test
    public void stopActor() {
        ActorSystem system = ActorSystem.create("sample");
        ActorRef ref = system.actorOf(Props.create(ExplainActorLifeCycle.class), "test");


    }

    @Test
    public void reSendMessageToAnTerminatedActor() {
        final ActorSystem system = ActorSystem.create("sample");
        final Props props = Props.create(ExplainActorLifeCycle.class);
        final TestActorRef<ExplainActorLifeCycle> ref = TestActorRef.create(system, props, "test");

        ref.tell(new String("Hello"), ActorRef.noSender());
        ref.tell(new String("Stop"), ActorRef.noSender());
        ref.tell(new String("Hello"), ActorRef.noSender());

    }

    @Test
    public void dealWithDeadLetterByListener() {
        final ActorSystem system = ActorSystem.create("sample");

        final Props props = Props.create(ExplainActorLifeCycle.class);
        final Props deadProps = Props.create(MyDeadLetterListener.class);

        final TestActorRef<ExplainActorLifeCycle> ref = TestActorRef.create(system, props, "test");
        final ActorRef deadLetterListener = TestActorRef.create(system, deadProps, "deadLetter");

        system.eventStream().subscribe(deadLetterListener, DeadLetter.class);
        assertTrue(system.eventStream().hasSubscriptions(deadLetterListener));

        ref.tell(new String("Hello"), ref);
        ref.tell(new String("Stop"), ref);
        ref.tell(new String("Hello"), ref);


    }

}

