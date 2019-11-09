package example

import org.scalajs.dom

import scala.util.Random

/**
  * Created by pulpo on 5/15/16.
  */
object Pi {

  @inline def getRandomNumberInInterval: Double = {
    Random.nextDouble() * 2D - 1D
  }

  @inline def getPoint: (Double, Double) = {
    (getRandomNumberInInterval, getRandomNumberInInterval)
  }

  @inline def distance(x: Double, y: Double): Double = {
    math.sqrt(x*x + y*y)
  }

  def run(limit: Long = 10000) {
    var total: Long = 0
    var inCircle: Long = 0
    while(total <= limit) {
      total += 1
      val point = getPoint
      val d = distance(point._1, point._2)
      inCircle += (if (d <= 1.0) 1 else 0)
      if (total % 1000 == 0) {
        val pi = 4 * inCircle / total.toDouble
        println(f"pi = $pi%1.14f -- ($inCircle%d / $total%d)")
        dom.document.getElementById("jsStuff").textContent = s"$pi"
        dom.setTimeout(() => 1, 0)
      }
    }

  }

}
