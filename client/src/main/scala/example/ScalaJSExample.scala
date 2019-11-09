package example

import scala.scalajs.js
import org.scalajs.dom
import org.scalajs.dom.raw.{Element, HTMLButtonElement}
import shared.SharedMessages

import scala.scalajs.js.annotation.JSName

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
//    dom.document.getElementById("jsStuff").textContent = doStuff()
    val t = dom.document.getElementById("gobutton").asInstanceOf[HTMLButtonElement]
    t.onclick = (x: dom.MouseEvent) => Pi.run(100000)
    t.
//    t.addEventListener("click", (e:dom.MouseEvent) => dom.document.getElementById("jsStuff").textContent = s"${util.Random.nextDouble()}" )
//    t.addEventListener("click", (e:dom.MouseEvent) => Pi.run(1000000000) )
    Pi.run()
  }

  @JSName("process")
  def process(): Unit = {
    Pi.run()
  }

  def doStuff(): String = {
    val q = 2
    val w = 4
    val t = q * w
    val f = t * t
    val r = f / w
    val s = math.sqrt(r)
    val arr = Array.fill(100)(s)
    val a2 = arr.map(x => x * x)
    val a3 = for {
      c1 <- a2
      c2 <- a2
    } yield c1 * c2
    println(s"Length of a3: ${a3.length}")
    val a4 = a3.sum
    val ret = s"Answer: $a4"
    ret
  }
}
