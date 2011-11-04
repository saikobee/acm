/***
description

In one of the countries of Caribbean basin all decisions were accepted by the
simple majority of votes at the general meeting of citizens (fortunately,
there were no lots of them). One of the local parties, aspiring to come to
power as lawfully as possible, got its way in putting into effect some reform
of the election system. The main argument was that the population of the
island recently had increased and it was to longer easy to hold general
meetings. The essence of the reform is as follows. From the moment of its
coming into effect all the citizens were divided into K (may be not equal)
groups. Votes on every question were to be held then in each group, moreover,
the group was said to vote "for" if more than half of the group had voted
"for", otherwise it was said to vote "against". After the voting in each group
a number of group that had voted "for" and "against" was calculated. The
answer to the question was positive if the number of groups that had voted
"for" was greater than the half of the general number of groups. At first the
inhabitants of the island accepted this system with pleasure. But when the
first delights dispersed, some negative properties became obvious. It appeared
that supporters of the party, that had introduced this system, could influence
upon formation of groups of voters. Due to this they had an opportunity to put
into effect some decisions without a majority of voters "for" it. Lets
consider three groups of voters, containing 5, 5 and 7 persons, respectively.
Then it is enough for the party to have only three supporters in each of the
first two groups. So it would be able to put into effect a decision with the
help of only six votes "for" instead of nine, that would be necessary in the
case of general votes. You are to write a program, which would determine
according to the given partition of the electors the minimal number of
supporters of the party, sufficient for putting into effect of any decision,
with some distribution of those supporters among the groups.
input specification

The input of this problem contains two lines. In the first line an only
natural number K <= 101, a quantity of groups. In the second line there are
written K natural numbers, separated with a space. Those numbers define a
number of voters in each group. In order to simplify the notion of "the
majority of votes" we will say that the number of groups also as the number of
voters in each group is odd. You may also consider, that the population of the
island does not exceeds 10001 persons.
output specification

You should write an only natural number: the minimal quantity of supporters of
the party, that can put into effect any decision.

sample input

3
5 7 5

sample output

6
***/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        int groups = s.nextInt();

        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < groups; i++) {
            nums.add(Integer.valueOf(s.next()));
        }

        int halfGroups = half(nums.size()); // minimum # of groups
        int sum = 0;
        for (int i = 0; i < halfGroups; i++) {
            Integer n = minimum(nums);
            nums.remove(n);
            sum += half(n); 
        }

        System.out.println(sum);
    }

    private static int half(int n) {
        return n / 2 + 1;
    }

    private static Integer minimum(ArrayList<Integer> ary) {
        int min = 10001;
        for (Integer a : ary) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }
} 