package cn.actor.robot

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.io.StdIn


class ClientActor(host:String,port:Int) extends Actor {

  var serverActorRef: ActorSelection = _ // 服务端的代理对象
  override def preStart() = {
        serverActorRef = context.actorSelection(s"akka.tcp://Server@${host}:${port}/user/robotServer")
  }

  override def receive: Receive = {

    case "start" => println("Client is OK")
    case msg: String => { // shit
      serverActorRef ! ClientMessage(msg) // 把客户端输入的内容发送给 服务端（actorRef）--》服务端的mailbox中 -> 服务端的receive
    }
    case ServerMessage(msg) => println(s"收到服务端消息：$msg")

  }
}

object ClientActor extends App {
  private val host = "127.0.0.1"
  private val port = 8098

  private val serverhost = "127.0.0.1"
  private val serverport = 8088


  private val config: Config = ConfigFactory.parseString(
    s"""|akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port""".stripMargin)

  private val clientSystem: ActorSystem = ActorSystem("client", config)
  private val clientActorRef: ActorRef = clientSystem.actorOf(Props(new ClientActor(serverhost ,serverport.toInt)), "clientActorRef")

  clientActorRef ! "start"
  while (true){
    val question = StdIn.readLine()
    clientActorRef ! question

  }



}
