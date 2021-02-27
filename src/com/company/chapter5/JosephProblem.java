package com.company.chapter5;

public class JosephProblem {
    private static EndlessList jewsCircle;
    public static void main(String[] args) {
        int jewsCount = 7;
        jewsCircle = new EndlessList();
        for(long jew = jewsCount; jew>=1;jew--){
            jewsCircle.insert(jew);
        }

        int countOff = 3;
        while (jewsCircle.getSize() != 1){
            long jewToKill = 1;
            for(int step = 1; step<=countOff;step++){
                jewToKill = jewsCircle.step();
            }
            System.out.println(makeJewCommitASuicide(jewToKill));
        }

        jewsCircle.displayList();
    }


    public static long makeJewCommitASuicide(long jew){
        return jewsCircle.remove(jew).dData;
    }
}
