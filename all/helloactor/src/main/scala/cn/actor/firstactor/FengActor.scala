package cn.actor.firstactor

import akka.actor.{Actor, ActorRef}

class FengActor(val longAcotrRef:ActorRef) extends Actor{
  override def receive: Receive = {
    case "start" => {
      println("Feng is Ok")
      longAcotrRef ! "pong"
    }
    case "ping" => {
      Thread.sleep(1000)
      println("feng receive ping")
      longAcotrRef ! "pong"
    }
  }
}
