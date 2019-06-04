package id.co.rezkyauliapratama.lib_uicomponent.domain.executors

import java.util.concurrent.Executor

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * base usecase out of the UI thread.
 */
interface ThreadExecutor : Executor