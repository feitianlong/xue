package cn.actor.robot

// 样例类可以封装数
// 样例对象不能封装数据

// 服务端发送给客户端的消息格式
case class ServerMessage(msg: String)

// 客户端发送给服务器端的消息格式
case class ClientMessage(msg: String)