class Department {

    private String departmentName;

    public Department(String departmentName) {
        System.out.println("Initializing from constructor");
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        System.out.println("Initializing from Setter");
        this.departmentName = departmentName;
    }
}