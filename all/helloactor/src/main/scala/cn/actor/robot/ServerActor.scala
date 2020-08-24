package cn.actor.robot

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}


class ServerActor extends Actor {
  override def receive: Receive = {

    case "start" => println("Server is Ok")
    case ClientMessage(msg) => {
      println(s"收到客户端消息：$msg")
      msg match {
        case "你叫什么" => sender() ! ServerMessage("铁扇公主")
        case "你是男是女" => sender() ! ServerMessage("老娘是男的")
        case "你是学生吗" => sender() ! ServerMessage("不是")
        case _ => sender() ! ServerMessage("What you say ?") //sender()发送端的代理对象， 发送到客户端的mailbox中 -> 客户端的receive
      }
    }

  }
}

object ServerActor  {
  def main(args: Array[String]): Unit = {
    // 指定端口
    val host = "127.0.0.1"
    val port = 8088

    val serverConfig: Config = ConfigFactory.parseString(
      s"""|akka.actor.provider="akka.remote.RemoteActorRefProvider"
          |akka.remote.netty.tcp.hostname=$host
          |akka.remote.netty.tcp.port=$port""".stripMargin)

    // 创建ActorSystem
    val serverActorSystem: ActorSystem = ActorSystem("server", serverConfig)

    // 创建ActorRef
    val robotServerActorRef: ActorRef = serverActorSystem.actorOf(Props[ServerActor], "robotServer")

    robotServerActorRef ! "start"
  }


}
