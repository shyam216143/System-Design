import com.parkinglot.dto.ParkingLot;
import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.dto.vehicle.Car;
import com.parkinglot.dto.vehicle.ParkingTicket;
import com.parkinglot.dto.vehicle.Vehicle;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.exceptions.InvalidTicketException;
import com.parkinglot.interfaces.ParkingSpotService;
import com.parkinglot.interfaces.PaymentService;
import com.parkinglot.parkingStrategy.FarthestFirstParkingStrategy;
import com.parkinglot.services.ParkingServiceImpl;
import com.parkinglot.services.ParkingSpotServiceImpl;
import com.parkinglot.services.PaymentServiceImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world! em chestunavu");
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
        ParkingSpot a1 = parkingSpotService.createParkingSpot(ParkingSpotEnum.COMPACT, 0, 20);
        ParkingSpot a2 = parkingSpotService.createParkingSpot(ParkingSpotEnum.COMPACT, 0, 20);

        ParkingSpot b1 = parkingSpotService.createParkingSpot(ParkingSpotEnum.LARGE, 0, 40);
        ParkingSpot b2 = parkingSpotService.createParkingSpot(ParkingSpotEnum.LARGE, 0, 40);

        ParkingSpot c1 = parkingSpotService.createParkingSpot(ParkingSpotEnum.MINI, 0, 50);
        ParkingSpot c2 = parkingSpotService.createParkingSpot(ParkingSpotEnum.MINI, 0, 50);

        Vehicle v1 = new Car();
        Vehicle v2 = new Car();
        Vehicle v3 = new Car();

        ParkingServiceImpl parkingLotService = new ParkingServiceImpl(new FarthestFirstParkingStrategy());
        PaymentService paymentService = new PaymentServiceImpl();
        ParkingTicket parkingTicket1 = parkingLotService.entry(v1);
        System.out.println("parking ticket 1"+parkingTicket1);
        System.out.println("parking ticket 1 with vehicle id: "+parkingTicket1.getVehicle().getId());
        System.out.println("parking ticket 1 is equal with vehicle id: "+parkingTicket1.getVehicle().equals(v1));

        ParkingTicket parkingTicket2 = parkingLotService.entry(v2);
        parkingLotService.addWash(parkingTicket2);
        System.out.println("parking ticket 2"+parkingTicket2);
        System.out.println("parking ticket 2 with vehicle id: "+parkingTicket2.getVehicle().getId());
        System.out.println("parking ticket 2 is equal with vehicle id: "+parkingTicket2.getVehicle().equals(v2));


        try{
           parkingLotService.exit(parkingTicket2, v2);
           int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());
           System.out.println("parking ticket 2 cost: "+cost);
        }
        catch(InvalidTicketException e){
            throw new RuntimeException(e);
        }
        ParkingTicket parkingTicket3 = parkingLotService.entry(v3);
        System.out.println("parking ticket 3"+parkingTicket3);

    }
}