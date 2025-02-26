package com.yzm.结构设计;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * description:
 *
 * @author yzm
 * @date 2025/2/26
 */
public class Lc1472BrowserHistory {

    private String homepage;
    private Stack<String> forwardStack;
    private Stack<String> backStack;

    public Lc1472BrowserHistory(String homepage) {
        this.homepage = homepage;
        forwardStack = new Stack<>();
        backStack = new Stack<>();
    }

    public void visit(String url) {
        forwardStack.push(url);
        while (!backStack.isEmpty()) {
            backStack.pop();
        }
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (forwardStack.isEmpty()) {
                return homepage;
            }
            String url = forwardStack.pop();
            backStack.push(url);
        }
        if (forwardStack.isEmpty()) {
            return homepage;
        } else {
            return forwardStack.peek();
        }
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backStack.isEmpty()) {
                if (!forwardStack.isEmpty()) {
                    return forwardStack.peek();
                } else {
                    return homepage;
                }
            }
            String url = backStack.pop();
            forwardStack.push(url);
        }
        if (forwardStack.isEmpty()) {
            return homepage;
        } else {
            return forwardStack.peek();
        }
    }

}
