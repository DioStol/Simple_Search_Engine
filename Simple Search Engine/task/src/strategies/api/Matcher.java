package strategies.api;

import search.Container;

import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
public interface Matcher<T> {

    List<T> match(Container<T> container, T value);
}
