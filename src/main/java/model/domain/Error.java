package model.domain;

public enum Error {
    INVALID_AMOUNT("[ERROR] 1000원 단위로 입력해 주세요."),
    INVALID_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 번호가 존재합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 로또와 중복된 번호가 있습니다.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
