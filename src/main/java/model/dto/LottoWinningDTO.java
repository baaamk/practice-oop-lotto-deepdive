package model.dto;

public class LottoWinningDTO {
    private final String description;
    private final int count;

    public LottoWinningDTO(String description, int count) {
        this.description = description;
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }
}
