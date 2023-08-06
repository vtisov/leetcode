package ru.edu.vtisov.stack;

// https://leetcode.com/problems/simplify-path

class SimplifyPath {
public:
    string simplifyPath(string path) {
        stack<string> stack;
        stringstream ss(path);
        string directory;
        string result;

        while (getline(ss, directory, '/')) {
            if (directory == "" || directory == ".") {
                continue;
            } else if (directory == "..") {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(directory);
            }
        }

        while(!stack.empty()) {
            result = "/" + stack.top() + result;
            stack.pop();
        }
        
        return result.empty() ? "/" : result;
    }
};