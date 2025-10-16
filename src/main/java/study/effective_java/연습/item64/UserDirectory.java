package study.effective_java.연습.item64;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDirectory {
    private final ArrayList<String> users = new ArrayList<>();

    public List<String> users() {
        return Collections.unmodifiableList(users);
    }

    public void addAll(Collection<? extends String> toAdd) {
        users.addAll(toAdd);
    }

//    public ArrayList<String> getUsers() {
//        return users;
//    }
//
//    public void addAll(ArrayList<String> toAdd) {
//        users.addAll(toAdd);
//    }
}
