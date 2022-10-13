package com.verby.restapi.user.command.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    @DisplayName("User 생성자 테스트")
    public void User() {
        // given
        String loginId = "violetBeach12";
        String password = "password12";

        // when
        User user = new User(loginId, password, "honey", "01012345678", null, false);

        // then
        assertThat(user).isNotNull();
        assertEquals(loginId, user.getLoginId());
        assertEquals(password, user.getPassword());
    }

    @Test
    @DisplayName("비밀번호 변경 테스트")
    public void resetPassword() {
        // given
        String newPassword = "changedPassword";
        User user = new User("loginId", "password", "honey", "01012345678", null, false);

        // when
        user.resetPassword(newPassword);

        // then
        assertThat(user).isNotNull();
        assertEquals(newPassword, user.getPassword());
    }

}