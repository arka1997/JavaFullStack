package streamapi;

import java.util.Arrays;
import java.util.List;

public class PaginationLimitSkip {
    public static void main(String[] args) {
        int page = 4;
        int pageSize = 5;
        List<String> employees = Arrays.asList(
                "Employee-1",
                "Employee-2",
                "Employee-3",
                "Employee-4",
                "Employee-5",
                "Employee-6",
                "Employee-7",
                "Employee-8",
                "Employee-9",
                "Employee-10",
                "Employee-11",
                "Employee-12",
                "Employee-13",
                "Employee-14",
                "Employee-15",
                "Employee-16",
                "Employee-17",
                "Employee-18",
                "Employee-19",
                "Employee-20"
        );
        // It says, we want the data of page 4. So we have to calculate what count of total data we need 
        // to skip, before showing the 4th pages data. So we do (4 - 1) * pageSize, where pageSize means 
        // the count of data each page will have-> gives all the data uptil page 3, is 15. So at page 4 
        // we show the next 5 pages, limit decides how much we need to show per page, that is nothing but pageSize itself
        List<String> paginationOutput = employees.stream()
        .skip((page - 1) * pageSize)
        .limit(pageSize)
        .toList();
        System.out.println(paginationOutput);
    }
}
