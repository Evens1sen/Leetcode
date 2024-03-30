package array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC224BasicCalculator {

    static class BasicCalculator {
        /**
         * 分几种场景
         * 1.普通的加减法
         * 统一转换成加法操作
         * 2.括号
         * 括号内的表达式也是一个正常的表达式，可以使用递归来解决，转化成子问题
         *
         * @param s
         * @return
         */
        public int calculate(String s) {
            List<Token> tokens = lex(s);
            return calculate(tokens, 0, tokens.size() - 1);
        }

        private int calculate(List<Token> tokens, int start, int end) {
            Deque<Integer> stack = new LinkedList<>();
            //是否正数
            boolean positive = true;
            int idx = start;
            while (idx <= end) {
                Token token = tokens.get(idx++);
                if (token instanceof Num) {
                    stack.offerLast(positive ? ((Num) token).value : -((Num) token).value);
                    positive = true;
                } else if (token instanceof Op) {
                    Op op = (Op) token;
                    if (op.op == '+') {
                        positive = true;
                    } else if (op.op == '-') {
                        positive = false;
                    }
                } else {
                    //找到下一个括号的位置
                    Deque<Character> s2 = new LinkedList<>();
                    s2.offerLast('(');
                    int s = idx;
                    while (idx <= end && !s2.isEmpty()) {
                        Token t1 = tokens.get(idx++);
                        if (t1 instanceof Bracket) {
                            Bracket bracket = (Bracket) t1;
                            if (bracket.bracket == '(') {
                                s2.offerLast('(');
                            } else {
                                s2.pollLast();
                            }
                        }
                    }
                    int res = calculate(tokens, s, idx - 2);
                    stack.offerLast(positive ? res : -res);
                    positive = true;
                }
            }
            //计算总和
            int res = 0;
            for (Integer n : stack) {
                res += n;
            }
            return res;
        }

        /**
         * 词法分析
         *
         * @param s
         * @return
         */
        private List<Token> lex(String s) {
            int len = s.length();
            List<Token> tokens = new ArrayList<>();
            int num = 0;
            boolean numStart = false;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    numStart = true;
                    num = num * 10 + (ch - '0');
                } else {
                    if (numStart) {
                        tokens.add(new Num(num));
                        numStart = false;
                        num = 0;
                    }
                    if (ch == '(' || ch == ')') {
                        tokens.add(new Bracket(ch));
                    } else if (ch == '+' || ch == '-') {
                        tokens.add(new Op(ch));
                    }
                    //空格直接跳过，不需要做任何事情
                }
            }
            //到达字符串尾部
            if (numStart) {
                tokens.add(new Num(num));
            }
            return tokens;
        }
    }

    interface Token {
    }

    static class Num implements Token {
        int value;

        public Num(int value) {
            this.value = value;
        }
    }

    static class Op implements Token {
        char op;

        public Op(char op) {
            this.op = op;
        }
    }

    static class Bracket implements Token {
        char bracket;

        public Bracket(char bracket) {
            this.bracket = bracket;
        }
    }

}


