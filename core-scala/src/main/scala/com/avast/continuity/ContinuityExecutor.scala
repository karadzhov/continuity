package com.avast.continuity

import java.util.concurrent.Executor

class ContinuityExecutor(executor: Executor)(implicit threadNamer: ThreadNamer) extends Executor with ContinuityExecutorMarker {

  override def execute(runnable: Runnable): Unit = executor.execute(new MdcRunnable(runnable))

}
