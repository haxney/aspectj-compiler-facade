package com.sun.tools.javac

import _root_.java.io.PrintWriter
import _root_.org.aspectj.tools.ajc.{Main => AjcMain}
import _root_.org.aspectj.bridge.{IMessage, MessageHandler}

/**
 *
 * An imitation of the real "com.sun.tools.javac.Main" which passes control over
 * to the AspectJ compiler.
 */

object Main {
  def compile(args: Array[String], writer: PrintWriter) = {
    val handler = new MessageHandler
    val aj = new AjcMain
    aj.run(args, handler)
    retval(handler)
  }

  def retval(handler: MessageHandler) = (handler.numMessages(IMessage.FAIL, true),
                         handler.numMessages(IMessage.ERROR, false)) match {
                           case (num, _) if num > 0 => -num
                           case (_, num) if num > 0 => num
                           case _ => 0
                         }
}
