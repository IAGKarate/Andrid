package mislugares.root.example.com.mislugares;

public class GeoPunto {
    private double longitud, latitud;

    public GeoPunto(double longitud, double latitud){
        this.longitud = longitud;
        this.latitud= latitud;
    }

    @Override
    public String toString() {
        return
                "longitud=" + longitud +
                ", latitud=" + latitud;
    }

    public double distancia (GeoPunto punto)
    {
        final double RADIO_TIERRA = 6371000;
        double dlat= Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud- punto.longitud);
        double lat1 = Math.toRadians(punto.latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dlat/2)*Math.sin(dlat/2)+
                Math.sin(dLon/2)*Math.sin(dLon/2)*
                        Math.cos(lat1)*Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return c * RADIO_TIERRA;

    }
}
