package abstractClassesAndInterefaces.textAnalyzation;

/**
 * Created by Roman Horilyi on 05.10.2016.
 */
public class Comment {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }

        return Label.OK;
    }
}
