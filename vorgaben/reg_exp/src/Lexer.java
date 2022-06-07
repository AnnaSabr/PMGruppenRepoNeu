import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class Lexer {
    private final List<Token> tokenizer = new ArrayList<>();

    public Lexer() {
        tokenizer.add(new Token(Pattern.compile("//+.*"),0, Color.gray));
        tokenizer.add(new Token(Pattern.compile("/\\*[^\\*/]*\\*/",Pattern.DOTALL),0, Color.CYAN));
        tokenizer.add(new Token(Pattern.compile("/\\*\\*[^/]*\\*/",Pattern.DOTALL),0, Color.ORANGE));
        tokenizer.add(new Token(Pattern.compile("\\\"{1}[\\s\\w]*\\\"{1}"),0, Color.pink));
        tokenizer.add(new Token(Pattern.compile("'{1}\\w'{1}"),0, Color.YELLOW));
        tokenizer.add(new Token(Pattern.compile("(package)\\s|(import)\\s|(class)\\s|(public)\\s|(private)\\s|(final)\\s|(return)\\s|(null)\\s|(new)\\s"),0, Color.RED));
        tokenizer.add(new Token(Pattern.compile("@[-A-Za-z]*"),0, Color.DARK_GRAY));



        // Fügen Sie hier die einzelnen Token hinzu. Beispiel:
        // tokenizer.add(new Token(Pattern.compile("TODO"), 0, colors[0])); // einzeiliger Kommentar

        // TODO einzeiliger Kommentar
        // TODO mehrzeiliger Kommentar
        // TODO Java-Doc-Kommentar
        // TODO Strings
        // TODO CharacterContent

        // TODO KeyWords: package, import, class, public, private, final, return, null, new

        // TODO Annotation
    }

    public List<MyMatchResult> tokenize(String s) {
        List<MyMatchResult> results = new ArrayList<>();
        tokenizer.forEach(t -> results.addAll(t.test(s)));
        return results;
    }

    public static void main(String[] args) {
        LexerUI lexerUI = new LexerUI();
    }
}
