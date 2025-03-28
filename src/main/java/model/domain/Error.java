package model.domain;

public enum Error {
    INVALID_AMOUNT("[ERROR] 1000원 단위로 입력해 주세요."),
     ;

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
