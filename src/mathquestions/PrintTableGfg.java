package mathquestions;

import java.util.ArrayList;

class PrintTableGfg {
    public static void main(String[] args) {
        System.out.println(getTable(9));
    }

    static ArrayList<Integer> getTable(int N){
        // code here
        ArrayList<Integer> table = new ArrayList<Integer>();
        for(int i=1; i<=10; i++) {
            table.add(i*N);
        }
        return table;
    }
}