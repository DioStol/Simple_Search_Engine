package strategies;

import search.Container;
import strategies.api.Matcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dionysios Stolis 4/13/2020
 */
class Any implements Matcher<String> {

    @Override
    public List match(Container<String> container, String query) {
        List<String> result = new ArrayList<>();
        String[] queries = query.split(" ");
        for(String s: container.getList()){
            for (String str : queries){
                if(s.toLowerCase().contains(str.toLowerCase())){
                    if(!result.contains(s))
                        result.add(s);
                }
            }
        }
        return result;
    }
}
