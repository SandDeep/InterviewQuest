package com.pkgS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P7 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("poon");
        set.add("plee");
        set.add("same");
        set.add("plea");
        set.add("poie");
        set.add("plie");
        set.add("poin");

        String start = "toon";
        String target = "plea";

        P7 test = new P7();

        int len = test.shortestChainLen(start, target, set);
        System.out.println("Length :" + len);
    }

    private int shortestChainLen(String start, String target, Set<String> set) {

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        System.out.print(start+" -> ");
        int count = 0;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String s : set) {
                if (isAdjacent(word, s)) {
                    System.out.print(s+" -> ");
                	queue.add(s);
                    count++;

                    if (s.equals(target)) {
                    	return count;
                    }
                }
            }
            set.remove(word);
        }
        return 0;
    }

    private boolean isAdjacent(String a, String b) {

        int count = 0;  // to store count of differences
        int n = a.length();

        // Iterate through all characters and return false
        // if there are more than one mismatching characters
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1 ? true : false;
    }
}
