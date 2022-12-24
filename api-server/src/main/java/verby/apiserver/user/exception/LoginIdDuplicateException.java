package verby.apiserver.user.exception;

import verby.apiserver.common.error.ErrorCode;
import verby.apiserver.common.error.exception.EntityDuplicateException;

public class LoginIdDuplicateException extends EntityDuplicateException {

    public LoginIdDuplicateException(String loginId) {
        super(ErrorCode.DUPLICATE_LOGIN_ID, String.format("loginId (%s) is duplicated.", loginId));
    }
}