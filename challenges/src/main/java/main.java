import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian Benitez on 8/5/2017.
 */
public class main {

    private static PhoneCallPriceCalculator[] availableCalculators = {new LocalPhoneCallPriceCalculator(),
             new InternationalPhoneCallPriceCalculator()};

    private static class InternationalPhoneCallPriceCalculator extends PhoneCallPriceCalculator {
        @Override
        boolean canCalculatePhoneCall(PhoneCall phoneCall) {
            return !phoneCall.getCallerCity().getCountryName().equals(phoneCall.getReceiverCity().getCountryName());
        }

        @Override
        long calculatePrice(PhoneCall phoneCall) {
            int dur =phoneCall.getDurationInSeconds();
            return dur;
        }
    }

    private static class City {
        private final String name;
        private final String country;

        String getName() {
            return name;
        }

        String getCountryName() {
            return country;
        }

        City(String name, String country) {
            this.name = name;
            this.country = country;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof City)) {
                return false;
            }

            City other = (City) object;
            return other.getName().equals(name) &&
                    other.getCountryName().equals(country);
        }

        @Override
        public int hashCode() {
            int hashFirst = name.hashCode();
            int hashSecond = country.hashCode();

            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }
    }

    private static class PhoneCall {
        private final City callerCity;
        private final City receiverCity;
        private final int duration;

        PhoneCall(City callerCity, City receiverCity, int seconds) {
            this.callerCity = callerCity;
            this.receiverCity = receiverCity;
            this.duration = seconds;
        }

        City getCallerCity() {
            return callerCity;
        }

        City getReceiverCity() {
            return receiverCity;
        }

        int getDurationInSeconds() {
            return duration;
        }

    }

    private static class LocalPhoneCallPriceCalculator extends PhoneCallPriceCalculator {
        @Override
        boolean canCalculatePhoneCall(PhoneCall phoneCall) {
            return phoneCall.getCallerCity().equals(phoneCall.getReceiverCity());
        }

        @Override
        long calculatePrice(PhoneCall phoneCall) {
            return phoneCall.getDurationInSeconds();
        }
    }

    private static abstract class PhoneCallPriceCalculator {
        abstract boolean canCalculatePhoneCall(PhoneCall phoneCall);
        abstract long calculatePrice(PhoneCall phoneCall);
    }

    static long[] calculatePrices(String[] from, String[] to, int[] seconds) {
        int n = from.length;
        long[] solution = new long[n];
        for (int i = 0; i < n; i++) {
            City fromCity = createCity(from[i]);
            City toCity = createCity(to[i]);
            int duration = seconds[i];
            PhoneCall call = new PhoneCall(fromCity, toCity, duration);
            solution[i] = getCorrectCalculator(call).calculatePrice(call);
        }
        return solution;
    }
    private static PhoneCallPriceCalculator getCorrectCalculator(PhoneCall call) {
        List<PhoneCallPriceCalculator> validCalculators = new ArrayList();
        for (PhoneCallPriceCalculator calculator : availableCalculators) {
            if (calculator.canCalculatePhoneCall(call)) {
                validCalculators.add(calculator);
            }
        }
        if (validCalculators.size() != 1) {
            throw new IllegalStateException("There must be one (and only one) calculator for this call");
        } else {
            return validCalculators.get(0);
        }
    }

    private static City createCity(String name) {
        String country;
        switch(name) {
            case "Buenos Aires":
            case "Rosario":
            case "Viedma":
                country = "Argentina";
                break;
            case "Cusco":
            case "Lima":
            case "Ayacucho":
                country = "Peru";
                break;
            case "Rio de Janeiro":
            case "Belo Horizonte":
            case "Recife":
                country = "Brazil";
                break;
            default:
                throw new IllegalArgumentException("Invalid name");
        }
        return new City(name, country);
    }

}
