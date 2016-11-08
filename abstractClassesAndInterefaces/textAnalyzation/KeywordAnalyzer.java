package abstractClassesAndInterefaces.textAnalyzation;

/**
 * Created by Roman Horilyi on 05.10.2016.
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }

        return Label.OK;
    }
}
