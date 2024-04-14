package homework20240327;

import java.util.*;

public class Customer implements Comparable<Customer> {
        private String name;
        private String email;
        private String country;
        private int bonusAmount;
        private boolean isEmailConfirmed;

        public Customer(String name, String email, String country, int bonusAmount, boolean isEmailConfirmed) {
                this.name = name;
                this.email = email;
                this.country = country;
                this.bonusAmount = bonusAmount;
                this.isEmailConfirmed = isEmailConfirmed;
        }

        @Override
        public String toString() {
                return "Customer{" +
                        "name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", country='" + country + '\'' +
                        ", bonusAmount=" + bonusAmount +
                        ", isEmailConfirmed=" + isEmailConfirmed +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Customer customer = (Customer) o;
                return bonusAmount == customer.bonusAmount && isEmailConfirmed == customer.isEmailConfirmed && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(country, customer.country);
        }

        @Override
        public int hashCode() {
                return Objects.hash(name, email, country, bonusAmount, isEmailConfirmed);
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public int getBonusAmount() {
                return bonusAmount;
        }

        public void setBonusAmount(int bonusAmount) {
                this.bonusAmount = bonusAmount;
        }

        public boolean isEmailConfirmed() {
                return isEmailConfirmed;
        }

        public void setEmailConfirmed(boolean emailConfirmed) {
                isEmailConfirmed = emailConfirmed;
        }

        public static void main(String[] args) {

                Customer customer1 = new Customer("Customer1", "customer1@gmail.com", "USA", 20, true);
                Customer customer2 = new Customer("Customer2", "customer2@gmail.com", "UK", 20, false);
                Customer customer3 = new Customer("Customer3", "customer3@gmail.com", "Ukraine", 20, true);
                List<Customer> customers = Arrays.asList(customer1, customer2, customer3);

                // a. Получить Map email / страна
                Map<String, String> mapEmailCountry = new HashMap<>();
                for (Customer customer : customers) {
                        mapEmailCountry.put(customer.getEmail(), customer.getCountry());
                }
                System.out.println(mapEmailCountry);

                //   b. Получить Map email / покупатель
                Map<String, String> mapEmailCustomer = new HashMap<>();
                for (Customer customer : customers) {
                        mapEmailCustomer.put(customer.getEmail(), customer.getName());
                }
                System.out.println(mapEmailCustomer);
                // c. Получить Map isEmailConfirmed / количество подтвержденных и неподтвержденных email
                Map<Boolean, Integer> mapConfirmedEmails = new HashMap<>();
                int confirmedCount = 0;
                int unconfirmedCount = 0;
                for (Customer customer : customers) {
                        if (customer.isEmailConfirmed) {
                                confirmedCount++;
                        } else {
                                unconfirmedCount++;
                        }
                }

                mapConfirmedEmails.put(true, confirmedCount);
                mapConfirmedEmails.put(false, unconfirmedCount);
                System.out.println(mapConfirmedEmails);

                // d. Получить Map<String, List<Customer>> страна / список покупателей из данной страны
                Map<String, List<Customer>> map = new HashMap<>();
                for (Customer customer : customers) {
                        List<Customer> currentCountryList = map.getOrDefault(customer.country, new ArrayList<>());
                        currentCountryList.add(customer);
                        map.put(customer.country, currentCountryList);
                }
                System.out.println(map);

                //e. Получить Map страна / суммарный накопленный бонус покупателей из данной страны
                Map<String, Integer> countryBonusMap = new HashMap<>();
                for (Customer customer : customers) {
                        String country = customer.getCountry();
                        int bonus = customer.getBonusAmount();
                        countryBonusMap.put(country, countryBonusMap.getOrDefault(country, 0) + bonus);

                }
                System.out.println(countryBonusMap);

                customer1.bonusAmount = 100;
                Customer customer4 = new Customer("Customer1", "abs1@gmail.com", "USA", 20, true);
                System.out.println(customer1.equals(customer4));

                Map<Customer, Integer> customerIntegerMap = new HashMap<>();
                customerIntegerMap.put(customer1, 1);
                customerIntegerMap.put(customer2, 2);
                customerIntegerMap.put(customer3, 3);
                customerIntegerMap.put(customer4, 3);
                System.out.println(customerIntegerMap.size());

                Map<Customer, Integer> customerIntegerTreeMap = new TreeMap<>();
                customerIntegerTreeMap.put(customer1, 1);
                customerIntegerTreeMap.put(customer2, 2);
                customerIntegerTreeMap.put(customer3, 3);
                customerIntegerTreeMap.put(customer4, 3);
                System.out.println(customerIntegerTreeMap.size());


                // example: how to corrupt Map
                customer1.bonusAmount = 20;
                customerIntegerMap.entrySet().forEach(System.out::println);
        }

        @Override
        public int compareTo(Customer o) {
                int result = name.compareTo(o.name);
                if (result == 0) result = email.compareTo(o.email);
                if (result == 0) result = country.compareTo(o.country);
                if (result == 0) result = bonusAmount - o.bonusAmount;
                if (result == 0) result = Boolean.compare(isEmailConfirmed, o.isEmailConfirmed);
                return result;
        }
}

