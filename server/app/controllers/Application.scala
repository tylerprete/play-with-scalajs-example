package controllers

import play.api.Environment
import play.api.mvc._
import shared.SharedMessages

class Application()(implicit environment: Environment) extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def twoNums = Action {
    implicit request =>
      val r = for {
        x <- request.getQueryString("x")
        y <- request.getQueryString("y")
        res = x.toInt + y.toInt
      } yield Ok(res.toString)
      r.getOrElse(BadRequest("Missing x or y"))
  }

}
