package project.scanner.tokens;

import project.scanner.ReturnedTuple;

public interface Token {

    ReturnedTuple match(int begin, String string);
}
