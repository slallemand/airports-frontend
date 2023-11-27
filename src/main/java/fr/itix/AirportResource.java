package fr.itix;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

@Path("/api/airports")
public class AirportResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AirportEntity> getAllAirports() {
        List<AirportEntity> airports = new ArrayList<AirportEntity>();
        airports.add(new AirportEntity("Paris CDG", "CDG", 49.012798, 2.55));
        airports.add(new AirportEntity("Brussels", "BRU", 50.8552, 4.3054));
        airports.add(new AirportEntity("London", "LON", 51.5343, -0.3004));
        airports.add(new AirportEntity("Lisboa", "LIS", 38.7436, -9.1602));
        airports.add(new AirportEntity("Athens", "ATH", 37.9909, 23.7033));
        airports.add(new AirportEntity("Stockholm", "STO", 59.326242,17.8419715));
        airports.add(new AirportEntity("Varsovia", "VAR", 52.2330653,20.9211121));
        airports.add(new AirportEntity("Dublin", "DUB", 53.3241807,-6.5327706));
        airports.add(new AirportEntity("Bucharest", "BUC", 44.4379269,26.0245979));
        airports.add(new AirportEntity("Brno", "BRN", 49.2021611,16.507921));
        return airports;
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public AirportEntity getAirport(@PathParam("code") String code) {
        List<AirportEntity> airports = this.getAllAirports();
        return airports.stream()
                         .filter(w -> w.code.equalsIgnoreCase(code))
                         .findFirst()
                         .orElseThrow();
    }
}