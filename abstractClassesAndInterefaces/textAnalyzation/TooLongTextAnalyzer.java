package abstractClassesAndInterefaces.textAnalyzation;

/**
 * Created by Roman Horilyi on 05.10.2016.
 */
public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > getMaxLength()) {
            return Label.TOO_LONG;
        } else {
            return Label.OK;
        }
    }
}
