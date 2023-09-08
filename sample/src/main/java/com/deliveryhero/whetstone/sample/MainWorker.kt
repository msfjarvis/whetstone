package com.deliveryhero.whetstone.sample

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.deliveryhero.whetstone.worker.ContributesWorker
import com.deliveryhero.whetstone.worker.WorkerScope
import com.squareup.anvil.annotations.optional.ForScope
import javax.inject.Inject

@ContributesWorker
class MainWorker @Inject constructor(
    @ForScope(WorkerScope::class) context: Context,
    workerParameters: WorkerParameters,
    private val dependency: MainDependency
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        Log.i("Worker", dependency.getMessage("MainWorker"))
        return Result.success()
    }
}
