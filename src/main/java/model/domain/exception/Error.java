package model.domain.exception;

public class Error {
    private static final String CONSTANT_ERROR = "[ERROR] ";

    public static final String INVALID_AMOUNT = CONSTANT_ERROR + "1000원 단위로 입력해 주세요.";
    public static final String INVALID_RANGE = CONSTANT_ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATED_NUMBER = CONSTANT_ERROR + "중복된 번호가 존재합니다.";
    public static final String DUPLICATED_BONUS_NUMBER = CONSTANT_ERROR + "로또와 중복된 번호가 있습니다.";
    public static final String INVALID_LOTTO_COUNT = CONSTANT_ERROR + "6개의 숫자를 입력해야 합니다.";
    public static final String INVALID_NUMBER_FORMAT = CONSTANT_ERROR + "숫자만 입력하세요.";
    public static final String INVALID_PURCHASE_AMOUNT = CONSTANT_ERROR + "구매 금액은 0 이상이어야 합니다.";
}
