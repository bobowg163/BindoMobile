package com.example.bindomobile.domain.usecases.login

import com.example.bindomobile.domain.repositories.LoginRepository

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/7
 * @time 下午11:01
 * @month_full 十月
 * @day 07
 * @day_full 星期一
 * @minute 01
 */
class LoginUseCase(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(username: String, password: String) {
        return loginRepository.login(username, password)
    }
}