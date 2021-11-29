public class New_hired {
    public static void main(String[] args) {
        Email employee1 = new Email("Sarah","Smith", "Magnolia");
        System.out.println(employee1.user_info());
        employee1.setAlternate_email("Alternate email is: s.smith@gamil.com");
        System.out.println(employee1.getAlternate_email());

    }
}
