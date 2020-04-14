package strategies;

import search.Container;
import strategies.api.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
public class NoMatcher implements Matcher<String> {

    @Override
    public List match(Container<String> container, String value) {
        System.out.println("Wrong choice");
        return new ArrayList<String>();
    }
}
