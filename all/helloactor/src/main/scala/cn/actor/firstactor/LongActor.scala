package cn.actor.firstactor

import akka.actor.Actor

class LongActor extends Actor{
  override def receive: Receive = {
    case "start" => {
      println("Long is Ok")
      sender() ! "ping"
    }
    case "pong" =>{
      Thread.sleep(1000)
      println("Long receive pong")
      sender() ! "ping"
    }
  }
}
