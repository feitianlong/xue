package cn.actor.firstactor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class HelloActor extends Actor{
  override def receive: Actor.Receive ={
    case "haha" => println("haha xx")
    case "didi" => println("didi")
    case "stop" => {
      context.stop(self)
      context.system.terminate()
    }

  }
}

// 伴生对象 和 类名相同，同时也是单例对象
object HelloActor {
  private val af: ActorSystem = ActorSystem("ActorFactory")
  private val helloActorRef: ActorRef = af.actorOf(Props[HelloActor], "helloActor")

  def main(args: Array[String]): Unit = {
      helloActorRef ! "haha"
  }
}
