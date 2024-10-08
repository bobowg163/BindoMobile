package com.example.bindomobile.domain.usecases.login

import com.example.bindomobile.domain.repositories.LoginRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午11:00
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 00
 */
class CheckIfLoggedInUseCase(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(): Boolean {
        return loginRepository.checkIfLoggedIn()
    }
}