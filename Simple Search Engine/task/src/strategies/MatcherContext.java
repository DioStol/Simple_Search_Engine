package strategies;

import search.Container;
import strategies.api.Matcher;

import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
public class MatcherContext<T> {

    private Matcher matcher;

    private void set(Matcher matcher){
        this.matcher = matcher;
    }

    public List execute(Container container, T value){
        return matcher.match(container, value);
    }

    public void setMatcher(String choice){
        switch (choice){
            case "ANY":
                set(new Any());
                break;
            case "ALL":
                set(new All());
                break;
            case "NONE":
                set(new None());
                break;
            default:
                set(new NoMatcher());
                break;
        }
    }
}
