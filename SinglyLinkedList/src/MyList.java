/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Son
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    //(1) - add an Person to the end of list
    void addLast(Person person) {
        if (isEmpty()) {
            head = tail = new Node(person);
            return;
        }
        Node p = new Node(person);
        tail.next = p;
        tail = p;
    }

    void visit(Node q) {
        if (q == null)
            return;
        System.out.print(q.info);
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println("");
    }

    void addMany(String[] name, int[] age) {
        for (int i = 0; i < name.length; i++) {
            this.addLast(new Person(name[i], age[i]));
        }
    }

    //(2) - search a node by Person name
    Node searchByName(String name) {
        if (isEmpty())
            return null;
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(name))
                return p;
            p = p.next;
        }
        return null;
    }

    Node searchByAge(int age) {
        if (isEmpty())
            return null;
        Node p = head;
        while (p != null) {
            if (p.info.age == age)
                return p;
            p = p.next;
        }
        return null;
    }

    //(3) - add an Person to the begin of list
    void addFirst(Person person) {
        if (isEmpty()) {
            head = tail = new Node(person);
            return;
        }
        head = new Node(person, head);
    }

    private boolean isInList(Node q) {
        Node p = head;
        while (p != null && p != q) {
            p = p.next;
        }
        return (p == null);
    }

    //(4) - insert a node after a position
    void insertAfter(Node q, Person person) {
        if (isEmpty() || q == null)
            return;
//        if (!isInList(q))
//            return;
        Node p = new Node(person, q.next);
        q.next = p;
        if (tail == q)
            tail = p;
    }

    //(5) - insert a node before a position
    void insertBefore(Node q, Person person) {
        if (isEmpty() || q == null)
            return;
        if (q == head) {
            addFirst(person);
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) //p not found in list
            return;
        insertAfter(p, person);
    }

    //(6)
    void removeFirst() {
        if (isEmpty())
            return;
        if (head == tail)
            this.clear();
        head = head.next;
    }

    void remove(Node q) {
        if (isEmpty() || q == null)
            return;
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p == null) //q not found in list
            return;
        p.next = q.next;
        if (p.next == null) // <=> if (q == tail)
            tail = p;
    }

    //(7)
    void remove(String name) {
        Node p = this.searchByName(name);
        this.remove(p);
    }

    //(8)
    void remove(int age) {
        Node p = this.searchByAge(age);
        this.remove(p);
    }

    //(9)
    void removeAll(int age) {
        while (true) {
            Node p = this.searchByAge(age);
            if (p == null)
                break;
            this.remove(p);
        }
    }

    //(10) - get address of k-th element
    Node pos(int k) {
        Node p = head;
        int i = 0;
        while (p != null && i < k) {
            p = p.next;
            ++i;
        }
        if (i < k)
            return null;
        return p;
    }

    //(11)
    void removePos(int k) {
        this.remove(this.pos(k));
    }

    //12
    void sortByName() {
        Node pi, pj;
        pi = head;
        while (pi != tail) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    Person temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //(13)
    void sortByAge() {
        Node pi, pj;
        pi = head;
        while (pi != tail) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    Person temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //(14)
    int size() {
        Node p = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            ++i;
        }
        return i;
    }

    //(15)
    Person[] toArray() {
        int n = size();
        Person[] persons = new Person[n];
        Node p = head;
        int i = 0;
        while (p != null) {
            persons[i++] = p.info;
            p = p.next;
        }
        return persons;
    }

    //(16)
    void reverse() {
        MyList reversedList = new MyList();
        Node p = this.head;
        while (p != null) {
//            reversedList.addFirst(p.info); //not allowed because the two lists will be sharing a Person object and hence it will lead to a conflict
            Person person = new Person(p.info.name, p.info.age);
            reversedList.addFirst(person);
            p = p.next;
        }
        this.head = reversedList.head;
        this.tail = reversedList.tail;
    }

    //(17)
    Node findMaxAge() {
        Node p = head;
        int maxAge = Integer.MIN_VALUE;
        Node maxAgeNode = null;
        while (p != null) {
            if (maxAge < p.info.age) {
                maxAge = p.info.age;
                maxAgeNode = p;
            }
            p = p.next;
        }
        return maxAgeNode;
    }

    //(18)
    Node findMinAge() {
        Node p = head;
        int minAge = Integer.MAX_VALUE;
        Node minAgeNode = null;
        while (p != null) {
            if (minAge > p.info.age) {
                minAge = p.info.age;
                minAgeNode = p;
            }
            p = p.next;
        }
        return minAgeNode;
    }

    //(19)
    void setData(Node q, Person person) {
        if (!isInList(q))
            return;
        q.info = person;
    }

    //(20)
    void sortByAge(int k, int h) {
        if (k > h)
            return;
        if (k < 0)
            k = 0;
        int n = this.size();
        if (h > n - 1)
            h = n - 1;
        Node u = pos(k);
        Node v = pos(h);
        Node pi, pj;
        pi = u;
        while (pi != v) {
            pj = pi.next;
            while (pj != v.next) {
                if (pi.info.age > pj.info.age) {
                    Person temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //(21)
    void reverse(int k, int h) {
        if (k > h)
            return;
        if (k < 0)
            k = 0;
        int n = this.size();
        if (h > n - 1)
            h = n - 1;

        Node u = pos(k);
        Node v = pos(h);

        Node beforeU = null;
        if (k > 0)
            beforeU = pos(k - 1);

        Node afterV = v.next;

        MyList reversedListFromKtoH = new MyList();
        Node pi = u;
        while (pi != v.next) {
            reversedListFromKtoH.addFirst(new Person(pi.info.name, pi.info.age));
            pi = pi.next;
        }
        u = reversedListFromKtoH.head;
        v = reversedListFromKtoH.tail;

        if (beforeU == null)
            head = u;
        else
            beforeU.next = u;

        v.next = afterV;
        if (v.next == null)
            tail = v;
    }
}
