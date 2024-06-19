public class Inheritance {

    class Mobile {
        protected int cost;

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void showCost() {
            System.out.println("Cost of the mobile:"+cost);
        }
    }
    class Samsung extends Mobile {
        private String model;

        public Samsung(String model) {
            this.model = model;
        }

        public void showModel() {
            System.out.println("Samsung model:"+model);
        }
    }
    class Apple extends Mobile {
        private String model;

        public Apple(String model) {
            this.model = model;
        }

        public void showModel() {
            System.out.println("Apple model:"+model);
        }
        @Override
        public void showCost() {
            System.out.println("Cost of the Apple mobile:"+cost);
        }

    }

    public static void main(String[] args) {
        Inheritance inheritance=new Inheritance();
        Inheritance.Mobile mobile=inheritance.new Mobile();
        mobile.setCost(500);
        mobile.showCost();
        System.out.println();
        Inheritance.Samsung samsung=inheritance.new Samsung("Galaxy S21");
        samsung.setCost(700);
        samsung.showModel();
        samsung.showCost();
        System.out.println();
        Inheritance.Apple apple=inheritance.new Apple("iPhone 11");
        apple.setCost(800);
        apple.showModel();
        apple.showCost();
    }
}
