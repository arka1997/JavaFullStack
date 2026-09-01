
package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionUtilsMethods {

    public static void main(String[] args) {

        /*
         * ============================================================
         * 1. BASIC LIST
         * ============================================================
         *
         * ArrayList:
         * - Maintains insertion order
         * - Allows duplicates
         * - Fast index-based access
         */

        List<String> cities = new ArrayList<>();

        cities.add("BLR");
        cities.add("CHE");
        cities.add("HYD");
        cities.add("DEL");
        cities.add("PUNE");

        System.out.println("Original List: " + cities);


        /*
         * ============================================================
         * 2. SORTING
         * ============================================================
         *
         * Collections.sort() sorts the list in ascending order.
         */

        Collections.sort(cities);

        System.out.println("Sorted List: " + cities);


        /*
         * ============================================================
         * 3. UNSUPPORTED / UNMODIFIABLE LIST
         * ============================================================
         *
         * unmodifiableList() returns a READ-ONLY VIEW.
         *
         * Important:
         * It does NOT make the original list immutable.
         */

        List<String> readOnlyCities =
                Collections.unmodifiableList(cities);

        System.out.println("Read-only List: " + readOnlyCities);

        // This will throw UnsupportedOperationException:
        // readOnlyCities.add("MUM");


        /*
         * But the original list can still be modified.
         */

        cities.add("MUM");

        System.out.println("After modifying original: " + readOnlyCities);


        /*
         * ============================================================
         * 4. SYNCHRONIZED LIST
         * ============================================================
         *
         * Makes individual List operations synchronized.
         *
         * Useful when multiple threads access the same list.
         */

        List<String> synchronizedCities =
                Collections.synchronizedList(new ArrayList<>());

        synchronizedCities.add("BLR");
        synchronizedCities.add("CHE");
        synchronizedCities.add("HYD");

        System.out.println("Synchronized List: " + synchronizedCities);


        /*
         * ============================================================
         * 5. COPY-ON-WRITE ARRAYLIST
         * ============================================================
         *
         * Best when:
         * - Reads are frequent
         * - Writes are relatively rare
         *
                           list
                        ↓
                ┌─────────────────┐
                │ [10, 20, 30]    │ Array A
                └─────────────────┘
                        │
                        │ iterator = list.iterator()
                        ↓
                Iterator takes a snapshot
                        │
                        ↓
                iterator ─────────→ [10, 20, 30]
                                    OLD ARRAY A
                        │
                        │
                        ▼
                    list.add(40)
                        │
                        ↓
                CopyOnWriteArrayList
                creates a NEW array B
                        │
                        ↓
                ┌─────────────────┐
                │ [10, 20, 30, 40]│
                └─────────────────┘
                        ↑
                        list

                OLD ARRAY A is still alive
                        │
                        ↓
                ┌─────────────────┐
                │ [10, 20, 30]    │
                └─────────────────┘
                        ↑
                    OLD iterator
                        ↓
        ┌──────────────────────────────────────────────┐
        │ 4. Create a NEW Iterator                    │
        │    itr = list.iterator()                     │
        └──────────────────────────────────────────────┘

                        │
                        │ itr = list.iterator()   ← NEW iterator
                        ↓
                iterator ─────────→ [10, 20, 30, 40]
                                    NEW ARRAY B
         */

        CopyOnWriteArrayList<String> safeCities =
                new CopyOnWriteArrayList<>();

        safeCities.add("BLR");
        safeCities.add("CHE");
        safeCities.add("HYD");

        System.out.println("CopyOnWriteArrayList: " + safeCities);


        /*
         * ============================================================
         * 6. ITERATOR
         * ============================================================
         *
         * Iterator moves only FORWARD.
         *
         * hasNext() -> checks whether another element exists
         * next()    -> returns the next element and moves forward
         */

        System.out.println("\nIterator - Forward:");

        Iterator<String> itr = cities.iterator();

        while (itr.hasNext()) {

            String city = itr.next();

            System.out.println(city);
        }


        /*
         * ============================================================
         * 7. REMOVE SAFELY USING ITERATOR
         * ============================================================
         *
         * When iterating, don't directly modify the ArrayList:
         *
         *     cities.remove(...)
         *
         * Use:
         *
         *     itr.remove()
         *
         * when you want to remove the element returned by next().
         */

        List<String> employeeRoles = new ArrayList<>();

        employeeRoles.add("Developer");
        employeeRoles.add("Tester");
        employeeRoles.add("Manager");
        employeeRoles.add("Developer");

        Iterator<String> roleIterator = employeeRoles.iterator();

        while (roleIterator.hasNext()) {

            String role = roleIterator.next();

            if (role.equals("Tester")) {
                roleIterator.remove();
            }
        }

        System.out.println("\nAfter Iterator Removal: " + employeeRoles);


        /*
         * ============================================================
         * 8. LISTITERATOR
         * ============================================================
         *
         * ListIterator is more powerful than Iterator.
         *
         * Iterator:
         *     Forward only
         *
         * ListIterator:
         *     Forward + Backward
         *
         * hasNext()     -> check forward
         * next()        -> move forward
         *
         * hasPrevious() -> check backward
         * previous()    -> move backward
         */

        List<String> route = new ArrayList<>();

        route.add("BLR");
        route.add("CHE");
        route.add("HYD");
        route.add("DEL");
        route.add("PUNE");

        ListIterator<String> listIterator =
                route.listIterator();


        /*
         * Move cursor to the END.
         *
         * Initially cursor is here:
         *
         *     ↓
         * [BLR, CHE, HYD, DEL, PUNE]
         *
         * After next() repeatedly:
         *
         * [BLR, CHE, HYD, DEL, PUNE]
         *                              ↑
         *                            cursor
         */

        while (listIterator.hasNext()) {
            listIterator.next();
        }


        /*
         * Now traverse BACKWARD using previous().
         */

        System.out.println("\nListIterator - Reverse:");

        while (listIterator.hasPrevious()) {

            String city = listIterator.previous();

            System.out.println(city);
        }


        /*
         * ============================================================
         * 9. LISTITERATOR - FORWARD + BACKWARD
         * ============================================================
         *
         * We can move in both directions.
         */

        List<String> pages = new ArrayList<>();

        pages.add("Home");
        pages.add("Products");
        pages.add("Inventory");
        pages.add("Orders");

        ListIterator<String> pageIterator =
                pages.listIterator();

        System.out.println("\nMoving Forward:");

        while (pageIterator.hasNext()) {
            System.out.println(pageIterator.next());
        }

        System.out.println("\nMoving Backward:");

        while (pageIterator.hasPrevious()) {
            System.out.println(pageIterator.previous());
        }


        /*
         * ============================================================
         * 10. LISTITERATOR CAN ALSO MODIFY THE LIST
         * ============================================================
         *
         * add(), remove(), set()
         *
         * Example:
         */

    }
}