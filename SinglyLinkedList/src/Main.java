/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Son
 */
public class Main {

    static MyList list = new MyList();
    static String[] a = {"A", "C", "B", "E", "D"};
    static int[] b = {9, 5, 17, 5, 8};

    public static void initList() {
        list.clear();
        list.addMany(a, b);
        list.traverse();
    }

    public static void main(String[] args) {
        Node p, q;
        Person x;
        int k;

        //(1)
        System.out.println("\n1.Test addLast and addMany");
        initList();

        //(2)
        System.out.println("\n2.Test searchByName(name), name = B");
        initList();
        p = list.searchByName("B");
        if (p == null)
            System.out.println("Not found!");
        else {
            System.out.print("Found Person: ");
            list.visit(p);
            System.out.println("");
        }

        //(3)
        System.out.println("\n3.Test addFirst(Person x), x = (X,30)");
        initList();
        x = new Person("X", 30);
        list.addFirst(x);
        list.traverse();

        //(4)
        System.out.println("\n4.Test insertAfter(q, x), q=(B,17), x = (X,30)");
        initList();
        x = new Person("X", 30);
        q = list.searchByName("B");
        list.insertAfter(q, x);
        list.traverse();

        //(5)
        System.out.println("\n5.Test insertBefore(q, x), q=(B,17), x = (X,30)");
        initList();
        x = new Person("X", 30);
        q = list.searchByName("B");
        list.insertBefore(q, x);
        list.traverse();

        //(6)
        System.out.println("\n6.Test remove(Node q), q=(B,17)");
        initList();
        q = list.searchByName("B");
        list.remove(q);
        list.traverse();

        //(7)
        System.out.println("\n7.Test remove(String name), name=B");
        initList();
        list.remove("B");
        list.traverse();

        //(8)
        System.out.println("\n8.Test remove(int age), age=5");
        initList();
        list.remove(5);
        list.traverse();

        //(9)
        System.out.println("\n9.Test removeAll(int age), age=5");
        initList();
        list.removeAll(5);
        list.traverse();

        //(10)
        System.out.println("\n10.Test pos(int k), k=2");
        initList();
        p = list.pos(2);
        System.out.print("The Person at position 2 is ");
        list.visit(p);
        System.out.println("");

        //(11)
        System.out.println("\n11.Test removePos(int k), k=2");
        initList();
        list.removePos(2);
        list.traverse();

        //(12)
        System.out.println("\n12.Test sortByName()");
        initList();
        list.sortByName();
        list.traverse();

        //(13)
        System.out.println("\n13.Test sortByAge()");
        initList();
        list.sortByAge();
        list.traverse();

        //(14)
        System.out.println("\n14.Test size()");
        initList();
        k = list.size();
        System.out.println("Size = " + k);

        //(15)
        System.out.println("\n15.Test toArray()");
        initList();
        Person[] u = list.toArray();
        if (u != null) {
            System.out.println("The array u is: ");
            for (int i = 0; i < u.length; i++) {
                System.out.print(u[i]);
            }
        }
        System.out.println("");

        //(16)
        System.out.println("\n16.Test reverse()");
        initList();
        list.reverse();
        list.traverse();

        //(17)
        System.out.println("\n17.Test findMaxAge()");
        initList();
        p = list.findMaxAge();
        System.out.print("The student with max age is: ");
        list.visit(p);
        System.out.println();

        //(18)
        System.out.println("\n18.Test findMinAge()");
        initList();
        p = list.findMinAge();
        System.out.print("The student with min age is: ");
        list.visit(p);
        System.out.println();

        //(19)
        System.out.println("\n19.Test setData(): Push new content to node p");
        initList();
        p = list.searchByName("B");
        x = new Person("XX", 99);
        list.setData(p, x);
        list.traverse();

        String[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] d = {9, 8, 7, 6, 15, 4, 3, 2, 1};
        //(20)
        System.out.println("\n20.Test sortByAge(3,6)");
        list.clear();
        list.addMany(c, d);
        list.traverse();
        list.sortByAge(3, 6);
        list.traverse();
        
        //(21)
        System.out.println("\n21.Test reverse(3,6)");
        list.clear();
        list.addMany(c, d);
        list.traverse();
        list.reverse(3,6);
        list.traverse();
        
        System.out.println("");
    }
}
