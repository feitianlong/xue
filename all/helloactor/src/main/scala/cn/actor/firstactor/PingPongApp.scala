package cn.actor.firstactor

import akka.actor.{ActorRef, ActorSystem, Props}


object PingPongApp extends App {

    val pingPongApp: ActorSystem = ActorSystem("PingPongApp")
    val longActorRef: ActorRef = pingPongApp.actorOf(Props[LongActor], "longActor")
    val fengActorRef: ActorRef = pingPongApp.actorOf(Props(new FengActor(longActorRef)), "fengActor")
    longActorRef ! "start"
    fengActorRef ! "start"

}
