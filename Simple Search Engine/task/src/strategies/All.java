package strategies;

import search.Container;
import strategies.api.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
class All implements Matcher<String> {

    @Override
    public List match(Container<String> container, String query) {
        List<String> result = new ArrayList<>();
        for(String s: container.getList()){
            if(s.toLowerCase().contains(query.toLowerCase())){
                if(!result.contains(s))
                    result.add(s);
            }
        }
        return result;
    }
}
