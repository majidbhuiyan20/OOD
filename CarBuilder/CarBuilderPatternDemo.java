class CarBuilderPatternDemo {

    // Car class with required and optional fields
    static class Car {
        private String modelName;
        private String engineType;
        private String color;
        private String transmission;
        private boolean sunroof;
        private boolean infotainmentSystem;

        // Private constructor to enforce usage of builder
        private Car(CarBuilder builder) {
            this.modelName = builder.modelName;
            this.engineType = builder.engineType;
            this.color = builder.color;
            this.transmission = builder.transmission;
            this.sunroof = builder.sunroof;
            this.infotainmentSystem = builder.infotainmentSystem;
        }

        // Display car configuration
        public void showCarDetails() {
            System.out.println("Car Configuration:");
            System.out.println("Model Name: " + modelName);
            System.out.println("Engine Type: " + engineType);
            System.out.println("Color: " + color);
            System.out.println("Transmission: " + transmission);
            System.out.println("Sunroof: " + (sunroof ? "Yes" : "No"));
            System.out.println("Infotainment System: " + (infotainmentSystem ? "Yes" : "No"));
            System.out.println("-----------------------------------------");
        }
    }

    // Builder class
    static class CarBuilder {
        private String modelName = "Default Model";
        private String engineType = "Petrol";
        private String color = "White";
        private String transmission = "Manual";
        private boolean sunroof = false;
        private boolean infotainmentSystem = false;

        public CarBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setTransmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setInfotainmentSystem(boolean infotainmentSystem) {
            this.infotainmentSystem = infotainmentSystem;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    // Main method to test the builder
    public static void main(String[] args) {
        // Default Car
        Car defaultCar = new CarBuilder().build();
        defaultCar.showCarDetails();

        // Customized Car
        Car customCar = new CarBuilder()
                .setModelName("Tesla Model 3")
                .setEngineType("Electric")
                .setColor("Midnight Silver")
                .setTransmission("Automatic")
                .setSunroof(true)
                .setInfotainmentSystem(true)
                .build();

        customCar.showCarDetails();
    }
}
