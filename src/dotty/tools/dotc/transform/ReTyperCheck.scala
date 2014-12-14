package dotty.tools.dotc.transform

import dotty.tools.dotc.core.Contexts.Context
import dotty.tools.dotc.core.Phases.Phase
import dotty.tools.dotc.typer.ReTyper

class ReTyperCheck extends Phase {

  def run(implicit ctx: Context): Unit = {
    val unit = ctx.compilationUnit
    unit.tpdTree = checker.typedExpr(unit.tpdTree)
  }

  val checker = new ReTyper

  override def phaseName: String = "retyper"
}
