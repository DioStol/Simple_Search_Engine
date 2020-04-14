package strategies;

import search.Container;
import strategies.api.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dionysios Stolis 4/13/2020
 */
class None implements Matcher<String> {

    @Override
    public List match(Container<String> container, String query) {
        List<String> result = new ArrayList<>();
        String[] queries = query.split(" ");
        for(String s: container.getList()){
            if(!contains(s,queries)){
                if(!result.contains(s))
                    result.add(s);
            }
        }
        return result;
    }

    private boolean contains(String value, String[] queries) {
        List<Boolean> contain = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if(value.toLowerCase().contains(queries[i])){
                contain.add(true);
            }else{
                contain.add(false);
            }
        }
        return contain.contains(true);
    }
}
