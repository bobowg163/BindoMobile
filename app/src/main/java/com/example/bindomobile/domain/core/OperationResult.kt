package com.example.bindomobile.domain.core

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午5:06
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 06
 */
sealed class OperationResult<out T> {
    data class Success<out T>(val data: T) : OperationResult<T>()
    data class Failure(val error: AppError) : OperationResult<Nothing>()

    fun isSuccess(): Boolean {
        return when (this) {
            is Success -> true
            is Failure -> false
        }
    }

    companion object {
        inline fun <R> runWrapped(block: () -> R): OperationResult<R> {
            return try {
                val res = block()
                Success(res)
            } catch (e: Exception) {
                e.printStackTrace()
                when (e) {
                    is AppError -> Failure(e)
                    else -> Failure(AppError(ErrorType.fromThrowable(e)))
                }
            }
        }
    }
}